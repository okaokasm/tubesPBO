/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author asd
 */
public class Pesanan {
	
	private String origin;
	private String destination;
	private String namaPelanggan;
	private String noHpPelanggan;
	
public Pesanan (String origin, String destination, String namaPelanggan, String noHpPelanggan) {
	this.origin = origin;
	this.destination = destination;
	this.namaPelanggan = namaPelanggan;
	this.noHpPelanggan = noHpPelanggan;
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

public void setNamaPelanggan (String namaPelanggan){
	this.namaPelanggan= namaPelanggan;
}
public String getNamaPelangan() {
	return this.namaPelanggan;
}

public void setNoHpPelanggan (String noHpPelanggan){
	this.noHpPelanggan= noHpPelanggan;
}
public String getNoHpPelanggan() {
	return this.noHpPelanggan;
}

}
