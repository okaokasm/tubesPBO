/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.model;

/**
 *
 * @author asd
 */
public class Kurir extends Pesanan {
	private double weight;

    public Kurir(int idPesanan, String origin, String destination, double weight, int idPelanggan) {
        super(idPesanan, origin, destination, idPelanggan);
        this.weight = weight;
    }

    public Kurir(String origin, String destination, double weight, int idPelanggan) {
        super(origin, destination, idPelanggan);
        this.weight = weight;
    }   

    public void setWeight(double weight) {
            this.weight= weight;
    }

    public double getWeight() {
            return this.weight;
    }
    
    public String setString(Aplikasi aplikasi){
        return "<html>ID : "+ super.getIdPesanan()+"<br>"
                + "Kurir : " + super.getOrigin() + " - " + super.getDestination()+"<br>"
                + "Weight : " + weight + " kg"+"<br>"
                + "Nama Pelanggan : " + aplikasi.getPelanggan(super.getIdPelanggan()).getNama()+"<br>"
                + "NoHP Pelanggan : " + aplikasi.getPelanggan(super.getIdPelanggan()).getNoHp()+"<br>"
                +"</html>";
    }
}
