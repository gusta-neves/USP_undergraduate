#include <stdio.h>
#include <stdlib.h>
#include <float.h>
#include "grafo_listaadj.h"

#define INFINITO FLT_MAX

float d[MAXVERTICES];
int pi[MAXVERTICES]; // antecessor (pi[v])
int emQ[MAXVERTICES]; // 1 se o vertice ainda esta em Q, 0 caso contrario

// RELAX(u, v, w)
void relax(int u, int v, Peso w, int* d, int* a) {
    if (d[v] > d[u] + w) {
        d[v] = d[u] + w;
        a[v] = u;
    }
}

// EXTRACT-MIN(Q): retorna o vertice ainda em Q com menor d[],
// e o remove de Q (busca linear, sem heap)
int extractMin(int n) {
    int u = -1;
    for (int v = 0; v < n; v++) {
        if (emQ[v] && (u == -1 || d[v] < d[u])) {
            u = v;
        }
    }
    emQ[u] = 0; // remove u de Q
    return u;
}

// DIJKSTRA(G, w, s)
void dijkstra(Grafo* g, int s) {
    int n = obtemNumVertices(g);

    initializeSingleSource(g, s);

    // Q = G.V
    for (int v = 0; v < n; v++) {
        emQ[v] = 1;
    }

    // while Q != vazio
    for (int i = 0; i < n; i++) {
        int u = extractMin(n); // u = EXTRACT-MIN(Q); S = S U {u}

        // for each vertex v in G.Adj[u]
        ApontadorVerticeAdjacente p = primeiroListaAdj(g, u);
        while (p != VERTICEINVALIDO) {
            int v = verticeDestino(g, p);
            Peso w = obtemPesoAresta(g, u, v);
            relax(u, v, w);
            p = proxListaAdj(g, u, p);
        }
    }
}

void imprimeCaminho(int v, int s) {
    if (v == s) {
        printf("%d", s);
        return;
    }
    if (pi[v] == -1) {
        printf("(sem caminho)");
        return;
    }
    imprimeCaminho(pi[v], s);
    printf(" -> %d", v);
}

int main() {
    Grafo g;
    int n = 5;
    inicializaGrafo(&g, n);

    // Exemplo com pesos nao-negativos (requisito do Dijkstra)
    insereAresta(&g, 0, 1, 6);
    insereAresta(&g, 0, 2, 7);
    insereAresta(&g, 1, 2, 2);
    insereAresta(&g, 1, 3, 5);
    insereAresta(&g, 2, 3, 4);
    insereAresta(&g, 2, 4, 9);
    insereAresta(&g, 3, 4, 3);

    int s = 0;
    dijkstra(&g, s);

    printf("Caminhos minimos a partir do vertice %d:\n", s);
    for (int v = 0; v < n; v++) {
        printf("v%d: d[%d]=", v, v);
        if (d[v] >= INFINITO) printf("inf");
        else printf("%.1f", d[v]);
        printf(", pi[%d]=%d, caminho: ", v, pi[v]);
        imprimeCaminho(v, s);
        printf("\n");
    }

    liberaGrafo(&g);
    return 0;
}