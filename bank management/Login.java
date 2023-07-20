import javax.swing.ImageIcon;
import javax.swing.plaf.synth.SynthStyleFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, SignUp;
    JTextField  accnotext;
    JPasswordField Pintext;
    Login(){
        setLayout(null);// making Custom layout Null
        setTitle("My ATM");// Giving title of Frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpeg")); // adding image Url
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // customizing size of image
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        add(label);// adding image to frame
        label.setBounds(70, 20, 100, 100); // for custom layout
        getContentPane().setBackground(Color.lightGray);


        JLabel text=new JLabel("WelCome to the ATM"); // adding Text
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

         JLabel AccNo=new JLabel("Enter the Account Number"); // adding Text
        AccNo.setBounds(120, 150, 400, 30);
        AccNo.setFont(new Font("Osward", Font.BOLD, 18));
        add(AccNo);

        accnotext= new JTextField();
        accnotext.setBounds(400, 150, 250, 30);
        add(accnotext);

         JLabel Pin=new JLabel("Enter the Pin"); // adding Text
        Pin.setBounds(120, 220, 400, 40);
        Pin.setFont(new Font("Osward", Font.BOLD, 18));
        add(Pin);

          Pintext= new  JPasswordField();
        Pintext.setBounds(400, 220, 250, 30);
        add(Pintext);
        
         login=new JButton("Login");
        login.setBounds(250, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
                add(login);


         clear =new JButton("Clear");
        clear.setBounds(390, 300, 100, 30);
         clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
                     add(clear);

                     
         SignUp=new JButton("Sign Up");
        SignUp.setBounds(250, 350, 230, 30);
         SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);
                     add(SignUp);

        setSize(800, 480);// frame size customizing
        setLocation(350, 200);// frame location from origin
        setVisible(true);
       
    }
    
      public void actionPerformed(ActionEvent ac)
       {
         if(ac.getSource() == clear){
              accnotext.setText(" ");
              Pintext.setText("");
         }else if(ac.getSource() == login){
          conn c=new conn();
          String cardno=accnotext.getText();
          String Pinnumber=Pintext.getText();
          String query= "select * from login where accno ='"+cardno+"' and pin = '"+Pinnumber+"'";
    
          try{
            ResultSet r=c.s.executeQuery(query);
            if(r.next())
            {
              setVisible(false);
              new transcation(Pinnumber).setVisible(true);
            }
            else{
              JOptionPane.showMessageDialog(null,"Incorrect Pin and cardNumber");
            }
          }
          catch(Exception e)
          {
            System.out.println(e);
          }

         }else if(ac.getSource() == SignUp){
           setVisible(false);
           new Signup().setVisible(true);
         }
       }
    public static void main(String[] args) {
        new Login();
    }
}