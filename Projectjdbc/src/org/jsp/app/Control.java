package org.jsp.app;

import java.util.Scanner;

public class Control extends Thread {

	@Override
	public void run(){
	
       access();
	}
	public static void access() {
		
		int count=0;
		do {
		System.out.println("enter 1 for registration");
		System.out.println("enter 2 for login");
		System.out.println("enter 3 for change password");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		
		switch(choice)
		{
		case 1:Operation.registration();
		        count++;
		break;
		case 2:Operation.login();
		         count++;
		break;
		case 3:Operation.changepassword();
		          count++;
		break;
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
