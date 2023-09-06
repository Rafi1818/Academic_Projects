#include <chrono>
#include <limits>
#include <locale>
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include "LineInfo.h"

using namespace std;
using namespace chrono;

int main() {
    for (int a = 1; a <= 10; a++) {
        string s = "";
        stringstream ss;
        ss << a;
        string num = ss.str();
        if (num.length() == 1) {
        num = "0" + num;
        }
        string fileName = num + "bisonsearchin.txt";
        ifstream file(fileName.c_str());
        if (!file.is_open()) {
            cerr << "Error opening file " << fileName << endl;
            return 1;
        }
        getline(file, s);
        
        
        int counter = 0;
        auto timeStart = steady_clock::now();
        for (int j = 0; j < s.length() - 2; j++) {
            if (s[j] == '(' && s[j + 1] == '(') {
                for (int i = j; i < s.length() - 2; i++) {
                    if ((s[i + 1] == ')') && (s[i + 2] == ')')) {
                        counter++;
                    }
                }
            }
        }
        auto timeElapsed1 = duration_cast<nanoseconds> (steady_clock::now() - timeStart);
        int timeElapsed = timeElapsed1.count();
        stringstream s2;
        s2 << timeElapsed;
        string timeTaken = s2.str();
        timeTaken = timeTaken;

        stringstream s1;
        s1 << counter;
        string cnt = s1.str();
        string outFile = num + "bisonsearchout.txt";
        ofstream out(outFile.c_str());
        if (!out.is_open()) {
            cerr << "Error opening file " << outFile << endl;
            return 1;
        }
        string outPut =  "Time Elapsed (nano) : " + timeTaken + "\n" + "Found Pattern Count : " + cnt + "\nSearched Pattern : \n" + s + "\n";
        out << outPut;
        out.close();
    }
    return 0;
}