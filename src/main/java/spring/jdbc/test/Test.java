package spring.jdbc.test;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.jdbc.api.Student;
import spring.jdbc.dao.StudentDAO;
import spring.jdbc.dao.StudentDAOImpl;
import spring.jdbc.service.StudentDaoHelper;

public class Test 
{

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/bean.xml");
		StudentDAO studentDAO  = context.getBean("studentDAO",StudentDAOImpl.class);
		StudentDaoHelper daoHelper = context.getBean("daoHelper", StudentDaoHelper.class);
		
		
		/*
		 * 
		 * Student student1 = new Student(); 
		 * student1.setName("Ansh");
		 * student1.setAddress("Udaipur");
		 * 
		 */
		
		/*  
		 * Operations
		 */
		
//		1. -> Insertion
//		studentDAO.insert(student1);
		
//		2. -> Deletion
//		System.out.println(studentDAO.delete(1) ? "1 row deleted " : "No rows present");
		
//		3. -> Deletion with some condition
//		System.out.println(studentDAO.deleteExtra("Anshi", "Udaipur") + " rows deleted");
		
//		4. -> Truncate
//		studentDAO.cleanUp();
		
//		5. -> Batch Insertion
//		daoHelper.setUpStudentTable();
		
//		6. -> Fetching the data from the database
		daoHelper.printStudents(studentDAO.displayStudent());
		
//		7. -> Fetching data with roll no.
//		try
//		{
//			System.out.println(studentDAO.findStudentByRollNo(2));;
//		}
//		catch(Exception e)
//		{
//			System.out.println("Roll no. doesn't exist");
//		}
		
//		7. -> Fetching data with named
//		try
//		{
//			System.out.println(studentDAO.findStudentByName("Anshi"));;
//		}
//		catch(Exception e)
//		{
//			System.out.println("No such name exist");
//		}
		
//		8. -> Group by
//		--> Returns no of students from particular city
//		daoHelper.printStudents(studentDAO.groupByAddress());
//		System.out.println(studentDAO.groupByAddress()); 
		
//		9. -> Updating the data of the student
//		Student stud = new Student();
//		stud.setAddress("Chittor");
//		stud.setRoll_no(3);
//		studentDAO.updateStudent(stud);
		
//		10. -> Updating the batch
		try 
		{
			List<Student> students = new LinkedList<>();
			Student s1 = new Student();
			s1.setAddress("Jaisalmer");
			s1.setRoll_no(1);
			students.add(s1);
			Student s2 = new Student();
			s2.setAddress("Jalore");
			s2.setRoll_no(2);
			students.add(s2);
			
			System.out.println(studentDAO.updateStudentTable(students)+" rows updated");
		} catch (Exception e) 
		{
			
		}
		
		daoHelper.printStudents(studentDAO.displayStudent());
		((AbstractApplicationContext) context).close();
	}

}