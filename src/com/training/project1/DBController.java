package com.training.project1;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBController {
	void createConnection(String uName, String pass)throws ClassNotFoundException, SQLException;
	boolean create(String sql)throws SQLException;
	ResultSet select(String columns, String tblName)throws SQLException;
	int insert(String sql)throws SQLException;
	int update(String sql)throws SQLException;
	int delete(String sql)throws SQLException;
}
