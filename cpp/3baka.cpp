#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
using namespace std;

int main(int argc, char *argv[])
{
    const int baka = 3;

    // start from 1 to ignore script name; argv[0] will be a name of processing file.
    for (int i = 1; i < argc; i++) {
        cerr << "argv[" << i << "]: " << argv[i] << endl;
    }

    for (int i = 1; i < argc; i++) {
        char *first_char = argv[i];
        int error = 0;
        int input_number = atoi(argv[i]);

        while(*argv[i] != '\0'){    // 非負整数以外の入力に対してinvalidを返すための条件
            if (!isdigit(*argv[i])) {
                error = 1;
                break;
            }
            ++argv[i];
        }
        if (input_number > 1000) {    // 1000より大きい整数に対しinvalidを返すための条件
            error = 1;
        }

        if (error) {
            cout << "invalid" << endl;
            continue;
        }

        int degree_of_baka = 0;
        if (input_number % baka == 0) {
            degree_of_baka++;
        }
        if (input_number / 100 == baka || input_number % 100 / 10 == baka || input_number % 10 == baka) {
            degree_of_baka = degree_of_baka + 2;
        }

        switch (degree_of_baka) {
            case 0:
                cout << "smart" << endl;
                break;
            case 1:
                cout << "idiot" << endl;
                break;
            case 2:
                cout << "stupid" << endl;
                break;
            case 3:
                cout << "dumb" << endl;
                break;
            default:
                cerr << "unexpected strings are input" << endl;
                break;
        }
    }

    return 0;
}
