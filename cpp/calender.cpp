#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
using namespace std;


int main(int argc, char *argv[])
{

    // start from 1 to ignore script name; argv[0] will be a name of processing file.
    for (int i = 1; i < argc; i++) {
        cout << "argv[" << i << "]: " << argv[i] << endl;
        //cerr << "argv[" << i << "]: " << argv[i] << endl;
    }

    int daysInYear = atoi(argv[1]);
    int daysInMonth = atoi(argv[2]);
    int daysInWeek = atoi(argv[3]);

    char *yearstr, *monthstr, *daystr;
    yearstr = strtok(argv[4], "-");
    monthstr = strtok(NULL, "-");
    daystr = strtok(NULL, "-");
    int yearint = atoi(yearstr);
    int monthint = atoi(monthstr);
    int dayint = atoi(daystr);

    if (daysInMonth < dayint) {
        cout << -1 << endl;
        return 0;
    }
    if (daysInYear / daysInMonth < monthint) {
        cout << -1 << endl;
        return 0;
    }

    if (daysInYear % daysInWeek == 0) {
        int youbi = dayint % daysInWeek;
        if (youbi == 0) {
            youbi = daysInWeek;
        }
        char output = 'A' + youbi - 1;
        cout << output << endl;
        return 0;
    }
    /*
    else if (yearint == 1 && monthint == 1 && daysInWeek >= dayint) {
        int youbi = dayint % (daysInWeek + 1);
        char output;
        if (youbi == 0) {
            output = 'A' + daysInWeek - 1;
        } else {
            output = 'A' + youbi - 1;
        }
        cout << output << endl;
        return 0;
    }
    */
  
    return 0;
}
