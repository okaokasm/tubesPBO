/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irfananda
 */
public class Pelanggan extends Orang{
    
    private List<Pesanan> pesanans = new ArrayList<>();

    public Pelanggan(String nama, String username, String password, String noHp) {
        super(nama, username, password, noHp);
    }
    
    public void createPesanan(String origin, String destination){
        pesanans.add(new Pesanan(origin, destination));
    }
    
    public void createPesananKurir(String origin, String destination, int weight){
        pesanans.add(new Kurir(origin, destination,weight));
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
