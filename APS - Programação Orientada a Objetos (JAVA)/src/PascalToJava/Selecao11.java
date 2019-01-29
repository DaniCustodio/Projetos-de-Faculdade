/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PascalToJava;
import java.util.Scanner;
/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Selecao11 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite a senha: ");
        int senha = teclado.nextInt();
        if(senha == 1234){
            System.out.println("ACESSSO PERMITIDO");
        }else{
            System.out.println("ACESSO NEGADO");
        }
        
    }
    
}
