#include <stdio.h>
#include "grafo_listadj.c"

// Ordenação topológica via DFS (grafo direcionado acíclico)

/*
Ideia geral:
Empilhamos cada vértice no momento em que ele termina, desse modo
o topo da pilha sempre terá vértices "mais à frente" na ordenação,
e desempilhar tudo no final dá a ordenação topológica.
 
Ao finalizar v (cor[v] = 1), em vez de só marcar, empilhamos v
em uma pilha auxiliar (vetor + topo, usado como pilha).

Branco = -1
Cinza = 0
Preto = 1
*/

void visitaTopologica(int v, Grafo* g, int* cor, int* pilha, int* topo) {
    cor[v] = 0;

    ApontadorVerticeAdjacente p = primeiroListaAdj(g, v);

    while (p != VERTICEINVALIDO) {
        int u = verticeDestino(g, p);
        if (cor[u] == -1) {
            visitaTopologica(u, g, cor, pilha, topo);
        }
        p = proxListaAdj(g, v, p);
    }

    cor[v] = 1;
    pilha[(*topo)++] = v;
}

void ordenacaoTopologica(Grafo* g) {
    int n = obtemNumVertices(g);
    int* cor = (int*) malloc(n * sizeof(int));
    // pilha estaticamente
    int* pilha = (int*) malloc(n * sizeof(int));
    int topo = 0;

    for (int i = 0; i < n; i++) {
        cor[i] = -1;
    }

    // Percorre todos os vértices para cobrir componentes desconexas
    for (int i = 0; i < n; i++) {
        if (cor[i] == -1) {
            visitaTopologica(i, g, cor, pilha, &topo);
        }
    }

    // Desempilha (ordem inversa de finalização) e imprime
    for (int i = topo - 1; i >= 0; i--) {
        printf("%d ", pilha[i]);
    }
    printf("\n");

    free(cor);
    free(pilha);
}