package aps.desenvolvimentoweb.Controller;

import aps.desenvolvimentoweb.DAO.UsuarioMock;
import aps.desenvolvimentoweb.appcontatos.Contato;
import aps.desenvolvimentoweb.appcontatos.Usuario;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;


/**
 *
 * @author Dani
 */
public class LoginController extends HttpServlet{  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nomeUsuario = request.getParameter("username");
        String senhaUsuario = request.getParameter("password");
        
        UsuarioMock usuarioMock = new UsuarioMock();
        List<Usuario> listaUsuarios = usuarioMock.getListaUsuarios();
        Boolean encontrouUsuario = false;
        
        for(Usuario usuario: listaUsuarios){
            
            if(usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenhaUsuario().equals(senhaUsuario)){
                
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario.getNomeUsuario());
                session.setAttribute("listaUsuarios", listaUsuarios);
                response.sendRedirect("Contatos.jsp");
                encontrouUsuario = true;
            }
        }    
        if(!encontrouUsuario){
            response.sendRedirect("LoginError.html");
        }
    }
    
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", null);
        }
}
