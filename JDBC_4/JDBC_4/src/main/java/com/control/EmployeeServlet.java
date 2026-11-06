
package com.control;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.model.EmployeeData;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws ServletException, IOException {

        try {
            int no = Integer.parseInt(req.getParameter("empno"));
            String name = req.getParameter("name");
            double salary = Double.parseDouble(req.getParameter("salary"));

            EmployeeData.register(no, name, salary);

            req.setAttribute("message", "Employee Registered Successfully!");

        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
        }

        req.getRequestDispatcher("/emp.jsp").forward(req, res);
    }

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws ServletException, IOException {

        try {
            List<EmployeeData> list = EmployeeData.view();
            req.setAttribute("employees", list);

        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
        }

        req.getRequestDispatcher("/emp.jsp").forward(req, res);
    }
}
