
package employee.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Loginpage extends JFrame implements ActionListener{
   
    JTextField  tfname,tfusername, tfPassword;

    
    Loginpage(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
         JLabel lblname = new JLabel("  NAME  :");
        lblname.setBounds(40,20, 100, 30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(150,20, 100, 30);
        add(tfname);
        
        
    
        JLabel lblusername = new JLabel("USERNAME  :");
        lblusername.setBounds(40,70, 100, 30);
        add(lblusername);
        
       tfusername = new JTextField();
        tfusername.setBounds(150,70, 100, 30);
        add(tfusername);
        
        
        
         JLabel lblPassword = new JLabel("PASSWORD  :");
        lblPassword.setBounds(40,120, 100, 30);
        add(lblPassword);
        
        tfPassword = new JTextField();
        tfPassword.setBounds(150,120, 100, 30);
        add(tfPassword);
        
         JButton click= new JButton("LOGIN");
        click.setBounds(150,190, 100, 30);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        add(click);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
        
        
         
}
   
      public void actionPerformed(ActionEvent ae) {
       
      //String query = "SELECT * FROM Loginpage WHERE name = ? AND username = ? AND password = ?;";         
            try{ 
         
          String name = tfname.getText();
           String username = tfusername.getText();
            String password = tfPassword.getText();
            
                  String query = "SELECT * FROM Loginpage WHERE name = '"+name+"' AND username = '"+username+"' AND password = '"+password+"'";         
 Conn c = new Conn();
            ResultSet rs= c.s.executeQuery(query);
           
            
            
            
            
          
          
          if(rs.next()){
              setVisible(false);
              new Home();
          }else{
              JOptionPane.showMessageDialog(null, "Invalid usernameOr password");
              setVisible(false);
          }
          
      }catch(Exception e){
          e.printStackTrace();
      }
    
}
    
    public static void main(String args[]){
        
        new Loginpage();
        
        
    }

   

   
   
}
