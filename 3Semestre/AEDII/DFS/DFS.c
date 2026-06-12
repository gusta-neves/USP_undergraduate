#include <stdio.h>
#include "grafo_listaadj.c" // poderia ser matriz também.

/*
Branco = -1
Cinza = 0
Preto = 1
*/
void visitaDFS(int v, Grafo* g, int* cor, int* tempo, int* tdesc, int* tterm, int* antecessor) {
    cor[v] = 0;
    tdesc[v] = (*tempo)++;

    ApontadorVerticeAdjacente p = primeiroListaAdj(g, v);
    
    while (p != VERTICEINVALIDO) {
        int u = verticeDestino(g, p);
        if (cor[u] == -1) {
            antecessor[u] = v;
            visitaDFS(u, g, cor, tempo, tdesc, tterm, antecessor);
        }

        p = proxListaAdj(g, v, p);
    }

    tterm[v] = (*tempo)++;
    cor[v] = 1;
}

void DFS(Grafo* g) {
    int n = obtemNumVertices(g);
    int* cor = (int*) malloc(n * sizeof(int));
    int* tdesc = (int*) malloc(n * sizeof(int));
    int* tterm = (int*) malloc(n * sizeof(int));
    int* antecessor = (int*) malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        cor[i] = -1;
        tdesc[i] = 0;
        tterm[i] = 0;
        antecessor[i] = -1;
    }

    int tempo = 0;

    for (int i = 0; i < n; i++) {
        if (cor[i] == -1) {
            visitaDFS(i, g, cor, &tempo, tdesc, tterm, antecessor);
        }
    }
}