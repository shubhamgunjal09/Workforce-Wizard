package employee.management;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    Random ran= new Random();
    int number =ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary, tfaddress, tfpno,tfemail,tfdesignation,tfadhar;
    JButton add, back;
    JDateChooser dcdob;
     JLabel lblempId;
     JComboBox cbeducation;
    
    AddEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san_serif", Font.BOLD, 25));
        add(heading);
        
        
        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        add(labelname);
        
         tfname= new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        
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
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
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
        
        String courses[]= {"BE","BTech","BBA","BCA","MCA","BCOM","MTech"};
         cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);
        
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
        
         tfadhar= new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add(tfadhar);
        
        
          JLabel labelempId= new JLabel("Employee Id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
           lblempId= new JLabel(""+number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.BOLD,20));
        add(lblempId);
        
           add= new JButton("Add Details");
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
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,650);
        add(image);
       
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    public  void actionPerformed(ActionEvent ae){
    
    if(ae.getSource()==add){
        String name= tfname.getText();
        String fname= tffname.getText();
        String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String salary= tfsalary.getText();
        String address= tfaddress.getText();
        String pno= tfpno.getText();
       String email= tfemail.getText();
String education= (String)cbeducation.getSelectedItem();
 String designation= tfdesignation.getText();
  String adhar= tfadhar.getText();
   String empId= lblempId.getText();

try{
      String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+pno+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+empId+"')";
      
 Conn conn = new Conn();

conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Details added Succesfully");
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
        
        new AddEmployee();
    }
}
