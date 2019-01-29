/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 * UNICARIOCA
 * @author Danielle Custodio
 * Turma 835
 * Disciplina: Desenvolvimento de Aplicações com Banco de Dados
 * Ano: 2018
 */
public class EstoqueInsuficienteException extends Exception {
    
    private int estoque;
    private int qtdReq;
    
    public EstoqueInsuficienteException(int estoque,int qtdReq) {
        super("Produto sem estoque!");
        this.estoque = estoque;
        this.qtdReq = qtdReq;  
    }

    /**
     * Constructs an instance of <code>SaldoInsuficienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public EstoqueInsuficienteException(String msg) {
        super(msg);
    }
}
