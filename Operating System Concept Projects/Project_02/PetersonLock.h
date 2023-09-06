// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009

#include <atomic>
#include <thread>
#include <vector>
#include <cmath>
#include <mutex>

class PetersonLock {
private:
    std::atomic<bool> flag[2];
    std::atomic<int> turn ;

public:
    void lock(int thread_id);
    void unlock(int thread_id);

};
