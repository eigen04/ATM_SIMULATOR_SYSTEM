package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
 
public class FastCash extends JFrame implements ActionListener {
    
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add (image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMMOUNT");
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setBounds(190, 300, 600, 30);
        text.setForeground(Color.white);
        image.add(text);
        
        hundred=new JButton("Rs 100");
        hundred.setFont(new Font("System", Font.BOLD, 15));
        hundred.setBounds(165, 417, 130, 30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        thousand=new JButton("Rs 1000");
        thousand.setFont(new Font("System", Font.BOLD, 15));
        thousand.setBounds(165, 452, 130, 30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        fivethousand=new JButton("Rs 5000");
        fivethousand.setFont(new Font("System", Font.BOLD, 15));
        fivethousand.setBounds(165, 487, 130, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        fivehundred=new JButton("Rs 500");
        fivehundred.setFont(new Font("System", Font.BOLD, 15));
        fivehundred.setBounds(345, 417, 160, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        twothousand=new JButton("Rs 2000");
        twothousand.setFont(new Font("System", Font.BOLD, 15));
        twothousand.setBounds(345, 452, 160, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        tenthousand=new JButton("Rs 10000");
        tenthousand.setFont(new Font("System", Font.BOLD, 15));
        tenthousand.setBounds(345, 487, 160, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back=new JButton("BACK");
        back.setFont(new Font("System", Font.BOLD, 15));
        back.setBounds(345, 520, 160, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String ammount=((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("ammount"));
                }
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(ammount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                else{
                    Date date=new Date();
                    String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+ammount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+ammount+" Debited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
                
            }
        }
    }
    

    public static void main(String args[]) {
        new FastCash("");
    }
}
