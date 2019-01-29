/*
 5) Ler uma matriz G 3x3 e criar 2 vetores, SL e SC, de 3 elementos cada, contendo respectivamente as
somas das linhas e das colunas de G. Escrever os vetores criados.
 */
package PascalToJava;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Matriz5 {
    public static void main(String[] args){
    
        int[][] g = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] sl = new int[3];
        int[] sc = new int[3];
        
        for(int linha = 0; linha < 3; linha++ ){
            for(int coluna = 0; coluna < 3; coluna++){
                sl[linha] += g[linha][coluna];
                sc[coluna] += g[linha][coluna];
            }
        }
        
        for(int i = 0; i < 3; i++)
            System.out.println("Soma da linha " + i + ": " + sl[i]);
        
        System.out.println("");
        
        for(int i = 0; i < 3; i++)
            System.out.println("Soma da coluna " + i + ": " + sc[i]);
        
    }
}
