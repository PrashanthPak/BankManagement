import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class balance extends JFrame implements ActionListener{
    JButton back;
    String pinno;
    balance(String pinno)
    {
        this.pinno=pinno;
        setTitle("BalanceEnquiry");
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        add(img);
      
        back =new JButton("Back");
        back.setBounds(360, 460, 100, 27);
        back.addActionListener(this);
        img.add(back);
      conn c=new conn();
      int balance=0;
        try{
            ResultSet r=c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        JLabel bal=new JLabel("Your Current account Balance '"+balance+"'");
        bal.setBounds(150, 250, 300, 30);
        bal.setFont(new Font("Raleway", Font.BOLD, 15));
        bal.setForeground(Color.WHITE);
        img.add(bal);
        setSize(800, 800);
        setLocation(50, 50);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new transcation(pinno).setVisible(true);
        }
    } 
    public static void main(String[] args) {
        new balance("").setVisible(true);
    }
}
