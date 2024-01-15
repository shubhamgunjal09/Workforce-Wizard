package employee.management;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class updateemployee extends JFrame implements ActionListener {
    
  
    
    JTextField tfeducation,tffname,tfsalary, tfaddress, tfpno,tfemail,tfdesignation,tfadhar;
    JButton add, back;
    
     JLabel lblempId;
  String empId;
    
    updateemployee( String empId){
        
        this.empId=empId;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san_serif", Font.BOLD, 25));
        add(heading);
        
        
        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        add(labelname);
        
        JLabel lblname= new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        
        JLabel labelfname= new JLabel("Fathers Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.BOLD,20));
        add(labelfname);
        
         tffname= new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
         JLabel labeldob= new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.BOLD,20));
        add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel labelsalary= new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.BOLD,20));
        add(labelsalary);
        
         tfsalary= new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress= new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.BOLD,20));
        add(labeladdress);
        
       tfaddress= new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
         JLabel labelpno= new JLabel("Phone Number");
        labelpno.setBounds(400,250,150,30);
        labelpno.setFont(new Font("serif",Font.BOLD,20));
        add(labelpno);
        
         tfpno= new JTextField();
        tfpno.setBounds(600,250,150,30);
        add(tfpno);
        
        JLabel labelemail= new JLabel("Email-Id");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.BOLD,20));
        add(labelemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        
         JLabel labeleducation= new JLabel("Hiest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.BOLD,20));
        add(labeleducation);
        
       
         tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
         JLabel labeldesignation= new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.BOLD,20));
        add(labeldesignation);
        
         tfdesignation= new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        
        JLabel labeladhar= new JLabel("Adhar Card");
        labeladhar.setBounds(400,350,150,30);
        labeladhar.setFont(new Font("serif",Font.BOLD,20));
        add(labeladhar);
        
        JLabel lbladhar= new JLabel();
        lbladhar.setBounds(600,350,150,30);
        add(lbladhar);
        
        
          JLabel labelempId= new JLabel();
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
        
           lblempId= new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.BOLD,20));
        add(lblempId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId= '"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                 tffname.setText(rs.getString("fname"));
                  lbldob.setText(rs.getString("dob"));
                   tfaddress.setText(rs.getString("address"));

               tfsalary.setText(rs.getString("salary"));
              tfpno.setText(rs.getString("pno"));
                   tfemail.setText(rs.getString("email"));
                   tfeducation.setText(rs.getString("education"));
                   lbladhar.setText(rs.getString("adhar"));
                   lblempId.setText(rs.getString("empId"));
                   tfdesignation.setText(rs.getString("designation"));


                
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
           add= new JButton("update Details");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
           back= new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
       
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    public  void actionPerformed(ActionEvent ae){
    
    if(ae.getSource()==add){
        
        String fname= tffname.getText();
        
        String salary= tfsalary.getText();
        String address= tfaddress.getText();
        String pno= tfpno.getText();
       String email= tfeducation.getText();
       String education= tfemail.getText();

 String designation= tfdesignation.getText();

   String empId= lblempId.getText();

try{
      String query = "update  employee set fname = '"+fname+"',salary = '"+salary+"', address = '"+address+"',pno = '"+pno+"', email = '"+email+"', designation = '"+designation+"' where empId = '"+empId+"'";
      
 Conn conn = new Conn();

conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Details updated Succesfully");
setVisible(false);
new Home();
}catch(Exception e){
    e.printStackTrace();
}


    }else{
        setVisible(false);
        new Home();
    }
    }
    
    public static void main(String args[]){
        
        new updateemployee("");
    }
}

