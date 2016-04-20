/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tubespbo.model.Aplikasi;
import tubespbo.model.Pelanggan;
import tubespbo.model.Pengemudi;
import tubespbo.view.ViewLogin;

/**
 *
 * @author asd
 */
public class ControllerLogin implements ActionListener{
    
    private Aplikasi aplikasi;
    private ViewLogin view;

    public ControllerLogin(Aplikasi aplikasi) {
        this.aplikasi = aplikasi;
        view = new ViewLogin();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnLoginCustomer())){        
            if((view.getTxtUsername()!=null)&&(view.getTxtPassword()!=null)){
                String username = view.getTxtUsername();
                String password = view.getTxtPassword();                
                Pelanggan p = aplikasi.loginPelanggan(username, password);
                if(p!=null){
                    new ControllerPelanggan(aplikasi, p);
                    view.dispose();
                }else{
                    JOptionPane.showMessageDialog(view, "Username / Password salah");
                }
            }else{
                JOptionPane.showMessageDialog(view, "Username dan Password harus terisi");
            }
        }else if(source.equals(view.getBtnLoginDriver())){
            if((view.getTxtUsername()!=null)&&(view.getTxtPassword()!=null)){
                String username = view.getTxtUsername();
                String password = view.getTxtPassword();                
                Pengemudi p = aplikasi.loginPengemudi(username, password);
                if(p!=null){
                    new ControllerPengemudi(aplikasi, p);
                    view.dispose();
                }else{
                    JOptionPane.showMessageDialog(view, "Username / Password salah");
                }
            }else{
                JOptionPane.showMessageDialog(view, "Username dan Password harus terisi");
            }
        }else if(source.equals(view.getBtnRegister())){
            new ControllerRegister(aplikasi);
            view.dispose();
        }       
    }
    
}
