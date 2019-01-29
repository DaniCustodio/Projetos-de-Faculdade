package aps.desenvolvimentoweb.Controller;

import aps.desenvolvimentoweb.DAO.UsuarioMock;
import aps.desenvolvimentoweb.appcontatos.Contato;
import aps.desenvolvimentoweb.appcontatos.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dani
 */

@WebServlet("/addcontato")
public class AddContatoController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
        HttpSession session = request.getSession();
        
        String nome = request.getParameter("add-nomeContato");
        String tel = request.getParameter("add-telefone");
        String email = request.getParameter("add-email");
        String endereco = request.getParameter("add-endereco");
        
        Contato novoContato = new Contato(nome, tel, email, endereco, false);
        
        List<Usuario> listaUsuarios = (ArrayList<Usuario>)request.getSession().getAttribute("listaUsuarios");
        for(Usuario usuario: listaUsuarios){         
            if(session.getAttribute("usuarioLogado").equals(usuario.getNomeUsuario())){
                usuario.getListaContatos().add(novoContato);
                break;
            }
        }
        response.sendRedirect("Contatos.jsp");
    }
}
