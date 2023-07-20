import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;

public class withdraw extends JFrame implements ActionListener{
    JLabel text;
    JTextField text1;
    JButton next,back;
     String Pinnumber;
    withdraw(String pinno)
    {
        this.Pinnumber=pinno;
        setTitle("Withdraw Window");
        setUndecorated(true);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
       Image i2=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel img=new JLabel(i3);
       img.setBounds(0, 0, 800,800);
       add(img);

        text =new JLabel("Enter the Amount");
       text.setBounds(170, 270, 300, 30);
       text.setFont(new Font("Raleway", Font.BOLD, 15));
       text.setForeground(Color.WHITE);
       img.add(text);

        text1=new JTextField();
       text1.setBounds(170, 300, 280, 30);
       text1.setFont(new Font("raleway", Font.BOLD, 19));
       img.add(text1);

       next=new JButton("Withdraw");
       next.setBounds(350, 430, 100, 25);
       next.addActionListener(this);
       img.add(next);

       back=new JButton("Back");
       back.setBounds(350, 460, 100, 25);
       back.addActionListener(this);
       img.add(back);


       setSize(800, 800);
       setLocation(100, 30);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == next)
        {
            String number=text1.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Plesae Enter the Valid amount");
            }
            else{
                conn c=new conn();
                String query="insert into bank values('"+Pinnumber+"','"+date+"','Withdraw','"+number+"')";
                try{
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs '"+number+"' Withdrawn Successfully");
                    setVisible(false);
                    new transcation(Pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new transcation(Pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new withdraw(" ");
    }
}
