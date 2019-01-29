/*
 2) Escreva um programa para ler uma temperatura em graus Fahrenheit, calcular 
e escrever o valor correspondente em graus Celsius.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Simples2 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite a tempreratura(F): ");
        float temp = teclado.nextFloat();
        float celsius = (temp - 32)/1.8f ;
        System.out.println(temp + " ºF = " + celsius + " ºC");    
        
    }
    
}
