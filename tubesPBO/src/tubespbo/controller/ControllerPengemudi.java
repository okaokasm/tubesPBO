/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import tubespbo.model.Aplikasi;
import tubespbo.model.Kurir;
import tubespbo.model.Pengemudi;
import tubespbo.model.Pesanan;
import tubespbo.view.ViewPengemudi;

/**
 *
 * @author irfananda
 */
public class ControllerPengemudi extends MouseAdapter implements ActionListener {

    private Aplikasi model;
    private Pengemudi pengemudi;
    private ViewPengemudi view;
    private Pesanan pesanan;

    public ControllerPengemudi(Aplikasi model, Pengemudi pengemudi) {
        this.model = model;
        this.pengemudi = pengemudi;
        view = new ViewPengemudi();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);        
        view.setListCustomer(pengemudi.getListIdPesanansPelanggan());
        view.setTitle("Pengemudi");
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnTake())) {
            model.takePesanan(pengemudi.getId(), pesanan);
            JOptionPane.showMessageDialog(view, "Pesanan telah diambil");  
            model.refreshPengemudi();
            view.setListCustomer(pengemudi.getListIdPesanansPelanggan());            
        }else if(source.equals(view.getBtnLogout())){
            new ControllerLogin(model);
            view.dispose();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getListCustomer())) {
            int idPesanan = view.getIdPesanan();
            pesanan = pengemudi.getPesananPelanggan(idPesanan);
            if(pesanan instanceof Pesanan){
                view.setTxtDetail(pesanan.setString(model));
            }else if(pesanan instanceof Kurir){
                view.setTxtDetail(((Kurir)pesanan).setString(model));
            }   
        }
    }
    
}
