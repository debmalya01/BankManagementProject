package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener{
    String pinNumber;
    JTextField amount;
    JButton depositButton, backButton;
    deposit(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the ammount you want to Deposit: ");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount =new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        depositButton = new JButton("Deposit");
        depositButton.setBounds(355, 485,150, 30);
        depositButton.addActionListener(this);
        image.add(depositButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(355, 520,150, 30);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setSize(900,900);
        setLocation(300,0);
        setTitle("Deposit Amount");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==depositButton){
            String amountNumber=amount.getText();
            Date date= new Date();
            if(amountNumber.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                try{
                    Conn c=new Conn();
                    String query= "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+amountNumber+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amountNumber+ " Deposited Successfully" );
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }else if(ae.getSource()==backButton){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new deposit("");
    }
}
