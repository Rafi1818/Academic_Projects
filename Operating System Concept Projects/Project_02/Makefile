OBJS	= main.o PetersonLock.o FAILock.o TASLock.o
SOURCE	= main.cpp PetersonLock.cpp FAILock.cpp TASLock.cpp
HEADER	= PetersonLock.h FAILock.h TASLock.h
OUT	= main
CC	 = g++
FLAGS	 = -g -c -Wall
LFLAGS	 = -lpthread

all: $(OBJS)
	$(CC) -g $(OBJS) -o $(OUT) $(LFLAGS)

main.o: main.cpp
	$(CC) $(FLAGS) main.cpp -std=c++11

PetersonLock.o: PetersonLock.cpp
	$(CC) $(FLAGS) PetersonLock.cpp -std=c++11

FAILock.o: FAILock.cpp
	$(CC) $(FLAGS) FAILock.cpp -std=c++11

TASLock.o: TASLock.cpp
	$(CC) $(FLAGS) TASLock.cpp -std=c++11


clean:
	rm -f $(OBJS) $(OUT)