package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dbconnection {
	
	static String url = "jdbc:mysql://localhost:3307?user=root&password=system";
	public ArrayList<UserVo> getAll(String id) {
		
		ArrayList<UserVo> userList = new ArrayList<>();
		String query = "select * from test.user where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url);
			System.out.println("connection establioshed...");
			// insertion data in to data base
			PreparedStatement platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");
			platform.setString(1, id);
			System.out.println("query executed......");
			ResultSet rs = platform.executeQuery();
			while (rs.next()) {
				UserVo user= new UserVo();

				user.setUsername(rs.getString("username"));
				System.out.println(user.getUsername());
				user.setPassword(rs.getString("password"));
				System.out.println(user.getPassword());
				user.setId(rs.getString("id"));
				System.out.println(user.getId());
				userList.add(user);
			}
		} catch (Exception ae) {
			ae.printStackTrace();
		}

		return userList;
	}
	
	public  String createuser(UserVo user) throws ClassNotFoundException
	{
		
		String query="insert into test.user values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getId());
			int i=preparedStatement.executeUpdate();
			if(i!=0)
			{
				System.out.println("user register successfully.....");
				return user.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return "user not register...";
	}
	public String update(UserVo name,String id) throws ClassNotFoundException
	{
		String query="update test.user set username=? where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name.getUsername());
			preparedStatement.setString(2, id);
			System.out.println("about to......");
			int i=preparedStatement.executeUpdate();
			if(i!=0)
			{
				System.out.println("user details updated sucessfully....");
				return "details updated....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return "user not register...";
	}
	
public String delete(String id) {
		String query = "delete from test.user where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("connection established...");
			// insertion data in to data base
			PreparedStatement platform = connection.prepareStatement(query);
			System.out.println("platfrom established......");
			platform.setString(1, id);
			System.out.println("query executed......");
			int rs = platform.executeUpdate();
			if(rs!=0)
			{
				return "user deleted successfully....";
			}
			
		} catch (Exception ae) {
			ae.printStackTrace();
		}

		return "not exist";
	}
}
