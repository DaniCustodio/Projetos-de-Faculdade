/*
 19) Escreva um programa para determinar e escrever a soma dos números pares de 100 a 200,
inclusive.
 */
package PascalToJava;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Repeticao19 {
    public static void main(String[] args){
    
        int soma = 0;
        for(int i = 100; i <= 200; i++){
            if(i % 2 == 0)
                soma+=i;
        }
        
        System.out.println("Soma = " + soma);
    }
}
