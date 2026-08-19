package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String year = request.getParameter("year");
        String department = request.getParameter("department");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Student Registration Successful</h2>");
        out.println("<hr>");

        out.println("<h3>Student Details</h3>");

        out.println("<p><b>Name :</b> " + name + "</p>");
        out.println("<p><b>Roll Number :</b> " + roll + "</p>");
        out.println("<p><b>Year :</b> " + year + "</p>");
        out.println("<p><b>Department :</b> " + department + "</p>");

        out.println("<br>");
        out.println("<a href='index.html'>Register Another Student</a>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}