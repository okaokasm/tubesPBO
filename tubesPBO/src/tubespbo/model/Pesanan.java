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
public class Pesanan {
	
    private int idPesanan;
    private String origin;
    private String destination;
    private int idPelanggan;
    private int idPengemudi;

    public Pesanan(int idPesanan, String origin, String destination, int idPelanggan) {
        this.idPesanan = idPesanan;
        this.origin = origin;
        this.destination = destination;
        this.idPelanggan = idPelanggan;
    }

    public Pesanan(String origin, String destination, int idPelanggan) {
        idPesanan = -1;
        this.origin = origin;
        this.destination = destination;
        this.idPelanggan = idPelanggan;
    }        

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getIdPengemudi() {
        return idPengemudi;
    }

    public void setIdPengemudi(int idPengemudi) {
        this.idPengemudi = idPengemudi;
    }        

    public int getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(int idPesanan) {
        this.idPesanan = idPesanan;
    }        

    public void setOrigin (String origin){
            this.origin= origin;
    }
    public String getOrigin() {
            return this.origin;
    }

    public void setDestination (String destination){
            this.destination= destination;
    }
    public String getDestination() {
            return this.destination;
    }
    
    public String setString(Aplikasi aplikasi){        
        return "<html>ID : "+ idPesanan+"<br>"
                + "Pesanan : " + origin + " - " + destination+"<br>"
                + "Nama Pelanggan : " + aplikasi.getPelanggan(idPelanggan).getNama()+"<br>"
                + "NoHP Pelanggan : " + aplikasi.getPelanggan(idPelanggan).getNoHp()+"<br>"
                +"</html>";
    }

}
