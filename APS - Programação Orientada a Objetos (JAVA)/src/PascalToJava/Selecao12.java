/*
 12) Tendo como entrada a altura e o sexo (codificado da seguinte forma: 1:feminino 2:masculino) de
uma pessoa, construa um programa que calcule e imprima seu peso ideal, utilizando as seguintes
fórmulas:
- para homens : (72.7 * h) – 58
- para mulheres : (62.1 * h) – 44.7
Observação: Altura = h (na fórmula acima)
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Selecao12 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
    
        
        System.out.print("Informe sua altura: ");
        double h = teclado.nextDouble();
        
        
        System.out.println("1: Feminino");
        System.out.println("2: Masculino");
        System.out.print("Informe seu sexo: ");
        int sexo = teclado.nextInt();
        
        switch(sexo){
        
            case 1:System.out.println("Seu peso ideal é: " + ((62.1 * h) - 44.7)); break;
            case 2:System.out.println("Seu peso ideal é: " + ((72.7 * h) - 58) ); break;
            default: System.out.println("Número invalido!"); break;
        }
        
    }
}
