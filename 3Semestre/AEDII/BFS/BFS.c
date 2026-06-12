#include <stdio.h>
#include "grafo_listadj.c"

/*
Ideia geral:
a BFS usa uma fila explícita e visita os vértices
em ondas: primeiro todos os vizinhos diretos da origem, depois os
vizinhos desses, e assim por diante. Isso garante que tdesc[v]
reflita a distância (em número de arestas) da origem até v.

BFS é útil para achar o caminho mais curto de um vértice origem a um destino

Branco = -1
Cinza = 0
Preto = 1
*/
void visitaBFS(int s, Grafo* g, int* cor, int* dist, int* antecessor) {
    int n = obtemNumVertices(g);
    int* fila = (int*) malloc(n * sizeof(int));
    int inicio = 0, fim = 0;

    cor[s] = 0;
    dist[s] = 0;
    // já coloca o elemento na fila
    fila[fim++] = s;

    while (inicio < fim) {
        int v = fila[inicio++];

        ApontadorVerticeAdjacente p = primeiroListaAdj(g, v);
        while (p != VERTICEINVALIDO) {
            int u = verticeDestino(g, p);

            if (cor[u] == -1) {
                cor[u] = 0;
                dist[u] = dist[v] + 1;
                antecessor[u] = v;
                // adiciona os vizinhos na fila
                fila[fim++] = u;
            }

            p = proxListaAdj(g, v, p);
        }

        cor[v] = 1;
    }

    free(fila);
}

void BFS(Grafo* g) {
    int n = obtemNumVertices(g);
    int* cor = (int*) malloc(n * sizeof(int));
    int* dist = (int*) malloc(n * sizeof(int));
    int* antecessor = (int*) malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        cor[i] = -1;
        dist[i] = -1;
        antecessor[i] = -1;
    }

    // Percorre todos os vértices para cobrir componentes desconexos
    for (int i = 0; i < n; i++) {
        if (cor[i] == -1) {
            visitaBFS(i, g, cor, dist, antecessor);
        }
    }

    free(cor);
    free(dist);
    free(antecessor);
}