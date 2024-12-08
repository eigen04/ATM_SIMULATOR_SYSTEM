package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pin extends JFrame implements ActionListener{
    
    JButton back,change;
    String pinnumber;
    JPasswordField New,Re;
    
    pin(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add (image);
        
        JLabel text=new JLabel("Change your PIN");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(250, 300, 600, 30);
        text.setForeground(Color.white);
        image.add(text);
        
        JLabel newpin=new JLabel("New PIN:");
        newpin.setFont(new Font("System", Font.BOLD, 18));
        newpin.setBounds(170, 350, 600, 30);
        newpin.setForeground(Color.white);
        image.add(newpin);
        
        JLabel re=new JLabel("Re Enter New PIN:");
        re.setFont(new Font("System", Font.BOLD, 18));
        re.setBounds(170, 390, 600, 30);
        re.setForeground(Color.white);
        image.add(re);
        
        New = new JPasswordField("");
        New.setBounds(350, 350, 150, 30);
        image.add(New);
        
        Re = new JPasswordField("");
        Re.setBounds(350, 390, 150, 30);
        image.add(Re);
        
        change=new JButton("Change");
        change.setFont(new Font("System", Font.BOLD, 15));
        change.setBounds(345, 487, 160, 30);
        change.addActionListener(this);
        image.add(change);
        
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
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == change) {
        try {
            String npin = New.getText();
            String rpin = Re.getText();
            
            // Check if both PINs match
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }
            
            // Ensure the new PIN is not empty
            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Pin");
                return;
            }
            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please re-Enter new Pin");
                return;
            }
            
            // Create connection to the database
            conn c = new conn();
            
            // Correct SQL queries with the proper column names in each table
            String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'"; // For bank table
            String q2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'"; // For login table
            String q3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'"; // For signupthree table
            
            // Execute the queries
            c.s.executeUpdate(q1);
            c.s.executeUpdate(q2);
            c.s.executeUpdate(q3);
            
            // Show success message
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}

    public static void main(String args[]) {
      new pin("").setVisible(true);
    }
}
