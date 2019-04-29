/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package p_lot;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
        

import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;
import static p_lot.Vehicle.emptySpace;
/**
 *
 * @author r34g4n
 */
public class P_LOT extends JFrame{
    private JPanel panel;
    public static ArrayList<Integer> emptySpace;
    private JButton btnCheckIn, btnCheckOut;

    public P_LOT() {
        this.setVisible(true);
        this.setTitle("Parking Lot Management System");
        this.setSize(new Dimension(800, 400));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        this.add(panel);
        btnCheckIn = new JButton("Check in");
        btnCheckOut = new JButton("Check out");
        
    }
    
    private class btnCheckInActionListener implements ActionListener{
        JFrame frameCheckIn;
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    
    //generate parking spaces on program start
    public static void genEmptyParkingSlot(){
        emptySpace = new ArrayList<Integer>(); 
        for(int i=0; i <21; i++){
            emptySpace.add(i);
            System.out.println(emptySpace.get(i));
        }
    }
    /*space '0' is for null
    because default int value is 0*/
    //
    
    
    public static void main(String[] args) {
        genEmptyParkingSlot();
        Vehicle.vehList = new ArrayList<Vehicle>(); //instatiating list of vehicles in parking
        new LogIn();
        
        /*Date tmp = new Date(System.currentTimeMillis());
        Time tmp0 = new Time(System.currentTimeMillis());
        System.out.println(tmp);
        System.out.println(tmp0);
        long x = tmp.getTime();
        long x0 = tmp.getTime();
        System.out.println(x);
        System.out.println(x0);
        Date d = new Date(x);
        Time t = new Time(x0);
        System.out.println(d);
        System.out.println(t);*/
        /*Vehicle bus = new Vehicle("KBC454J", "nissan", "John", "4528588");
        bus.check_in();
        bus.check_out();
        bus.calcFee();*/
       //System.out.println((new Date(System.currentTimeMillis())).getTime());
       //ong a = Long.parseLong("1555250991000");
       //long b = new Time(System.currentTimeMillis()).getTime();
       //System.out.println(b);
       //System.out.println((b - a) / (60 * 1000));
       //JOptionPane.showMessageDialog(null, b.);
    }
}
