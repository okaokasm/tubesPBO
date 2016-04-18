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
public class Pelanggan extends Orang{
    
    private List<Pesanan> pesanans = new ArrayList<>();

    public Pelanggan(int id, String nama, String username, String password, String noHp) {
        super(id, nama, username, password, noHp);
    }        

    public Pelanggan(String nama, String username, String password, String noHp) {
        super(nama, username, password, noHp);
    }
    
    public void createPesanan(String origin, String destination){
        pesanans.add(new Pesanan(origin, destination,super.getId()));
    }
    
    public void createPesananKurir(String origin, String destination, int weight){
        pesanans.add(new Kurir(origin, destination,weight,super.getId()));
    }
    
    public Pesanan getPesanan(int x){
        return pesanans.get(x);
    }
    
    public void removePesanan(int x){
        pesanans.remove(x);
    }

    public List<Pesanan> getAllPesanan() {
        return pesanans;
    }        
    
}
