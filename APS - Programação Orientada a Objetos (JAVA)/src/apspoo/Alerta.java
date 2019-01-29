package apspoo;
import javax.swing.*;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class Alerta {
    
    public Alerta(String titulo, String mensagem){
        JFrame jf = new JFrame();
        JOptionPane.showMessageDialog(jf, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
    }
}
