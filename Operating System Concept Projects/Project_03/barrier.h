#ifndef BARRIER_H
#define BARRIER_H


#include <semaphore.h>
#include <atomic>
#include <mutex>

namespace synchronization
{

   // Provides a reusable barrier
   class barrier {
   private:
       sem_t mutex;
       sem_t barr;
       sem_t barr2;
       std::atomic<int> thread_count;
       int num_threads;
   public:

      // Constructor
      barrier( int numberOfThreads );

      // Destructor
      ~barrier( );

      // Function to wait at the barrier until all threads have reached the barrier
      void arriveAndWait( void );
   };

}

#endif