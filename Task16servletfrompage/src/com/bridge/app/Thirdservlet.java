package com.bridge.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Thirdservlet")
public class Thirdservlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private String fname;
	private String lname;
	private String address;
	private String phone;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		ServletContext sct=req.getServletContext();
        fname=(String)sct.getAttribute("bean");
        lname=(String)sct.getAttribute("bean1");
        
        String query = "insert into test.bank2 values(?,?,?,?)";
		String url = "jdbc:mysql://localhost:3307?user=root&password=system";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("connection established...");
			// insertion data in to data base
			PreparedStatement platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");

			platform.setString(1, fname);
			platform.setString(2, lname);
			platform.setString(3, address);
			platform.setString(4, phone);

			platform.executeUpdate();
			System.out.println("insert query executed......");
			writer.println("details updated sucessfully........");
		} catch (Exception ae) {
			writer.println("updatedddd error");
			// ae.printStackTrace();
		}
	}

	
		
		
	
}

