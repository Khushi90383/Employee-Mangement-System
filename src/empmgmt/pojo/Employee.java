/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author HP
 */
public class Employee {
    private int empNo;
    private String empName;
    private double empSal;
    public Employee()
      {
                
      }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public Employee(int empNo, String empName, double empSal) {
        this.empNo = empNo;
        this.empName = empName;
        this.empSal = empSal;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public double getEmpSal() {
        return empSal;
    }
    
}
