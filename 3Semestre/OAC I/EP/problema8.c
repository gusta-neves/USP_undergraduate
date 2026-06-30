#include <stdio.h>
// a) Escreva uma função de cabeçalho int divide (int *m, int *n, int d) que recebe três inteiros positivos como parâmetros e devolve 1 se d divide pelo menos um entre *m e *n, 0 caso contrário. Fora isso, se d divide *m, divide *m por d, e o mesmo para o *n.
// b) Escreva um programa que lê dois inteiros positivos m e n e calcula, usando a função acima, o mínimo múltiplo comum entre m e n, ou seja, mmc(m,n).

int divide(int* m, int* n, int d) {
    int ok = 0;

    if ((*m) % d == 0) {
        (*m) /= d;
        ok = 1;
    }

    if ((*n) % d == 0) {
        (*n) /= d;
        ok = 1;
    }

    return ok;
}

int MMC(int m, int n) {
    int d = 2;
    int result = 1; // minimo MMC possivel

    while (m > 1 || n > 1) {
        if (divide(&m, &n, d)) {
            printf("m: %i, n: %i.\n", m, n);
            result *= d;
        } else {
            d++;
        }
    }

    return result;
}

int main() {
    printf("%i", MMC(2,3));
    return 0;
}
