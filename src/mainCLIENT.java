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


public class mainCLIENT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Client c = new Client("127.0.0.1",6789);
            c.comunica();
            c.close();
        } catch (IOException ex) {
            Logger.getLogger(mainCLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
