/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import tubespbo.model.Pelanggan;
import tubespbo.model.Kurir;
import tubespbo.model.Pengemudi;
import tubespbo.model.Pesanan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tubespbo.database.Database;

/**
 *
 * @author irfananda
 */
public class Konsol {
    
    private Pelanggan pelanggan;
    private Pengemudi pengemudi;
    private Database connection;

    public Konsol() {
        connection = new Database();
        connection.connect();
    }    
       
    public Pelanggan loginPelanggan(String username, String password){       
        return connection.getPelanggan(username, password);
    }
    
    public Pengemudi loginPengemudi(String username, String password){
        return connection.getPengemudi(username, password);
    }
    
    private void showPesanan(Pelanggan pelanggan) {
        for(int i=0; i<pelanggan.getAllPesanan().size(); i++){
            if(pelanggan.getPesanan(i) instanceof Kurir){                                        
                System.out.println(i+". origin    : "+pelanggan.getPesanan(i).getOrigin());
                System.out.println("  destination : "+pelanggan.getPesanan(i).getDestination());
                System.out.println("  weight : "+((Kurir) pelanggan.getPesanan(i)).getWeight());
            }else if(pelanggan.getPesanan(i) instanceof Pesanan){                                        
                System.out.println(i+". origin    : "+pelanggan.getPesanan(i).getOrigin());
                System.out.println("  destination : "+pelanggan.getPesanan(i).getDestination());
            }
        }
    }
    
    private void showPesanan(Pengemudi pengemudi) {
        for(int i=0; i<pengemudi.getAllPesanan().size(); i++){
            if(pengemudi.getPesanan(i) instanceof Kurir){                                        
                System.out.println(i+". origin    : "+pengemudi.getPesanan(i).getOrigin());
                System.out.println("  destination : "+pengemudi.getPesanan(i).getDestination());
                System.out.println("  weight : "+((Kurir) pengemudi.getPesanan(i)).getWeight());
            }else if(pengemudi.getPesanan(i) instanceof Pesanan){                                        
                System.out.println(i+". origin    : "+pengemudi.getPesanan(i).getOrigin());
                System.out.println("  destination : "+pengemudi.getPesanan(i).getDestination());
            }
        }
    }
    
//    public void mainMenu(){                     
//        int x,y, weight, n;
//        String username,password, nama, nohp;
//        String origin,destination, any;    
//        Pelanggan pelanggan = null;
//        do{
//            clearScreen();
//            System.out.println("1. Login Pelanggan");
//            System.out.println("2. Login Pengemudi");
//            System.out.println("3. Daftar Pelanggan");
//            System.out.println("4. Daftar Pengemudi");
//            System.out.println("0. Exit");
//            System.out.print("pilih menu : ");   
//            x = scanner.nextInt();           
//            switch(x){
//                case 1:
//                    //pelanggan
//                    clearScreen();
//                    System.out.print("username : ");
//                    username = scanner.next();
//                    System.out.print("password : ");
//                    password = scanner.next();
//                    pelanggan = loginPelanggan(username, password);
//                    if(pelanggan!=null){
//                        do{
//                            clearScreen();
//                            //bisa lihat pesanan, bisa hapus pesanan
//                            //pesanan dapat berupa pesanan/kurir
//                            System.out.println("1. Tambah pesanan Transport");
//                            System.out.println("2. Tambah pesanan Kurir");
//                            System.out.println("3. Lihat semua pesanan");
//                            System.out.println("0. Back");
//                            System.out.print("Pilih menu : ");
//                            y = scanner.nextInt();
//                            switch(y){
//                                case 1:
//                                    //pesanan
//                                    clearScreen();
//                                    System.out.print("origin      : ");
//                                    origin = scanner.next();
//                                    System.out.print("destination : ");
//                                    destination = scanner.next();
//                                    pelanggan.createPesanan(origin, destination);
//                                    break;
//                                case 2:
//                                    //kurir
//                                    clearScreen();
//                                    System.out.print("origin      : ");
//                                    origin = scanner.next();
//                                    System.out.print("destination : ");
//                                    destination = scanner.next();
//                                    System.out.print("weight : ");
//                                    weight = scanner.nextInt();
//                                    pelanggan.createPesananKurir(origin, destination, weight);
//                                    break;                            
//                                case 3:
//                                    //lihat pesanan
//                                    clearScreen();
//                                    showPesanan(pelanggan);
//                                    System.out.println("-1. Back");
//                                    System.out.print("hapus pesanan : ");
//                                    n = scanner.nextInt();
//                                    if(n>=0){
//                                        pelanggan.removePesanan(n);                                        
//                                    }
//                                    break;
//                            }
//                        }while(y!=0);
//                    }else{
//                        System.out.println("username/password salah");
//                    }                    
//                    break;
//                case 2:
//                    //pengemudi
//                    clearScreen();
//                    System.out.print("username : ");
//                    username = scanner.next();
//                    System.out.print("password : ");
//                    password = scanner.next();
//                    Pengemudi pengemudi = loginPengemudi(username, password);                    
//                    if(pengemudi!=null){   
//                        do{
//                            clearScreen();
//                            //bisa lihat pesanan, bisa ambil pesanan
//                            //pesanan dapat berupa pesanan/kurir   
//                            clearScreen();
//                            
//                            System.out.println("0. Back");
//                            System.out.println("1. Ambil pesanan ");
//                            System.out.println("2. Lihat pesanan yang diambil ");
//                            System.out.print("Pilih menu : ");
//                            y = scanner.nextInt();
//                            switch(y){
//                                case 1:
//                                    showPesanan(pelanggan);
//                                    System.out.print("Ambil pesanan : ");
//                                    n = scanner.nextInt();
//                                    if(n>=0){
//                                        pengemudi.addPesanan(pelanggan.getPesanan(n));
//                                    }
//                                    break;
//                                case 2:
//                                    showPesanan(pengemudi);
//                                    System.out.print("Press any key <BACK>");
//                                    any = scanner.next();
//                                    break;
//                            }
//                            
//                        }while(y!=0);
//                    }else{
//                        System.out.println("username/password salah");
//                    }   
//                    break;
//                case 3:
//                    clearScreen();
//                    System.out.print("nama     : ");
//                    nama = scanner.next();
//                    System.out.print("username : ");
//                    username = scanner.next();
//                    System.out.print("password : ");
//                    password = scanner.next();
//                    System.out.print("no hp    : ");
//                    nohp = scanner.next();
//                    addPelanggan(new Pelanggan(nama, username, password, nohp));                           
//                    break;
//                case 4:
//                    clearScreen();
//                    System.out.print("nama     : ");
//                    nama = scanner.next();                 
//                    System.out.print("username : ");
//                    username = scanner.next();
//                    System.out.print("password : ");
//                    password = scanner.next();
//                    System.out.print("no hp    : ");
//                    nohp = scanner.next();
//                    addPengemudi(new Pengemudi(nama, username, password, nohp));
//                    break;
//            }
//        }while(x!=0);
//    }
//    
//    public void clearScreen() {
//        final String operatingSystem = System.getProperty("os.name");
//        if (operatingSystem .contains("Windows")) {
//            try {
//                Runtime.getRuntime().exec("cls");
//            } catch (IOException ex) {
//                Logger.getLogger(Konsol.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else {
//            try {
//                Runtime.getRuntime().exec("clear");
//            } catch (IOException ex) {
//                Logger.getLogger(Konsol.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
}
