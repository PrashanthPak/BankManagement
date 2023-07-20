import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class fastcash extends JFrame implements ActionListener{
    JButton Dp,wd,ms,pn,cb,fc,et;
    String pinno;
    fastcash(String pinno)
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

       JLabel text=new JLabel("Select the Withdraw amount");
       text.setBounds(220, 270, 500, 30); 
       img.add(text);
       text.setForeground(Color.WHITE);

       Dp =new JButton("RS 100");
       Dp.setBounds(150, 370, 120, 25); 
       img.add(Dp);
       Dp.setBackground(Color.BLACK);
       Dp.setForeground(Color.WHITE);
       Dp.addActionListener(this);

       wd =new JButton("RS 500");
       wd.setBounds(150, 400, 120, 25); 
       img.add(wd);
       wd.addActionListener(this);
       wd.setBackground(Color.BLACK);
       wd.setForeground(Color.WHITE);

       ms =new JButton("RS 1000");
       ms.setBounds(350, 370, 100, 25); 
       img.add(ms);
       ms.setBackground(Color.BLACK);
       ms.addActionListener(this);
       ms.setForeground(Color.WHITE);

       
       pn =new JButton("RS 5000");
       pn.setBounds(350, 400, 100, 25); 
       img.add(pn);
       pn.addActionListener(this);
       pn.setBackground(Color.BLACK);
       pn.setForeground(Color.WHITE);


       cb =new JButton("RS 10000");
       cb.setBounds(150, 430, 120, 25); 
       img.add(cb);
       cb.setBackground(Color.BLACK);
       cb.addActionListener(this);
       cb.setForeground(Color.WHITE);

       fc =new JButton("RS 15000");
       fc.setBounds(350, 430, 100, 25); 
       img.add(fc);
       fc.setBackground(Color.BLACK);
       fc.addActionListener(this);
       fc.setForeground(Color.WHITE);
     
       et =new JButton(" Back ");
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
       if(ae.getSource()== et)
       {
        setVisible(false);
        new transcation(pinno).setVisible(true);
       }
       else{
        String amount=((JButton)ae.getSource()).getText().substring(3);
        conn c=new conn();
        try{
            ResultSet r=c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            int balance=0;
            while(r.next())
            {
                if(r.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(r.getString("amount"));
                }
               else {
                    balance-=Integer.parseInt(r.getString("amount"));
               }
            }
            if(ae.getSource()!=et && balance < Integer.parseInt(amount))
            {
                    JOptionPane.showMessageDialog(null," Insufficient Balance" );
                    return;
            }

            Date date=new Date();
            String query="insert into bank values('"+pinno+"','"+date+"','withdraw','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs '"+amount+"' is withdrawn");
            setVisible(false);
            new transcation(pinno).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       }
    }
    public static void main(String[] args) {
        new fastcash(" ");
    }
}
