package spring.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.jdbc.api.Student;
import spring.jdbc.dao.StudentDAO;

@Service(value = "studentDaoHelper")
public class StudentDaoHelper 
{
	@Autowired
	private StudentDAO studentDao;
	
	public void setUpStudentTable()
	{
		Student s1 = new Student();
		s1.setName("Hinata");
		s1.setAddress("Jaipur");
		
		Student s2 = new Student();
		s2.setName("Kageyama");
		s2.setAddress("Jaipur");
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(s1);
		studentList.add(s2);
		
		studentDao.insert(studentList);
	}

}
