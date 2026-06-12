#include <stdio.h>
#include <stdlib.h>

#define MAXVERTICES 100
#define ARESTANULA -1.0
#define VERTICEINVALIDO -1

typedef float Peso;

typedef struct {
    Peso matriz[MAXVERTICES][MAXVERTICES];
    int numVertices;
} Grafo;

typedef int ApontadorVerticeAdjacente;


int verificaValidadeGrafo(Grafo* g) {
    if (!g) {
        printf("ERRO na chamada de inicializacao do grafo.\n");
        return 0;
    }

    return 1;
}

int verificaValidadeVertice (Grafo* g, int v) {
    verificaValidadeGrafo(g);
    if (v < 0) {
        printf("ERRO na funcao verificaValidadeVertice, vertices menor que zero.\n");
        return 0;
    }
    if (v >= g->numVertices) {
        printf("ERRO na funcao verificaValidadeVertice, %i maior que o numero de vertices %i.\n", v, g->numVertices);
        return 0;
    }

    return 1;
}

int inicializaGrafo(Grafo* g, int n) {
    verificaValidadeGrafo(g);

    g->numVertices = n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            g->matriz[i][j] = ARESTANULA;
        }
    }

    return 1;
}

int obtemNumVertices(Grafo* g) {
    verificaValidadeGrafo(g);

    return g->numVertices;
}

ApontadorVerticeAdjacente proxListaAdj(Grafo* g, int v, ApontadorVerticeAdjacente atual) {
    verificaValidadeVertice(g, v);

    if (atual == VERTICEINVALIDO) return VERTICEINVALIDO;

    for (int i = atual+1; i < g->numVertices; i++) {
        if (g->matriz[v][i] != ARESTANULA) return i;
    }

    return VERTICEINVALIDO;
}

ApontadorVerticeAdjacente primeiroListaAdj(Grafo* g, int v) {
    verificaValidadeVertice(g, v);
    
    for (int i = 0; i < g->numVertices; i++) {
        if (g->matriz[v][i] != ARESTANULA) return i;
    }
    
    return VERTICEINVALIDO;
}

int listaAdjVazia(Grafo* g, int v) {
    verificaValidadeVertice(g,v);

    for (int i = 0; i < g->numVertices; i++) {
        if (g->matriz[v][i] != ARESTANULA) return 0;
    }

    return 1;
}

int existeAresta(Grafo* g, int v1, int v2) {
    verificaValidadeVertice(g,v1);
    verificaValidadeVertice(g,v2);

    return g->matriz[v1][v2] != ARESTANULA;
}

Peso obtemPesoAresta(Grafo* g, int v1, int v2) {
    verificaValidadeVertice(g,v1);
    verificaValidadeVertice(g,v2);

    if (g->matriz[v1][v2] == ARESTANULA) {
        printf("ERRO ao obter peso da aresta que nao existe.\n");
        return -1.0;
    }

    return g->matriz[v1][v2];
}

void insereAresta(Grafo* g, int v1, int v2, Peso peso) {
    verificaValidadeVertice(g,v1);
    verificaValidadeVertice(g,v2);

    g->matriz[v1][v2] = peso;
    g->matriz[v2][v1] = peso;
}

int removeAresta(Grafo* grafo, Peso* peso, int v1, int v2) {
    verificaValidadeVertice(grafo,v1);
    verificaValidadeVertice(grafo,v2);

    if (grafo->matriz[v1][v2] == ARESTANULA) {
        printf("Erro ao tentar remover aresta que não existe.\n");
        return 0;
    }
    *peso = grafo->matriz[v1][v2];
    grafo->matriz[v1][v2] = ARESTANULA;
    grafo->matriz[v2][v1] = ARESTANULA;

    return 1;
}

void imprimeGrafo(Grafo* g) {
    verificaValidadeGrafo(g);

    for (int i = 0; i < g->numVertices; i++) {
        printf("v%i: ", i);

        for (int j = 0; j < g->numVertices; j++) {
            if (g->matriz[i][j] != ARESTANULA) {
                printf("(adj%i, peso%.1f); ", j, g->matriz[i][j]);
            }
        }

        printf("\n");
    }
}

void liberaGrafo(Grafo* g) {
    verificaValidadeGrafo(g);
    // nao tem como liberar grafo na aplicacao por matriz
    g->numVertices = 0;
}

int verticeDestino(Grafo* g, ApontadorVerticeAdjacente p) {
    verificaValidadeGrafo(g);

    if (p != VERTICEINVALIDO) return (int) p;

    printf("Erro na funcao 'verticeDestino' com 'p' sendo vertice invalido.\n");

    return 0;
}