import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;
public class ministatement extends JFrame {
    JLabel card,text,text1;
    String pinno;
     int balance=0;
    ministatement(String pinno){
        this.pinno=pinno;
       setLayout(null);
          JPanel color=new JPanel();
          color.setBounds(0, 0, 250, 30);
          color.setBackground(new Color(130, 100, 200));
          add(color);


           text=new JLabel("MINISTATEMENT");
          text.setBounds(17, 10, 100, 30);
          text.setFont(new Font("Raleway", Font.BOLD, 15));
          color.add(text);


           text1=new JLabel("PAKA'S BANK");
          text1.setBounds(90, 55, 160, 30);
          text1.setFont(new Font("Raleway", Font.BOLD, 10));
          add(text1);

          
          card=new JLabel("Card ");
          card.setBounds(10, 70, 300, 30);
          add(card);
          
          JLabel mini=new JLabel();
          mini.setBounds(10, 90, 200, 300);
          add(mini);


           JLabel bal=new JLabel("Your current Account balance is RS "+balance);
           bal.setBounds(10, 500, 250, 20);
           add(bal);

           try{
                conn c=new conn();
                
                ResultSet r=c.s.executeQuery("select * from login where pin ='1305'");
                while(r.next())
                {
                    card.setText("Card Number:"+r.getString("accno").substring(0, 4)+"XXXXXXXX"+r.getString("accno").substring(12));
                }
           }
           catch(Exception e)
           {
            System.out.println(e);
           }

           try {
               conn c=new conn();
              
               ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinno+"'");
               while(rs.next())
               {
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
               else {
                    balance-=Integer.parseInt(rs.getString("amount"));
            }
           }
           
        } 
           catch (Exception e) {
            System.out.println(e);
           }
          

          
                setUndecorated(true);
                setSize(250,600);
                setLocation(70, 100);
                setVisible(true);

            }
            
    public static void main(String[] args) {
        new ministatement("");
    }
}
