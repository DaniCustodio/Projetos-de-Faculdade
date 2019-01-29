/*
Ler um vetor X de 10 elementos inteiros e positivos. Criar um vetor Y da seguinte forma: os
elementos de Y com índice par receberão os respectivos elementos de X divididos por 2; os
elementos com índice ímpar receberão os respectivos elementos de X multiplicados por 3.
Escrever o vetor X e o vetor Y.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Vetor7 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int[] X = new int[5];
        int[] Y = new int[5];
        
        for(int i = 0; i < 5; i++){
            System.out.print("Digite o elemento: ");
            X[i] = teclado.nextInt();
            if(i%2 == 0){
                Y[i] = X[i] / 2;
            }else{
                Y[i] = X[i] * 3;
            }
        }
        
        for(int i = 0; i < 5; i++){
            System.out.println("X[" + i + "] = " + X[i] + "  Y[" + i + "] = " + Y[i]);
        }
        
    }
}
