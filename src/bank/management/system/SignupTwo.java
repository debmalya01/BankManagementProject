
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField, adharTextField;
    JRadioButton yes, no, yesButton, noButton;
    JButton next;
    JComboBox rel, cat, incom, education, occupationBox;
    String formno;
            
    SignupTwo(String formno){
        this.formno=formno; 
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel(" Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(270, 75, 400, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 135, 100, 30);
        add(religion);
        
        String[] valrel = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        rel= new JComboBox(valrel);
        rel.setBounds(300, 135, 400, 30);
        rel.setBackground(Color.white);
        add(rel);
        
        JLabel category = new JLabel("Categroy:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 185, 200, 30);
        add(category);
        
        String[] valcat = {"General", "SC", "ST", "OBC", "Other"};
        cat= new JComboBox(valcat);
        cat.setBounds(300, 185, 400, 30);
        cat.setBackground(Color.white);
        add(cat);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 235, 200, 30);
        add(income);
        
        String[] valincome = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        incom= new JComboBox(valincome);
        incom.setBounds(300, 235, 400, 30);
        incom.setBackground(Color.white);
        add(incom);
        
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 285, 200, 30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 310, 200, 30);
        add(qualification);
        
        String[] educationVal = {"Non-Graduate", "Under-Graduate", "Post-Graduate", "Doctrate", "Others"};
        education= new JComboBox(educationVal);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 385, 200, 30);
        add(occupation);
        
        String[] OccupationVal = {"Student", "Salaried", "Business", "Self-Employed", "Retired", "Unemployed"};
        occupationBox= new JComboBox(OccupationVal);
        occupationBox.setBounds(300, 385, 400, 30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);
        
        JLabel panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        panNo.setBounds(100, 435, 200, 30);
        add(panNo);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 435, 400, 30);
        add(panTextField);
        
        JLabel adharNo = new JLabel("Adhar Number:");
        adharNo.setFont(new Font("Raleway", Font.BOLD, 20));
        adharNo.setBounds(100, 485, 200, 30);
        add(adharNo);
        
        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        adharTextField.setBounds(300, 485, 400, 30);
        add(adharTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 535, 200, 30);
        add(seniorCitizen);
        
        yes= new JRadioButton("YES");
        yes.setFont(new Font("Raleway", Font.BOLD, 14));
        yes.setBounds(300, 535, 100, 30);
        yes.setBackground(Color.white);
        add(yes);
        
        no= new JRadioButton("NO");
        no.setFont(new Font("Raleway", Font.BOLD, 14));
        no.setBounds(500, 535, 100, 30);
        no.setBackground(Color.white);
        add(no);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);
        
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 585, 200, 30);
        add(existingAccount);
        
        yesButton = new JRadioButton("YES");
        yesButton.setFont(new Font("Raleway", Font.BOLD, 14));
        yesButton.setBounds(300, 585, 100, 30);
        yesButton.setBackground(Color.white);
        add(yesButton);
        
        noButton = new JRadioButton("NO");
        noButton.setFont(new Font("Raleway", Font.BOLD, 14));
        noButton.setBounds(500, 585, 100, 30);
        noButton.setBackground(Color.white);
        add(noButton);
        
        ButtonGroup rbg = new ButtonGroup();
        rbg.add(yesButton);
        rbg.add(noButton);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 640, 80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae){
        
        String formNumber = "" + formno;
        String strReligion= "" + rel.getSelectedItem();
        String strCategory= ""+ cat.getSelectedItem();
        String strIncome= ""+ incom.getSelectedItem();
        String strEducation= ""+ education.getSelectedItem();
        String strOccupation= ""+ occupationBox.getSelectedItem();
        
        String strSCitizen= null;
        if(yes.isSelected()){
            strSCitizen="YES";
        }else if(no.isSelected()){
            strSCitizen="NO";
        }
        
        String strEAccount= null;
        if(yesButton.isSelected()){
            strEAccount="YES";
        }else if(noButton.isSelected()){
            strEAccount="NO";
        }
        
        String panNo= panTextField.getText();
        String adharNo= adharTextField.getText();
      
        
        try{
            Conn c= new Conn();
            String query = "insert into signuptwo values('"+formNumber+"', '"+strReligion+"', '"+strCategory+"', '"+strIncome+"', '"+strEducation+"', '"+strOccupation+"', '"+strSCitizen+"', '"+strEAccount+"', '"+panNo+"', '"+adharNo+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formNumber).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]) {
        new SignupTwo("");
    }
}
