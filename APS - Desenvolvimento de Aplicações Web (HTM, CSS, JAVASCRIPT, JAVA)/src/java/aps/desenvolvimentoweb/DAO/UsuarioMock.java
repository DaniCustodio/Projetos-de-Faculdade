package aps.desenvolvimentoweb.DAO;

import aps.desenvolvimentoweb.appcontatos.Contato;
import aps.desenvolvimentoweb.appcontatos.Usuario;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Dani
 */
public class UsuarioMock {
    
    private List<Usuario> listaUsuarios;
    
    public UsuarioMock(){   
        List<Usuario> ex = new ArrayList<>();
        Usuario usuario1 = new Usuario("Aluno Unicarioca", "aluno", "12345" );
        Contato c1 = new Contato("Unicarioca Méier", "2563-1919", "UniMeier@unicarioca.edu.br", "R. Venceslau, 192 - Meier, Rio de Janeiro " ,true);
        Contato c2 = new Contato("Unicarioca Rio Comprido", "2563-1919", "UniRioComprido@unicarioca.edu.br", "Av. Paulo de Frontin, 568 - Rio Comprido, Rio de Janeiro", false);
        Contato c3 = new Contato("Unicarioca Jacarepaguá", "2563-1919", "UniJacarepagua@unicarioca.edu.br", "Estr. de Jacarepaguá, 6816 - Anil, Rio de Janeiro", false);
        usuario1.getListaContatos().add(c1);
        usuario1.getListaContatos().add(c2);
        usuario1.getListaContatos().add(c3);
        ex.add(usuario1);
        
        Usuario usuario2 = new Usuario("Administrador", "admin", "admin");
        ex.add(usuario2);
        
        this.listaUsuarios = ex;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
