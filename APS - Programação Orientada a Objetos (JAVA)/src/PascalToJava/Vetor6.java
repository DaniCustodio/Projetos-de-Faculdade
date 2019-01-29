/*
Ler um vetor D de 10 elementos. Criar um vetor E, com todos os elementos de D 
na ordem inversa, ou seja, o último elemento passará a ser o primeiro, o 
penúltimo será o segundo e assim por diante. Escrever todo o vetor D e todo o
vetor E.
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Vetor6 {
    public static void main(String[] args){
        int[] A = new int[10];
        int[] B = new int[10];
        
        //adicionando no array A
        for(int i = 0; i < 10;i++){
            A[i] = i+1;
        }
        
        //passando para o array B
        int j = 0;
        for(int i = A.length-1; i >= 0; i--){
            B[j] = A[i];
            j++;
        }
        
        for(int i =0; i<B.length; i++){
            System.out.printf("[%d] = %d\n", i+1, B[i]);
        }
        
        
        
        
        
        
        
        
    }
}
