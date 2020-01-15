package com.jsp.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deposite")
public class Deposite extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		String accountnumber = req.getParameter("acc");
		String amount = req.getParameter("amount");
		String rstamount = check(accountnumber);
		if (rstamount != null) {
			int r = Integer.parseInt(rstamount);
			int r1 = Integer.parseInt(amount);
			int c = r + r1;
			// int amt = Integer.parseInt(c);
			update(accountnumber, c);
			//req.getRequestDispatcher("welcome.html").include(req, res);
			pw.println("user amount updated......");
		} else {
			insert(accountnumber, amount);
			req.getRequestDispatcher("welcome.html").include(req, res);
			pw.println("user account created......");
		}
	}

	int j;

	private void update(String accountnumber, int amount) {
		String query = "update test.bank set amount=? where accountnumber=?";
		String url = "jdbc:mysql://localhost:3307?user=root&password=system";
		// int i;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("connection established...");
			// insertion data in to data base
			PreparedStatement platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");

			platform.setString(2, accountnumber);
			platform.setInt(1, amount);

			j = platform.executeUpdate();
			System.out.println("query executed......");

		} catch (Exception ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
		}
		// return j;

	}

	String rst;

	private String check(String accountnumber) {
		String query = "select amount from test.bank where accountnumber=?";
		String url = "jdbc:mysql://localhost:3307?user=root&password=system";
		// int i;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("connection established...");
			// insertion data in to data base
			PreparedStatement platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");

			platform.setString(1, accountnumber);
			ResultSet resultset = platform.executeQuery();
			while (resultset.next()) {
				rst = resultset.getString("amount");
			}
			System.out.println("query executed......");

		} catch (Exception ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
		}
		return rst;
	}

	int i;

	private int insert(String accountnumber, String amount) {
		String query = "insert into test.bank values(?,?)";
		String url = "jdbc:mysql://localhost:3307?user=root&password=system";
		// int i;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("connection established...");
			// insertion data in to data base
			PreparedStatement platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");

			platform.setString(1, accountnumber);
			platform.setString(2, amount);

			i = platform.executeUpdate();
			System.out.println("insert query executed......");

		} catch (Exception ae) {
			try {
				throw new MYException("pls");
			} catch (MYException e) {
				e.printStackTrace();
			}
			// ae.printStackTrace();
		}
		return i;

	}

}
