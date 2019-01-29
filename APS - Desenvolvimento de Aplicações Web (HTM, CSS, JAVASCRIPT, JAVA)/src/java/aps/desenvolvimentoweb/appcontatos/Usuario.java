package aps.desenvolvimentoweb.appcontatos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielle Cutodio Turma: 856
 */
public class Usuario {
    private String nome;
    private String nomeUsuario;
    private String senhaUsuario;
    private List<Contato> listaContatos = new ArrayList<>();

    public Usuario(String nome, String nomeUsuario, String senhaUsuario) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }
}
