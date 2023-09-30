package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
   String pinNumber; 
   JButton cash100, cash500, cash1000, cash2000, cash5000, cash10000, back; 
   FastCash(String pinNumber){
       this.pinNumber=pinNumber;
       setLayout(null);
       setTitle("ATM");
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("Select Withdrawal Ammount");
       text.setBounds(235,300,700,35);
       text.setFont(new Font("System", Font.BOLD, 16));
       text.setForeground(Color.white);
       image.add(text);
       
       cash100= new JButton("Rs 100");
       cash100.setBounds(170, 415, 150, 30);
       cash100.setBackground(Color.white);
       cash100.addActionListener(this);
       image.add(cash100);
       
       cash500= new JButton("Rs 500");
       cash500.setBounds(355, 415, 150, 30);
       cash500.setBackground(Color.white);
       cash500.addActionListener(this);
       image.add(cash500);
       
       cash1000= new JButton("Rs 1000");
       cash1000.setBounds(170, 450, 150, 30);
       cash1000.setBackground(Color.white);
       cash1000.addActionListener(this);
       image.add(cash1000);
       
       cash2000= new JButton("Rs 2000");
       cash2000.setBounds(355, 450, 150, 30);
       cash2000.setBackground(Color.white);
       cash2000.addActionListener(this);
       image.add(cash2000);
       
       cash5000= new JButton("Rs 5000");
       cash5000.setBounds(170, 485, 150, 30);
       cash5000.setBackground(Color.white);
       cash5000.addActionListener(this);
       image.add(cash5000);
       
       cash10000= new JButton("Rs 10000");
       cash10000.setBounds(355, 485, 150, 30);
       cash10000.setBackground(Color.white);
       cash10000.addActionListener(this);
       image.add(cash10000);
       
       back= new JButton("Back");
       back.setBounds(355, 520, 150, 30);
       back.setBackground(Color.white);
       back.addActionListener(this);
       image.add(back);
       
       setSize(900,900);
       setLocation(300,0);
       getContentPane().setBackground(Color.white);
       setUndecorated(true);
       setVisible(true);
       
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==back){
           setVisible(false);
           new Transaction(pinNumber).setVisible(true);
       } else {
           String amount= ((JButton)ae.getSource()).getText().substring(3);
           Conn c=new Conn();
           try{
               ResultSet rs=c.s.executeQuery("select* from bank where pin='"+pinNumber+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+= Integer.parseInt(rs.getString("ammount"));
                   }else{
                       balance -=Integer.parseInt(rs.getString("ammount"));
                   }
               }
               if(ae.getSource()!= back && balance< Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               Date date=new Date();
               String query="insert into bank values ('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"' )";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
               
               setVisible(false);
               new Transaction(pinNumber).setVisible(true);
                   
           }catch(Exception e){
               System.out.println(e);
           }
           
       }
       
   }
    public static void main(String args[]) {
        new FastCash("");
    }
}