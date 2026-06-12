#include <stdio.h>
#include "grafo_listadj.c"

// Componentes conexos (grafo não direcionado)

/*
Ideia geral:
Em grafo não direcionado, basta uma DFS simples por vértice não
visitado, já que tudo que essa DFS alcança forma um componente
conexo.

Para descobrir se um grafo é conectado basta chamar a função
componentesConexos e verificar se ela retorna 1.
*/

void visitaComponenteConexo(int v, Grafo* g, int* cor) {
    cor[v] = 0;
    printf("%d ", v);

    ApontadorVerticeAdjacente p = primeiroListaAdj(g, v);
    while (p != VERTICEINVALIDO) {
        int u = verticeDestino(g, p);
        if (cor[u] == -1) {
            visitaComponenteConexo(u, g, cor);
        }
        p = proxListaAdj(g, v, p);
    }

    cor[v] = 1;
}

int componentesConexos(Grafo* grafo) {
    int n = obtemNumVertices(grafo);
    int* cor = (int*) malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        cor[i] = -1;
    }

    int numComponentes = 0;

    for (int i = 0; i < n; i++) {
        if (cor[i] == -1) {
            printf("Componente %d: ", numComponentes + 1);
            visitaComponenteConexo(i, grafo, cor);
            printf("\n");
            numComponentes++;
        }
    }

    free(cor);

    return numComponentes;
}