/*
 Escreva um programa para ler o raio de um círculo, calcular e escrever a sua área.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Simples1 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite o raio do circulo(cm): ");
        int raio = teclado.nextInt(); 
        float area = 3.14f * (raio * raio);
        System.out.println("Área do círculo: " + area + "cm²");
    }
    
}
