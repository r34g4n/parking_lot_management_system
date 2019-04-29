/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_lot;
import p_lot.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Time;
import java.sql.Date;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author r34g4n
 */
public class FrameCheckIn extends JFrame{
    boolean flag;
    JPanel inPanel;
    private JLabel lblSize,lblReg, lblModel, lblOname, lblOid;
    private JTextField txtSize,txtReg, txtModel, txtOname, txtOid;
    JButton btnSubmit, btnBack;
    String reg, model, Oname, Oid;
    char size;
    Vehicle vehiclex;

    public FrameCheckIn() {
        this.setVisible(true);
        this.pack();
        this.setTitle("Check In");
        this.setResizable(false);
        this.setSize(new Dimension(800, 400));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        inPanel = new JPanel(new FlowLayout());
        this.add(inPanel);
        
        lblReg = new JLabel("Registration Number");
        lblSize = new JLabel("Size(S/M/L) ");
        lblModel = new JLabel("Model");
        lblOname = new JLabel("Owner Name");
        lblOid = new JLabel("Owner Id");
        
        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new FrontPage();
            }
        });
        
        txtReg = new JTextField(12);
        txtSize = new JTextField(2);
        txtModel = new JTextField(10);
        txtOname = new JTextField(20);
        txtOid = new JTextField(10);
        
        inPanel.add(lblReg);
        inPanel.add(txtReg);
        inPanel.add(lblModel);
        inPanel.add(txtModel);
        inPanel.add(lblOname);
        inPanel.add(txtOname);
        inPanel.add(lblOid);
        inPanel.add(txtOid);
        inPanel.add(lblSize);
        inPanel.add(txtSize);
        inPanel.add(btnSubmit);
        inPanel.add(btnBack);
        btnSubmit.addActionListener(new Handler());
        
        
     pack();   
    }
    
    private void checkSize(){
        this.size = ((txtSize.getText()).toUpperCase()).charAt(0);
        this.reg = txtReg.getText();
        this.model = txtModel.getText();
        this.Oname = txtOname.getText();
        this.Oid = txtOid.getText();
        for(int i = 0; i < Vehicle.vehList.size(); i++){
           String reg1 = (Vehicle.vehList.get(i)).reg_no;
           long date = (Vehicle.vehList.get(i)).checkIn_date;
           long time = (Vehicle.vehList.get(i)).checkIn_time;
           int space = (Vehicle.vehList.get(i)).parkingSpace;
           if(reg1.equalsIgnoreCase(reg)){
               i = Vehicle.vehList.size();
               JOptionPane.showMessageDialog(null, reg1 + " already registered and checked in on "
                       + "" + new Date(date) + " at " + new Time(time) + "\n"
                       + "check ** PARKING SPACE: " + space + " **");
               this.flag = true;
               setVisible(false);
               new FrameCheckIn();
           }
        }
       if(!this.flag){
            if( this.size=='S'){
            this.vehiclex = new smallVehicle(this.reg, this.model, this.Oname, this.Oid);
        }
        else if (this.size=='M'){
           this.vehiclex = new mediumVehicle(this.reg, this.model, this.Oname, this.Oid);
        }else{this.vehiclex = new largeVehicle(this.reg, this.model, this.Oname, this.Oid);}
        Vehicle.vehList.add(vehiclex);
       }
    }
    
    private class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            checkSize();
        }
    }
    public static void main(String[]s){
        new FrameCheckIn();
    }
    
}
