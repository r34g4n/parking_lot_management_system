/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_lot;
import javax.swing.*;
import java.sql.*;
import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
/**
 *
 * @author r34g4n
 */
public abstract class Vehicle {
    public static ArrayList <Vehicle> vehList;
    public String SIZE;
    //public static int counter;
    protected String reg_no, model, Oname, Oid;
    protected long checkIn_date, checkOut_date;
    protected boolean checked_in, checked_out = true;
    protected long checkIn_time, checkOut_time;
    protected long ParkingMins;
    //protected static int[] emptySpace = P_LOT.emptySpace;
    protected static ArrayList<Integer> emptySpace = P_LOT.emptySpace;
    protected int parkingSpace;

    public Vehicle(String reg_no, String model, String Oname, String Oid) {
        this.reg_no = reg_no.toUpperCase();
        this.model = model;
        this.Oname = Oname;
        this.Oid = Oid;
        check_in();
        //this.counter += 1;
        
    }
    
    protected void getParkingSpace(){
        String msg;
        if(this.parkingSpace==0 && emptySpace.size() > 1){
            this.parkingSpace = emptySpace.get(1);
            emptySpace.remove(1); //allocted space is removed from empty space
            msg = "Proceed to parking Space: " + this.parkingSpace;
            JOptionPane.showMessageDialog(null, msg);
            //JOptionPane.showMessageDialog(null, "Debugging...passed here");
        }else{
            msg = "Sorry! No empty parking space";
            JOptionPane.showMessageDialog(null, msg);
        }
    }
    
    protected void releaseParkingSpace(){
        if(this.parkingSpace!=0){
            emptySpace.add(parkingSpace);
            this.parkingSpace = 0;
        }
    }
    
    
    void check_in(){
        String msg;
        if (checked_in){
            msg = "FAILED! Vehicle " + reg_no + " ("+ model +") already checked in.";
            JOptionPane.showMessageDialog(null, msg);
        }else{
            this.checkIn_date = new Date(System.currentTimeMillis()).getTime();
            this.checkIn_time = new Time(System.currentTimeMillis()).getTime();
            checked_in = true;
            checked_out = false;
            msg = "SUCCESS! " + reg_no + " checked in at "
                    + new Time(checkIn_time) + " on " + new Date(checkIn_date) + ".";
            JOptionPane.showMessageDialog(null, msg);
        }
        getParkingSpace();
    }
    
    void check_out(){
       String msg;
        if (checked_out){
            msg = "FAILED! Vehicle " + reg_no + " ("+ model +") already checked out.";
            JOptionPane.showMessageDialog(null, msg);
        }else{
            this.checkOut_date = new Date(System.currentTimeMillis()).getTime();
            this.checkOut_time = new Time(System.currentTimeMillis()).getTime();
            checked_in = false;
            checked_out = true;
            msg = "SUCCESS! " + reg_no + " checked out at "
                    + new Time(checkOut_time) + " on " + new Date(checkOut_date) + ".";
            JOptionPane.showMessageDialog(null, msg);
        }
        
        releaseParkingSpace();
        this.calcParkingTime();
        vehList.remove(this);
    }
    
    protected void calcParkingTime(){
        this.ParkingMins = (this.checkOut_time - this.checkIn_time) / (60 * 1000);
        
    }
    
    
    
}
