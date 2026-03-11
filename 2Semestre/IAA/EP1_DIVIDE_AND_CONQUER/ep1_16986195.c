#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

int processaQuadrante(int** matriz, int l, int c, int tam, int* countB, int* countP){
    //Caso base: quadrante (1x1);
    if(tam == 1){
        if(matriz[l][c] == 1){
            countB[0]++;
        }else{
            countP[0]++;
        }
        return matriz[l][c];
    }

    int metade = tam/2;

    //fazendo a subdivisão em 4 subquadrantes (que nem o da aula);
    int q1 = processaQuadrante(matriz, l, c, metade, countB, countP);
    int q2 = processaQuadrante(matriz, l + metade, c, metade, countB, countP);
    int q3 = processaQuadrante(matriz, l, c + metade, metade, countB, countP);
    int q4 = processaQuadrante(matriz, l+metade, c+metade, metade, countB, countP);

    if(q1 == q2 && q2 == q3 && q3 == q4 && q1 != -1){
        int subquadrantes = 0, maximal = 0, aux = 1;

        while(aux < metade){
            subquadrantes++;
            aux *= 2;
        }
        aux = 1;

        while(aux < tam){
            maximal++;
            aux *= 2;
        }

        if(q1 == 1){
            //Remove 4 subquadrantes brancos e adiciona 1 quadrante maior;
            countB[subquadrantes] -= 4;
            countB[maximal] += 1;
        }else{
            //Remove 4 subquadrantes pretos e adiciona 1 quadrante maior;
            countP[subquadrantes] -= 4;
            countP[maximal] += 1;
        }
        
        return q1;
    }

    //Caso misto
    return -1;
}

//Função auxiliar para criar matrizes;
int** alocaMatriz(int n){
    int** matriz = (int**) malloc(n * sizeof(int*));

    for(int i = 0; i<n; i++){
        matriz[i] = (int*) malloc(n * sizeof(int));
    }

    return matriz;
}

void limpa(int** matriz, int n){
    for(int i = 0; i<n; i++){
        free(matriz[i]);
    }

    free(matriz);
}

int main(int argc, char* argv[]){
    
    if(argc != 3){
        printf("ERRO, formato não correto.");
        return -1;
    }
    //le os parametros fornecidos pela chamada
    int n = atoi(argv[1]);
    char* nome_arquivo = argv[2];

    FILE* arquivo_ler = fopen(nome_arquivo, "r");

    if(!arquivo_ler){
        printf("ERRO, arquivo não encontrado ou erro ao abrir o arquivo.");
        return -1;
    }

    int** matriz = alocaMatriz(n);

    //Scaneia elemento por elemento da matriz do arquivo de leitura
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            fscanf(arquivo_ler, "%1d", &matriz[i][j]);
        }
    }

    //Cria o arquivo txt saida
    FILE* saida = fopen("saida.txt", "w");
    if(!saida){
        printf("Erro ao criar o arquivo de saida");
        return -1;
    }

    //Quantidade de divisões possiveis da matriz n, equivalente a log2(n) + 1
    int QuantDivisoes = 0;
    for(int i = 1; i <= n; i *= 2){
        QuantDivisoes++;
    }

    //Cria arrays com numero de divisoes possiveis.
    int* countB = (int*) calloc(QuantDivisoes, sizeof(int));
    int* countP = (int*) calloc(QuantDivisoes, sizeof(int));

    processaQuadrante(matriz, 0, 0, n, countB, countP);

    //impressao dos resultados no arquivo saida
    for(int i = n, j = QuantDivisoes-1; i >= 1; i /= 2, j--){
        fprintf(saida, "%ix%i %i %i\n", i, i, countB[j], countP[j]);
    }

    //limpando dados e fechando arquivos
    limpa(matriz, n);
    free(countB);
    free(countP);
    fclose(arquivo_ler);
    fclose(saida);

    return 0;
}