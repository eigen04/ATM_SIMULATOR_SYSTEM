package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{
    
    JButton exit;
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("Indian Bank");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(140, 30, 600, 30);
        add(text);
        
        JLabel mini=new JLabel();
        mini.setBounds(20, 130, 300, 300);
        add(mini);
        
        JLabel card=new JLabel("Card Number:");
        card.setBounds(20, 80, 300, 30);
        add(card);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        
        int balance=0;
        conn c = new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");               
                while(rs.next()){
                    mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("ammount") + "<br><br><html>");

                    if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("ammount"));
                }
                }
            }   catch(Exception e){
                System.out.println(e);
                
            }
        
        JLabel Balance=new JLabel("Your Total Balance is RS"+ balance);
        Balance.setFont(new Font("System", Font.BOLD, 18));
        Balance.setBounds(30, 460, 600, 30);
        add(Balance);
        
        exit=new JButton("Exit");
        exit.setBounds(30, 500, 80, 40);
        exit.addActionListener(this);
        add(exit);
        
        setTitle("MiniStatement");
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
        this.setVisible(false); 
        new Transactions(pinnumber).setVisible(true); // Open the Transaction page
    }
    }

    public static void main(String args[]) {
        new MiniStatement("").setVisible(true);
        
    }
}
