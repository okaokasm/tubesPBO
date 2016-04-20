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
import tubespbo.view.ViewRegister;

/**
 *
 * @author asd
 */
public class ControllerRegister implements ActionListener {

    private Aplikasi aplikasi;
    private ViewRegister view;
    private String tipe;

    public ControllerRegister(Aplikasi aplikasi) {
        this.aplikasi = aplikasi;
        view = new ViewRegister();
        view.setVisible(true);
        view.addListener(this);
        tipe = "null";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnok())){
            String nama = view.getTxtnama();
            String username = view.getTxtusername();
            String password = view.getTxtpassword();
            String noHp = view.getTxthp();
            if(tipe.equalsIgnoreCase(view.getRadioCustomer().getText())){
                Pelanggan p = new Pelanggan(nama, username, password, noHp);
                aplikasi.addPelanggan(p);
                JOptionPane.showMessageDialog(view, "Registrasi Berhasil");                    
                new ControllerLogin(aplikasi);
                view.dispose();
            }else if(tipe.equalsIgnoreCase(view.getRadioDriver().getText())){
                Pengemudi p = new Pengemudi(nama, username, password, noHp);
                aplikasi.addPengemudi(p);
                JOptionPane.showMessageDialog(view, "Registrasi Berhasil");                    
                new ControllerLogin(aplikasi);
                view.dispose();
            }else if(tipe.equalsIgnoreCase("null")){
                JOptionPane.showMessageDialog(view, "Jenis registrasi harus dipilih");     
            }
        }else if(source.equals(view.getRadioCustomer())){
            tipe = view.getRadioCustomer().getText();
        }else if(source.equals(view.getRadioDriver())){
            tipe = view.getRadioDriver().getText();
        }            
    }
    
}
