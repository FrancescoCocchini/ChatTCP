/*
authors Vagnetti,Cocchini e Locco
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    
    private ServerSocket serverSocket;
    private Socket connection = null;

    /**
     * 
     * @param port Porta in cui il server ascolta
     * @throws IOException Eccezione generata in caso di errori di comunicazione
     */
    public Server(int port) throws IOException{
 
       serverSocket = new ServerSocket(port);
       connection = serverSocket.accept();
    }

    public void comunica() {
        try {
            Gestore g = new Gestore(connection.getInputStream());
            g.start();
            Invia i = new Invia(connection.getOutputStream(), "Server");
            i.start();
         
            i.join();
            g.join();
            
        } catch (IOException | InterruptedException e) { // gestisco due tipi di eccezzioni con un unico catch, multicatch
            System.err.println(e);
        }

    }

    public void close() {
        try {
            System.out.println("Close connection.");
            connection.close();
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
