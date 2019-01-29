/*
Ler um vetor W de 10 elementos, depois ler um valor V. Contar e escrever quantas vezes o valor V
ocorre no vetor W e escrever também em que posições (índices) do vetor W o valor V aparece.
Caso o valor V não ocorra nenhuma vez no vetor W, escrever uma mensagem informando isto.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Vetor8 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int[] W = new int[5];
        int[] indice = new int[5];
        int v, numOcorrencia = 0;
        
        for(int i = 0; i < 5; i++){
            System.out.print("Digite o valor de W: ");
            W[i] = teclado.nextInt();
        }
        
        System.out.println("Digite o valor que quer buscar: ");
        v = teclado.nextInt();
        int j = 0;
        for(int i =0; i <5; i++){
            if(W[i] == v){
                numOcorrencia += 1;
                indice[j] = i;
                j++;
            }
        }
        
        System.out.println("Numero de Ocorrêcias: " + numOcorrencia);
        for(int i = 0; i < numOcorrencia; i++){
            System.out.println("Indice[" + indice[i] + "]");
        }
    }
}
