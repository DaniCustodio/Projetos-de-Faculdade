/*
Ler um vetor X de 10 elementos. A seguir copiar todos os valores negativos do vetor X para um
vetor R, sem deixar elementos vazios entre os valores copiados. Escrever o vetor X e o vetor R
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Vetor11 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        final int MAX = 5;
        
        int[] X = new int[MAX];
        int[] R = new int[MAX];
        
        //Elementos de X
        for(int i = 0; i < MAX; i++){
            System.out.print("Digite um número: ");
            X[i] = teclado.nextInt();
        }
        
        //verificar X e achar os numeros negativos
        int j = 0;
        for(int i = 0; i < MAX; i++){
            if(X[i] < 0){
                R[j] = X[i];
                j++;
            }
        }
        
        //imprimindo X e R
        for(int i = 0; i < MAX; i++ ){
            System.out.println(" X[" + i + "] = " + X[i]);                
        }
        
        System.out.println("");
        for(int i = 0; i < j; i++ )
            System.out.println(" R[" + i + "] = " + R[i]);
        
    }
}
