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

    static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ajt",
            "root",
            "Qwertyviraj@2006"
        );
    }

    public static boolean registerEmployee(
            int no, String name, double salary)
            throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO emp VALUES(?,?,?)"
        );

        ps.setInt(1, no);
        ps.setString(2, name);
        ps.setDouble(3, salary);

        int result = ps.executeUpdate();

        con.close();

        return result > 0;
    }

    public static List<EmployeeData> getAllEmployees()
            throws Exception {

        List<EmployeeData> list = new ArrayList<>();

        Connection con = getConnection();

        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM emp");

        while (rs.next()) {

            list.add(new EmployeeData(
                rs.getInt("empno"),
                rs.getString("name"),
                rs.getDouble("salary")
            ));
        }

        con.close();

        return list;
    }
}