#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
using namespace std;


int main(int argc, char *argv[])
{
    const int  key = 13;

    // start from 1 to ignore script name; argv[0] will be a name of processing file.
    for (int i = 1; i < argc; i++) {
        cerr << "argv[" << i << "]: " << argv[i] << endl;
    }

    for (int i = 1; i < argc; i++) {
        char *first_char = argv[i];

        while(*argv[i] != '\0'){
            if (isalpha(*argv[i])) {    // only alphabet is TRUE
                if (*argv[i] > 'z' - key) {
                    *argv[i] = *argv[i] - 'z' + 'a' + key - 1;
                } else if (*argv[i] > 'Z' - key && *argv[i] < 'a') {
                    *argv[i] = *argv[i] - 'Z' + 'A' + key - 1;
                } else {
                    *argv[i] = *argv[i] + key;
                }
            }

            ++argv[i];
        }
        cout << first_char << endl;

    }

    return 0;
}
