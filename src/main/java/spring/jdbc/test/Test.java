package spring.jdbc.test;

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
		StudentDaoHelper daoHelper = context.getBean("studentDaoHelper", StudentDaoHelper.class);
		
		
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
//		System.out.println(studentDAO.deleteExtra("Ansh", "Udaipur") + " rows deleted");
		
//		4. -> Truncate
//		studentDAO.cleanUp();
		
//		5. -> Batch Insertion
//		daoHelper.setUpStudentTable();
		
//		6. -> Fetching the data from the database
		
		
		((AbstractApplicationContext) context).close();
	}

}