#include <stdio.h>
#include <stdlib.h>

void limpa(int **matriz, int lin){
    for(int i = 0; i<lin; i++){
        free(matriz[i]);
    }
    free(matriz);
}

int somalinhacoluna(int** matriz, int lin, int col) {
    int antlin = 0, antcol = 0, somalin = 0, somacol = 0;

    for (int j = 0; j < col; j++) {
        somalin += matriz[0][j];//soma primeira linha
        somacol += matriz[j][0];//soma primeira coluna
    }
    antlin = somalin;
    antcol = somacol;

    for (int i = 1; i < lin; i++) {//Verifica resto colunas
        somalin = 0;
        somacol = 0;
        for (int j = 0; j < col; j++) {
            somalin += matriz[i][j];//soma resto linhas
            somacol += matriz[j][i];//soma resto colunas
        }
        if (somalin != antlin || somacol != antcol) {
            return 0;
        }
    }

    return 1;
}

int diagonal(int** matriz, int lin, int col) {
    int diag1 = 0, diag2 = 0, linha1 = 0;

    for (int i = 0; i < lin; i++) {
        diag1 += matriz[i][i]; // testa coluna principal
        diag2 += matriz[i][lin - 1 - i]; // testa coluna secundaria
    }

    for (int j = 0; j < col; j++) {
        linha1 += matriz[0][j];//soma primeira linha
    }

    return diag1 == diag2 && linha1 == diag1;//as diagonais tem que ser iguais a soma de cada linha e coluna
}

int magico(int** matriz, int lin, int col){
    return diagonal(matriz, lin, col) && somalinhacoluna(matriz, lin, col);//retorna 1 somente se ambas as condições forem verdadeiras
}

int** removeborda(int **matriz, int lin, int col){ //int** pois a função vai retornar uma matriz
    int** nova_matriz = (int**) malloc((lin-2)*sizeof(int*));
    for(int i = 0; i < lin-2; i++){
        nova_matriz[i] = (int*) malloc((col-2) * sizeof(int));
    }

    for(int i = 0; i<lin-2; i++){
        for(int j = 0; j<col-2; j++){
            nova_matriz[i][j]=matriz[i+1][j+1]; //valor do elemento (0)(0) da removeborda é o elemento (1)(1) da matriz original
        }
    }
    
    return nova_matriz;
}

int associativo(int** matriz, int lin, int col){
    if(lin<2 || !(magico(matriz, lin, col)))//tem que ser maior que ou igual a 2 e tem que ser mágico
    return 0;
    
    int** atual = matriz;//cria uma matriz atual, igual a matriz original
    int tamanho=lin;
    int teste = lin*lin+1;
    
    while(tamanho >= 2){
        for (int i = 0; i < tamanho; i++) {
            int SomaVertical = atual[i][0] + atual[tamanho - 1 - i][tamanho - 1];
            int SomaHorizontal = atual[0][i] + atual[tamanho - 1][tamanho - 1 - i];

            if (SomaVertical != teste || SomaHorizontal != teste) {
                if(atual != matriz){
                limpa(atual, tamanho);
            }
                return 0;
            }
        }
        //se ele passou por todas essas verificações é menor que ou igual a 2, então ele é associativo e nn precisa testar novamente
        if(tamanho <= 2){
            if(atual != matriz){
                limpa(atual, tamanho);
            }
            return 1;
        }
        
        int** anterior = atual;
        atual = removeborda(atual, tamanho, tamanho);//atualização da matriz se o lado continua sendo maior que dois.

        if(anterior!=matriz){
            limpa(anterior, tamanho);
        }

        tamanho -= 2;//atualização do tamanho
    }
    return 1;//retorna quando tamanho é igual a 1.
}

int comborda(int** matriz, int lin, int col){
    if(lin<=3 || !(magico(matriz, lin, col))) //tem que ter lado maior que 3 e magico
    return 0;
    
    int** nova = removeborda(matriz, lin, col); // cria uma nova matriz nova,que no caso é a anterior sem as bordas 
    int resultado = magico(nova, lin-2, col-2);

    limpa(nova, lin-2); // libera a nova matriz

    return resultado;
}

int main(){
    int lin, col;

    printf("Entre o numero de linhas: ");
    scanf("%i",&lin);
    printf("Entre o numero de colunas: ");
    scanf("%i",&col);

    int**matriz = (int**) malloc(lin * sizeof(int*));

    for(int i = 0; i<lin; i++){
        matriz[i] = (int*) malloc(col * sizeof(int));
    }

    printf("Entre os valores da matriz:\n");
    for(int i = 0;i<lin; i++){
        for(int j = 0; j<col; j++){
            scanf("%i", &matriz[i][j]);
        }
    }

    //Testes na ordem de complexidade do quadrado
    if (lin != col) {
    printf("Matriz Comum");
    } else if (comborda(matriz, lin, col)) { 
    printf("Quadrado Magico Com Borda");
    } else if (associativo(matriz, lin, col)) { 
    printf("Quadrado Magico Associativo");
    } else if (magico(matriz, lin, col)) {
    printf("Quadrado Magico");
    } else if (somalinhacoluna(matriz, lin, col)) {
    printf("Semi Quadrado Magico");
    } else {
    printf("Matriz Comum");
    }

    limpa(matriz, lin);//libera a matriz original fornecida durante a execução do programa

    return 0;
}