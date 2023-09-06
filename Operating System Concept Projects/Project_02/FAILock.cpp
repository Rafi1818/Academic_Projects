// Written by Zamir Khan and Tahmidul Karim, for CS 4348
// NetID: ZHK210000, TXK210009

#include "FAILock.h"

void FAILock::lock() {
    int myToken = lockToken.fetch_add(1);
    while (turnToken != myToken) {
        //Wait
    }
}

void FAILock::unlock() {
    turnToken++;
}