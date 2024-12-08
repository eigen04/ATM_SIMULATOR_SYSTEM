package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,reset,signup;
    JTextField cardfield;
    JPasswordField pinfield;
    
    Login(){
        //set icon to top
        setLayout(null);
        
        //pasting image on frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add (label);
        
       //background color
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setBounds(200, 40, 500, 40); 
        text.setFont(new Font("Raleway", Font.BOLD, 38)); 
        add(text);
        
        JLabel cardno = new JLabel("CARD NO:");
        cardno.setBounds(120, 150, 150, 40); 
        cardno.setFont(new Font("Raleway", Font.BOLD, 28)); 
        add(cardno);
        
        cardfield=new JTextField();
        add(cardfield);
        cardfield.setBounds(300,150,250,30);
        
        
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120, 220, 250, 30); 
        pin.setFont(new Font("Raleway", Font.BOLD, 28)); 
        add(pin);
        
        pinfield=new JPasswordField();
        add(pinfield);
        pinfield.setBounds(300,220,250,30);
        
        login=new JButton("SIGN IN");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setBounds(300, 300, 100, 30);
        add(login);
        
        reset=new JButton("RESET");
        reset.setBackground(Color.black);
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        reset.setBounds(430, 300, 100, 30);
        add(reset);
        
        signup=new JButton("SIGN UP");
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        signup.setBounds(300, 350, 230, 30);
        add(signup);
        
        
        //create frame
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==reset){
            cardfield.setText("");
            pinfield.setText("");
        }else if(ae.getSource()==login){
            conn c = new conn();
            String cardnumber = cardfield.getText();
            String pinnumber = pinfield.getText();
            String query = "select * from login where cardnumber ='"+cardnumber+"'and pinnumber='"+pinnumber+"'";
            try{
                ResultSet rs =c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(true);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect card number");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signupone().setVisible(true);
            
        }
    }

    public static void main(String args[]) {
        new Login();
        
    }
}
