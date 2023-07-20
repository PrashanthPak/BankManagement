import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

public class Signup2 extends JFrame implements ActionListener{
    JLabel Header,acctype, accno,a,acctext,pin,p,pintext,service;
     JRadioButton t1,t2,t3,t4;
    JCheckBox s1,s2,s3,s4,d;
    JButton submit,clear;
    String formno;
    Signup2(String formno)
    {
        this.formno=formno;
          setLayout(null);
        setTitle("Bank Details");
         Header=new JLabel("page 2: Account Details");
        Header.setFont(new Font("Times New Roman",Font.BOLD,29));
        Header.setBounds(280, 40, 400, 40);
        add(Header);

        acctype=new JLabel("Account Type");
         acctype.setFont(new Font("Times New Roman",Font.BOLD,20));
         acctype.setBounds(100, 140, 200, 30);
        add(acctype);

        t1=new JRadioButton("Fixed Account");
        t1.setBounds(100, 180, 150, 20);
        t1.setBackground(Color.WHITE);
        add(t1);
        
        t2=new JRadioButton("Savings Account");
        t2.setBounds(350, 180, 150, 20);
        t2.setBackground(Color.WHITE);
        add(t2);

        t3=new JRadioButton("Current Account");
        t3.setBounds(100, 210, 150, 20);
        t3.setBackground(Color.WHITE);
        add(t3);

        t4=new JRadioButton("Recurring  Account");
        t4.setBounds(350, 210, 150, 20);
        t4.setBackground(Color.WHITE);
        add(t4);
        
        ButtonGroup b=new ButtonGroup();
        b.add(t1);
        b.add(t2);
        b.add(t3);
        b.add(t4);
     
        accno=new JLabel("Account Number");
        accno.setBounds(100,240,250,30);
        accno.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(accno);

         a=new JLabel("your 16 digit number");
        a.setBounds(100, 260, 250, 30);
        a.setFont(new Font("Raleway", Font.BOLD, 10));
        add(a);

         acctext=new JLabel("160 210 1305 XXXXXX");
        acctext.setBounds(350, 240, 500, 30);
        add(acctext);


        pin=new JLabel("Pin Number");
        pin.setBounds(100,300,250,30);
        pin.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(pin);

         p=new JLabel("your 4 digit Pin");
        p.setBounds(100, 320, 250, 30);
        p.setFont(new Font("Raleway", Font.BOLD, 10));
        add(p);

         pintext=new JLabel("XXXX");
         pintext.setBounds(350, 300, 500, 30);
        add(pintext);

        service =new JLabel("Services Required");
        service.setBounds(100, 360, 300, 30);
        service.setFont(new Font("Raleway", Font.BOLD, 20));
        add(service);
        
        s1=new JCheckBox("ATM card");
        s1.setBounds(100, 400, 150, 30);
        s1.setFont(new Font("Raleway", Font.BOLD, 10));
          s1.setBackground(Color.WHITE);
        add(s1);
         
        s2=new JCheckBox("Mobile Banking");
        s2.setBounds(350, 400, 150, 30);
        s2.setFont(new Font("Raleway", Font.BOLD, 10));
          s2.setBackground(Color.WHITE);
        add(s2);
         
        s3=new JCheckBox("Check Book");
        s3.setBounds(100, 450, 150, 30);
        s3.setFont(new Font("Raleway", Font.BOLD, 10));
          s3.setBackground(Color.WHITE);
        add(s3);
         
        s4=new JCheckBox("Credit card");
        s4.setBounds(350, 450, 150, 30);
          s4.setBackground(Color.WHITE);
        s4.setFont(new Font("Raleway", Font.BOLD, 10));
        add(s4);

        
        d=new JCheckBox("I here declared that the above entered details are correct to the bestof my knowledge");
        d.setBounds(100, 500, 550, 30);
        d.setFont(new Font("Raleway", Font.BOLD, 10));
        d.setBackground(Color.WHITE);
        add(d);

        submit=new JButton("Submit");
         submit.setBounds(200, 550, 100, 30);
         submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.addActionListener(this);
         add(submit);
         
          clear=new JButton("clear");
         clear.setBounds(350, 550, 100, 30);
         clear.setFont(new Font("Raleway", Font.BOLD, 20));
         clear.addActionListener(this);
         add(clear);


       setSize(850, 820);
       setLocation(50, 50);
       setVisible(true);

        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()== submit)
        {
            String acctype=null;
            if(t1.isSelected())
            {
                acctype="fixed Account";
            }
            else if(t2.isSelected())
            {
                acctype="Savings Account";
            }
            else if(t3.isSelected())
            {
                acctype="Current Account";
            }
            else if(t4.isSelected())
            {
                acctype="Recurring  Account";
            }

            Random r=new Random();
            String accno=""+Math.abs((r.nextLong() % 900000000L)+ 16021013000000L);
            String Pincode=""+Math.abs((r.nextLong() % 9000L)+1000L);
            String facility="";
            if(s1.isSelected())
            {
                facility=facility+" ATM card";
            }
            else if(s2.isSelected())
            {
                facility=facility+" mobile Banking";
            }
            else if(s3.isSelected())
            {
                facility=facility+" Cheque Book";
            }
            else if(s4.isSelected())
            {
                facility=facility+" Cardit card";
            }
            try{
                if(acctype.equals(" "))
                {
                 JOptionPane.showMessageDialog(null,"Account Type is required");   
                }
                else{
                    conn c=new conn();
                    String query="insert into signup2 values('"+formno+"','"+acctype+"','"+accno+"','"+Pincode+"','"+facility+"')";
                    String query1="insert into login values('"+formno+"','"+accno+"','"+Pincode+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Accno"+accno+"\n Pincode:"+Pincode);
                }
                JOptionPane.showMessageDialog(null, "successfully Registered");
                setVisible(false);
                new Login().setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()== clear)
        {
            setVisible(false);   
        }
    }
    public static void main(String[] args) {
        new Signup2(" ");
    }
}
