package org.bridge.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Operation {
	static Connection connection;
	static String url = "jdbc:mysql://localhost:3307?user=root&password=system";
	static String query ;
	static PreparedStatement platform;
	static Scanner scan = new Scanner(System.in);

	public static void creataccount() {

		query = "insert into test.employeedetails values(?,?,?,?,?)";
		try {
			connection = DriverManager.getConnection(url);
			System.out.println("connection establioshed...");
			// insertion data in to data base
			platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");

			System.out.println("enter the name");
			platform.setString(1, scan.next());
			System.out.println("enter the emailid");
			platform.setString(2, scan.next());
			System.out.println("enter the  phonenumber");
			platform.setString(3, scan.next());
			System.out.println("enter the password");
			platform.setString(4, scan.next());
			System.out.println("enter the Gender");
			platform.setString(5, scan.next());
          
			platform.executeUpdate();
			System.out.println("user register succesfully......");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updatePassword() {
		String query2 = "select * from test.employeedetails where phonenumber=?";
		String query = "update test.registration set password=? where phonenumber=?";
		try {
			connection = DriverManager.getConnection(url);
			System.out.println("connection establisthed....");
			platform = connection.prepareStatement(query2);
			System.out.println("enter the phonenumber");
			String phone = scan.next();
			platform.setString(1, phone);

			ResultSet res = platform.executeQuery();
			if (res.next()) {
				Random random = new Random();
				int otp = random.nextInt(10000);
				otp = (otp < 0) ? otp = otp * -1 : otp;
				int opt = String.valueOf(otp).length();
				// int opt=otp.length;
				if (opt > 3)
					System.out.println("otp generated:" + otp);

				System.out.println("enter your otp");
				int i = scan.nextInt();
				if (i == otp) {
					System.out.println(" otp Sucessfull.....");
					PreparedStatement pre = connection.prepareStatement(query);
					System.out.println("enter the new password");
					pre.setString(1, scan.next());
					pre.setString(2, phone);
					int a = pre.executeUpdate();
					System.out.println("no. of rows updated:" + a);

				} else {
					System.out.println("invalid otp");
					System.exit(0);
				}
				String name = res.getString("name");
				System.out.println("welcome:" + name);
			} else {
				System.err.println("invalid user...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void read() {

		query = "select * from test.employeedetails where phonenumber=?";
		try {
			connection = DriverManager.getConnection(url);
			System.out.println("connection established...");
			// insertion data in to data base
			platform = connection.prepareStatement(query);
			System.out.println("enter the phonenumber");
			platform.setInt(1,scan.nextInt());
			System.out.println("*****user details******");
			ResultSet result=platform.executeQuery();
			while(result.next())
			{
			System.out.println("Name:"+result.getString("name"));
			System.out.println("Email:"+result.getString("emailid"));
			System.out.println("password:"+result.getInt("phonenumber"));
			System.out.println("Gender:"+result.getString("Gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete() throws SQLException
	{
		query="delete from test.employeedetails where phonenumber=?";
		connection=DriverManager.getConnection(url);
		System.out.println("enter the phonenumber");
		int phonenumber=scan.nextInt();
		platform=connection.prepareStatement(query);
		platform.setInt(1, phonenumber);
		int i=platform.executeUpdate();
		if(i!=0)
		{
			System.out.println("user deleted succesfully.....");
		}
		else{
			System.out.println("user not exist.......");
		}
		connection.close();
	}

	public static void login() {
		
		String query = "select * from test.registration where email=? or phonenumber=?";
		String query2 = "select name from test.registration where password=? ";
		try {
			connection = DriverManager.getConnection(url);
			System.out.println("connection established.........");
			// creating the platform
			platform = connection.prepareStatement(query);

			System.out.println("enter the emailid r phonenumber");
			String phone = scan.next();
			platform.setString(1, phone);
			platform.setString(2, phone);
			ResultSet res = platform.executeQuery();
			if (res.next()) {
				PreparedStatement pre = connection.prepareStatement(query2);
				System.out.println("enter the password");
				pre.setString(1, scan.next());
				ResultSet result = pre.executeQuery();
				if (result.next()) {
					String name = res.getString("name");
					System.out.println("welcome:" + name);
				} else {
					System.err.println("invalid user...");
				}

			}
		} catch (SQLException ae) {
			ae.printStackTrace();
		}
	}
}

	