package com.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection 
{
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";
	static final String u = "root";
	static final String p = "root";
	
	public static ResultSet query(String sql)
	{
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,u,p);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	System.out.println("Error in main()");
        }
        return rs;
	}
}
