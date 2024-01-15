package employee.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.lang.String;

import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Viewemployee extends JFrame implements ActionListener{
    JTable table;
    Choice cemployeeId;
    JButton search, print ,update,back;
    
    
    Viewemployee(){
        
       
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl= new JLabel("Search by Employee Id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        
        cemployeeId= new Choice();
        cemployeeId.setBounds(180,20,150,20);
        cemployeeId.setBackground(Color.WHITE);
        add(cemployeeId);
        
        table  = new JTable();
  
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
         setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
        
        search= new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
       print= new JButton("print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update= new JButton("update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back= new JButton("back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
       
      
        
   
         try{
            
            
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from employee");
                     
 
                while(rs.next()){
                    cemployeeId.add(rs.getString("empId"));
                }
                
 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from employee");
                table.setModel(DbUtils.resultSetToTableModel(rs));       
 
                
                
 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==search){
                String query= "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try{
                Conn c =new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
            }else if(ae.getSource()==print){
                 try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
                
            }
            }else if(ae.getSource()==update){
                setVisible(false);
                new updateemployee(cemployeeId.getSelectedItem());
                
            }else{
                setVisible(false);
                new Home();
            }
        }
        
        
    
    public static void main (String args[]){
        new Viewemployee();
    }

    
}


