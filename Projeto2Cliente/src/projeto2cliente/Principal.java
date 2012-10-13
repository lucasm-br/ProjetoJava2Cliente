/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2cliente;
import java.io.*;
import java.net.*;
/**
 *
 * @author lucas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Recebe o login e senha válidos como parâmetro	
        //Aguarda a chegada dos dados do cliente
        try{
            ServerSocket serverSock = new ServerSocket(4000);
            
            while(true)
            {
                Socket sock = serverSock.accept();
                InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                String login = reader.readLine();
                String senha = reader.readLine();
                
                System.out.println(login);
                System.out.println(senha);
                //Compara o login e senha recebidos com os válidos
                if(login.equals(args[0]) && senha.equals(args[1]))
                {
                    String arquivo = reader.readLine();
                    //Chama a classe de impressão enviando o que deve ser impresso
                }
                else{
                    //TODO responder que houve problema de validação
                }
            }
        }
        catch(IOException ex){
           ex.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException ex){
           System.out.println("Parâmetros Incorretos!");
           System.out.println("Parâmetros requeridos: login senha");
        }
    }
}
