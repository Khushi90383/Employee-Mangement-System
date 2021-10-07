/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutuil.DBConnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class EmpDAO {
    public static boolean addEmployee(Employee obj)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into employees values(?,?,?)");
        ps.setInt(1,obj.getEmpNo());
        ps.setString(2,obj.getEmpName());
        ps.setDouble(3,obj.getEmpSal());
        int result=ps.executeUpdate();
        return result==1;
    }
    public static Employee findEmployeeById(int empNo)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employees where EMPID=?");
        ps.setInt(1,empNo);
        ResultSet rs=ps.executeQuery();
        Employee e=null;
        if(rs.next())
        {
            e=new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
        }
        return e;
    }   
    public static ArrayList<Employee> getAllEmployees()throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("select * from EMPLOYEES");
      ResultSet rs=ps.executeQuery();
      Employee e=null;
      ArrayList<Employee> al=new ArrayList<>();
      while(rs.next())
      {
            e=new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            al.add(e);
      }
      return al;
    }
    public static boolean updateEmployee(Employee e)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set EMPNAME=?,EMPSAL=? where EMPID=?");
        ps.setString(1,e.getEmpName());
        ps.setDouble(2,e.getEmpSal());
        ps.setInt(3,e.getEmpNo());        
        int result=ps.executeUpdate();
         return result==1;
    }
     public static boolean deleteEmployee(Employee e)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from EMPLOYEES where EMPID=?");
        ps.setInt(1,e.getEmpNo());        
        int result=ps.executeUpdate();
         return result==1;
    }
    
    
}
