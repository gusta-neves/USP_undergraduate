#include <stdio.h>
#include <stdlib.h>

#define MAXVERTICES 100
#define VERTICEINVALIDO NULL

typedef float Peso;

typedef struct aresta {
    int vdest;
    Peso peso;
    struct aresta* prox;
} Aresta;

typedef Aresta* ApontadorVerticeAdjacente;

typedef struct {
    int numVertices;
    ApontadorVerticeAdjacente* listaAdj;
} Grafo;

int verificaValidadeGrafo(Grafo* g) {
    if (!g) {
        printf("ERRO na chamada de 'verificaValidadeGrafo' do grafo.\n");
        return 0;
    }

    return 1;
}

int verificaValidadeVertice(Grafo* g, int v) {
    verificaValidadeGrafo(g);

    if (v < 0) {
        return 0;
    }
    if (v >= g->numVertices) {
        return 0;
    }

    return 1;
}

int inicializaGrafo(Grafo* g, int n) {
    verificaValidadeGrafo(g);

    if (n <= 0) {
        printf("ERRO na chamada de 'inicializaGrafo', numero de vertices invalido.\n");
        return 0;
    }

    g->numVertices = n;
    g->listaAdj = (ApontadorVerticeAdjacente*) calloc(n, sizeof(ApontadorVerticeAdjacente));

    if (!g->listaAdj) {
        printf("ERRO falha na alocacao de memoria do vetor na funcao 'inicializarGrafo'.\n");
        return 0;
    }

    return 1;
}

int obtemNumVertices(Grafo* g) {
    verificaValidadeGrafo(g);
    return g->numVertices;
}

int listaAdjVazia(Grafo* g, int v) {
    verificaValidadeVertice(g, v);

    return g->listaAdj[v] == NULL;
}

ApontadorVerticeAdjacente proxListaAdj(Grafo* g, int v, ApontadorVerticeAdjacente atual) {
    verificaValidadeVertice(g, v);

    if (!atual) return VERTICEINVALIDO;
    return atual->prox;
}

ApontadorVerticeAdjacente primeiroListaAdj(Grafo* g, int v) {
    verificaValidadeVertice(g, v);

    return g->listaAdj[v];
}

int existeAresta(Grafo* g, int v1, int v2) {
    verificaValidadeVertice(g, v1);
    verificaValidadeVertice(g, v2);
    
    ApontadorVerticeAdjacente p = g->listaAdj[v1];

    while (p && p->vdest != v2) p = p->prox;

    if (!p) return 0;

    return 1;
}

Peso obtemPesoAresta(Grafo* g, int v1, int v2) {
    verificaValidadeVertice(g, v1);
    verificaValidadeVertice(g, v2);

    ApontadorVerticeAdjacente p = g->listaAdj[v1];

    while (p && p->vdest != v2) p = p->prox;

    if (!p) {
        printf("ERRO ao obter peso da aresta que nao existe.\n");
        return -1.0;
    }
    
    return p->peso;
}

// Suponha que a aresta existe;
void insereAresta(Grafo* g, int v1, int v2, Peso p) {
    verificaValidadeVertice(g, v1);
    verificaValidadeVertice(g, v2);

    ApontadorVerticeAdjacente novo = (ApontadorVerticeAdjacente) malloc(sizeof(Aresta));

    if (!novo) {
        printf("ERRO na alocacao de memoria para criar uma nova aresta.\n");
        return;
    }

    novo->vdest = v2;
    novo->peso = p;
    novo->prox = g->listaAdj[v1];
    g->listaAdj[v1] = novo;

    novo = (ApontadorVerticeAdjacente) malloc(sizeof(Aresta));

    if (!novo) {
        printf("ERRO na alocacao de memoria para criar uma nova aresta.\n");
        return;
    }

    novo->vdest = v1;
    novo->peso = p;
    novo->prox = g->listaAdj[v2];
    g->listaAdj[v2] = novo;
}
//
int removeAresta(Grafo* g, Peso* peso, int v1, int v2) {
    verificaValidadeVertice(g, v1);
    verificaValidadeVertice(g, v2);

    ApontadorVerticeAdjacente p, ant;

    p = g->listaAdj[v1];
    ant = NULL;

    while (p && p->vdest != v2) {
        ant = p;
        p = p->prox;
    }
    
    if (!p) {
        printf("ERRO ao tentar remover aresta que nao existe.\n");
        return 0;
    }

    if (ant) {
        ant->prox = p->prox;
    } else {
        g->listaAdj[v1] = p->prox;
    }

    *peso = p->peso;
    p->prox = NULL;
    free(p);
    p = NULL;

    p = g->listaAdj[v2];
    ant = NULL;

    while (p && p->vdest != v1) {
        ant = p;
        p = p->prox;
    }

    if (!p) {
        printf("ERRO ao tentar remover aresta que nao existe.\n");
        return 0;
    }

    if (ant) {
        ant->prox = p->prox;
    } else {
        g->listaAdj[v2] = p->prox;
    }

    return 1;
}

void liberaLinha(ApontadorVerticeAdjacente p) {
    if (!p) return;
    liberaLinha(p->prox);
    free(p);
}

void imprimeGrafo(Grafo* g) {
    verificaValidadeGrafo(g);
    ApontadorVerticeAdjacente p;
    
    for (int i = 0; i < g->numVertices; i++) {
        p = g->listaAdj[i];
        printf("v%i: ", i);
        while (p) {
            printf("(adj%i, peso%.1f); ", p->vdest, p->peso);
            p = p->prox;
        }
        printf("\n");
    }
}

void liberaGrafo(Grafo* g) {
    verificaValidadeGrafo(g);

    for (int i = 0; i < g->numVertices; i++) {
        liberaLinha(g->listaAdj[i]);
        g->listaAdj[i] = NULL;
    }

    g->numVertices = 0;
    free(g->listaAdj);
    g->listaAdj = NULL;
}

int verticeDestino(Grafo* g, ApontadorVerticeAdjacente p) {
    verificaValidadeGrafo(g);
    if (p) return p->vdest;

    printf("ERRO na funcao verticeDestino, passagem de p = NULL.\n");
    return 0;
}
