package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add (image);
        
        JLabel text=new JLabel("Enter Ammount You Want To Deposit");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(170, 300, 600, 30);
        text.setForeground(Color.white);
        image.add(text);
        
        amount = new JTextField("");
        amount.setBounds(160, 350, 350, 30);
        add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 15));
        deposit.setBounds(345, 487, 160, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 15));
        back.setBounds(345, 520, 160, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the ammount you want to deposit");
            }else {
            try {
                conn c = new conn();
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + number + "')";
                c.s.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true); 
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    

    public static void main(String args[]) {
       new Deposit("");
    }
}
