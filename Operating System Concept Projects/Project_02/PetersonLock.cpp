// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009

#include "PetersonLock.h"

void PetersonLock::lock(int thread_id) {
    flag[thread_id] = true;
    turn = 1 - thread_id;

    while (flag[turn] && (turn!=thread_id));
}

void PetersonLock::unlock(int thread_id) {
    flag[thread_id] = false;
}
