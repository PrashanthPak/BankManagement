import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class pinchange extends JFrame implements ActionListener{
    JButton c,c1;
    JPasswordField textfield1,textfield2;
    JLabel text,text1,text2;
    String pinno;
    pinchange(String pinno){
        this.pinno=pinno;
        setTitle("Pinchange");
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel i3=new JLabel(i2);
        add(i3);
         
        text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(190, 250, 300, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 17));
        i3.add(text);

        text1=new JLabel("New Pin");
        text1.setBounds(160, 300, 100, 30);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Raleway", Font.BOLD, 12));
        i3.add(text1);

        textfield1=new JPasswordField ();
        textfield1.setBounds(250, 305, 150, 20);
        textfield1.setForeground(Color.BLACK);
        textfield1.setFont(new Font("Raleway", Font.BOLD, 17));
        i3.add(textfield1);

         text2=new JLabel("Re-Enter Pin");
        text2.setBounds(160, 340, 100, 30);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Raleway", Font.BOLD, 12));
        i3.add(text2);

        textfield2=new JPasswordField ();
        textfield2.setBounds(250, 345, 150, 20);
        textfield2.setForeground(Color.BLACK);
        textfield2.setFont(new Font("Raleway", Font.BOLD, 17));
        i3.add(textfield2);

        c=new JButton("CHANGE");
        c.setBounds(353, 413, 100, 28);
        c.setFont(new Font("Raleway", Font.BOLD, 15));
        // c.setForeground(Color.WHITE)
        c.addActionListener(this);
        i3.add(c);

          c1=new JButton("Back");
        c1.setBounds(353, 446, 100, 25);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.addActionListener(this);
        i3.add(c1);

        setSize(800, 800);
        setLocation(30, 50);
        setUndecorated(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == c)
       {
         String newpin=textfield1.getText();
         String rpin=textfield2.getText();
         try{
                if(newpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"New pin must not Empty");
                }
                else if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"ReEnter Pin must not be Empty");
                }
                else if(!rpin.equals(newpin))
                {
                    JOptionPane.showMessageDialog(null,"Repin Must same as New Pin");
                }
                else{
                    conn c=new conn();
                    JOptionPane.showMessageDialog(null,"Pin Changed Successfully...!");
                    setVisible(false);
                    new transcation(rpin).setVisible(true);
                    String query1="update bank set pin='"+newpin+"' where pin='"+pinno+"'";
                    String query2="update login set pin='"+newpin+"' where pin='"+pinno+"'";
                    String query3="update signup2 set pin='"+newpin+"' where pin='"+pinno+"'";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                }
         }
         catch(Exception e)
         {
            System.out.println(e);
         }
       }
       else if(ae.getSource() == c1)
       {
        setVisible(false);
        new transcation(pinno).setVisible(true);
       }

    }
       public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
}
