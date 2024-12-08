package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit,fastcash,pinchange,cash,statement,balance,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add (image);
        
        JLabel text=new JLabel("Please Select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setBounds(190, 300, 600, 30);
        text.setForeground(Color.white);
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 15));
        deposit.setBounds(165, 417, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setFont(new Font("System", Font.BOLD, 15));
        fastcash.setBounds(165, 452, 130, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        pinchange=new JButton("Pin Change");
        pinchange.setFont(new Font("System", Font.BOLD, 15));
        pinchange.setBounds(165, 487, 130, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        cash=new JButton("Cash Withdrawl");
        cash.setFont(new Font("System", Font.BOLD, 15));
        cash.setBounds(345, 417, 160, 30);
        cash.addActionListener(this);
        image.add(cash);
        
        statement=new JButton("Mini Statement");
        statement.setFont(new Font("System", Font.BOLD, 15));
        statement.setBounds(345, 452, 160, 30);
        statement.addActionListener(this);
        image.add(statement);
        
        balance=new JButton("Balance Enquiry");
        balance.setFont(new Font("System", Font.BOLD, 15));
        balance.setBounds(345, 487, 160, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit=new JButton("Exit");
        exit.setFont(new Font("System", Font.BOLD, 15));
        exit.setBounds(345, 520, 160, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==cash){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pin(pinnumber).setVisible(true);
        }else if(ae.getSource()==statement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    

    public static void main(String args[]) {
        new Transactions("");
    }
}
