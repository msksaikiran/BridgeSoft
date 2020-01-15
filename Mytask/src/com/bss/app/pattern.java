package com.bss.app;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter the number of rounds");
		int n=scan.nextInt();
		System.out.println("please enter the number of view");
		int m=scan.nextInt();
		
		for(int row=0;row<=n-1;row++)
		{
			for(int column=row+1;column<=m;column++)
			{
				System.out.print(column);
			}
			
			for(int k=m;k>=1;k--)
			{
				if(k<=row)
				{
					System.out.print(k);
				}
			}
			System.out.println();
		}scan.close();
	}

}
