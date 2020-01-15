package com.jsp.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerurl")
	public class Register extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	PrintWriter out = null ;
	String name = null ;
	out = res.getWriter();
	res.setContentType("text/html");
	//read form data
	name = req.getParameter("name");
	//display form data 
	out.println("<h1>Name is :</h1>"+name);
	out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	doGet(req, res);
	}
}      

