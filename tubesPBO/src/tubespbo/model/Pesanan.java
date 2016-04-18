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
	
    private String origin;
    private String destination;
	
    public Pesanan (String origin, String destination) {
            this.origin = origin;
            this.destination = destination;
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

}
