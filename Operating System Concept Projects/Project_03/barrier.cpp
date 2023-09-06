#include "barrier.h"

using namespace synchronization;


barrier::barrier( int numberOfThreads ){
    num_threads = numberOfThreads;
    thread_count=0;
    sem_init(&mutex,0,1);
    sem_init(&barr,0,0);
    sem_init(&barr2,0,0);
    return;
}

barrier::~barrier( ) {
    sem_destroy(&mutex);
    sem_destroy(&barr);
    sem_destroy(&barr2);
    return;
}

void barrier::arriveAndWait( void ) {

    sem_wait(&mutex);   // get mutex lock
    thread_count++;     // increment counter

    if(thread_count==num_threads){
        for(int i = 0; i < num_threads - 1; i++){
            sem_post(&barr);
        }
        sem_wait(&barr2);
        thread_count--;
        sem_post(&mutex);
    }

    else {
        sem_post(&mutex);
        sem_wait(&barr);
        thread_count--;
        if(thread_count == 1){
            sem_post(&barr2);
        }
    }
    
    return;
}