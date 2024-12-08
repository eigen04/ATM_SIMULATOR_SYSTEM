package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class signuptwo extends JFrame implements ActionListener {
    
    JTextField panfield,aadharfield;
    JButton next;
    JRadioButton no,yes,YES,NO;
    JComboBox Religion,Category,Income,Education,Occupation; 
    String formno;
    
    
    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        
        getContentPane().setBackground(Color.white);        
        
        JLabel form=new JLabel("Page2:Additional details");
        form.setFont(new Font("Raleway", Font.BOLD, 25));
        form.setBounds(160, 70, 600, 30);
        add(form);
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Arial", Font.BOLD, 20));
        religion.setBounds(30, 120, 150, 30);
        add(religion);
        
        String valreligion[]={"hindu","muslim","sikh","christian","other"};
        Religion = new JComboBox(valreligion);
        Religion.setFont(new Font("Arial", Font.BOLD, 20));
        Religion.setBounds(260, 120, 300, 30);
        Religion.setBackground(Color.white);
        add(Religion);
        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(30, 170, 200, 30);
        add(category);
        
        String valcategory[]={"general","obc","sc","st","other"};
        Category = new JComboBox(valcategory);
        Category.setFont(new Font("Arial", Font.BOLD, 20));
        Category.setBackground(Color.white);
        Category.setBounds(260, 170, 300, 30);
        add(Category);
        
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(30, 220, 200, 30);
        add(income);
        
        String valincome[]={"null","<5,00,000","<10,00,000","<15,00,00",">20,00,000"};
        Income = new JComboBox(valincome);
        Income.setFont(new Font("Arial", Font.BOLD, 20));
        Income.setBackground(Color.white);
        Income.setBounds(260, 220, 300, 30);
        add(Income);
        
        JLabel education=new JLabel("Education");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(30, 270, 550, 30);
        add(education);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(30, 310, 550, 30);
        add(qualification);
        
        String valeducation[]={"non graduate","post graduate","graduate","other","doctorate"};
        Education = new JComboBox(valeducation);
        Education.setFont(new Font("Arial", Font.BOLD, 20));
        Education.setBackground(Color.white);
        Education.setBounds(260, 310, 300, 30);
        add(Education);
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(30, 360, 550, 30);
        add(occupation);
        
        String valoccupation[]={"buisness","private","government","other"};
        Occupation = new JComboBox(valoccupation);
        Occupation.setFont(new Font("Arial", Font.BOLD, 20));
        Occupation.setBackground(Color.white);
        Occupation.setBounds(260, 360, 300, 30);
        add(Occupation);
        
        JLabel pan=new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(30, 410, 550, 30);
        add(pan);
        
        panfield = new JTextField("");
        panfield.setBounds(260, 410, 300, 30);
        add(panfield);
        
        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(30, 460, 550, 30);
        add(aadhar);
        
        aadharfield = new JTextField("");
        aadharfield.setBounds(260, 460, 300, 30);
        add(aadharfield);
        
        JLabel senior=new JLabel("Senior Citizen");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(30, 510, 400, 30);
        add(senior);
        
        yes = new JRadioButton("YES");
        yes.setBackground(Color.white);
        yes.setBounds(260, 510, 60, 30);
        add(yes);
        
        no = new JRadioButton("NO");
        no.setBackground(Color.white);
        no.setBounds(420, 510, 60, 30);
        add(no);
        
        ButtonGroup Senior = new ButtonGroup();
        Senior.add(yes);
        Senior.add(no);
        
        JLabel account=new JLabel("Existing Account:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(30, 560, 300, 30);
        add(account);
        
        YES = new JRadioButton("YES");
        YES.setBackground(Color.white);
        YES.setBounds(260, 560, 100, 30);
        add(YES);
        
        NO = new JRadioButton("NO");
        NO.setBackground(Color.white);
        NO.setBounds(420,560, 150, 30);
        add(NO);
        
        ButtonGroup Account = new ButtonGroup();
        Account.add(YES);
        Account.add(NO);
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(500, 650, 60, 40);
        next.addActionListener(this);
        add(next);
        
        
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE2");
        setSize(800,800);
        setVisible(true);
        setLocation(350,10);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        String religion =(String) Religion.getSelectedItem();
        String category =(String) Category.getSelectedItem();
        String income =(String) Income.getSelectedItem();
        String education =(String) Education.getSelectedItem();
        String occupation =(String) Occupation.getSelectedItem();
        String pan= panfield.getText();
        String aadhar=aadharfield.getText();
        String Senior = null;
        if(yes.isSelected()){
            Senior="YES";
            
        }else if(no.isSelected()){
            Senior="NO";
        }
    
        String Account=null;
        if(YES.isSelected()){
            Account="YES";
        }else if(NO.isSelected()){
            Account="NO";
        }
        
    try
    {
            conn c = new conn();
            String query = "insert into signuptwo values('" + formno + "','" + religion + "','" + category + "','" + income + "','" +education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + Senior + "','" + Account + "')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new signupthree(formno).setVisible(true);
            
    }catch(Exception e){
        System.out.println(e);
    }
        }

    public static void main(String args[]) {
      new signuptwo("");  
    }
}
