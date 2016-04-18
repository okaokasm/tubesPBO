/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.model;

/**
 *
 * @author Acer-PC
 */
public class Orang {
        private int id;
	private String nama; 
	private String username;
	private String password;
	private String noHp;

    public Orang(int id, String nama, String username, String password, String noHp) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.noHp = noHp;
    }                
	
public Orang (String nama, String username, String password, String noHp){
        id = -1;
	this.nama = nama;
	this.username = username;
	this.password = password;
	this.noHp = noHp;
}

public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
public void setNama(String nama) {
	this.nama = nama;
}
public String getNama() {
	return this.nama;
}

public void setUsername(String username) {
	this.username = username;
}
public String getUsername() {
	return this.username;
}

public void setPassword(String password) {
	this.password = password;
}
public String getPassword() {
	return this.password;
}

public void setNoHp(String noHp) {
	this.noHp = noHp;
}
public String getNoHp() {
	return this.noHp;
}
	
}
