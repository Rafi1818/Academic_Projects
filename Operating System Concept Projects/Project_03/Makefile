OBJS	= prefix-sum.o barrier.o
SOURCE	= prefix-sum.cpp barrier.cpp
HEADER	= barrier.h
OUT	= prefix-sum
CC	 = g++
FLAGS	 = -g -c -Wall
LFLAGS	 = -lpthread

all: $(OBJS)
	$(CC) -g $(OBJS) -o $(OUT) $(LFLAGS)

prefix-sum.o: prefix-sum.cpp
	$(CC) $(FLAGS) prefix-sum.cpp -std=c++11

barrier.o: barrier.cpp
	$(CC) $(FLAGS) barrier.cpp -std=c++11


clean:
	rm -f $(OBJS) $(OUT)