package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{
    String pinNumber;
    JTextField amount;
    JButton withdrawButton, backButton;
    Withdrawal(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the ammount you want to Withdraw: ");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount =new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(355, 485,150, 30);
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(355, 520,150, 30);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setSize(900,900);
        setLocation(300,0);
        setTitle("Withdraw Amount");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawButton){
            String amountNumber=amount.getText();
            Date date= new Date();
            if(amountNumber.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                try{
                    Conn c=new Conn();
                    int balance=0;
                    ResultSet rs=c.s.executeQuery("select* from bank where pin='"+pinNumber+"'");
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("ammount"));
                        }else{
                            balance -=Integer.parseInt(rs.getString("ammount"));
                        }
                    }
                    if(balance< Integer.parseInt(amountNumber)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query= "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amountNumber+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amountNumber+ " Withdrawn Successfully" );
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
