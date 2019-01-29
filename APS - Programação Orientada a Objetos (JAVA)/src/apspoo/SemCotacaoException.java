package apspoo;

/**
 *
 * @author Danielle Custodio - Turma: 835
 */
public class SemCotacaoException extends Exception{
    
    public SemCotacaoException(String titulo, String mensagem){
        super(titulo);
        new Alerta(titulo, mensagem);
    
    }
}
