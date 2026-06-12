#include <stdio.h>
#include "grafo_listadj.c"

// Adaptação da DFS para verificar existência de caminho v1 até v2, dado o Grafo, v1 e v2.

/*
Ideia geral:
A DFS clássica visita TODOS os vértices alcançáveis, sem parar.
Aqui, queremos parar assim que encontrarmos o vértice de destino.

Branco = -1
Cinza = 0
Preto = 1
*/
bool visitaCaminho(int v, int destino, Grafo* g, int* cor, int* antecessor) {
    cor[v] = 0;

    if (v == destino) {
        cor[v] = 1;
        return true;
    }

    ApontadorVerticeAdjacente p = primeiroListaAdj(g, v);

    while (p != VERTICEINVALIDO) {
        int u = verticeDestino(g, p);
        if (cor[u] == -1) {
            antecessor[u] = v;
            // if para verificar se já achamos o destino recursivamente (mais fundo), passando true "pra cima" sem mais chamadas recursivas.
            if (visitaCaminho(u, destino, g, cor, antecessor)) {
                return true;
            }
        }
        p = proxListaAdj(g, v, p);
    }

    cor[v] = 1;
    return false;
}

// imprime o caminho "recursivamente"
void imprimeCaminho(int v1, int v2, int* antecessor) {
    if (v2 == v1) {
        printf("%d", v1);
        return;
    }

    if (antecessor[v2] == -1) {
        // não deveria acontecer se existeCaminho retornou true
        return;
    }

    imprimeCaminho(v1, antecessor[v2], antecessor);
    printf(" -> %d", v2);
}

bool existeCaminho(int v1, int v2, Grafo* grafo) {
    // vetores auxiliares, sem necessidade de tdesc ou tterm
    int n = obtemNumVertices(grafo);
    int* cor = (int*) malloc(n * sizeof(int));
    int* antecessor = (int*) malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        cor[i] = -1;
        antecessor[i] = -1;
    }

    if (visitaCaminho(v1, v2, grafo, cor, antecessor)) {
        imprimeCaminho(v1, v2, antecessor);
        printf("\n");
        free(cor);
        free(antecessor);
        return true;
    }

    free(cor);
    free(antecessor);
    return false;
}