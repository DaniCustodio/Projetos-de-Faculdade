/*
 * Escreva um programa para ler as notas da 1ª e 2ª avaliações de um aluno, 
calcular e imprimir a média semestral. Faça com que o algoritmo só aceite notas
válidas (uma nota válida deve pertencer ao intervalo [0,10]). Cada nota deve 
ser validada separadamente. Deve ser impressa a mensagem "Nota inválida" caso 
a nota informada não pertença ao intervalo [0,10]
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Repeticao5 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int av1, av2, ch;
        do{
            do{
                System.out.print("Digite a 1ª nota: ");
                av1 = teclado.nextInt();
                if(!(av1 >=0) || !(av1 <= 10))
                    System.out.println("Nota Invalida");
            }while(!(av1 >=0) || !(av1 <= 10));

            do{
                System.out.print("Digite a 2ª nota: ");
                av2 = teclado.nextInt();
                if(!(av2 >=0) || !(av2 <= 10))
                    System.out.println("Nota Invalida");
            }while(!(av2 >=0) || !(av2 <= 10));

            System.out.println("Média: " + (av1 + av2)/2);

            System.out.println("Deseja calcular uma nova média?");
            System.out.println("[1] SIM");
            System.out.println("[2] NÃO");
            ch = teclado.nextInt();
        }while(ch == 1);
    }
}
