// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009
#include <iostream>
#include <cstdio>
#include <thread>
#include "TASLock.h"
#include "FAILock.h"
#include "PetersonLock.h"
#include <vector> 
#include <cmath>


const int Number_of_threads = 100;
const int Number_of_iterations = 1000000;

int algo, numThreads, levels;
int counter [Number_of_threads];
int *levelArr;
std::string algoType;

FAILock fai_lock;
TASLock tas_lock;
PetersonLock* pt_lock;


// Increment Method
void count(){
    for(int i=0;i<Number_of_iterations;i++){
        counter[0]++;
    }
}

// Calculate Level of tree
int calculateLevels(int numLeafNodes) {
    return static_cast<int>(std::ceil(std::log2(numLeafNodes)));
}

// Implement Tournament Tree
void TournamentTree(int thread_id,int curLevel, int offset) {//0,0,0
    int lock_id = thread_id/2; // 0/2 = 0
    int port_id = thread_id%2; // 0%2 = 0
    if(numThreads==1){
        curLevel+=1;
    }
    // Base Case
    if(curLevel==0){
        pt_lock[lock_id+offset].lock(port_id); // 0+2=2, 0
        count();
        pt_lock[lock_id+offset].unlock(port_id);// 2,0
    }
    else{ // Recursive Case
        pt_lock[lock_id+offset].lock(port_id); //0+0=0, 0
        TournamentTree(lock_id,curLevel-1, offset+pow(2,curLevel));
        pt_lock[lock_id+offset].unlock(port_id); //0+0=0, 0
    }
}

// Picking Lock based on argument
void doWork(int thread_id, int lock_type, int curLevel){
    if(lock_type==0){
        algoType = "Tournament-Tree (TT)";
        TournamentTree(thread_id,curLevel,0);
    }

    else if(lock_type==1) {
        algoType = "Test-And-Set (TAS)";
        tas_lock.lock();
        count();
        tas_lock.unlock();
    }
    else{
        algoType = "Fetch-And-Increment (FAI)";
        fai_lock.lock();
        count();
        fai_lock.unlock();
    }
}

int main(int argc, char* argv[]) {
    if(argc != 3){
        fprintf(stderr,"ERROR: Arguments must be exactly 2\n");
        exit(EXIT_FAILURE);
    }
    algo = atoi(argv[1]);
    numThreads = atoi(argv[2]);
    levels = calculateLevels(numThreads);
    //if(numThreads==1){
    //    levels +=1;     //adding 1 to get levels for singular thread
    //}

    if(algo < 0 || algo >2){
        fprintf(stderr,"ERROR: Invalid Algorithm Type!\n");
        exit(EXIT_FAILURE);
    }
    if(numThreads <= 0 || numThreads>Number_of_threads){
        fprintf(stderr,"ERROR: Number of Threads has to be between 1-100\n");
        exit(EXIT_FAILURE);
    }

    //Initialize Counter
    for(int i=0;i<numThreads;i++){
        counter[i]=0;
    }

    pt_lock = new PetersonLock[numThreads-1];

    //Work in individual threads
    std::thread workers[numThreads];

    for(int i=0;i<numThreads;++i){
        workers[i] = std::thread(doWork,i,algo,levels-1);
    }

    //Wait for all worker to finish
    for(int i=0;i<numThreads;++i){
        workers[i].join();
    }

    //Print Result
    for(int i=0;i<1;++i){
        std::cout << "Lock Type:      "+algoType<<std::endl;
        std::cout << "Level:          "<<levels<<std::endl;
        std::cout << "Expected Value: "<< numThreads*Number_of_iterations<<std::endl;
        std::cout << "Counter Value:  "<< counter[i]<< std::endl;
    }
    return 0;
}