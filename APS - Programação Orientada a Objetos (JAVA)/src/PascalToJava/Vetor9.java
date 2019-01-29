/*
Ler um vetor C de 10 nomes de pessoas, após pedir que o usuário digite um nome qualquer de
pessoa. Escrever a mensagem ACHEI, se o nome estiver armazenado no vetor C ou NÃO ACHEI
caso contrário.
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Vetor9 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        String[] C = new String[5];
        int ctrl =0;
        
        for(int i = 0; i < 5; i++){
            System.out.print("Digite um nome: ");
            C[i] = teclado.nextLine();
        }
        
        System.out.print("Digite o nome para busca: ");
        String busca = teclado.nextLine();
        for(int i = 0; i < 5; i++){
            if(C[i].equals(busca)){
                System.out.println("ACHEI!");
                ctrl = 1;
                break;
            }
        }
        if(ctrl != 1)
            System.out.println("NÃO ACHEI");
        
    }
}
