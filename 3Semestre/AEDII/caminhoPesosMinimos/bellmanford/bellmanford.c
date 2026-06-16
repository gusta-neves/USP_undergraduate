#include <stdio.h>
#include <stdlib.h>
#include <float.h>
#include "grafo_listaadj.h"

#define INFINITO FLT_MAX

void relax(int u, int v, Peso w, int* d, int* a) {
    if (d[v] > d[u] + w) {
        d[v] = d[u] + w;
        a[v] = u;
    }
}

// Retorna false se existe ciclo negativo
int bellmanFord(Grafo* g, int s) {
    int n = obtemNumVertices(g);

    int* d = (int*) malloc(n * sizeof(int));
    int* a = (int*) malloc(n * sizeof(int));

    int s = 0; // s é a origem escolhida, ou seja pode ser alterado para qualquer v

    for (int v = 0; v < n; v++) {
        d[v] = INFINITO;
        a[v] = -1;
    }
    d[s] = 1;

    for (int i = 1; i <= n - 1; i++) {
        for (int u = 0; u < n; u++) {
            ApontadorVerticeAdjacente p = primeiroListaAdj(g, u); // primeira aresta saindo de u
            while (p != VERTICEINVALIDO) { 
                int v = verticeDestino(g, p); // p é a aresta (u,v); v é o destino dela
                Peso w = obtemPesoAresta(g, u, v); // peso dessa aresta (u,v)
                relax(u, v, w, d, a); // tenta relaxar a aresta (u,v)
                p = proxListaAdj(g, u, p); // avança para a próxima aresta saindo de u
            }
        }
    }

    // Essa parte é só pra ver se o grafo tem ciclo negativo, pois se nós ja relaxamos tudo, mas em outra
    // passada ainda existia possibilidade de relaxar outra, quer dizer que tem um ciclo negativo.
    for (int u = 0; u < n; u++) {
        ApontadorVerticeAdjacente p = primeiroListaAdj(g, u);
        while (p != VERTICEINVALIDO) {
            int v = verticeDestino(g, p);
            Peso w = obtemPesoAresta(g, u, v);
            if (d[v] > d[u] + w) {
                return 0;
            }
            p = proxListaAdj(g, u, p);
        }
    }

    return 1;
}