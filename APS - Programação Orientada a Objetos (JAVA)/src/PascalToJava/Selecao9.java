/*
 9) As maçãs custam R$ 0,30 cada se forem compradas menos do que uma dúzia, e R$ 0,25 se forem
compradas pelo menos doze. Escreva um programa que leia o número de maçãs compradas,
calcule e escreva o valor total da compra
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Selecao9 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Maças compradas: ");
        int macasCompradas = teclado.nextInt();
        
        if(macasCompradas < 12)
            System.out.println("Valor da compra: " + macasCompradas * 0.30);
        else
            System.out.println("Valor da compra: " + macasCompradas * 0.25);
    
    
    }
}
