/*
 5) Escreva um programa para ler as dimensões de uma cozinha retangular (comprimento, largura e
altura), calcular e escrever a quantidade de caixas de azulejos para se colocar em todas as suas
paredes (considere que não será descontada a área ocupada por portas e janelas). Cada caixa de
azulejos possui 1,5 m2.
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Simples5 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Comprimento da cozinha: ");
        double compCozinha = teclado.nextDouble();
        System.out.print("Largura da cozinha: ");
        double larguraCozinha = teclado.nextDouble();
        System.out.print("Altura da cozinha: ");
        double alturaCozinha = teclado.nextDouble();
        
        double area = (compCozinha * alturaCozinha * 2) + (larguraCozinha * alturaCozinha * 2);
        double caixaAzuleijo = area / 1.5;
        
        System.out.println("Caixas de ajuleijo necessarias: " + Math.round(caixaAzuleijo));
    }
}
