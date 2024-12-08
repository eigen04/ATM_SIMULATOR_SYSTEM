package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupthree extends JFrame implements ActionListener {
    
    JRadioButton saving,fixed,current,recurring;
    JCheckBox atm,internal,mobile,email,Cheque,statement,declaration;
    JButton submit,cancel;
    String formno;
    
    signupthree(String formno){
        this.formno=formno;
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel form=new JLabel("Page3:Account Details");
        form.setFont(new Font("Raleway", Font.BOLD, 25));
        form.setBounds(180, 30, 600, 30);
        add(form);
        
        JLabel account=new JLabel("Account Type:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(30,110, 300, 30);
        add(account);
        
        saving=new JRadioButton("Savings Account");
        saving.setBackground(Color.white);
        saving.setBounds(50, 160, 200, 30);
        add(saving);
        
        fixed=new JRadioButton("Fixed Deposit Account");
        fixed.setBackground(Color.white);
        fixed.setBounds(300, 160, 500, 30);
        add(fixed);
        
        current=new JRadioButton("Current Account");
        current.setBackground(Color.white);
        current.setBounds(50, 210, 200, 30);
        add(current);
        
        recurring=new JRadioButton("Recurring Deposit Account");
        recurring.setBackground(Color.white);
        recurring.setBounds(300, 210, 500, 30);
        add(recurring);
        
        ButtonGroup Account = new ButtonGroup();
        Account.add(saving);
        Account.add(fixed);
        Account.add(current);
        Account.add(recurring);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(30, 270, 600, 30);
        add(card);
        
        JLabel Card=new JLabel("(Your 16 digit card number)");
        Card.setFont(new Font("Raleway", Font.BOLD, 14));
        Card.setBounds(30, 300, 600, 30);
        add(Card);
        
        JLabel dummyno=new JLabel("XXXX-XXXX-XXXX-3272");
        dummyno.setFont(new Font("Raleway", Font.BOLD, 20));
        dummyno.setBounds(260, 270, 600, 30);
        add(dummyno);
        
        JLabel cheque=new JLabel("it would appear on ATM card/cheque book and statements");
        cheque.setFont(new Font("Raleway", Font.BOLD, 14));
        cheque.setBounds(260, 300, 600, 30);
        add(cheque);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(30, 360, 600, 30);
        add(pin);
        
        JLabel pwd=new JLabel("(4-digit password)");
        pwd.setFont(new Font("Raleway", Font.BOLD, 14));
        pwd.setBounds(30, 390, 600, 30);
        add(pwd);
        
        JLabel PIN=new JLabel("XXXX");
        PIN.setFont(new Font("Raleway", Font.BOLD, 20));
        PIN.setBounds(260, 360, 600, 30);
        add(PIN);
        
        JLabel require=new JLabel("Service Required:");
        require.setFont(new Font("Raleway", Font.BOLD, 20));
        require.setBounds(30, 450, 600, 30);
        add(require);
        
        atm=new JCheckBox("ATM CARD");
        atm.setBackground(Color.white);
        atm.setBounds(50, 500, 200, 30);
        add(atm);
        
        internal=new JCheckBox("Internal Banking");
        internal.setBackground(Color.white);
        internal.setBounds(300, 500, 200, 30);
        add(internal);
        
        mobile=new JCheckBox("Mobile Banking");
        mobile.setBackground(Color.white);
        mobile.setBounds(50, 540, 200, 30);
        add(mobile);
        
        email=new JCheckBox("Email Alerts");
        email.setBackground(Color.white);
        email.setBounds(300, 540, 200, 30);
        add(email);
        
        Cheque=new JCheckBox("Cheque Book");
        Cheque.setBackground(Color.white);
        Cheque.setBounds(50, 580, 200, 30);
        add(Cheque);
        
        statement=new JCheckBox("E-Statement");
        statement.setBackground(Color.white);
        statement.setBounds(300,580, 200, 30);
        add(statement);
        
        declaration=new JCheckBox("I hereby declare that the above enterd details are correct to the best of my knowledge");
        declaration.setBackground(Color.white);
        declaration.setBounds(50, 620, 700, 15);
        add(declaration);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(150, 650, 100, 40);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(400, 650, 100, 40);
        cancel.addActionListener(this);
        add(cancel);
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE3");
        setSize(700,800);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String AccountType = null;

        if (saving.isSelected()) {
            AccountType = "Saving Account";
        } else if (fixed.isSelected()) {
            AccountType = "Fixed Deposit Account";
        } else if (current.isSelected()) {
            AccountType = "Current Account";
        } else if (recurring.isSelected()) {
            AccountType = "Recurring Deposit Account";
        }

        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 2709402100000000L);
        String pinnumber = String.format("%04d", Math.abs(random.nextInt(10000))); 


        String facility = "";
        if (atm.isSelected()) {
            facility += "ATM CARD ";
        }
        if (internal.isSelected()) {
            facility += "Internal Banking ";
        }
        if (mobile.isSelected()) {
            facility += "Mobile Banking ";
        }
        if (email.isSelected()) {
            facility += "Email Alerts ";
        }
        if (Cheque.isSelected()) {
            facility += "Cheque Book ";
        }
        if (statement.isSelected()) {
            facility += "E-Statement ";
        }

        try {
            if (AccountType == null) {
                JOptionPane.showMessageDialog(null, "Please select an account type.");
            } else {
                conn c = new conn();
                String query1 = "insert into signupthree values('" + formno + "','" + AccountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                c.s.executeUpdate(query1);
                String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n PIN: " + pinnumber);

                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
        new Login().setVisible(true);
    }
}
       
         

    public static void main(String args[]) {
        new signupthree("");
    }
}
