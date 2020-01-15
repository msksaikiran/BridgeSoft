package org.jsp.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Operation {
	static Connection connection=null;
	static String url="jdbc:mysql://localhost:3307?user=root&password=system";
	static String query=null;
	static PreparedStatement platform=null;
	static Scanner scan=new Scanner(System.in);
	
	public static void registration()
	{
		
	    query="insert into test.registration values(?,?,?,?,?)";
	     try {
				connection=DriverManager.getConnection(url);
				System.out.println("connection establioshed...");
				//insertion data in to data base
				platform=connection.prepareStatement(query);
				System.out.println("platfrom established......");
				
				System.out.println("enter the name");
				platform.setString(1,scan.next());
				System.out.println("enter the emailid");
				platform.setString(2, scan.next());
				System.out.println("enter the  phonenumber");
				platform.setString(3, scan.next());
				System.out.println("enter the password");
				platform.setString(4, scan.next());
				System.out.println("enter the Gender");
				platform.setString(5, scan.next());
		
		        platform.executeUpdate();
		        System.out.println("query executed......");
		    
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	public static void login()
	{
		System.out.println("enter 1 for login using phonenumber &password");
		System.out.println("enter 2 for login using email & password");
        System.out.println("enter 3 for login using email/phonenumber &password");
        System.out.println("enter ur choice");
        int choice=scan.nextInt();
        switch(choice)
        {
        case 1:Operation.loginusingphone();
        break;
        case 2:Operation.loginusingemailid();
        break;
        case 3 : Operation.loginusingemailrpassword();
        break;
        default : 
        	throw new Invalidchoice();
 
        }
	}
        public static void loginusingphone()
        {
        	query="select name from test.registration where phonenumber=? and password=?";
        	try {
        	Connection connection=DriverManager.getConnection(url);
        	System.out.println("connection established.........");

        	PreparedStatement prepare= connection.prepareStatement(query);
            System.out.println("platform created.....");
 
        	System.out.println("enter the phonenumber");
        	prepare.setString(1, scan.next());
        	System.out.println("enter the password");
        	prepare.setString(2,scan.next());

        	ResultSet res= prepare.executeQuery();
        	if(res.next())
        	{
        		String name=res.getString("name");
        		System.out.println("welcome:"+name);
        	}
        	else {
        		System.err.println("invalid user...");
        	}
        	}
        	catch(SQLException ae)
        	{
        		ae.printStackTrace();
        	}
        	}
        public static void loginusingemailid()
        {
        	String query="select name from test.registration where email=? and password=?";
        	try {
            connection=DriverManager.getConnection(url);
        	System.out.println("connection established.........");

        	platform= connection.prepareStatement(query);

        	
        	System.out.println("enter the emailid");
        	platform.setString(1, scan.next());
        	System.out.println("enter the password");
        	platform.setString(2,scan.next());

        	ResultSet res= platform.executeQuery();
        	if(res.next())
        	{
        		String name=res.getString("name");
        		System.out.println("welcome:"+name);
        	}
        	else {
        		System.err.println("invalid user...");
        	}
        	}
        	catch(SQLException ae)
        	{
        		ae.printStackTrace();
        	}
        }

	public static void loginusingemailrpassword() {
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

        public static void changepassword()
        {
        	String query2="select * from test.registration where phonenumber=?";
   	     String query="update test.registration set password=? where phonenumber=?";
   	     try
   	     {
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
}
	
	


