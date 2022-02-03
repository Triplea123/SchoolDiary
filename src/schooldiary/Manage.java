/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schooldiary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Manage {
    
        public void addStudent(String table,Integer nr,String emriMbiemri, String detyratEShtepise,String angazhimiIndividual, String prezentimet,
                                String seminar, String kriteri,String vp1,String detyratKontrolluese, String testPermbledhes,
                                String vp2,String notaPerfundimtare) {
        
        
          Connection con = MyConnection.getMyConnection();
          PreparedStatement ps ;
          
          try {
                
                ps = con.prepareStatement("INSERT INTO `"+table+"`(`Nr`, `EmriMbiemri`, `DetyratEShtepise`, `AngazhimiIndividual`, "
                                  + "`Prezantimet`, `Seminar`, `Kriteri`, `VP1`, `DetyratKontrolluese`, `TestPermbledhes`, "
                                  + "`VP2`, `NotaPerfundimtare`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, nr);
                ps.setString(2, emriMbiemri);
                ps.setString(3, detyratEShtepise);
                ps.setString(4, angazhimiIndividual);
                ps.setString(5, prezentimet);
                ps.setString(6, seminar);
                ps.setString(7, kriteri);
                ps.setString(8, vp1);
                ps.setString(9, detyratKontrolluese);
                ps.setString(10, testPermbledhes);
                ps.setString(11, vp2);
                ps.setString(12, notaPerfundimtare);
                
                
                if(ps.executeUpdate()>0){
                  //  JOptionPane.showMessageDialog(null, "New Student Added");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    
        public void addText(String sqlText,Integer id,String Date, String Text) {
        
        
          Connection con = MyConnection.getMyConnection();
          PreparedStatement ps ;
          
          try {
                
                ps = con.prepareStatement("INSERT INTO `"+sqlText+"`(`Date`, `Text`) VALUES (?,?)");
                ps.setString(1, Date);
                ps.setString(2, Text);  
               
                
                
                if(ps.executeUpdate()>0){
                  //  JOptionPane.showMessageDialog(null, "New Student Added");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        
        public void editStudent(String table,Integer nr,String emriMbiemri, String detyratEShtepise,String angazhimiIndividual, String prezentimet,
                                String seminar, String kriteri,String vp1,String detyratKontrolluese, String testPermbledhes,
                                String vp2,String notaPerfundimtare){
            
            Connection con = MyConnection.getMyConnection();
            PreparedStatement ps ;
            
            try {
                ps = con.prepareStatement("UPDATE `"+table+"` SET `EmriMbiemri`=?,`DetyratEShtepise`=?,`AngazhimiIndividual`=?,`Prezantimet`=?,`Seminar`=?,`Kriteri`=?,`VP1`=?,`DetyratKontrolluese`=?,`TestPermbledhes`=?,`VP2`=?,`NotaPerfundimtare`=? WHERE `Nr`=?");
                
                ps.setString(1, emriMbiemri);
                ps.setString(2, detyratEShtepise);
                ps.setString(3, angazhimiIndividual);
                ps.setString(4, prezentimet);
                ps.setString(5, seminar);
                ps.setString(6, kriteri);
                ps.setString(7, vp1);
                ps.setString(8, detyratKontrolluese);
                ps.setString(9, testPermbledhes);
                ps.setString(10, vp2);
                ps.setString(11, notaPerfundimtare);
                ps.setInt(12, nr);
                
                if(ps.executeUpdate()>0){
                  //  JOptionPane.showMessageDialog(null, "Student Data Updated");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }
        
           public void editText(String text,Integer id,String date, String msgText){
            
            Connection con = MyConnection.getMyConnection();
            PreparedStatement ps ;
            
            try {
                ps = con.prepareStatement("UPDATE `"+text+"` SET `Date`=?,`Text`=?  WHERE `Id`=?");
                
                ps.setString(1, date);
                ps.setString(2, msgText);                
                ps.setInt(3, id);
                
                if(ps.executeUpdate()>0){
                  //  JOptionPane.showMessageDialog(null, "Student Data Updated");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }
        
        public void deleteStudent(String table,Integer nr) {
            
            Connection con = MyConnection.getMyConnection();
            PreparedStatement ps ;
        
         int YesOrNo = JOptionPane.showConfirmDialog(null, "A jeni e sigurte? ","Nxenesi do te fshihet pergjithmone",JOptionPane.OK_CANCEL_OPTION);
            
            if (YesOrNo == JOptionPane.OK_OPTION) {
            
                try {
                ps = con.prepareStatement("DELETE FROM `"+table+"` WHERE `Nr`=?");
                ps.setInt(1, nr);
                
                if(ps.executeUpdate()>0){
                   // JOptionPane.showMessageDialog(null, "Student Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }   
        
        }
        
         public void deleteText(String text,Integer id) {
            
            Connection con = MyConnection.getMyConnection();
            PreparedStatement ps ;
        
         int YesOrNo = JOptionPane.showConfirmDialog(null, "A jeni e sigurte? ","Nxenesi do te fshihet pergjithmone",JOptionPane.OK_CANCEL_OPTION);
            
            if (YesOrNo == JOptionPane.OK_OPTION) {
            
                try {
                ps = con.prepareStatement("DELETE FROM `"+text+"` WHERE `Id`=?");
                ps.setInt(1, id);
                
                if(ps.executeUpdate()>0){
                   // JOptionPane.showMessageDialog(null, "Student Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }   
        
        }
    
    
        public void fillStudentJtable(String table,JTable jtable) {
        
        Connection con = MyConnection.getMyConnection();
        PreparedStatement ps ;
        try {
            ps = con.prepareStatement("SELECT * FROM `"+table+"`");            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)jtable.getModel();
            
            Object[] row ;
            
            while(rs.next()){
            row = new Object[12];
            row[0] = rs.getInt(2);
            row[1] = rs.getString(3);
            row[2] = rs.getString(4);
            row[3] = rs.getString(5);
            row[4] = rs.getString(6);
            row[5] = rs.getString(7);
            row[6] = rs.getString(8);
            row[7] = rs.getString(9);
            row[8] = rs.getString(10);
            row[9] = rs.getString(11);
            row[10] = rs.getString(12);
            row[11] = rs.getString(13);

            
            model.addRow(row);
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        
          public void fillTextJtable(String text,JTable jtable) {
        
        Connection con = MyConnection.getMyConnection();
        PreparedStatement ps ;
        try {
            ps = con.prepareStatement("SELECT * FROM `"+text+"`");            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)jtable.getModel();
            
            Object[] row ;
            
            while(rs.next()){
            row = new Object[3];
            row[0] = rs.getString(2);
            row[1] = rs.getString(3);
            row[2] = rs.getInt(1);
            model.addRow(row);
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        
        public boolean isNrStudentExist(String table,Integer nr) {
        
        boolean isExist = false;
        Connection con = MyConnection.getMyConnection();
        PreparedStatement ps ;
        try {
            ps = con.prepareStatement("SELECT * FROM `"+table+"` WHERE `Nr` = ?");
            ps.setInt(1,nr);
            
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next()){
                        
                isExist = true ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    return isExist;
    } 
    
}
