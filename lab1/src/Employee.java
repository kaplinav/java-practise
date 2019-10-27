/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Employee {
    private static int m_count;
    private int m_idNumber;
    private String m_name;
    private String m_position;
    private float m_salary;
   
    public Employee(String name) { this(name, "worker", 5000); }
    public Employee(String name, String position)
    {
        this(name, position, "worker".equals(position) ? 5000 : 6000);
    }
    
    public Employee(String name, String position, float salary)
    {
        m_idNumber = ++m_count;
        m_name = name;
        m_position = position;
        m_salary = salary;
    }
    
    private void showEmployee()
    {
        System.out.print("ID:"+this.m_idNumber);
        System.out.print(" Name:"+this.m_name);
        System.out.print(" Position:"+this.m_position);
        System.out.print(" Salary:"+this.m_salary+"\n");
    }
    
    public static void showEmployeesList(Employee emp[])
    {
        int count = emp.length;
        float sumOfSalary = 0;
        float maxSalary = 0;
        String position = "";
        
        for (int i = 0; i < count; i++) {
            emp[i].showEmployee();
            sumOfSalary += emp[i].m_salary;
            
            if (emp[i].m_salary > maxSalary) {
                maxSalary = emp[i].m_salary;
                position = emp[i].m_position;
            }
        }
        System.out.println("Sum of salary: "+sumOfSalary);
        System.out.println("Position with max salary: "+position);
    }
}
