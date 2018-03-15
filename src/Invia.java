/**
@author Vagnetti,Cocchini e Locco
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Invia extends Thread {

    private PrintWriter streamOut;//stream di scrittura che deve ssere accessibile da tutti i metodi
    private String mittente;
    private boolean out = true;

    /**
     * 
     * @param i InputStream del socket che permette al Thread di legge messaggi
     * @param mittente Nome dell'utente dell'host remoto
     */
    public Invia(OutputStream i, String mittente) {
        this.mittente=mittente;
        streamOut= new PrintWriter(i);
    }

    
    public void run() {
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(in);
        System.out.println("ATTENDO...");
        String messaggio ="";
        try{
            while (out) {//gestisco cio che dovro mandare in output
                    messaggio = tastiera.readLine();
                    switch (messaggio) {
                        case "autore":
                            System.out.println("Inserisci il tuo nuovo nome utente:");
                            mittente = tastiera.readLine();
                            break;
                        case "smile":
                            streamOut.println(mittente + ": " + "\u263A");
                            streamOut.flush();
                            break;
                        case "echo":
                            streamOut.println(mittente + ":" + messaggio);
                            streamOut.flush();
                            break;
                        case "end":
                            streamOut.println("end");
                            streamOut.flush();
                            out = false;
                            System.out.println("Close Connection.");
                            break;
                        default:
                            streamOut.println(mittente + ":" + messaggio);
                            streamOut.flush();
                    }
                }
            } catch (IOException e) {
                Logger.getLogger(Invia.class.getName()).log(Level.SEVERE, null, e);
            }

        }

}
