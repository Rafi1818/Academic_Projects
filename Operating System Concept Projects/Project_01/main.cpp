#include <iostream>
#include <string>
#include <cstdlib>
#include <fstream>
#include <sstream>
#include <iterator>
#include <array>
#include <vector>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <signal.h>

using namespace std;

int VAL_TO_FIND;

//method to count the number of times user input has been repeated
int count(int* portion, int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        if(portion[i] == VAL_TO_FIND){
            sum++;
        }
    }
    return sum;
}

int main(int argc, char* argv[]){
    //Checking whether there are more than 3 arguments
    if(argc != 4){
            cout << "ERROR! Incorrect number of arguments. Can only accept 3 arguments." << endl << "Terminating Program....." << endl;
            return 1;
    }

    string s_str = argv[1];
    string d_str = argv[3];

    //Checking whether the first argument contains anything other than integer
    for (int i = 0; i < s_str.length(); i++){
        char c = s_str[i];
        if(!((c >= 48) && (c <= 57))){
        cout << "ERROR! Invalid First Argument. Example Format: ./my-count Size <positive int> File_Name <string> Degree <positive int>" << endl << "Terminating Program....." << endl;
            return 1;
        }
    }

    //Checking whether the third argument contains anything other than a positive integer
    for (int i = 0; i < d_str.length(); i++){
        char c = d_str[i];
        if(!((c >= 48) && (c <= 57))){
            cout << "ERROR! Invalid Third Argument. Example Format: ./my-count Size<int> File_Name<string> Degree<int>" << endl << "Terminating Program....." << endl;
            return 1;
        }
    }
    
    int s;
    try{
        s = stoi(argv[1]);
    }catch(exception& e){
        cout << "ERROR! Integer out of bound" << endl << "Terminating Program....." << endl;
        return 1;
    }

    int d;
    try{
        d = stoi(argv[3]);
    }catch(exception& e){
        cout << "ERROR! Degree must be between 1 and 97" << endl << "Terminating Program....." << endl;
        return 1;
    }

    if (d > s){
        cout << "ERROR! Degree must be smaller than Array size." << endl << "Terminating Program....." << endl;
        return 1;
    }

    if ((d < 1) || (d > 97)){
        cout << "ERROR! Degree must be between 1 and 97" << endl << "Terminating Program....." << endl;
        return 1;
    }

    //checking if the file exists
    ifstream file(argv[2]);
    if(!file){
        cout << "ERROR! File does not exist." << endl << "Terminating Program....." << endl;
        return 1;
    }

    string line;
    int ctr = 0;        //counter variable to match the user input with the actual number of integer in the file
    vector<int> A(s);   //vector for storing the integers from the file
    
    //reading integers from the file and storing them in a vector
    while(getline(file, line)){
        
        //checking for invalid integers in the file 
        try{
            int x = stoi(line);
            A[ctr] = x;
        }catch(exception& e){
            cout << "ERROR! Integer out of bound in line: " << (ctr + 1) << endl << "Terminating Program....." << endl;
            return 1;
        }

        if((line.length() > 1) && line[0] == '-'){
            for(int i = 1; i < line.length(); i++){
                char c = line[i];
                if(!((c >= 48) && (c <= 57))){
                    cout << "Invalid integer in line: " << (ctr + 1) << endl << "Terminating Program....." << endl;
                    return 1;
                }
            }
        }

        else{
            for(int i = 0; i < line.length(); i++){
                char c = line[i];
                if(!((c >= 48) && (c <= 57))){
                    cout << "ERROR! Invalid integer in line: " << (ctr + 1) << endl << "Terminating Program....." << endl;
                    return 1;
                }
            }
        }
        ctr += 1;
    }

    //terminate program if number of inputs does not match the file
    if(ctr != s){
        cout << "ERROR! Number of integers in the file does not match the number provided." << endl << "Terminating Program....." << endl;
        return 1;
    }
    
    int num_of_queries = 0;     //counter for the number of queries handled by the program

    while(true){
        string str_v;
        cout << "Enter a value or type quit: ";
        cin >> str_v;
        cout << endl;
        int error_handle = 0;       //value will be changed to -1 if user input is invalid

        //handling errors in user input
        if(str_v == "quit"){
            cout << "Total number of queries handled: " << num_of_queries << endl;
            break;
        }

        if((str_v.length() > 1) && (str_v[0] == '-')){
            for(int i = 1; i < str_v.length(); i++){
                char c = str_v[i];
                if(!((c >= 48) && (c <= 57))){
                    cout << "ERROR! Invalid input. Try Again." << endl;
                    error_handle = -1;
                    break;
                }
            }
        }

        if((str_v[0] != '-') && (error_handle != -1)){
            for(int i = 0; i < str_v.length(); i++){
                char c = str_v[i];
                if(!((c >= 48) && (c <= 57))){
                    cout << "ERROR! Invalid input. Try Again." << endl;
                    error_handle = -1;
                    break;
                }
            }
        }

        if(error_handle != -1){
            try{
                stoi(str_v);
            }catch(exception& e){
                cout << "ERROR! Integer Out Of Bound. Try Again." << endl;
                error_handle = -1;
            }
        }   

        if(error_handle == -1){
            continue;
        }
        
        VAL_TO_FIND = stoi(str_v);

        int shmId;      //shared memory ID
        int* shmPtr;    //pointer to the shared memory

        //creating the shared memory segment
        shmId = shmget(IPC_PRIVATE, s * sizeof(int), IPC_CREAT | 0666);
        if (shmId == -1) {
            cout << "ERROR! Failed to create shared memory!" << endl << "Terminating Program....." << endl;
            return 1;
        }

        //attaching the shared memory segment
        shmPtr = (int*)shmat(shmId, NULL, 0);
        if (shmPtr == (int*)-1) {
            cout << "ERROR! Failed to attach shared memory!" << endl << "Terminating Program....." << endl;
            return 1;
        }

        //copying the array to the shared memory
        copy(A.begin(), A.end(), shmPtr);

        int processResults[d];      //array to store results returned by child processes

        for (int i = 0; i < d; i++) {
            pid_t pid = fork();

            //handling fork failure
            if (pid < 0) {
                cout << "ERROR! Fork failed!" << endl << "Terminating Program....." << endl;
                return 1;
            } 

            //child process
            else if (pid == 0){
                int portionSize = s / d;
                int startIdx = i * portionSize;
                int endIdx;

                //when arraysize % degree != 0
                if(i < d - 1){
                    endIdx = startIdx + portionSize;
                }
                else{
                    endIdx = s;
                }

                int* portion = shmPtr + startIdx;
                int size = endIdx - startIdx;
                int result = count(portion, size);

                //detaching the shared memory segment
                shmdt(shmPtr);

                exit(result);
            }
        }

        //parent process
        for (int i = 0; i < d; i++) {
            int status;
            wait(&status);      //waiting for child process to terminate

            if (WIFEXITED(status)) {
                int childResult = WEXITSTATUS(status);
                processResults[i] = childResult;
                if((i + 1) < 10){ 
                    cout << "Process 0" << i + 1 << " returned: " << childResult << endl;
                }
                else{
                    cout << "Process " << i + 1 << " returned: " << childResult << endl;
                }
            }
        }

        //adding the number of occurences
        int totalSum = 0;
        for (int i = 0; i < d; i++) {
            totalSum += processResults[i];
        }
        cout << VAL_TO_FIND << " has been found " << totalSum << " times." << endl;
        num_of_queries++;

    }
    return 0;
}
