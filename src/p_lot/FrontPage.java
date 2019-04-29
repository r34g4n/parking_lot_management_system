package p_lot;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

/**
 *
 * @author r34g4n
 */

public class FrontPage extends JFrame {
    private JButton btnCheckIn,btnCheckOut,btnExit;
    FrontPage(){
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnCheckIn=new JButton("Check In");
        btnCheckOut=new JButton("Check Out");
        btnExit= new JButton("Exit");
        setVisible(true);
        setTitle("THE PARKINGLOT");
        setSize(350,450);
        setLayout(new FlowLayout());
        add(btnCheckIn);
        add(btnCheckOut);
        add(btnExit);
      btnCheckIn.addActionListener(new HomePage());
       btnCheckOut.addActionListener(new HomePage());
       btnExit.addActionListener(new HomePage());
    }
    public static void main(String[]s){
        new FrontPage();
    }private class HomePage implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnCheckIn){
                            setVisible(false);
                            new FrameCheckIn();
                }else{
                if(e.getSource()==btnCheckOut){
                            setVisible(false);
                            new CheckOut();
                }else{System.exit(1);}
            }
        }
    }
}
