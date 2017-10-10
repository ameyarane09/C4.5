package com.abc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.databaseconnection.DatabaseConnection;

public class abc
{
	public static void main(String args[])
	{
		Date today = Calendar.getInstance().getTime();
		System.out.println(today);
	}
}
