
package com.model;

import java.sql.*;
import java.util.*;

public class EmployeeData {

    int empno;
    String name;
    double salary;

    public EmployeeData(int empno, String name, double salary) {
        this.empno = empno;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Database Connection
    static Connection con() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ajt",
            "root",
            "Qwertyviraj@2006"
        );
    }

    // Insert Employee
    public static void register(int no, String name, double salary)
            throws Exception {

        Connection c = con();

        PreparedStatement ps = c.prepareStatement(
            "INSERT INTO emp VALUES(?,?,?)"
        );

        ps.setInt(1, no);
        ps.setString(2, name);
        ps.setDouble(3, salary);

        ps.executeUpdate();
        c.close();
    }

    // Display Employees
    public static List<EmployeeData> view() throws Exception {

        List<EmployeeData> list = new ArrayList<>();

        Connection c = con();

        ResultSet rs = c.createStatement().executeQuery(
            "SELECT * FROM emp"
        );

        while (rs.next()) {
            list.add(new EmployeeData(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3)
            ));
        }

        c.close();
        return list;
    }
}
