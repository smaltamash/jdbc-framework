package com.training.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDBController implements DBController {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	@Override
	public void createConnection(String uName, String pass) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDatabase", uName, pass);
	}
	@Override
	public boolean create(String sql)throws SQLException {
		boolean flag = false;
		stmt=conn.createStatement();
		flag=stmt.execute(sql);
		return !flag;
	}
	@Override
	public ResultSet select(String columns, String tblName)throws SQLException {
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select "+columns+" from "+tblName);
		return rs;
	}

	@Override
	public int insert(String sql)throws SQLException {
		stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		return i;
	}

	@Override
	public int update(String sql)throws SQLException {
		stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		return i;
	}

	@Override
	public int delete(String sql)throws SQLException {
		stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		return i;
	}
}
