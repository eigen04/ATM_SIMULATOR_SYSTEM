package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Signupone extends JFrame implements ActionListener {
    
    long random;
    JTextField namefield,fatherfield,emailfield,pinfield,statefield,cityfield,addressfield;
    JButton next;
    JRadioButton female,male,married,unmarried,other;
    JDateChooser DOB;
    
    
    
    Signupone(){
        setLayout(null);
        
        Random ran=new Random();
        random= Math.abs((ran.nextLong() % 9000L)+1000L);
        
        getContentPane().setBackground(Color.white);
        
        JLabel formno=new JLabel("Application Form No."+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 28));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel form=new JLabel("Page1:Personal details");
        form.setFont(new Font("Raleway", Font.BOLD, 25));
        form.setBounds(160, 70, 600, 30);
        add(form);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 25));
        name.setBounds(30, 120, 150, 30);
        add(name);
        
        namefield = new JTextField("");
        namefield.setBounds(260, 120, 300, 30);
        add(namefield);
        
        JLabel fathername=new JLabel("Father's Name:");
        fathername.setFont(new Font("Raleway", Font.BOLD, 25));
        fathername.setBounds(30, 170, 200, 30);
        add(fathername);
        
        fatherfield = new JTextField("");
        fatherfield.setBounds(260, 170, 300, 30);
        add(fatherfield);
        
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 25));
        dob.setBounds(30, 220, 200, 30);
        add(dob);
        
        DOB= new JDateChooser();
        DOB.setBounds(260, 220, 300, 30);
        add(DOB);
        
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 25));
        gender.setBounds(30, 270, 400, 30);
        add(gender);
        
        male = new JRadioButton("male");
        male.setBackground(Color.white);
        male.setBounds(260, 270, 60, 30);
        add(male);
        
        female = new JRadioButton("female");
        female.setBackground(Color.white);
        female.setBounds(420, 270, 100, 30);
        add(female);
        
        ButtonGroup Gender = new ButtonGroup();
        Gender.add(male);
        Gender.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 25));
        email.setBounds(30, 320, 200, 30);
        add(email);
        
        emailfield = new JTextField("");
        emailfield.setBounds(260, 320, 300, 30);
        add(emailfield);
        
        JLabel marriage=new JLabel("Marital Status:");
        marriage.setFont(new Font("Raleway", Font.BOLD, 25));
        marriage.setBounds(30, 370, 200, 30);
        add(marriage);
        
        married = new JRadioButton("married");
        married.setBackground(Color.white);
        married.setBounds(260, 370, 100, 30);
        add(married);
        
        unmarried = new JRadioButton("unmarried");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(380,370, 150, 30);
        add(unmarried);
        
        other = new JRadioButton("other");
        other.setBackground(Color.white);
        other.setBounds(550, 370, 100, 30);
        add(other);
        
        ButtonGroup marry = new ButtonGroup();
        marry.add(married);
        marry.add(unmarried);
        marry.add(other);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 25));
        address.setBounds(30, 420, 550, 30);
        add(address);
        
        addressfield = new JTextField("");
        addressfield.setBounds(260, 420, 300, 30);
        add(addressfield);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 25));
        city.setBounds(30, 470, 550, 30);
        add(city);
        
        cityfield = new JTextField("");
        cityfield.setBounds(260, 470, 300, 30);
        add(cityfield);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 25));
        state.setBounds(30, 520, 550, 30);
        add(state);
        
        statefield = new JTextField("");
        statefield.setBounds(260, 520, 300, 30);
        add(statefield);
        
        JLabel pin=new JLabel("Pincode:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(30, 570, 550, 30);
        add(pin);
        
        pinfield = new JTextField("");
        pinfield.setBounds(260, 570, 300, 30);
        add(pinfield);
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(500, 650, 60, 40);
        next.addActionListener(this);
        add(next);
        
        
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE1");
        setSize(800,800);
        setVisible(true);
        setLocation(350,10);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = namefield.getText();
        String fathername = fatherfield.getText();
        String dob = ((JTextField)DOB.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
            
        }else if(female.isSelected()){
            gender="Female";
        }
    
        String email = emailfield.getText();
        String marriage=null;
        if(married.isSelected()){
            marriage="married";
        }else if(unmarried.isSelected()){
            marriage="unmarried";
        }else if(other.isSelected()){
            marriage="other";
        }
    
    String pin= pinfield.getText();
    String city=cityfield.getText();
    String state=statefield.getText();
    String address=addressfield.getText();
    try
    {
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "required");
        }else {
            conn c = new conn();
            String query="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+city+"','"+pin+"','"+state+"','"+dob+"','"+gender+"','"+marriage+"','"+email+"','"+address+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new signuptwo(formno).setVisible(true);
        }
    }catch(Exception e){
        System.out.println(e);
    }
        }

    public static void main(String args[]) {
      new Signupone();  
    }
}
