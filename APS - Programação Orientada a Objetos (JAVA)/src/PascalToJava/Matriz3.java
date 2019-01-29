/*
 3) Ler 9 números inteiros para preencher uma matriz D 3x3, ou seja, com 3 linhas e 3 colunas
(considere que não serão informados valores duplicados). A seguir, ler um número inteiro X e escrever
uma mensagem indicando se o valor de X existe ou não na matriz D.
 */
package PascalToJava;

import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Matriz3 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int matriz[][] = new int[3][3];
        
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                System.out.print("Digite um numero: ");
                matriz[linha][coluna] = teclado.nextInt();
            }
        }
        
        int numBusca;
        System.out.println("Digite o numero que deseja procurar");
        numBusca = teclado.nextInt();
        boolean ver = false;
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                if(matriz[linha][coluna] == numBusca){
                    System.out.println("O valor existe na matriz!");
                    ver = true;
                }
            }
        }
        if(!ver)
            System.out.println("O valor não existe na matriz!");
    
    }
}
