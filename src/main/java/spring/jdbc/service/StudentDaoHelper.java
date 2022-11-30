package spring.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.jdbc.api.Student;
import spring.jdbc.dao.StudentDAO;

@Service("daoHelper")
public class StudentDaoHelper 
{
	@Autowired
	StudentDAO studentDAO;
	
	public void setUpStudentTable()
	{
		Student s1 = new Student();
		s1.setAddress("Udaipur");
		s1.setName("Ansh");
		
		Student s2 = new Student();
		s2.setAddress("Udaipur");
		s2.setName("Anshi");
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		
		studentDAO.insert(students);
	}
	
	public void printStudents(List<Student> students)
	{
		for(Student student : students)
		{
			System.out.println(student);
		}
	}
}
