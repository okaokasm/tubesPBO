/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import tubespbo.controller.ControllerLogin;
import tubespbo.controller.ControllerRegister;
import tubespbo.model.Aplikasi;

/**
 *
 * @author irfananda
 */
public class TubesPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aplikasi konsol = new Aplikasi();       
        new ControllerLogin(konsol);
    }
    
}
