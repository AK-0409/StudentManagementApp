package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao 
{
	public static boolean insertStudentToDb(student st)
	{
		boolean f=false;
		try
		{
			Connection con=CP.createC();
			String q= "insert into students(sId,sName,sPhone,sCity) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1, st.getStudentId());
			pstmt.setString(2, st.getStudentName());
			pstmt.setString(3, st.getStudentPhone());
			pstmt.setString(4, st.getStudentCity());
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	

	public static boolean deleteStudent(int stId) {
		// TODO Auto-generated method stub
		boolean f=false;
		try
		{
			Connection con=CP.createC();
			String q= "delete from students where sId=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1, stId);
			
			pstmt.executeUpdate();
			f=true;
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}



	public static void showAllStudents()
	{
		// TODO Auto-generated method stub
		
		try
		{
			Connection con=CP.createC();
			String q= "select * from students";
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			while(set.next())
			{
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				
				
				System.out.println("Id : "+id);
				System.out.println("Name : "+name);

				System.out.println("Phone : "+phone);

				System.out.println("City : "+city);

				System.out.println("+++++++++++++++++++++++++++");

			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}



	public static boolean updateStudentToDb(student st) {
		// TODO Auto-generated method stub
		boolean f=false;
		try
		{
			Connection con=CP.createC();
			String q= "update students SET sName=?,sPhone=?,sCity=? where sId=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(4, st.getStudentId());
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
}

