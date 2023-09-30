package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pinNumber;
    
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
      
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("Select * from login where pin = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+ "XXXXXXXX"+ rs.getString("cardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn c= new Conn();
            int bal=0;
            ResultSet rs= c.s.executeQuery("Select * from bank where pin= '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("ammount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                   bal+= Integer.parseInt(rs.getString("ammount"));
                }else{
                   bal -=Integer.parseInt(rs.getString("ammount"));
                }
            }
            balance.setText("Your Current Accoun Balance is Rs "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String args[]) {
       new MiniStatement("");
    }
}
