package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEX PC
 */
public class abmContact extends conexion{
    
   public DefaultTableModel insertTable (String condition){
     
       DefaultTableModel modelTable = new DefaultTableModel();   
       modelTable.setColumnIdentifiers(new Object[]{"ID","NOMBRE","TELEFONO","DIRECCION"});
       
       PreparedStatement preparation = null;
       Connection conex = getOpenConnetion();
       String sql = "";
       ResultSet result = null;
       
       try {
            sql = "SELECT * FROM agendacel"+condition;
            preparation = conex.prepareStatement(sql);
            result = preparation.executeQuery();
            while(result.next() == true){
               modelTable.addRow(new Object[]{
                   result.getInt("id"),
                   result.getString("name"),
                   result.getString("phone"),
                   result.getString("adress")
            });
            }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
       }
       return modelTable;
   }
   
   public boolean insertContact(modelContact contact){
       
       PreparedStatement preparation = null;
       Connection conex = getOpenConnetion();
       String sql;
       
       try {
           sql = "insert into agendacel (name,phone,adress)values(?,?,?)";
           preparation = conex.prepareStatement(sql);
           preparation.setString(1, contact.getName());
           preparation.setString(2, contact.getPhone());
           preparation.setString(3, contact.getAdress());
           preparation.execute();
           conex.close();
           return true;
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
           return false;
       }
   }
   
   public boolean getContact(String code, modelContact contact){
       PreparedStatement preparation = null;
       Connection conex = getOpenConnetion();
       String sql = "";
       ResultSet result = null;
       try {
           sql ="select * from agendacel where id= '"+code+"'";
           preparation = conex.prepareStatement(sql);
           result = preparation.executeQuery();
           
           if(result.next() == true){
               contact.setId(result.getInt("id"));
               contact.setName(result.getString("name"));
               contact.setPhone(result.getString("phone"));
               contact.setAdress(result.getString("adress"));
               return true;
           }else{
               return false;
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
           return false;
       }
   }
   
   public boolean updateContact(modelContact contact){
       PreparedStatement preparation = null;
       Connection conex = getOpenConnetion();
       String sql = "";
       try {
            sql = "update agendacel set name=?, phone=?, adress=? where id=?";
            preparation = conex.prepareStatement(sql);
            preparation.setString(1,contact.getName());
            preparation.setString(2, contact.getPhone());
            preparation.setString(3, contact.getAdress());
            preparation.setInt(4, contact.getId());
            preparation.execute();
            conex.close();
            return true;
       } catch (SQLException e){
           JOptionPane.showMessageDialog(null, e);
            return false;
       }
   }
   
   public boolean deleteContact (String code){
       PreparedStatement preparation = null;
       Connection conex = getOpenConnetion();
       String sql = "";
       
       try {
           sql = "delete from agendacel where id=?";
           preparation = conex.prepareStatement(sql);
           preparation.setInt(1, Integer.parseInt(code));
           preparation.execute();
           return true;
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
            return false;         
       }
   }
}
