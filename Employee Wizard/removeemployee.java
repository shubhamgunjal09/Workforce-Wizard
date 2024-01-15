
package employee.management;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class removeemployee extends JFrame implements ActionListener{
    
    Choice cempId;
    JButton delete,back;
    
    removeemployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lblempId =  new JLabel("EMPLOYEE ID");
        lblempId.setBounds(50,50,100,30);
        add(lblempId);
        
        cempId = new Choice();
        cempId.setBounds(200,50,150,30);
        add(cempId);
        
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempId.add(rs.getString("empId"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
         JLabel labelname =  new JLabel("NAME");
        labelname.setBounds(50,100,100,30);
        add(labelname);
         JLabel lblname =  new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
          JLabel labelpno =  new JLabel("PHONE");
        labelpno.setBounds(50,150,100,30);
        add(labelpno);
         JLabel lblpno =  new JLabel();
        lblpno.setBounds(200,150,100,30);
        add(lblpno);
        
          JLabel labelemail =  new JLabel("EMAIL");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
         JLabel lblemail =  new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        
         try{
            Conn c = new Conn();
            String query = "select * from employee where empId= '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
               lblname.setText(rs.getString("name"));

               lblpno.setText(rs.getString("pno"));
               lblemail.setText(rs.getString("email"));


            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
         cempId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            
             try{
            Conn c = new Conn();
            String query = "select * from employee where empId= '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
               lblname.setText(rs.getString("name"));

               lblpno.setText(rs.getString("pno"));
               lblemail.setText(rs.getString("email"));


            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
            
        }
    });
         
         delete = new JButton("Delete");
         delete.setBounds(80,300,100,30);
         delete.setBackground(Color.BLACK);
         delete.setForeground(Color.WHITE);
         delete.addActionListener(this);
         add(delete);
         back = new JButton("Back");
         back.setBounds(220,300,100,30);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.addActionListener(this);
         add(back);
        
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0,600,400);
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c = new Conn();
                String query = " delete from employee where empId = '"+cempId.getSelectedItem()+"' ";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Employee Information Deleted");
            setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }else{
            setVisible(false);
            new Home();
            
            
        }
    }
    
    public static void main (String args[]){
        new removeemployee();
        
    }
}
