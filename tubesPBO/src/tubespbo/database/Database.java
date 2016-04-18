/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tubespbo.model.Kurir;
import tubespbo.model.Pelanggan;
import tubespbo.model.Pengemudi;
import tubespbo.model.Pesanan;

/**
 *
 * @author irfananda
 */
public class Database {
    
    private final String SERVER = "jdbc:mysql://127.0.0.1/Syaujek";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "";
    Statement statement;
    Connection connection;
    
    public void connect() {
        try {                
            System.out.println(SERVER);
            System.out.println(DBUSER);
            System.out.println(DBPASSWORD);
            connection = DriverManager.getConnection(SERVER, DBUSER, DBPASSWORD);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Tidak dapat conenct ke MySQL , "+ex.toString());
        }
    }
    
    public void savePelanggan(Pelanggan p) {
        try {
            String query = "INSERT INTO PELANGGAN(nama,username,password,noHp) VALUES("
                    + "'" + p.getNama() + "',"
                    + "'" + p.getUsername()+ "',"
                    + "'" + p.getPassword()+ "',"
                    + p.getNoHp()+ ")";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setId(generatedId);
        } catch (SQLException ex) {
            System.out.println("Gagal insert");
        }
    }
    
    public void savePengemudi(Pengemudi p) {
        try {
            String query = "INSERT INTO PENGEMUDI(nama,username,password,noHp) VALUES("
                    + "'" + p.getNama() + "',"
                    + "'" + p.getUsername()+ "',"
                    + "'" + p.getPassword()+ "',"
                    + p.getNoHp()+ ")";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setId(generatedId);
        } catch (SQLException ex) {
            System.out.println("Gagal insert");
        }
    }
    
    public void savePesanan(Pesanan p) {
        try {
            String query = "INSERT INTO PESANAN(origin,destination,idPelanggan) VALUES("
                    + "'" + p.getOrigin()+ "',"
                    + "'" + p.getDestination()+ "',"
                    + p.getIdPelanggan()+ ")";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setIdPesanan(generatedId);
        } catch (SQLException ex) {
            System.out.println("Gagal insert");
        }
    }
    
    public void saveKurir(Kurir k) {
        try {
            String query = "INSERT INTO PESANAN(origin,destination,idPelanggan,weight) VALUES("
                    + "'" + k.getOrigin()+ "',"
                    + "'" + k.getDestination()+ "',"
                    + k.getIdPelanggan()+ " ,"
                    + k.getWeight()+ " )";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            k.setIdPesanan(generatedId);
        } catch (SQLException ex) {
            System.out.println("Gagal insert");
        }
    }
    
    public Pelanggan getPelanggan(String username, String password) {
        Pelanggan p = null;
        try {
            String query = "SELECT * FROM PELANGGAN WHERE username = '"
                    + username + "',"
                    + " AND password = '" + password +"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Pelanggan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal select");
        }
        return p;
    }
    
    public Pengemudi getPengemudi(String username, String password) {
        Pengemudi p = null;
        try {
            String query = "SELECT * FROM PENGEMUDI WHERE username = '"
                    + username + "',"
                    + " AND password = '" + password +"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Pengemudi(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal select");
        }
        return p;
    }
    
    public Pesanan getPesanan(int idPesanan) {
        Pesanan p = null;
        try {
            String query = "SELECT * FROM PESANAN WHERE idPesanan = "
                    + idPesanan;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new Pesanan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal select pesanan");
        }
        return p;
    }
    
    public ArrayList<Pesanan> loadPesananNotTaken() {
        ArrayList<Pesanan> pesanans = new ArrayList<>();
        try {
            String query = "SELECT * FROM PESANAN WHERE idPengemudi = null";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt(4)==0){
                    Pesanan p = new Pesanan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5));  
                    pesanans.add(p);
                }else{
                    Kurir k = new Kurir(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                    pesanans.add(k);
                }               
            }
        } catch (SQLException ex) {
            System.out.println("Gagal load pesanan not taken");
        }
        return pesanans;
    }
    
    public ArrayList<Pesanan> loadPesananPelanggan(int idPelanggan) {
        ArrayList<Pesanan> pesanans = new ArrayList<>();
        try {
            String query = "SELECT * FROM PESANAN WHERE idPelanggan = "
                    + idPelanggan;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt(4)==0){
                    Pesanan p = new Pesanan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5));  
                    pesanans.add(p);
                }else{
                    Kurir k = new Kurir(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                    pesanans.add(k);
                }               
            }
        } catch (SQLException ex) {
            System.out.println("Gagal load pesanan pelanggan");
        }
        return pesanans;
    }
    
    public ArrayList<Pesanan> loadPesananPengemudi(int idPengemudi) {
        ArrayList<Pesanan> pesanans = new ArrayList<>();
        try {
            String query = "SELECT * FROM PESANAN WHERE idPengemudi = "
                    + idPengemudi;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt(4)==0){
                    Pesanan p = new Pesanan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5));  
                    pesanans.add(p);
                }else{
                    Kurir k = new Kurir(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                    pesanans.add(k);
                }               
            }
        } catch (SQLException ex) {
            System.out.println("Gagal load pesanan pengemudi");
        }
        return pesanans;
    }
    
    public Kurir getKurir(int idPesanan) {
        Kurir k = null;
        try {
            String query = "SELECT * FROM PESANAN WHERE idPesanan = "
                    + idPesanan;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                k = new Kurir(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal select kurir");
        }
        return k;
    }
    
    public void updatePesanan(Pesanan p) {
        try {
            String query = "UPDATE PESANAN SET origin = '" + p.getOrigin()+ "',"
                    + "destination = '" + p.getDestination()+ "', "                  
                    + "WHERE idPesanan = " + p.getIdPesanan();
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Gagal update pesanan");
        }
    } 
    
    public void updateKurir(Kurir k) {
        try {
            String query = "UPDATE PESANAN SET origin = '" + k.getOrigin()+ "',"
                    + "destination = '" + k.getDestination()+ "', "                  
                    + "weight = " + k.getWeight()+ " , "   
                    + "WHERE idPesanan = " + k.getIdPesanan();
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Gagal update kurir");
        }
    } 
    
    public void takePesanan(Pesanan p) {
        try {
            String query = "UPDATE PESANAN SET idPengemudi = " + p.getIdPengemudi()+ ","                                   
                    + "WHERE idPesanan = " + p.getIdPesanan();
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Gagal take pesanan");
        }
    }
    
    public void cancelPesanan(Pesanan p) {
        try {
            String query = "UPDATE PESANAN SET idPengemudi = null,"                                   
                    + "WHERE idPesanan = " + p.getIdPesanan();
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Gagal cancel pesanan");
        }
    }
    
    public void deletePesanan(int idPesanan) {
        try {
            String query = "DELETE FROM PESANAN where idPesanan = "+ idPesanan;
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("Gagal delete pesanan");
        }
    }        
}
