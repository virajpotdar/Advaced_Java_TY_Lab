package com.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/edus")
public class edus extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String degree = request.getParameter("degree");
	    String branch = request.getParameter("branch");
	   

	    HttpSession session = request.getSession();

	    session.setAttribute("degree", degree);
	    session.setAttribute("branch", branch);
	    
	    
	    response.sendRedirect("submit.jsp");
	}

}
