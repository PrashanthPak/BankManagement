import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
public class Signup extends JFrame implements ActionListener{
    long random;
    JTextField nametext,fnametext,Mtext,email,Addtext,ctext,dobtext,pincodetext;
    JButton submit,clear;
    JRadioButton male,female;
    Signup(){
        setLayout(null);
        Random r=new Random();
         random=Math.abs((r.nextLong() % 9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO :-"+random); 
        formno.setFont(new Font("Times New Roman",Font.BOLD,26));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

          JLabel personDetail=new JLabel("Personal Details Page-1"); 
        personDetail.setFont(new Font("Times New Roman",Font.BOLD,20));
        personDetail.setBounds(290, 80, 300, 30);
        add(personDetail);


         JLabel Name=new JLabel("Full Name"); 
        Name.setFont(new Font("Times New Roman",Font.BOLD,20));
        Name.setBounds(100, 140, 300, 30);
        add(Name);

        nametext=new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 15));
        nametext.setBounds(300,140,400,30);
        add(nametext);

        
         JLabel fName=new JLabel("Father's Name"); 
        fName.setFont(new Font("Times New Roman",Font.BOLD,20));
        fName.setBounds(100, 190, 300, 30);
        add(fName);
         
          fnametext=new JTextField();
        fnametext.setFont(new Font("Raleway", Font.BOLD, 15));
        fnametext.setBounds(300,190,400,30);
        add(fnametext);

        JLabel DOB=new JLabel("DOB");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 230, 300, 30);
        add(DOB);

        dobtext=new JTextField();
        dobtext.setFont(new Font("Raleway", Font.BOLD, 20));
        dobtext.setBounds(300,230,400,30);
        add(dobtext);
        
         JLabel gender=new JLabel("Gender"); 
        gender.setFont(new Font("Times New Roman",Font.BOLD,20));
        gender.setBounds(100, 270, 300, 30);
        add(gender);

         male=new JRadioButton("Male"); 
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBackground(Color.CYAN);
        male.setBounds(300,270,150,30);
        add(male);

        female=new JRadioButton("FeMale"); 
         female.setBackground(Color.CYAN);
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBounds(450,270,200,30);
        add(female);

        ButtonGroup groupbutton=new ButtonGroup();
        groupbutton.add(male);
        groupbutton.add(female);
        
         JLabel mno=new JLabel("Mobile No"); 
        mno.setFont(new Font("Times New Roman",Font.BOLD,20));
        mno.setBounds(100, 310, 300, 30);
        add(mno);

        Mtext=new JTextField();
        Mtext.setFont(new Font("Raleway", Font.BOLD, 15));
        Mtext.setBounds(300,310,400,30);
        add(Mtext);

           JLabel Email=new JLabel("Email"); 
        Email.setFont(new Font("Times New Roman",Font.BOLD,20));
        Email.setBounds(100, 350, 300, 30);
        add(Email);

         email=new JTextField();
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(300,350,400,30);
        add(email);

         JLabel Address=new JLabel("Address"); 
        Address.setFont(new Font("Times New Roman",Font.BOLD,20));
        Address.setBounds(100, 390, 300, 30);
        add(Address);

        Addtext =new JTextField();
        Addtext.setFont(new Font("Raleway", Font.BOLD, 20));
        Addtext.setBounds(300,390,400,30);
        add(Addtext);

        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 430, 300, 30);
        add(city);

        ctext=new JTextField();
        ctext.setFont(new Font("Raleway", Font.BOLD, 20));
        ctext.setBounds(300,430,400,30);
        add(ctext);

        JLabel Pincode=new JLabel("Pincode");
        Pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        Pincode.setBounds(100, 470, 300, 30);
        add(Pincode);

        pincodetext=new JTextField();
        pincodetext.setFont(new Font("Raleway", Font.BOLD, 20));
        pincodetext.setBounds(300,470,400,30);
        add(pincodetext);

         submit=new JButton("Next");
        submit.setBounds(250, 510, 150, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setForeground(Color.WHITE);
       submit.setBackground(Color.GRAY);
       submit.addActionListener(this);
           add(submit);

        clear=new JButton("Clear");
        clear.setBounds(420, 510, 150, 30);
        clear.setFont(new Font("Raleway", Font.BOLD, 20));
        clear.setForeground(Color.WHITE);
       clear.setBackground(Color.GRAY);
       clear.addActionListener(this);
           add(clear);
        
    getContentPane().setBackground(Color.CYAN);
   setSize(850,800);
   setLocation(350,10);
   setVisible(true);
    }
    // Actions to the page below 
    public void actionPerformed(ActionEvent ae)
    {
      
      String formno =" "+random;
      String Name = nametext.getText();
      String fName = fnametext.getText();
      String DOB = dobtext.getText();
      String gender = null;
      if(male.isSelected())
      {
        gender= "male";
      }
      else{
        gender="female";
      }
      String mno= Mtext.getText();
      String Email= email.getText();
      String Address= Addtext.getText();
      String city= ctext.getText();
      String Pincode = pincodetext.getText();

      try{
        if(Name.equals(""))        {
         JOptionPane.showMessageDialog(null,"Name is Empty"); //adding validation
         System.exit(0);
        }
      else
      {
        conn c=new conn();
        String query= "insert into signup values('"+formno+"','"+Name+"','"+fName+"','"+DOB+"','"+gender+"','"+mno+"','"+Email+"','"+Address+"','"+city+"','"+Pincode+"')";
        c.s.executeUpdate(query);
      }
    }
      catch(Exception e)
      {
        System.out.println(e);
      }

      if(ae.getSource() == submit)
      {
          setVisible(false);
          new Signup2(formno).setVisible(true);
      }
      else if(ae.getSource() == clear)
      {
         nametext.setText("");
         fnametext.setText("");
        dobtext.setText("");
         email.setText("");
         Mtext.setText("");
         Addtext.setText("");
         pincodetext.setText("");
         ctext.setText("");
      }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
