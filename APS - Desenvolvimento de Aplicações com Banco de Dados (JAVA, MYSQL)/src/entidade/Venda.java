/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * UNICARIOCA
 * @author Danielle Custodio
 * Turma 835
 * Disciplina: Desenvolvimento de Aplicações com Banco de Dados
 * Ano: 2018
 */
public class Venda {
    private int codCliente;
    private int codProduto;
    private int codLocalidade;
    private int qtdVenda;
    private double valorTotal;
    private Date dataVenda;

    public Venda(int codCliente, int codProduto, int codLocalidade, int qtdVenda) {
        this.codCliente = codCliente;
        this.codProduto = codProduto;
        this.codLocalidade = codLocalidade;
        this.qtdVenda = qtdVenda;
        this.valorTotal = 0.0;
    }

    public Venda() {
        
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodLocalidade() {
        return codLocalidade;
    }

    public void setCodLocalidade(int codLocalidade) {
        this.codLocalidade = codLocalidade;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }
    
       public String getDataVendaString(){
        String data = new SimpleDateFormat("dd/MM/yyyy").format(this.dataVenda);
        return data;    
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
