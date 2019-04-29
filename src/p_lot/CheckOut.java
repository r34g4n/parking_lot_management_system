package p_lot;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author r34g4n
 */

public class CheckOut extends JFrame {
    int counter; JPanel panelHeader;
    JLabel lblReg, lblCounter;
    JLabel lblModel;
    JLabel lblname;
    JLabel lblid;
    JLabel lblsize, lblSpace;
   JScrollPane scroll;
   JButton btnAction;

    public CheckOut() {
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(800,800));
        this.setResizable(false);
        this.pack();
    }

   private void initComponents(){
       
       this.setTitle("Choose vehicle to checkout");
       this.setLayout(new FlowLayout());
       //Header panel
       panelHeader = new JPanel();
       lblCounter = new JLabel("No.");
       lblReg = new JLabel("| Reg Number |");
       lblModel = new JLabel("*****Model*****|");
       lblname = new JLabel("Owner Name |");
       lblid = new JLabel("Owner Id |");
       lblsize = new JLabel(" Size |");
       lblSpace = new JLabel("ParkingSpace|");
      btnAction = new JButton("<--Back");
       
       
       panelHeader.add(lblCounter);
       panelHeader.add(lblReg);
       panelHeader.add(lblModel);
       panelHeader.add(lblname);
       panelHeader.add(lblid);
       panelHeader.add(lblsize);
       panelHeader.add(lblSpace);
       panelHeader.add(btnAction);
       btnAction.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
               setVisible(false);
               new FrontPage();
           }
       });
       
       this.add(panelHeader);
       //
       for(int i = 0; i < Vehicle.vehList.size(); i++){
           this.counter = i;
           this.getContentPane().add(new panelBody());
       }
       
       
   }
   
   private class panelBody extends JPanel{
       
       JTextField txtCounter, txtReg, txtModel,txtname,txtid,txtsize, txtSpace;
       JButton btnConfirm;

        panelBody() {
            Vehicle veh = Vehicle.vehList.get(counter);
            
            txtCounter = new JTextField(3);
            txtReg = new JTextField(8);
            txtModel = new JTextField(10);
            txtname = new JTextField(8);
            txtid = new JTextField(4);
            txtsize = new JTextField(3);
            txtSpace = new JTextField(7);
            btnConfirm = new JButton("Check Out");
            
            txtCounter.setText(counter + 1 + ".");
            this.txtReg.setText(veh.reg_no);
            this.txtModel.setText(veh.model);
            this.txtname.setText(veh.Oname);
            this.txtid.setText(veh.Oid);
            this.txtsize.setText(veh.SIZE.charAt(0) + "");
            this.txtSpace.setText(veh.parkingSpace + "");
            
            txtCounter.setEditable(false);
            txtReg.setEditable(false);
            txtModel.setEditable(false);
            txtname.setEditable(false);
            txtid.setEditable(false);
            txtsize.setEditable(false);
            txtSpace.setEditable(false);
            
            
            this.add(txtCounter);
            this.add(txtReg);
            this.add(txtModel);
            this.add(txtname);
            this.add(txtid);
            this.add(txtsize);
            this.add(txtSpace);
            this.add(btnConfirm);
            btnConfirm.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   veh.check_out();
                   Vehicle.vehList.remove(veh);
                   setVisible(false);
                }
            });
        }
       
       
   }
   
   public static void main(String[]s){
        new CheckOut();
    }
                   
}

