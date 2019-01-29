package aps.desenvolvimentoweb.Controller;

import aps.desenvolvimentoweb.appcontatos.Contato;
import aps.desenvolvimentoweb.appcontatos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeleteController", urlPatterns = {"/excluir"})
public class DeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String AtualName = request.getParameter("nome-atual");
        
        List<Usuario> listaUsuarios = (ArrayList<Usuario>)request.getSession().getAttribute("listaUsuarios");
        for(Usuario usuario: listaUsuarios){         
            if(session.getAttribute("usuarioLogado").equals(usuario.getNomeUsuario())){
                List<Contato> listaContatos = usuario.getListaContatos();
              for(Contato contato: listaContatos){
                  if(contato.getNomeContato().equals(AtualName)){
                    listaContatos.remove(contato);
                    break;
                  }
              }
                break;
            }
        }
        response.sendRedirect("Contatos.jsp");
    }


}
