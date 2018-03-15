/**
@author Vagnetti,Cocchini e Locco
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class mainSERVER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server s = new Server(6789);
            s.comunica();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(mainSERVER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
