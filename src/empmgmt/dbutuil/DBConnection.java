/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutuil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-8K341KCI:1521/xe","javaproject","java");
            JOptionPane.showMessageDialog(null,"Connection opened successfully","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException cnfe)
         {
             JOptionPane.showMessageDialog(null,"Error in Loading the Driver!","Driver Error!",JOptionPane.ERROR_MESSAGE); 
             cnfe.printStackTrace();
             System.exit(1);
         }
        catch(SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"Error in opening the Connection!","Connection Error",JOptionPane.ERROR_MESSAGE); 
           ex.printStackTrace();
           System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
           conn.close();
           JOptionPane.showMessageDialog(null,"Connection closed Sucessfully!","Success",JOptionPane.INFORMATION_MESSAGE); 
        }
        catch(SQLException sql)
        {
           JOptionPane.showMessageDialog(null,"Error in Closing the Connection!","DB Error",JOptionPane.ERROR_MESSAGE);  
           sql.printStackTrace();
        }
            
     }
}

