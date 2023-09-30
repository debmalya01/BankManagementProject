package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton clear, signin,signup; 
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    Login(){
        setSize(800,450);
        setLocation(300, 180);
        setLayout(null);
        
        setTitle("Automated Teller Machine");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmbank.png"));
        Image i2= i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150, 20, 100, 100);
        add(label);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30 ));
        text.setBounds(270, 60, 400,40);
        add(text);
        
        JLabel cardno= new JLabel("CARD N0.: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20 ));
        cardno.setBounds(180, 150, 150,30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(360, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20 ));
        pin.setBounds(180, 200, 150,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(360, 200, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(250, 260, 100, 30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(380, 260, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(315, 300, 100, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
        setVisible(true);    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource()== signin){
            Conn c= new Conn();
            String cardNumber= cardTextField.getText();
            String pinNumber= pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
            try{
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        } 
    }
    
    public static void main(String[] args){ 
        new Login();
    }
}

