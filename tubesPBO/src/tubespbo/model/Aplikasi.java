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
        Pelanggan p = connection.getPelanggan(username, password);
        p.setPesanans(connection.loadPesananPelanggan(p.getId()));
        return p;
    }
    
    public Pengemudi loginPengemudi(String username, String password){
        Pengemudi p = connection.getPengemudi(username, password);
        p.setPesanans(connection.loadPesananPengemudi(p.getId()));
        p.setPesanansPelanggan(connection.loadPesananNotTaken());
        return p;
    }   
}
