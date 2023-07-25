package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP 
{
	 static Connection con;
	public  static  Connection createC() {
		try
		{
			//Class.forName("com.mysql.ct.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student_manage";
			String username="root";
			String password="Anikesh";
			con=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

	
}
