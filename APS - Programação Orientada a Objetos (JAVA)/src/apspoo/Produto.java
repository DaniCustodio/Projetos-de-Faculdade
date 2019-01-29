package apspoo;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Produto {
    private String nome;
    private double valor, valorCompra, valorVenda;
    
    public Produto(String nome, double valor, double valorCompra, double valorVenda ){
        this.nome = nome;
        this.valor = valor;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
