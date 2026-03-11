#include <stdio.h>
#include <stdlib.h>

//Nome: Gustavo Neves Moraes NUSP: 16986195 //////////////////////////////////////////

typedef struct{
    int valor;
    int peso;
    double razao;
}OBJETO;

void limpalimpinho(OBJETO* objetos, FILE* entrada, FILE* saida){
    free(objetos);
    fclose(entrada);
    fclose(saida);
}

//i) MENOR PESO - MAIOR VALOR
void organizaPorPeso(OBJETO* obj, int n){
    //Basicamente um InsertionSort só que com desempate
    for(int i = 1; i < n; i++){
        OBJETO chave = obj[i];
        int j = i - 1;

        while(j>=0){
            int mover = 0;

            if(obj[j].peso > chave.peso){
                //se o meso é maior, precisa mover
                mover = 1;
            }else if(obj[j].peso == chave.peso && obj[j].valor < chave.valor){
                //se o peso é o mesmo mas o valor é menor, então precisa mover
                mover = 1;
            }

            if(!mover) break;

            obj[j+1] = obj[j];
            j--;
        }

        obj[j+1] = chave;
    }
}

//ii) MAIOR VALOR - MENOR PESO
void organizaPorValor(OBJETO* obj, int n){
    for(int i = 1; i < n; i++){
        OBJETO chave = obj[i];
        int j = i - 1;

        while(j>=0){
            int mover = 0;

            if(obj[j].valor < chave.valor){
                mover = 1;
            }else if(obj[j].valor == chave.valor && obj[j].peso > chave.peso){
                mover = 1;
            }

            if(!mover) break;

            obj[j+1] = obj[j];
            j--;
        }

        obj[j+1] = chave;
    }
}

// iii) MAIOR VALOR/PESO - MAIOR PESO
void organizaPorRazao(OBJETO* obj, int n){
    for(int i = 1; i < n; i++){
        OBJETO chave = obj[i];
        int j = i - 1;

        while(j>=0){
            int mover = 0;

            if(obj[j].razao < chave.razao){
                mover = 1;
            }else if(obj[j].razao == chave.razao && obj[j].peso < chave.peso){
                mover = 1;
            }

            if(!mover) break;

            obj[j+1] = obj[j];
            j--;
        }

        obj[j+1] = chave;
    }
}

// Algoritmo Guloso
void algoritmoGuloso(OBJETO* obj, int n, double capacidade, int criterio, FILE* arquivo_saida){
    //ordena antes de fazer as escolhas--------------------------------------------------
    if(criterio == 0){
        fprintf(arquivo_saida, "Testando Criterio de Selecao: 'Menor Peso'\n");
        organizaPorPeso(obj, n);
    }else if(criterio == 1){
        fprintf(arquivo_saida, "Testando Criterio de Selecao: 'Maior Valor'\n");
        organizaPorValor(obj, n);
    }else{
        fprintf(arquivo_saida, "Testando Criterio de Selecao: 'Maior Valor Dividido pelo Peso'\n");
        organizaPorRazao(obj, n);
    }
    //------------------------------------------------------------------------------------

    //Algoritmo Guloso em si -----------------------------
    double pesoTotal = 0, valorTotal = 0;
    int quantUsados = 0;
    
    for(int i = 0; i < n; i++){
        if(pesoTotal + obj[i].peso <= capacidade){
            pesoTotal += obj[i].peso;
            valorTotal += obj[i].valor;
            quantUsados++;
        }
    }
    //-----------------------------------------------------
    
    fprintf(arquivo_saida, "Peso maximo:\t%.1f\n", capacidade);
    fprintf(arquivo_saida, "Peso usado:\t%.1f\n", pesoTotal);
    fprintf(arquivo_saida, "Valor carregado:\t%.1f\n", valorTotal);
    fprintf(arquivo_saida, "Numero de objetos:\t%i\n", quantUsados);
    fprintf(arquivo_saida, "\n");
}

int main(int argc, char *argv[]){
    if(argc != 3){
        return 1;
    }

    FILE* arquivo_entrada = fopen(argv[1], "r");
    if(!arquivo_entrada){
        printf("Erro ao abrir arquivo de entrada\n");
        return 1;
    }

    FILE* arquivo_saida = fopen(argv[2], "w");
    if(!arquivo_saida){
        printf("Erro ao abrir arquivo de saida\n");
        return 1;
    }

    int capacidade, n;
    fscanf(arquivo_entrada, "%i %i", &capacidade, &n);

    OBJETO* obj = (OBJETO*) malloc(n*sizeof(OBJETO));

    for(int i = 0; i<n; i++){
        fscanf(arquivo_entrada, "%i %i", &obj[i].peso, &obj[i].valor);
        obj[i].razao = (double)obj[i].valor/obj[i].peso;
    }

    for(int i = 0; i<=2; i++){
        algoritmoGuloso(obj, n, capacidade, i, arquivo_saida);
    }

    limpalimpinho(obj, arquivo_entrada, arquivo_saida);

    return 0;
}