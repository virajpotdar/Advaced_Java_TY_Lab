package com.control;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.EmployeeData;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int no = Integer.parseInt(
                request.getParameter("empno"));

            String name =
                request.getParameter("name");

            double salary = Double.parseDouble(
                request.getParameter("salary"));

            EmployeeData.registerEmployee(
                no, name, salary);

            request.setAttribute(
                "message",
                "Employee registered successfully!");

        } catch (Exception e) {

            request.setAttribute(
                "message",
                e.getMessage());
        }

        request.getRequestDispatcher("emp.jsp")
               .forward(request, response);
    }


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            List<EmployeeData> list =
                EmployeeData.getAllEmployees();

            request.setAttribute(
                "employees", list);

        } catch (Exception e) {

            request.setAttribute(
                "message", e.getMessage());
        }

        request.getRequestDispatcher("emp.jsp")
               .forward(request, response);
    }
}