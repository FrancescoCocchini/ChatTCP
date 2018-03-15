/*
authors Vagnetti,Cocchini e Locco 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestore extends Thread {

    private BufferedReader streamIn;//

    /**
     * 
     * @param asc
     */
    public Gestore(InputStream asc) {
        streamIn = new BufferedReader(new InputStreamReader(asc));
    }

    public void run() {
        boolean stato = true;
        String mess=null;// messaggio che viene inviato
        System.out.println("ATTENDO..");
        try{
            while (stato) {

                mess = streamIn.readLine();

                if (mess.equals("end")) {
                    stato = false;
                    System.out.println("CLOSE CONNECTION, è stato bello parlare con te");
                } else {
                    System.out.println(mess);
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
