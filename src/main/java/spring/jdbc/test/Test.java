package spring.jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.jdbc.api.Student;
import spring.jdbc.dao.StudentDAO;
import spring.jdbc.dao.StudentDAOImpl;

public class Test 
{

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/bean.xml");
		StudentDAO studentDAO  = context.getBean("studentDAO",StudentDAOImpl.class);
		
		Student student1 = new Student();
		student1.setName("Shikamaru");
		student1.setAddress("Konohagakure");
		
		studentDAO.insert(student1);
		
		((AbstractApplicationContext) context).close();
	}

}