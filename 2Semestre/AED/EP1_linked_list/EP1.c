#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

char* nroUSP1() {
    return("16986195");
}

char* nroUSP2() {
    return("16985106");
}

int grupo() {
    return 11;
}

typedef struct estr {
        int chave;
        struct estr* prox;
} NO;

typedef struct {
	NO* inicio;
} LISTA;

int contaNO(LISTA* l){
    NO* p = l->inicio;
    int count = 0;

    while(p){
        p = p->prox;
        count++;
    }

    return count;
}

NO* percorreDiferencaLista(LISTA* l, int diferenca){
    NO* posi_correta = l->inicio;

    while(diferenca > 0 && posi_correta){
        posi_correta = posi_correta->prox;
        diferenca--;
    }

    return posi_correta;
}

NO* achaNoCompartilhado(LISTA* l1, LISTA* l2){
    int c1 = contaNO(l1), c2 = contaNO(l2);

    NO* p1 = NULL;
    NO* p2 = NULL;

    if(c1>c2){
        p1 = percorreDiferencaLista(l1, c1-c2);
        p2 = l2->inicio;
    }else{
        p2 = percorreDiferencaLista(l2, c2-c1);
        p1 = l1->inicio;
    }

    while(p1 && p2){
        if(p1 == p2){
            //Nó compartilhado encontrado
            return p1;
        }
        p1 = p1->prox;
        p2 = p2->prox;
    }
    
    //Nó compartilhado não encontrado
    return NULL;
}

NO* copia_pos_compartilhado(NO* p){
    if(!p) return NULL;

    NO* inicio = (NO*) malloc(sizeof(NO));
    inicio->chave = p->chave; inicio-> prox = NULL;

    NO* atual = inicio;
    p = p->prox;

    while(p){
        NO* novo = (NO*) malloc(sizeof(NO));
        novo->chave = p->chave;
        novo->prox = NULL;
        atual->prox = novo;
        atual = novo;
        p = p->prox;
    }

    return inicio;
}

void inverterLista(LISTA* l){
    NO* anterior = NULL;
    NO* atual = l->inicio;
    NO* proximo = NULL;

    while(atual){
        proximo = atual->prox;
        atual->prox = anterior;
        anterior = atual;
        atual = proximo;
    }

    l->inicio = anterior;
}

void separar(LISTA* l1, LISTA* l2) {
    NO* compartilhado = achaNoCompartilhado(l1, l2);

    //Cria uma lista a partir do nó posterior ao compartilhado (já faz o teste se nn é NULL)
    NO* futuro_inicio_l1 = copia_pos_compartilhado(compartilhado->prox);

    //Remove nós após o compartilhado (funciona pra NULL)
    if(compartilhado->prox){
        NO* excluir = compartilhado->prox;
        compartilhado->prox = NULL;
        while(excluir){
            NO* aux = excluir->prox;
            free(excluir);
            excluir = aux;
        }
    }

    if(l1->inicio == l2->inicio){
        l1->inicio = futuro_inicio_l1;
        
        return;
    }else if(l2->inicio == compartilhado){

        NO* penultimo1 = l1->inicio;
        while(penultimo1->prox != compartilhado){
            penultimo1 = penultimo1->prox;
        }

        penultimo1->prox = NULL;

        inverterLista(l1);

        l2->inicio->prox = l1->inicio;
        l1->inicio = futuro_inicio_l1;
        
        return;
    }

    NO* penultimo2 = l2->inicio;
    while(penultimo2->prox != compartilhado){
        penultimo2 = penultimo2->prox;
    }
    penultimo2->prox = NULL;

    inverterLista(l1);

    penultimo2->prox = compartilhado;

    l1->inicio = futuro_inicio_l1;
}