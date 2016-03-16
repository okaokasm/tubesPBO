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
public class Pengemudi {
    
    private List<Pesanan> pesanans = new ArrayList<>();
    
    public void addPesanan(Pesanan p){
        pesanans.add(p);
    }
    
    public Pesanan getPesanan(int x){
        return pesanans.get(x);
    }
    
    public void removePesanan(int x){
        pesanans.remove(x);
    }
    
}
