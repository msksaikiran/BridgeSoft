package com.bfs.app;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SimpleCsv2DbInserter {

	public static void main(String[] args) {
		insert();
	}

	static String url = "jdbc:mysql://localhost:3307?user=root&password=system";
	static Connection connection = null;

	public static void insert() {

		//int batchSize = 28;
		try {

			connection = DriverManager.getConnection(url);
			connection.setAutoCommit(false);

			String sql = "INSERT INTO test.csv3 VALUES (?, ?, ?, ?, ?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			System.out.println("platform established......");
			BufferedReader lineReader = new BufferedReader(new FileReader("F:\\Bridgesoft\\notepad\\ACME finance.csv"));
			String lineText = null;

			Set<String> set1 = new LinkedHashSet<String>();
			Set<String> set2 = new LinkedHashSet<String>();
			Set<String> set3 = new LinkedHashSet<String>();
			Set<String> set4 = new LinkedHashSet<String>();
			Set<String> set5 = new LinkedHashSet<String>();
			Set<String> set6 = new LinkedHashSet<String>();

			int count = 0;

			lineReader.readLine(); // skip header line

			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				String employeeid = data[0];
				String dbid = data[1];
				String priviledge = data[2];
				String lastlogin = data[3];
				String inactive = data[4];
				String grpmvr = data[5];
				String username = data[6];
                 List<String> ssc = Arrays.asList(employeeid,dbid,priviledge,lastlogin,inactive , grpmvr,username);
                //inserting the values into database
				int id = Integer.parseInt(employeeid);
				statement.setInt(1, id);
				statement.setString(2, dbid);
				statement.setString(3, priviledge);
				statement.setString(4, lastlogin);
				statement.setString(5, inactive);
				statement.setString(6, grpmvr);
				statement.setString(7, username);
				set1.add(data[5]);
				grpmvr = String.join(",", set1);
				String[] accesslst = grpmvr.split(",");
				if (accesslst[0].equals(data[5])) {
					set2.add(data[6]);
					String s = String.join(",", set2);
					statement.setString(8, s);
				} else if (accesslst[1].equals(data[5])) {
					set3.add(data[6]);
					String s = String.join(",", set3);
					statement.setString(8, s);
					
				} else if (accesslst[2].equals(data[5])) {
					set4.add(data[6]);
					String s = String.join(",", set4);
					statement.setString(8, s);
					
				} else if (accesslst[3].equals(data[5])) {
					set5.add(data[6]);
					String s = String.join(",", set5);
					statement.setString(8, s);
					
				} else if (accesslst[4].equals(data[5])) {
					set6.add(data[6]);
					String s = String.join(",", set6);
					statement.setString(8, s);
					
				}
				statement.executeUpdate();
				System.out.println("details registered....");
			}
			/*if (count % batchSize == 0) {
				statement.executeBatch();
				System.out.println("details registered....");
			}*/

			lineReader.close();
			connection.commit();
			connection.close();

		} catch (Exception ex) {
			ex.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
