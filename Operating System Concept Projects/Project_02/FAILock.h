// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009
#include <atomic>
class FAILock {
private:
    std::atomic<int> lockToken;
    std::atomic<int> turnToken;

public:
    void lock();
    void unlock();
};