package org.bridge.control;
import java.sql.SQLException;
import java.util.Scanner;

import org.bridge.operation.Invalidchoice;
import org.bridge.operation.Operation;

public class Control extends Thread {

	@Override
	public void run(){
	
       try {
		access();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	public static void access() throws SQLException {
		
		int count=0;
		do {
		System.out.println("enter 1 for create user");
		System.out.println("enter 2 for Update user password");
		System.out.println("enter 3 for read user details");
		System.out.println("enter 4 for delete user account");
		
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		
		switch(choice)
		{
		case 1:Operation.creataccount();
		         count++;
		break;
		case 2:Operation.updatePassword();;
		         count++;
		break;
		case 3:Operation.read();
		         count++;
		break;
		case 4:Operation.delete();
		         count++;
	    break;
		case 5:Operation.login();
		         count++;
		default:
		        throw new Invalidchoice();
		}
		System.out.println("enter 1 to continue");
		System.out.println("enter 0 exit");
		System.out.println("enter ur choice");
		int choice1=scan.nextInt();
		switch(choice1)
		{
		case 1:continue;
		      
		case 0: System.exit(0);
		      break;
		default:throw new Invalidchoice();
		}
		}while(count>=1);
	}

}
