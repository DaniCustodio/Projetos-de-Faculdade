/*
4) Ler uma matriz SOMA 4x4, calcular e escrever as seguintes somas:
    a) da linha 3
    b) da coluna 2
    c) de todos os elementos da matriz
 */
package PascalToJava;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Matriz4 {
    public static void main(String[] args){
    
        int[][] soma = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int somaLinha3 = 0, somaColuna2 = 0, somaTotal = 0;
        
        for(int linha = 0; linha < 4; linha++){
            for(int coluna = 0; coluna < 4; coluna++){
                somaTotal += soma[linha][coluna];
                if(linha == 3)
                        somaLinha3 += soma[linha][coluna];
                if(coluna == 2)
                    somaColuna2 += soma[linha][coluna];
            }
        }
        
        System.out.println("Soma Linha 3: " + somaLinha3);
        System.out.println("Soma Coluna 2: " + somaColuna2);
        System.out.println("Soma Total: " + somaTotal);
    
    }
}
