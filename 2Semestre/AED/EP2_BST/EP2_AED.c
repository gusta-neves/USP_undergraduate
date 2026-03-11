#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>

const char* nroUSP1() {
    return("16986195");
}

const char* nroUSP2() {
    return("16985106");
}

int grupo() {
	return 11;
}

// no da arvore
typedef struct estr {
    int chave;
    struct estr *esq;
	struct estr *dir;
} NO;

/////////////////////FILA AUXILIAR///////////////////////////////

// no de lista ligada (caso queira usar alguma estrutura auxiliar)
typedef struct estrL {
    NO* pont_arv;
    struct estrL *prox;
} NOL;

//fila que guardar nós que guardam ponteiros para nó da arvore
typedef struct{
    NOL* inicio;
    NOL* fim;
}FILA;

///////////////////FUNÇÕES PUSH E POP////////////////////////////////////

void push(FILA* f, NO* n){
    NOL* novo = (NOL*)malloc(sizeof(NOL));
    novo->pont_arv = n;
    novo->prox = NULL;
    
    if(f->fim){
        f->fim->prox = novo;
    }else{
        f->inicio = novo;
    }
    f->fim = novo;
}

NO* pop(FILA* f) {
    if(!f->inicio) return NULL;

    NOL* temp = f->inicio;
    NO* resultado = temp->pont_arv;
    f->inicio = f->inicio->prox;
    
    if(!f->inicio) f->fim = NULL;

    free(temp);
    return resultado;
}

/////////////////////////////////////////////////////////////////////////

NO* criarNo(int chave) {
    NO* novo = (NO*)malloc(sizeof(NO));
    novo->chave = chave;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

///////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////

int achaNivelMaisExtenso(NO* raiz){
    if(!raiz) return 0;
    
    FILA* f = (FILA*) malloc(sizeof(FILA));
    if(!f) return 0; //previnindo erro pq sim;
    f->inicio = NULL;
    f->fim = NULL;

    push(f, raiz);

    int nivelAtual = 0, nivelMax = 0, maxNOS = 0;

    while(f->inicio){
        int nosNivel = 0;
        NOL* temp = f->inicio;

        //Conta quantos nós tem no nivel atual
        while(temp){
            nosNivel++;
            temp = temp->prox;
        }

        //atualiza os maximos se eles forem superados
        if(nosNivel > maxNOS){
            maxNOS = nosNivel;
            nivelMax = nivelAtual; 
        }

        for(int i = 0; i<nosNivel; i++){
            NO* atual = pop(f);
            if(atual->esq) push(f, atual->esq);
            if(atual->dir) push(f, atual->dir);
        }

        nivelAtual++;
    }
    
    free(f);
    return nivelMax;
}

/////////////////////////////////////////////////////////////////////////

void removerNo(NO** raiz, NO* pai, NO* alvo) {
    if(!alvo) return;

    // Caso 1: nó é folha
    if(!alvo->esq && !alvo->dir){
        if(pai == NULL){ 
            *raiz = NULL; // era a raiz da árvore
        }else if(pai->esq == alvo){
            pai->esq = NULL;
        }else{ 
            pai->dir = NULL;
        }

        free(alvo);
        return;
    }

    // Caso 2: nó com apenas um filho
    if(!alvo->esq || !alvo->dir){
        NO* filho;

        if(alvo->esq){
            //Se o unico filho do alvo é o esquerdo
            filho = alvo->esq;
        }else{
            //Se o unico filho do alvo é o direito
            filho = alvo->dir;
        }

        if(!pai){
            //Caso: Arvore com raiz e somente um elemento, o nivel mais extenso é a raiz então alvo = raiz, nova raiz é o filho esq ou dir.
            *raiz = filho;
        }else if(pai->esq == alvo){
            //altera o ponteiro corretamente do pai
            pai->esq = filho;
        }else{
            pai->dir = filho;
        }

        free(alvo);
        return;
    }

    // Caso 3: nó com dois filhos
    
    NO* substituto = alvo->dir;
    NO* pai_substituto = alvo;

    //Substituto é o menor da subarvore da direita
    while(substituto->esq){
        pai_substituto = substituto;
        substituto = substituto->esq;
    }

    alvo->chave = substituto->chave;

    //Remover o substituto, note que o substituto só pode ter, no máximo um filho (sempre a direita nesse caso)
    if(substituto->dir){
        //O pai do substituto tem que pegar o ponteiro que apontava para o substituto e apontar para o elemento a direita do substituto.
        if(pai_substituto->esq == substituto){
            pai_substituto->esq = substituto->dir;
        }else{
            pai_substituto->dir = substituto->dir;
        }
    }else{
        //O substituto é folha, então basta atualizar o do pai para NULL;
        if(pai_substituto->esq == substituto){
            pai_substituto->esq = NULL;
        }else{
            pai_substituto->dir = NULL;
        }
    }

    free(substituto);
    return;
}

/////////////////////////////////////////////////////////////////////////

NO* RemoverNivelMaisExtenso(NO* raiz){
    if(!raiz) return NULL;
    
    int nivelRemover = achaNivelMaisExtenso(raiz);

    //Cuida do caso onde o nivel maior é a raiz;
    if(nivelRemover == 0){
        removerNo(&raiz, NULL, raiz);
        return raiz;
    }

    FILA* f = (FILA*) malloc(sizeof(FILA));
    if(!f) return 0; //previnindo erro novamente

    //inicializa a fila
    f->inicio = NULL;
    f->fim = NULL;

    push(f, raiz);

    int nivelpai = nivelRemover-1;
    int nivelAtual = 0;
    
    while(nivelAtual < nivelpai){
        int nosNivel = 0;
        NOL* temp = f->inicio;

        //Conta quantos nós tem no nivel atual
        while(temp){
            nosNivel++;
            temp = temp->prox;
        }

        for(int i = 0; i<nosNivel; i++){
            NO* atual = pop(f);
            if(atual->esq) push(f, atual->esq);
            if(atual->dir) push(f, atual->dir);
        }

        nivelAtual++;
    }

    //Agora temos uma fila com os elementos anteriores ao nivel mais extenso (os pais da fila que queremos excluir).
    
    while(f->inicio){
        NO* pai = pop(f);
        NO* filho_esq = pai->esq;
        NO* filho_dir = pai->dir;

        if(filho_esq) removerNo(&raiz, pai, filho_esq);
        if(filho_dir) removerNo(&raiz, pai, filho_dir);
    }
    
    return raiz;
}