package aps.desenvolvimentoweb.appcontatos;

/**
 *
 * @author Dani
 */
public class Contato {
    private String nomeContato;
    private String telefone;
    private String email;
    private String endereco;
    private boolean isFav;

    public Contato(String nomeContato, String telefone, String email, String endereco, Boolean isFav) {
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.isFav = isFav;
    }

    public Contato(String nomeContato, String telefone) {
        this.nomeContato = nomeContato;
        this.telefone = telefone;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public boolean getIsFav() {
        return isFav;
    }

    public void setIsFav(boolean isFav) {
        this.isFav = isFav;
    }
   
}
