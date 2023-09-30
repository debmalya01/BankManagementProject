
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton b1,b2,b3,b4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancel, submit;
    String formno;
    
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(270, 20, 400,30);
        add(l1);
        
        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 100, 200,30);
        add(accountType);
        
        b1= new JRadioButton("Savings Account");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBounds(100, 140, 200,20);
        b1.setBackground(Color.white);
        add(b1);
        b2= new JRadioButton("Fixed Deposit Account");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBounds(350, 140, 200,20);
        b2.setBackground(Color.white);
        add(b2);
        b3= new JRadioButton("Current Account");
        b3.setFont(new Font("Raleway", Font.BOLD, 14));
        b3.setBounds(100, 170, 200,20);
        b3.setBackground(Color.white);
        add(b3);
        b4= new JRadioButton("Recurring Deposit Account");
        b4.setFont(new Font("Raleway", Font.BOLD, 14));
        b4.setBounds(350, 170, 250,20);
        b4.setBackground(Color.white);
        add(b4);
        
        ButtonGroup gb= new ButtonGroup();
        gb.add(b1);
        gb.add(b2);
        gb.add(b3);
        gb.add(b4);
        
        JLabel cardNumber= new JLabel("Card Number");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumber.setBounds(100, 230, 200, 30);
        add(cardNumber);
        JLabel cardDetail= new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 270, 200, 10);
        add(cardDetail);
        
        JLabel cardNo= new JLabel("XXXX-XXXX-XXXX-4184");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNo.setBounds(350, 230, 300, 30);
        add(cardNo);
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 310, 200, 30);
        add(pin);
        JLabel pinDetail= new JLabel("Your 4 Digit Pin");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 350, 200, 10);
        add(pinDetail);
        
        JLabel pinNo= new JLabel("XXXX");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNo.setBounds(350, 310, 300, 30);
        add(pinNo);

        JLabel servicesRequired= new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        servicesRequired.setBounds(100, 400, 200, 30);
        add(servicesRequired);
        
        c1= new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100, 450, 200, 20);
        add(c1);
        c2= new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350, 450, 200, 20);
        add(c2);
        c3= new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100, 480, 200, 20);
        add(c3);
        c4 = new JCheckBox("E-mail 7 SMS Allerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350, 480, 200, 20);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100, 510, 200, 20);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350, 510, 200, 20);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 600, 600, 20);
        add(c7);
        
        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(250, 630, 100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit= new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(370, 630, 100,30);
        submit.addActionListener(this);
        add(submit);
        
        setTitle("Account Details");
        setSize(850, 800);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==cancel){
          setVisible(false);
          new Login().setVisible(true);
      }else if(ae.getSource()==submit){
          String formNumber=formno;
          String accountType=null;
          if(b1.isSelected()){
              accountType="Savings Account";
          }else if(b2.isSelected() ){
              accountType="Fixed Deposit Account";
          }else if(b3.isSelected()){
              accountType="Current Account";
          }else if(b4.isSelected()){
              accountType="Recurring Deposit Account";
          }
          
          Random random= new Random();
          String cardNumber= "" + Math.abs((random.nextLong()%90000000L)+ 5040936000000000L);  
          String pinNumber= "" + Math.abs((random.nextLong()%9000L) + 1000L);
          
          String facility= "";
          if(c1.isSelected()){
              facility=facility+ " ATM Card"; 
          }else if(c2.isSelected()){
              facility=facility+ " Internet Banking";
          }else if(c3.isSelected()){
              facility=facility+ " Mobile Banking";
          }else if(c4.isSelected()){
              facility=facility+ " E-mail & SMS allerts";
          }else if(c5.isSelected()){
              facility=facility+ " Cheque Book";
          }else if(c6.isSelected()){
              facility=facility+ " E-Statement";
          }
        try{
            Conn c= new Conn();
            String query1= "insert into signupthree values ('" +formNumber+ "', '" +accountType+ "', '" +cardNumber+ "', '" +pinNumber+ "', '" +facility+ "')";
            String query2= "insert into login values ('" +formNumber+ "', '" +cardNumber+ "', '" +pinNumber+"')";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, " Card Number: " + cardNumber + "\n Pin: " + pinNumber );
            
            setVisible(false);
            new deposit(pinNumber).setVisible(true);
            
        }catch( Exception e){
            System.out.println(e);
        }    
      }
    }
    public static void main(String args[]) {
        new SignupThree("");
    }
}
