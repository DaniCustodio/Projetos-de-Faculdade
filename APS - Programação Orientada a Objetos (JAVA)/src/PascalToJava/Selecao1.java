/*
 1) Escreva um programa que leia o código de origem de um produto e imprima 
na tela a região de sua procedência conforme a tabela abaixo:

Observação: Caso o código não seja nenhum dos especificados o produto deve 
ser encarado como Importado.
 */
package PascalToJava;
import java.util.Scanner;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Selecao1 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
    
        System.out.print("Digite o codigo: ");
        int cod = teclado.nextInt();
        
        switch(cod){
            case 1:
                System.out.println("Produto vindo do Sul");
                break;
            case 2:
                System.out.println("Produto vindo do Norte");
                break;
            case 3:
                System.out.println("Produto vindo do Leste");
                break;
            case 4:
                System.out.println("Produto vindo do Oeste");
                break;
            case 5:
            case 6:
                System.out.println("Produto vindo do Nordeste");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Produto vindo do Sudeste");
                break;
            case 10:
                System.out.println("Produto vindo do Centro-Oeste");
                break;
            case 11:
                System.out.println("Produto vindo do Noroeste");
                break;
            default:
                System.out.println("Produto Importado");
                break;
        }
    }
    
    
}
