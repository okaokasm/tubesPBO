/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irfananda
 */
public class Pengemudi extends Orang{
    
    private List<Pesanan> pesanans = new ArrayList<Pesanan>();    
    private List<Pesanan> pesanansPelanggan = new ArrayList<Pesanan>();

    public Pengemudi(int id, String nama, String username, String password, String noHp) {
        super(id, nama, username, password, noHp);
    }        

    public Pengemudi(String nama, String username, String password, String noHp) {
        super(nama, username, password, noHp);
    }
    
    public void addPesanan(Pesanan p){
        pesanans.add(p);
    }
    
    public Pesanan getPesanan(int x){
        return pesanans.get(x);
    }
    
    public void removePesanan(int x){
        pesanans.remove(x);
    }

    public List<Pesanan> getPesanans() {
        return pesanans;
    }       

    public void setPesanans(List<Pesanan> pesanans) {
        this.pesanans = pesanans;
    }        
    
    public Pesanan getPesananPelanggan(int x){
        return pesanans.get(x);
    }    

    public List<Pesanan> getPesanansPelanggan() {
        return pesanansPelanggan;
    }

    public void setPesanansPelanggan(List<Pesanan> pesanansPelanggan) {
        this.pesanansPelanggan = pesanansPelanggan;
    }
    
    
}
