// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009
#include <atomic>

class TASLock{
private:
    std::atomic<bool> locked;

public:
    TASLock() : locked(false){}

    void lock();

    void unlock();

};