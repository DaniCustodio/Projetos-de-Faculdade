/*
Ler dois vetores: R de 5 elementos e S de 10 elementos. Gerar um vetor X de 15 elementos cujas
5 primeiras posições contenham os elementos de R e as 10 últimas posições, os elementos de S.
Escrever o vetor X.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Vetor12 {
    public static void main(String[] args){
        final int MAX = 5;
        
        int[] R = new int[MAX];
        int[] S = new int[MAX];
        int[] X = new int[10];
        int a = 1;
        int b = 6;
        int ind = 0;
        
        //preenchendo os vetores
        for(int i = 0; i < MAX; i++){
            R[i] = a;
            S[i] = b;
            a++;
            b++;
        }
        
        //juntando os vetores
        for(int i = 0; i < 10; i++){
            if(i < 5)
                X[i] = R[i];
            else{
                X[i] = S[ind];
                ind++;
            }   
        }
        
        //imprinmindo
        for(int i = 0; i <10; i++)
            System.out.println("X[" + i + "] = " + X[i]);
        
    }
}
