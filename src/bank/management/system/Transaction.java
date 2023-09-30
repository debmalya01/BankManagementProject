
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
   String pinNumber; 
   JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit; 
   Transaction(String pinNumber){
       this.pinNumber=pinNumber;
       setLayout(null);
       setTitle("ATM");
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("Select your Transaction");
       text.setBounds(235,300,700,35);
       text.setFont(new Font("System", Font.BOLD, 16));
       text.setForeground(Color.white);
       image.add(text);
       
       deposit= new JButton("Deposit");
       deposit.setBounds(170, 415, 150, 30);
       deposit.setBackground(Color.white);
       deposit.addActionListener(this);
       image.add(deposit);
       
       withdrawal= new JButton("Cash Withdrawal");
       withdrawal.setBounds(355, 415, 150, 30);
       withdrawal.setBackground(Color.white);
       withdrawal.addActionListener(this);
       image.add(withdrawal);
       
       fastCash= new JButton("Fast Cash");
       fastCash.setBounds(170, 450, 150, 30);
       fastCash.setBackground(Color.white);
       fastCash.addActionListener(this);
       image.add(fastCash);
       
       miniStatement= new JButton("Mini Statement");
       miniStatement.setBounds(355, 450, 150, 30);
       miniStatement.setBackground(Color.white);
       miniStatement.addActionListener(this);
       image.add(miniStatement);
       
       pinChange= new JButton("Pin Change");
       pinChange.setBounds(170, 485, 150, 30);
       pinChange.setBackground(Color.white);
       pinChange.addActionListener(this);
       image.add(pinChange);
       
       balanceEnquiry= new JButton("Balance Enquiry");
       balanceEnquiry.setBounds(355, 485, 150, 30);
       balanceEnquiry.setBackground(Color.white);
       balanceEnquiry.addActionListener(this);
       image.add(balanceEnquiry);
       
       exit= new JButton("Exit");
       exit.setBounds(355, 520, 150, 30);
       exit.setBackground(Color.white);
       exit.addActionListener(this);
       image.add(exit);
       
       setSize(900,900);
       setLocation(300,0);
       getContentPane().setBackground(Color.white);
       setUndecorated(true);
       setVisible(true);
       
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==exit){
           System.exit(0);
       } else if(ae.getSource()==deposit){
           setVisible(false);
           new deposit(pinNumber).setVisible(true);
       } else if(ae.getSource()==withdrawal){
           setVisible(false);
           new Withdrawal(pinNumber).setVisible(true);
       } else if(ae.getSource()==fastCash ){
           setVisible(false);
           new FastCash(pinNumber).setVisible(true);
       } else if(ae.getSource()==miniStatement){
           new MiniStatement(pinNumber).setVisible(true);
       } else if(ae.getSource()==pinChange){    
           setVisible(false);
           new PinChange(pinNumber).setVisible(true);
       } else if(ae.getSource()==balanceEnquiry){
           setVisible(false);
           new BalanceEnquiry(pinNumber).setVisible(true);
       }
       
   }
    public static void main(String args[]) {
        new Transaction("");
    }
}
