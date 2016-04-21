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
import tubespbo.model.Pelanggan;
import tubespbo.model.Pesanan;
import tubespbo.view.ViewPelanggan;

/**
 *
 * @author irfananda
 */
public class ControllerPelanggan extends MouseAdapter implements ActionListener {

    private Aplikasi model;
    private Pelanggan pelanggan;
    private ViewPelanggan view;
    private Pesanan pesanan;
    private int idPesanan;

    public ControllerPelanggan(Aplikasi model, Pelanggan pelanggan) {
        this.model = model;
        this.pelanggan = pelanggan;
        view = new ViewPelanggan();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);        
        view.setListPesanan(pelanggan.getListIdPesanans());
        view.setTitle("Pelanggan");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            new ControllerLogin(model);
            view.dispose();         
        }else if(source.equals(view.getBtnPesan())){
            String origin = view.getTxtOrigin();
            String destination = view.getTxtDestination();
            int weight = view.getTxtWeight();
            if(view.getBtnPesan().getText().equals("Pesan")){
                if(weight!=0){
                    model.getConnection().saveKurir(new Kurir(origin, destination, weight, pelanggan.getId()));
                }else{
                    model.getConnection().savePesanan(new Pesanan(origin, destination, pelanggan.getId()));
                }
                JOptionPane.showMessageDialog(view, "Pesanan berhasil disimpan"); 
                view.setTxtOrigin("");
                view.setTxtDestination("");
                view.setTxtWeight("");
            }else if(view.getBtnPesan().getText().equals("Ubah")){
                if(weight!=0){
                    model.getConnection().updateKurir(new Kurir(idPesanan, origin, destination, weight, pelanggan.getId()));
                }else{
                    model.getConnection().updatePesanan(new Pesanan(idPesanan, origin, destination, pelanggan.getId()));
                }
                idPesanan = 0;
                JOptionPane.showMessageDialog(view, "Pesanan berhasil diubah"); 
                view.getBtnPesan().setText("Pesan");
                view.setTxtOrigin("");
                view.setTxtDestination("");
                view.setTxtWeight("");
            }
            model.refreshPelanggan();
            view.setListPesanan(pelanggan.getListIdPesanans());  
        }else if(source.equals(view.getBtnEdit())){
            if(idPesanan!=0){
                pesanan = pelanggan.getPesanan(idPesanan);
                if(pesanan instanceof Pesanan){
                    view.setTxtOrigin(pesanan.getOrigin());
                    view.setTxtDestination(pesanan.getDestination());
                }else if(pesanan instanceof Kurir){                    
                    view.setTxtOrigin(pesanan.getOrigin());
                    view.setTxtDestination(pesanan.getDestination());
                    view.setTxtWeight(((Kurir) pesanan).getWeight()+"");
                }                
                model.refreshPelanggan();
                view.setListPesanan(pelanggan.getListIdPesanans()); 
                view.getBtnPesan().setText("Ubah");
            }else{
                JOptionPane.showMessageDialog(view, "Pilih pesanan dahulu"); 
            }
        }else if(source.equals(view.getBtnHapus())){
            if(idPesanan!=0){                
                model.getConnection().deletePesanan(idPesanan);
                JOptionPane.showMessageDialog(view, "Pesanan berhasil dihapus"); 
                model.refreshPelanggan();
                view.setListPesanan(pelanggan.getListIdPesanans());  
            }else{
                JOptionPane.showMessageDialog(view, "Pilih pesanan dahulu"); 
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getListPesanan())) {
            idPesanan = view.getIdPesanan();
            pesanan = pelanggan.getPesanan(idPesanan);
            if(pesanan instanceof Pesanan){
                view.setTxtDetail(pesanan.setString(model));
            }else if(pesanan instanceof Kurir){
                view.setTxtDetail(((Kurir)pesanan).setString(model));
            }         
        }
    }
    
}
