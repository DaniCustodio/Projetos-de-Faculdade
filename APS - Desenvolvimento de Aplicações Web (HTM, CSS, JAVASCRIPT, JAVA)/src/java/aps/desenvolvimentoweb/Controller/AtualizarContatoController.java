package aps.desenvolvimentoweb.Controller;


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
@WebServlet(name = "AtualizarContatoController", urlPatterns = {"/atualizar"})
public class AtualizarContatoController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String AtualName = request.getParameter("nome-atual");
        String nome = request.getParameter("nome");
        String tel = request.getParameter("telefone");
        String mail = request.getParameter("email");
        String end = request.getParameter("endereco");
        
        
        List<Usuario> listaUsuarios = (ArrayList<Usuario>)request.getSession().getAttribute("listaUsuarios");
        for(Usuario usuario: listaUsuarios){
          if(session.getAttribute("usuarioLogado").equals(usuario.getNomeUsuario())){
              List<Contato> listaContatos = usuario.getListaContatos();
              for(Contato contato: listaContatos){
                  if(contato.getNomeContato().equals(AtualName)){
                      contato.setNomeContato(nome);
                      contato.setTelefone(tel);
                      contato.setEmail(mail);
                      contato.setEndereco(end);
                      break;
                  }
              }
          }
        }
        response.sendRedirect("Contatos.jsp");
    }
      
  }
