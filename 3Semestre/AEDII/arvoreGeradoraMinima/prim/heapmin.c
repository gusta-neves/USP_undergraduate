#include <stdio.h>
#include <stdlib.h>

typedef float Peso;

typedef struct {
    int vertice;
    Peso valor;
} ElemFP;

typedef struct {
    ElemFP* vetor;
    int numElem;
    int capaMAX;
    int* pos;
} FilaDePrioridade;

void heapify(FilaDePrioridade* fp, int i) {
    int esq = 2*i+1;
    int dir = 2*i+2;
    int menor = i;

    if (esq < fp->numElem && fp->vetor[esq].valor < fp->vetor[menor].valor) menor = esq;
    if (dir < fp->numElem && fp->vetor[dir].valor < fp->vetor[menor].valor) menor = dir;

    if (menor == i) return;
    
    ElemFP temp = fp->vetor[i];
    fp->vetor[i] = fp->vetor[menor];
    fp->vetor[menor] = temp;
    
    fp->pos[fp->vetor[i].vertice] = i;
    fp->pos[fp->vetor[menor].vertice] = menor;
    heapify(fp, menor);
}

void constroiHeapMin(FilaDePrioridade* fp) {
    for (int i = fp->numElem/2 - 1; i >= 0; i--) heapify(fp, i); 
}

int inicializaFilaDePrioridade(FilaDePrioridade* fp, int numElem, Peso peso) {
    if (!fp || numElem < 1) return 0;

    fp->numElem = numElem;
    fp->capaMAX = numElem;
    
    fp->vetor = (ElemFP*) malloc(numElem * sizeof(ElemFP));
    if (!fp->vetor) {
        printf("ERRO ao inicializar fila de prioridade, em 'fp->vetor'.\n");
        return 0;
    }
    
    fp->pos = (int*) malloc(numElem *sizeof(int));
    if (!fp->pos) {
        printf("ERRO ao inicializar fila de prioridade, em 'fp->pos'.\n");
        return 0;
    }

    for (int i = 0; i<numElem; i++) {
        fp->vetor[i].vertice = i;
        fp->vetor[i].valor = peso;
        fp->pos[i] = i;
    }

    return 1;
}

int filaDePrioridadeVazia(FilaDePrioridade* fp) {
    if (!fp || fp->numElem == 0) return 1;
    return 0;
}

void atualizaPosicao(FilaDePrioridade* fp, int pos) {
    if (!fp || pos<0 || pos >= fp->numElem) return;

    Peso valor = fp->vetor[pos].valor;
    int posPai = (pos-1)/2;
    ElemFP temp;

    while (pos > 0 && fp->vetor[posPai].valor > valor) {
        temp = fp->vetor[pos];
        fp->vetor[pos] = fp->vetor[posPai];
        fp->vetor[posPai] = temp;
        fp->pos[fp->vetor[posPai].vertice] = posPai;
        fp->pos[fp->vetor[pos].vertice] = pos;
        pos = posPai;
        posPai = (pos-1)/2;
    }
}

int diminuiPrioridade(FilaDePrioridade* fp, int vertice, Peso valor) {
    if (!fp || vertice < 0 || vertice >= fp->capaMAX) return 0;

    int pos = fp->pos[vertice];
    if (pos == -1) return 0;

    if (fp->vetor[pos].valor <= valor) return 0;
    
    fp->vetor[pos].valor = valor;
    atualizaPosicao(fp, pos);
    return 1;
}

ElemFP extraiMin(FilaDePrioridade* fp) {
    ElemFP raiz = fp->vetor[0];
    ElemFP ultimo = fp->vetor[fp->numElem - 1];

    fp->vetor[0] = ultimo;
    fp->pos[ultimo.vertice] = 0;

    fp->numElem--;
    heapify(fp, 0);

    fp->pos[raiz.vertice] = -1;

    return raiz;
}