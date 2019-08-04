package com.training.project1.test;

import java.sql.ResultSet;

import com.training.project1.DBController;
import com.training.project1.OracleDBController;

public class TestJDBCFramework {
	public static void main(String args[]) {
		try{
			DBController c1=new OracleDBController();
			c1.createConnection("hr", "hr");
			System.out.println("Connection Established Successfully");
			boolean flag=c1.create("create table TblOneTest(id int, name varchar2(30))");
			if(flag) {
				System.out.println("Table Created Successfully");
			}
			else {
				System.out.println("Table Not Created");
			}
			int a=c1.insert("insert into TblOneTest values(1, 'Karishma')");
			System.out.println(a+" records inserted");
			a=c1.insert("insert into TblOneTest values(2, 'Mahima')");
			System.out.println(a+" records inserted");
			ResultSet rs=c1.select("*", "TblOneTest");
			System.out.println("Table:-");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2));
			}
			a=c1.update("update TblOneTest set name='Daisy' where id=1");
			System.out.println(a+" records updated successfully");
			rs=c1.select("*", "TblOneTest");
			System.out.println("Table:-");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2));
			}
			a=c1.delete("delete from TblOneTest where id=2");
			System.out.println(a+" records deleted successfully");
			rs=c1.select("*", "TblOneTest");
			System.out.println("Table:-");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
