#include <string>
#include <iostream>
#include <fstream>
#include <stdint.h>

#include <stdlib.h>
#include <string.h>
#include <cstdlib>
#include <cstring>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <fcntl.h>

#include <stdexcept>
#include <sstream>

#include "LineInfo.h"
using namespace std;

const int READ_MAX_LEN = 100;
const int NO_OF_LETTER_GUESS_MAX = 12;
const int OK = 0;

int main(int argc, char* argv[]){
    try{
        if(argc != 1){
            throw domain_error(LineInfo("Usage: ./gclient ", __FILE__, __LINE__));
        }
        string srd_cwr_req_np_str = "./srd_cwr_req_np";
        mkfifo(srd_cwr_req_np_str.c_str(), 0600);

        int srd_cwr_req_np_fd = open(srd_cwr_req_np_str.c_str(), O_WRONLY);
        if(srd_cwr_req_np_fd < OK){
            throw domain_error(LineInfo("open FAILURE", __FILE__, __LINE__));
        }

        string swr_crd_np_str = "./swr_crd_np-";
        int i = getpid(); 
        string s; 
        stringstream out; 
        out << i; 
        s = out.str();
        swr_crd_np_str += s;

        if(write(srd_cwr_req_np_fd, swr_crd_np_str.c_str(), (swr_crd_np_str.size() + 1)) < OK){
            throw domain_error(LineInfo("write FAILURE", __FILE__, __LINE__));
        }

        mkfifo(swr_crd_np_str.c_str(), 0600);

        int swr_crd_np_fd = open(swr_crd_np_str.c_str(), O_RDONLY);
        if (swr_crd_np_fd < OK){
            throw domain_error(LineInfo("open FAILURE", __FILE__, __LINE__));
        }

        char clientno_ary[READ_MAX_LEN] = { 0 };
        
        if(read(swr_crd_np_fd, clientno_ary, READ_MAX_LEN) < OK){
            throw domain_error(LineInfo("read FAILURE", __FILE__, __LINE__));
        }
        string clientno_str(clientno_ary);

        char randomWordAry[READ_MAX_LEN] = { 0 };
        if (read(swr_crd_np_fd, randomWordAry, READ_MAX_LEN) < OK){
            throw domain_error(LineInfo("read FAILURE", __FILE__, __LINE__));
        }
        string randomword_str(randomWordAry);

        char srd_cwr_np_ary[READ_MAX_LEN] = { 0 };
        if (read(swr_crd_np_fd, srd_cwr_np_ary, READ_MAX_LEN) < OK){
            throw domain_error(LineInfo("read FAILURE", __FILE__, __LINE__));
        }
        string srd_cwr_np_str(srd_cwr_np_ary);
        mkfifo(srd_cwr_np_str.c_str(), 0600);

        int srd_cwr_np_fd = open(srd_cwr_np_str.c_str(), O_WRONLY);
        if (srd_cwr_np_fd < OK){
            throw domain_error(LineInfo("open FAILURE", __FILE__, __LINE__));
        }

        int noOfTries = 0;

        cout << endl << endl << "Game Start" << endl << "You have " << NO_OF_LETTER_GUESS_MAX << " letter guesses to win" << endl << endl;

        do{
            char guessWordAry[READ_MAX_LEN] = { 0 };
            if(read(swr_crd_np_fd, guessWordAry, READ_MAX_LEN) < OK){
                throw domain_error(LineInfo("read FAILURE", __FILE__, __LINE__));
            }

            string guessword_str(guessWordAry);

            //Determine if done:
            if(guessword_str == randomword_str){
                cout << endl << guessword_str << endl;
                cout << endl << endl << "You Win!" << endl << endl;
                break;
            }

            if(noOfTries > NO_OF_LETTER_GUESS_MAX){
                cout << endl << endl << "Out of tries : " << noOfTries - 1 << " allowed" << endl << "The word is: " << randomword_str << endl << endl;
                break;
            }

            cout << endl;

            cout << "Client: " << clientno_str << endl << "No of tries : " << noOfTries << endl << "(Guess) Enter a letter in the word : " << guessword_str << endl;
            cout << endl;

            char letterGuess_char = ' ';
            cin >> letterGuess_char;
            string letterGuess_str = " ";
            letterGuess_str[0] = letterGuess_char;

            if(write(srd_cwr_np_fd, letterGuess_str.c_str(), letterGuess_str.size() + 1) < OK){
                throw domain_error(LineInfo("write FAILURE", __FILE__, __LINE__));
            }

            noOfTries++;
        } while(true);

        close(srd_cwr_req_np_fd);
        close(swr_crd_np_fd);
        close(srd_cwr_np_fd);

        unlink(srd_cwr_req_np_str.c_str());
        unlink(swr_crd_np_str.c_str());
        unlink(srd_cwr_np_str.c_str());
        
    }
    catch(exception& e){
        cout << e.what() << endl;
        exit(EXIT_FAILURE);
    }//catch

    exit(EXIT_SUCCESS);
}