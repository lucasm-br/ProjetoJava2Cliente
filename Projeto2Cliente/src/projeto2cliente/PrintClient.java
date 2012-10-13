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
          PrintClient pc = new PrintClient("Lucas","1234","Mensagem a ser impressa");
          pc.enviar("127.0.0.1", 4000);
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
      
      //public String getStatusImpressao(){
      //    return new String();
      //}
}
