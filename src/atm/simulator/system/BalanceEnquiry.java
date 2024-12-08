package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
            
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add (image);
        
        back=new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 15));
        back.setBounds(345, 487, 160, 30);
        back.addActionListener(this);
        image.add(back);
        
        int balance=0;
        conn c = new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");               
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("ammount"));
                }
                }
            }   catch(Exception e){
                System.out.println(e);
                
            }
        JLabel text=new JLabel("Your current Account Balance is Rs "+ balance);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setBounds(170, 300, 600, 30);
        text.setForeground(Color.white);
        image.add(text);    
        
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
