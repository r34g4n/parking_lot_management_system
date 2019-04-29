package p_lot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

/**
 *
 * @author r34g4n
 */

public class LogIn extends JFrame{
    private JLabel lblName,lblPassword;
    private JTextField txtName;
    private JPasswordField txtPassword;
    private JButton btnLogin,btnExit;
    LogIn(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lblName=new JLabel("Username: ");
        lblPassword =new JLabel("Password: ");
        txtName =new JTextField(20);
        txtPassword= new JPasswordField(20);
        btnLogin=new JButton("Login");
        btnExit= new JButton("Exit");
        setVisible(true);
        this.setResizable(false);
        setTitle("Log In Here");
        setSize(350,450);
        setLayout(new FlowLayout());
        add(lblName);
        add(txtName);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
        add(btnExit);
        btnLogin.addActionListener(new Logini());
        btnExit.addActionListener(new  Logini());
        this.setLocationRelativeTo(null);
    }
    public static void main(String[]args){
        new LogIn();
    }
    private class Logini implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnLogin){
                String txtname =txtName.getText();
                String txtpassword = txtPassword.getText();
                if(txtname.equals("Parkguard1") && txtpassword.equals("parking15")){
                            setVisible(false);
                            new FrontPage();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Password or Username!");
                }
            }
            else{
                       int x=JOptionPane.showConfirmDialog(LogIn.this,"Are you sure you want to Exit?"); 
                        if(x==0){
                        System.exit(0);
                        }
                        }
    }
  }
}

