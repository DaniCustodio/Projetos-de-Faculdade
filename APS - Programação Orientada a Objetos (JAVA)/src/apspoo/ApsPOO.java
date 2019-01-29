package apspoo;

import com.google.gson.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 *
 * @author Danielle Pereira da Silva Custodio - Turma: 835
 */
public class ApsPOO {
    
        public static double cotaCompra;
        public static double cotaVenda;
    
    public static void main(String[] args){
        
        //Definindo a data
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Calendar cobj = Calendar.getInstance();
        String hoje = df.format(cobj.getTime());
        
        
        //URL usando a data atual    
        String uurl = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?%40dataCotacao=%27" + hoje +"%27&%24format=json";
        
       
        //Conectando a URL 
        try{
            URL url = new URL(uurl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection(); 
            request.connect(); 
        
            //Converter objeto Json
            JsonParser jpObj = new JsonParser();
            JsonElement cota = jpObj.parse(new InputStreamReader((InputStream) request.getContent())); //Converte o input stream para um elemento Json
            JsonObject cotaObj = cota.getAsJsonObject();
            JsonArray cotaArray = cotaObj.getAsJsonArray("value");

            for(JsonElement jse : cotaArray){
                JsonObject cotaDia = jse.getAsJsonObject();
                cotaCompra = cotaDia.get("cotacaoCompra").getAsDouble();
                cotaVenda = cotaDia.get("cotacaoVenda").getAsDouble();
            }
            
            testarCotacao(cotaCompra, cotaVenda);
            
             
            
        }catch(IOException e){new Alerta("Erro de Conexão",
                "Ocorreu um erro de conexão, verifique a sua conexão com a internet e tente novamente");}
        catch(JsonIOException | JsonSyntaxException j){new Alerta("Erro no Json",
                "Ocorreu um erro na conversão do Json. Por favor tente novamente");}
        catch(SemCotacaoException sc){}
        
        
        //Exibe Tela
            new CotacaoTela().setVisible(true);
        
        //Visualizar o valor da cotação
        System.out.println("Cota Compra: " + cotaCompra);
        System.out.println("Cota Venda: " + cotaVenda);
      
    }
    
    //Testar se a cotação está disponivel
    public static void testarCotacao(double compra, double venda)throws SemCotacaoException{
        if(compra == 0.0 || venda == 0.0)
            throw new SemCotacaoException("Cotação não disponivel!", "Cotação não disponivel, por favor tente mais tarde!");
    }
    
    
}
