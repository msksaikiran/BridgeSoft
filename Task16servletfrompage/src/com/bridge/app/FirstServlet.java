package com.bridge.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firstservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fname = null;
	private String lname = null;
	// private Bean bean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		fname = req.getParameter("firstname");
		lname = req.getParameter("lastname");
		ServletContext sct = req.getServletContext();
		sct.setAttribute("bean", fname);
		sct.setAttribute("bean1", lname);
		pw.println("<body><form action='secondservlet' method='post'>");
		pw.println("address:<input type='text' name='address' required></input>");
		pw.println("Phonenumber:<input type='number' name='phone' required></input>");
		/*pw.println("<a href='secondservlet'<button>submit</button></a><a href='Thirdservlet'<button>skip</button></a></body>");*/
		pw.println("<input type=submit></form>");
		pw.println("<a href='Thirdservlet'<button>skip</button></a></body>");
	}
}
