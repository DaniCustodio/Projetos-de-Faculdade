/*
 20) Faça um programa que leia um número indeterminado de idades. A última idade lida, que não
entrará nos cálculos, deverá ser igual a zero. Ao final programa deverá escrever quantas idades foram
lidas, calcular e escrever a média de idade desse grupo de idades.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Repeticao20 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int idade, quantIdade = 0;
        double somaIdade = 0;
        do{
            System.out.println("Digite uma idade: ");
            idade = teclado.nextInt();
            somaIdade+=idade;
            quantIdade++;
        }while(idade != 0);
        quantIdade--;
        System.out.println("Idades lidas: " + quantIdade);
        System.out.println("Media de idade: " + somaIdade / quantIdade);
    }
}
