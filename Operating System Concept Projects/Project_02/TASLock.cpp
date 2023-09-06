// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009
#include "TASLock.h"


void TASLock::lock() {
    while (locked.exchange(true, std::memory_order_acquire));
}

void TASLock::unlock() {
    locked.store(false, std::memory_order_release);
}