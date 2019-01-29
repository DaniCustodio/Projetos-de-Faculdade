/*
 1) Para que a divisão entre 2 números possa ser realizada, o divisor não pode 
ser nulo (zero). Escreva um programa para ler 2 valores e imprimir o resultado 
da divisão do primeiro pelo segundo. OBS: O programa deve validar a leitura do 
segundo valor (que não deve ser nulo). Enquanto for fornecido um valor nulo a 
leitura deve ser repetida. Utilize a estrutura Repita/Até na construção da 
repetição de validação.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Repeticao1 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int denominador, numerador;
        
         System.out.print("Digite o numerador: ");
         numerador = teclado.nextInt();
         
        do{
            System.out.print("Digite o denominador: ");
            denominador = teclado.nextInt();
            if(denominador == 0)
                System.out.println("Valor Invalido");
        }while(!(denominador != 0));
        
        System.out.println("Resultado: " + numerador/denominador);
    }
}
