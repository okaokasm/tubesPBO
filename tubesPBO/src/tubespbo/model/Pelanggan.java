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
    
    public Pesanan getPesanan(int id){
        for (int i = 0; i < pesanans.size(); i++) {
            if(id==pesanans.get(i).getIdPesanan()){
                return pesanans.get(i);
            }
        }
        return null;
    }
    
    public void removePesanan(int x){
        pesanans.remove(x);
    }

    public void setPesanans(List<Pesanan> pesanans) {
        this.pesanans = pesanans;
    }    
    
    public List<Pesanan> getAllPesanan() {
        return pesanans;
    }     
    
    public String[] getListIdPesanans(){
        ArrayList<String> listId = new ArrayList<>();        
        for(int i=0; i<pesanans.size();i++){            
            listId.add(String.valueOf(pesanans.get(i).getIdPesanan()));
        }
        return listId.toArray(new String[0]);
    }        
}
