/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_lot;

import javax.swing.JOptionPane;

/**
 *
 * @author r34g4n
 */
public class smallVehicle extends Vehicle {
    public double fee;
    private double rate; 

    public smallVehicle(String reg_no, String model, String Oname, String Oid) {
        super(reg_no, model, Oname, Oid);
        this.fee = 10;
        this.rate = 5;
        this.SIZE = "Small";
    }
    
    public void calcFee(){
        this.fee += this.ParkingMins * rate;
    }
    
    @Override
    public void check_out(){
        super.check_out();
        this.calcFee();
        String msg = "Total Fee: KES" + this.fee + "\n"
                + "Please ensure the fee is FULLY paid";
        JOptionPane.showMessageDialog(null, msg);
    }
    
    
}
