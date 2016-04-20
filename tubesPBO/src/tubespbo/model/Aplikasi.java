/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.model;

import tubespbo.model.Pelanggan;
import tubespbo.model.Kurir;
import tubespbo.model.Pengemudi;
import tubespbo.model.Pesanan;
import tubespbo.database.Database;

/**
 *
 * @author irfananda
 */
public class Aplikasi {
    
    private Pelanggan pelanggan;
    private Pengemudi pengemudi;
    private Database connection;

    public Aplikasi() {
        connection = new Database();
        connection.connect();
    }
       
    public Pelanggan loginPelanggan(String username, String password){       
        pelanggan = connection.getPelanggan(username, password);
        if(pelanggan!=null)
            pelanggan.setPesanans(connection.loadPesananPelanggan(pelanggan.getId()));
        return pelanggan;
    }
    
    public Pengemudi loginPengemudi(String username, String password){
        pengemudi = connection.getPengemudi(username, password);       
        if(pengemudi!=null){
            pengemudi.setPesanans(connection.loadPesananPengemudi(pengemudi.getId()));
            pengemudi.setPesanansPelanggan(connection.loadPesananNotTaken());           
        }
        return pengemudi;
    }   
    
    public void refreshPelanggan(){
        if(pelanggan!=null)
            pelanggan.setPesanans(connection.loadPesananPelanggan(pelanggan.getId()));
    }
    
    public void refreshPengemudi(){
        if(pengemudi!=null){
            pengemudi.setPesanans(connection.loadPesananPengemudi(pengemudi.getId()));
            pengemudi.setPesanansPelanggan(connection.loadPesananNotTaken());
        }
    }
    
    public void takePesanan(int idPengemudi, Pesanan p){
        connection.takePesanan(idPengemudi, p);
    }
    
    public void addPelanggan(Pelanggan p){
        connection.savePelanggan(p);
    }
    
    public void addPengemudi(Pengemudi p){
        connection.savePengemudi(p);
    }

    public Database getConnection() {
        return connection;
    }    
    
    public Pelanggan getPelanggan(int id){
        return connection.getPelanggan(id);
    }
    
    public Pengemudi getPengemudi(int id){
        return connection.getPengemudi(id);
    }
}
