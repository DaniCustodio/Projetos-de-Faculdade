/*
 13) Escreva um programa para ler um número inteiro (considere que serão lidos apenas valores
positivos e inteiros) e escrever se é par ou ímpar.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Selecao13 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite um numero inteiro: ");
        int num = teclado.nextInt();
        
        if(num % 2 == 0)
            System.out.println("Seu número é par!");
        else
            System.out.println("Seu número é ímpar!");
    
    
    }
}
