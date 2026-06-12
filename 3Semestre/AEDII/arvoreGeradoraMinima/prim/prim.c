#include <stdio.h>
#include <stdlib.h>
#include <float.h>
#include "grafo_listadj.c"
#include "heap_min.c"

#define PESO_INFINITO FLT_MAX

// AGM - Prim, usando a FilaDePrioridade (heap mínima)

void AGM_Prim(Grafo* grafo, int verticeRaiz) {
    int n = obtemNumVertices(grafo);

    Peso* chave_minPeso = (Peso*) malloc(n * sizeof(Peso));
    int* antecessor = (int*) malloc(n * sizeof(int));

    FilaDePrioridade filaP;
    inicializaFilaDePrioridade(&filaP, n, PESO_INFINITO);

    for (int u = 0; u < n; u++) {
        chave_minPeso[u] = PESO_INFINITO;
        antecessor[u] = -1;
    }

    chave_minPeso[verticeRaiz] = 0;
    diminuiPrioridade(&filaP, verticeRaiz, 0);

    while (!filaDePrioridadeVazia(&filaP)) {
        ElemFP minimo = extraiMin(&filaP);
        int u = minimo.vertice;

        ApontadorVerticeAdjacente p = primeiroListaAdj(grafo, u);
        while (p != VERTICEINVALIDO) {
            int v = verticeDestino(grafo, p);
            Peso peso_uv = obtemPesoAresta(grafo, u, v);

            // v pertence a filaP então ainda não foi extraido
            if (filaP.pos[v] != -1 && peso_uv < chave_minPeso[v]) {
                antecessor[v] = u;
                chave_minPeso[v] = peso_uv;
                diminuiPrioridade(&filaP, v, peso_uv);
            }

            p = proxListaAdj(grafo, u, p);
        }
    }

    printf("Arvore Geradora Minima:\n");
    for (int v = 0; v < n; v++) {
        if (antecessor[v] != -1) {
            printf("%d -- %d (peso %.2f)\n", antecessor[v], v, chave_minPeso[v]);
        }
    }

    free(chave_minPeso);
    free(antecessor);
    free(filaP.vetor);
    free(filaP.pos);
}