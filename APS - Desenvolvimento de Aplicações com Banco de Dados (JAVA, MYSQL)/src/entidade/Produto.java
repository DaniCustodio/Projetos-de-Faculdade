/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 * UNICARIOCA
 * @author Danielle Custodio
 * Turma 835
 * Disciplina: Desenvolvimento de Aplicações com Banco de Dados
 * Ano: 2018
 */
public class Produto {
   private int codProduto;
   private int codLocalFab;
   private String descricao;
   private int qtdEstoque;
   private double precoUnitario;

    public Produto(int codProduto, int codLocalFab, String descricao, int qtdEstoque, double precoUnitario) {
        this.codProduto = codProduto;
        this.codLocalFab = codLocalFab;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.precoUnitario = precoUnitario;
    }
    
    public Produto(){}
    
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodLocal() {
        return codLocalFab;
    }

    public void setCodLocal(int codLocal) {
        this.codLocalFab = codLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
   
   @Override
    public String toString(){
        return String.valueOf(this.getCodProduto());
    }
}
