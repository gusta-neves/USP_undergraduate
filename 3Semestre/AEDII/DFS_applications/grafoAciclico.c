#include <stdio.h>
#include "grafo_listadj.c"

// Adaptação da DFS para detectar ciclo (grafoAciclico)

/*
Ideia geral:
Um ciclo existe se, ao explorar os vizinhos de v, encontramos um
vizinho u com cor == 0 (cinza).
Diferente da DFS original, paramos assim que detectamos a aresta que
faz essa conexão.

Branco = -1
Cinza = 0
Preto = 1
*/

bool visitaAciclico(int v, Grafo* g, int* cor, int* antecessor, int* fechaCiclo) {
    cor[v] = 0; 

    ApontadorVerticeAdjacente p = primeiroListaAdj(g, v);

    while (p != VERTICEINVALIDO) {
        int u = verticeDestino(g, p);

        // chamada recursiva normal do DFS
        if (cor[u] == -1) {
            antecessor[u] = v;
            if (visitaAciclico(u, g, cor, antecessor, fechaCiclo)) {
                return true;
            }
        } else if (cor[u] == 0) {
            // achamos um ciclo
            antecessor[u] = v;
            *fechaCiclo = u;
            return true;
        }

        p = proxListaAdj(g, v, p);
    }

    cor[v] = 1;
    return false;
}

void imprimeCiclo(int v, int fechaCiclo, int* antecessor) {
    if (v == fechaCiclo) {
        printf("%d", v);
        return;
    }

    imprimeCiclo(antecessor[v], fechaCiclo, antecessor);
    printf(" -> %d", v);
}

bool grafoAciclico(Grafo* grafo) {
    int n = obtemNumVertices(grafo);
    int* cor = (int*) malloc(n * sizeof(int));
    int* antecessor = (int*) malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        cor[i] = -1;
        antecessor[i] = -1;
    }

    bool aciclico = true;

    for (int i = 0; i < n; i++) {
        if (cor[i] == -1) {
            int fechaCiclo = -1;
            if (visitaAciclico(i, grafo, cor, antecessor, &fechaCiclo)) {
                aciclico = false;
                
                imprimeCiclo(antecessor[fechaCiclo], fechaCiclo, antecessor);
                printf(" -> %d\n", fechaCiclo);

                break;
            }
        }
    }

    free(cor);
    free(antecessor);

    return aciclico;
}