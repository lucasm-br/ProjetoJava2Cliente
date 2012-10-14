/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2cliente;
import java.net.*;
import java.io.*;
/**
 *
 * @author lucas
 */
public class PrintClient {
      private String vLogin;
      private String vSenha;
      private String vArquivo;
      
      public static void main(String[] args) {
          PrintClient pc = new PrintClient(args[0],args[1],"Mensagem a ser impressa");
          pc.enviar(args[2], 4000);
      }
      
      public PrintClient(String login,String senha,String arquivo){
          vLogin = login;
          vSenha = senha;
          vArquivo = arquivo;
      }
      
      public void enviar(String ip, int porta){
          try{
              Socket sock = new Socket(ip,porta);
              PrintWriter writer = new PrintWriter(sock.getOutputStream());
              writer.println(vLogin + "\n" + vSenha + "\n" + vArquivo + "\n");
              writer.close();
          }
          catch(IOException ex){
              ex.printStackTrace();
          }
      }
}
