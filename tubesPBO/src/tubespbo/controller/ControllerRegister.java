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
import tubespbo.view.Register;

/**
 *
 * @author asd
 */
public class ControllerRegister implements ActionListener {

    private Aplikasi aplikasi;
    private Register view;

    public ControllerRegister(Aplikasi aplikasi) {
        this.aplikasi = aplikasi;
        view = new Register();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnok())){
            String nama = view.getTxtnama();
            String username = view.getTxtusername();
            String password = view.getTxtpassword();
            String noHp = view.getTxthp();
            if(view.getRadioGroup().getSelection().equals(view.getRadioCustomer())){
                Pelanggan p = new Pelanggan(nama, username, password, noHp);
                aplikasi.addPelanggan(p);
                JOptionPane.showMessageDialog(view, "Registrasi Berhasil");                                
            }else if(view.getRadioGroup().getSelection().equals(view.getRadioDriver())){
                Pengemudi p = new Pengemudi(nama, username, password, noHp);
                aplikasi.addPengemudi(p);
                JOptionPane.showMessageDialog(view, "Registrasi Berhasil");                
            }
        }
        new ControllerLogin(aplikasi);
        view.dispose();
    }
    
}
