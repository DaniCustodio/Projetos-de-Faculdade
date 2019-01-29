/*
 3) Escreva um programa para ler uma temperatura em graus Celsius, calcular e escrever o valor
correspondente em graus Fahrenheit.
 */
package PascalToJava;

import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Simples3 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite a temperatura (C): ");
        float celsius = teclado.nextFloat();
        float fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperatura em Fahrenheit: " + fahrenheit + "ºF");
    }
}
