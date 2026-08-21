package com.model;
import java.sql.*;

public class demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/ajt";
        	String user="root";
        	String pass="Qwertyviraj@2006";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Student");
        
        while (rs.next()) {
        	System.out.println(rs.getInt("id"));
        System.out.println(rs.getString("name"));
        System.out.println(rs.getInt("marks"));
        
        }
        
        con.close();

    }

	
}