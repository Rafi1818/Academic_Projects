/*
    Program Name: Diagonal
    Date: 03/20/2023
    Author: Tahmidul Karim
    Module Purpose: This program takes words as argument and writes them diagonally in a binary file named diagonal2.bin
*/

#include <iostream>
#include <iomanip>
#include <string>
#include <string.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

#include "LineInfo.h"

using namespace std;

const int LINESIZE = 16;

//use one command line argument
int main(int argc, char* argv[]) {
    try {
        if (argc < 2) {
            throw domain_error(LineInfo("Usage: diagonal <textstring>", __FILE__, __LINE__));
        }

        // create a file with 16 rows of empty space
        int fdbinaryout = open("diagonal2.bin", O_CREAT | O_WRONLY | O_TRUNC, S_IRUSR | S_IWUSR);
        if (fdbinaryout == -1) {
            throw domain_error(LineInfo("Open Failed File: diagonal2.bin", __FILE__, __LINE__));
        }
        char space = '.';
        for (int line = 0; line < LINESIZE*(argc-1); line++) {
            for (int column = 0; column < LINESIZE; column++) {
                if (write(fdbinaryout, &space, 1) == -1) {
                    throw domain_error(LineInfo("write() failed", __FILE__, __LINE__));
                }
            }
        }

        // write the input strings diagonally into the file
        int offset = 0;
        for (int k = 1; k < argc; k++) {
            int increment = LINESIZE;
            offset = LINESIZE*LINESIZE*(k-1);
            if (k % 2 == 1){
                increment++;
            }
            else{
                increment--;
                offset += 15;
            }
            
            int n = strlen(argv[k]);
            for (int i = 0; i < n; i++) {
                if (lseek(fdbinaryout, offset, SEEK_SET) == -1) {
                    throw domain_error(LineInfo("lseek() failed", __FILE__, __LINE__));
                }
                if (write(fdbinaryout, &argv[k][i], 1) == -1) {
                    throw domain_error(LineInfo("write() failed", __FILE__, __LINE__));
                }
                offset += increment; // update the offset to the next diagonal position
            }
        }
        close(fdbinaryout);

        cout << "diagonal2.bin has been created." << endl
            << "Use od -c diagonal2.bin to see the contents." << endl;
    }
    catch (exception& e) {
        cout << e.what() << endl;
        cout << endl << "Press the enter key once or twice to leave..." << endl;
        cin.ignore(); cin.get();
        exit(EXIT_FAILURE);
    }

    exit(EXIT_SUCCESS);
}