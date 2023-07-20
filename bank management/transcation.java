import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class transcation extends JFrame implements ActionListener{
    JButton Dp,wd,ms,pn,cb,fc,et;
    String pinno;
    transcation(String pinno)
    {
        this.pinno=pinno;
        setLayout(null);
        setTitle("ATM Machine");
       ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
       Image i2=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel img=new JLabel(i3);
       img.setBounds(0, 0, 800,800);
       add(img);

       JLabel text=new JLabel("Please Select your Transcation");
       text.setBounds(220, 270, 500, 30); 
       img.add(text);
       text.setForeground(Color.WHITE);

       Dp =new JButton("Deposit");
       Dp.setBounds(150, 370, 120, 25); 
       img.add(Dp);
       Dp.setBackground(Color.BLACK);
       Dp.setForeground(Color.WHITE);
       Dp.addActionListener(this);

       wd =new JButton("Withdrawl");
       wd.setBounds(150, 400, 120, 25); 
       img.add(wd);
       wd.addActionListener(this);
       wd.setBackground(Color.BLACK);
       wd.setForeground(Color.WHITE);

       ms =new JButton("MiniStatement");
       ms.setBounds(350, 370, 100, 25); 
       img.add(ms);
       ms.setBackground(Color.BLACK);
       ms.addActionListener(this);
       ms.setForeground(Color.WHITE);

       
       pn =new JButton("Pin Change");
       pn.setBounds(350, 400, 100, 25); 
       img.add(pn);
       pn.addActionListener(this);
       pn.setBackground(Color.BLACK);
       pn.setForeground(Color.WHITE);


       cb =new JButton("Check balance");
       cb.setBounds(150, 430, 120, 25); 
       img.add(cb);
       cb.setBackground(Color.BLACK);
       cb.addActionListener(this);
       cb.setForeground(Color.WHITE);

       fc =new JButton("Fast cash ");
       fc.setBounds(350, 430, 100, 25); 
       img.add(fc);
       fc.setBackground(Color.BLACK);
       fc.addActionListener(this);
       fc.setForeground(Color.WHITE);
     
       et =new JButton("Exit ");
       et.setBounds(350, 460, 100, 25); 
       img.add(et);
       et.addActionListener(this);
       et.setBackground(Color.BLACK);
       et.setForeground(Color.WHITE);
       
        setSize(800, 800);
        setUndecorated(true);
        setVisible(true);
        setLocation(350, 0);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Dp)
        {

           setVisible(false);
           new Deposit(pinno).setVisible(true);
        }
        else if(ae.getSource()==et)
        {
            System.exit(0);
        }
        else if(ae.getSource()==wd)
        {
            setVisible(false);
            new withdraw(pinno).setVisible(true);
        }
        else if(ae.getSource()==fc)
        {
            setVisible(false);
            new fastcash(pinno).setVisible(true);
        }
        else if(ae.getSource()==pn)
        {
            setVisible(false);
            new pinchange(pinno).setVisible(true);
        }
        else if(ae.getSource()==cb)
        {
            setVisible(false);
            new balance(pinno).setVisible(true);
        }
        else if(ae.getSource()== ms)
        {
            
            new ministatement(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new transcation(" ");
    }
}
