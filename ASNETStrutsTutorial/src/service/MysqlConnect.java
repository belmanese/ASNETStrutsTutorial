package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.beanutils.RowSetDynaClass;

public class MysqlConnect {
	
	public static Integer create(String sql) {
		return executeUpdate(sql);
	}
	
	@SuppressWarnings("finally")
	public static RowSetDynaClass read(String sql) {
		Connection connection = MysqlConnect.get();
		Statement statement = null;
		ResultSet response = null;
		RowSetDynaClass result = null;
		
		try {
			statement = connection.createStatement();
			response = statement.executeQuery(sql);
			result = new RowSetDynaClass(response);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			return result;
		}
	}
	
	public static Integer update(String sql) {
		return executeUpdate(sql);
	}
	
	public static Integer delete(String sql) {
		return executeUpdate(sql);
	}
	
	@SuppressWarnings("finally")
	private static Connection get() {
		Connection connection = null;
		String driver = "com.mysql.jdbc.Driver";
		String database = "bd_test_1";
		String user = "user_test_1";
		String password = "user_test";
		String host = "10.52.1.162";
		String port = "3306";
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
	@SuppressWarnings("finally")
	private static Integer executeUpdate(String sql) {
		int response = 0;
		try {
			Connection connection = MysqlConnect.get();
			Statement statement = connection.createStatement();
			response = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return response;
		}
	}

}
