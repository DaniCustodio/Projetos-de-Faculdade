/*
4) Escreva um programa para calcular e imprimir o número de lâmpadas necessárias para iluminar um
determinado cômodo de uma residência. Dados de entrada: a potência da lâmpada utilizada (em
watts), as dimensões (largura e comprimento, em metros) do cômodo. Considere que a potência
necessária é de 18 watts por metro quadrado.
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Simples4 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        //Entrada de dados
        System.out.print("Potência da lâmpada(watts): ");
        double potencia = teclado.nextDouble();
        System.out.print("Largura do cômodo: ");
        double largura = teclado.nextDouble();
        System.out.print("Comprimento do cômodo: ");
        double comprimento = teclado.nextDouble();
        
        double area = largura * comprimento;
        double potenciaNecessaria = area * 18;
        double numeroLampadas = potenciaNecessaria / potencia;
        
        System.out.println("Número de lâmpadas necessarias: " + Math.round(numeroLampadas));
    
    }
}
