/*
authors Vagnetti,Cocchini e Locco
*/
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    
    private  Socket connessione;
    
    /**
     * 
     * @param ip ip/nomehost del server
     * @param porta porta a cui mi devo collegare del server
     * @throws IOException eccezione generata in caso di errori di comunicazione con il server
     */
    public Client(String ip, int porta) throws IOException{
        connessione = new Socket(ip, porta);
    }
  

     public void comunica() {
        try {
            Gestore g = new Gestore(connessione.getInputStream());
            g.start();
            Invia i = new Invia(connessione.getOutputStream(), "Client");
            i.start();
                
            i.join();
            g.join();
            
        } catch (IOException | InterruptedException e) { // gestisco due tipi di eccezzioni con un unico catch, multicatch
            System.err.println(e);
        }

    }

    public void close() {
        try {
            connessione.close();
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
