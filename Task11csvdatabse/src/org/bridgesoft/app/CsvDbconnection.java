package org.bridgesoft.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvDbconnection {
	static PreparedStatement statement;

	public static void main(String[] args) throws Exception {
		datasheet();
		//groupmbr1();
	}

	public static void datasheet() throws IOException {
		String url = "jdbc:mysql://localhost:3307?user=root&password=system";
		Connection connection = null;

		int batchSize = 28;
		try {
			connection = DriverManager.getConnection(url);
			connection.setAutoCommit(false);
			String sql = "INSERT INTO test.csv2 VALUES (?, ?, ?, ?, ?,?,?)";
			statement = connection.prepareStatement(sql);
			System.out.println("platform established......");
			BufferedReader lineReader = new BufferedReader(new FileReader("F:\\Bridgesoft\\notepad\\ACME finance.csv"));
			String lineText = null;

			int count = 0;

			lineReader.readLine(); // skip header line
			Map<String, String> map = new LinkedHashMap<>();

			while ((lineText = lineReader.readLine()) != null) {
				String[] datasheet = lineText.split(",");
				List<String> list1 = new ArrayList<>();
				int flage = 0;
				for (String i : datasheet) {
					list1.add(datasheet[flage++].toString());
				}

				map.put(datasheet[0], String.join(",", list1));

			}
			Collection<String> mapvalues = map.values();
			String list2 = String.join("/", mapvalues);
			String[] list3 = list2.split("/");
			int count2 = 0;
			String[] accessdata = groupmbr1();//method call
			for (String ss : list3) {
				String[] data2 = ss.split(",");
				List<String> listee = Arrays.asList(data2[0], data2[1], data2[2], data2[3], data2[4], accessdata[count2++],
						data2[6]);
				// inserting into the data base
				int id = Integer.parseInt(data2[0]);
				statement.setInt(1, id);
				statement.setString(2, data2[1]);
				statement.setString(3, data2[2]);
				statement.setString(4, data2[3]);
				statement.setString(5, data2[4]);
				statement.setString(6, listee.get(5));
				statement.setString(7, data2[6]);
				statement.addBatch();
				if (count % batchSize == 0) {
					statement.executeBatch();
					System.out.println("details registered....");
				}

			}
			lineReader.close();
			connection.commit();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String[] groupmbr1() throws IOException, SQLException {

		BufferedReader csvfile1 = new BufferedReader(new FileReader("F:\\Bridgesoft\\notepad\\ACME finance.csv"));
		// reading the header value
		String sp = csvfile1.readLine();
		String[] header = sp.split(",");
		// reading the body value
		String rowss;
		Map<String, List<String>> mm = new LinkedHashMap<>();
		Map<String, String> m4 = new LinkedHashMap<>();

		while ((rowss = csvfile1.readLine()) != null) { // reading the file
														// line-by-line
			String[] s1 = rowss.split(",");
			List<String> list = new ArrayList<>();
			if (mm.containsKey(s1[0])) {
				list = mm.get(s1[0]);
				list.add(s1[5]);
				mm.put(s1[0], list);

			} else {
				list.add(s1[5]);
				mm.put(s1[0], list);

			}
			List<String> as = mm.get(s1[0]);
			String values = String.join(",", as);
			m4.put(s1[0], values);
		}
		Collection<String> list = m4.values();
		String list2 = String.join("/", list);
		System.out.println("list2:" + list2);
		String[] list3 = list2.split("/");
		return list3;
	}
}
