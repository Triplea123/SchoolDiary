/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schooldiary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyConnection {
    
    public static Connection getMyConnection(){
    
    Connection con = null ;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldiary","root","root");
            //JOptionPane.showMessageDialog(null, "Connection in database:... is succesful..");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error:  "+ex.getMessage());
        }    

    return con;
    }
    
    
    public static Connection getMyConnection(String db){
    
    Connection con = null ;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","root");
            JOptionPane.showMessageDialog(null, "Connection in database: "+db.toUpperCase()+" is succesful..");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error:  "+ex.getMessage());
        }
    
    return con;
    }
    
    
}
