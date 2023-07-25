package learnJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.student.manage.StudentDao;
import com.student.manage.student;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to Student Management App");
		while(true)
		{
			System.out.println("Press 1 for Add Student");
			System.out.println("Press 2 for Delete Student");
			System.out.println("Press 3 for Display Student");
			System.out.println("Press 4 update Student");
			System.out.println("Press 5 for exit" );
			int c=Integer.parseInt(br.readLine());
			if(c==1)
			{
				//add
				System.out.println("Enter id of student:");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Enter name of student:");
				String name=br.readLine();
				System.out.println("Enter phone of student:");
				String phone=br.readLine();
				System.out.println("Enter city of student:");
				String city=br.readLine();
			     student st=new student(id,name,phone,city);
			    boolean answer= StudentDao.insertStudentToDb(st);
		
			    if(answer)
			    {
			    	System.out.println("Student added successfully");
			    }
			    else
			    {
			    	System.out.println("Student Not added");
			    }
				System.out.println(st);
			}
			else if(c==2)
			{
				//Delete
				System.out.println("Enter student id to delete student:");
				int stId=Integer.parseInt(br.readLine());
				 boolean answer=StudentDao.deleteStudent(stId);
				 if(answer)
				 {
					 System.out.println("Deleted successfullY");
					 
				 }
				 else
				 {
					 System.out.println("Error in deletin student");
				 }
			}
			else if(c==3)
			{
				//Display
				StudentDao.showAllStudents();
				
			}
			else if(c==4)
			{
				
				//Update
				System.out.println("Enter id of student:");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Enter name of student:");
				String name=br.readLine();
				System.out.println("Enter phone of student:");
				String phone=br.readLine();
				System.out.println("Enter city of student:");
				String city=br.readLine();
				student st=new student(id,name,phone,city);
			    boolean answer= StudentDao.updateStudentToDb(st);
			    if(answer)
			    {
			    	System.out.println("Updated Successfully");
			    }
			    else
			    {
			    	System.out.println("Error while updating.....");
			    }
			}
				
			else if(c==5)
			{
				break;
			}
			else
			{
				
			}
		}
		System.out.println("Thankyou for using my Application");
	}

}
