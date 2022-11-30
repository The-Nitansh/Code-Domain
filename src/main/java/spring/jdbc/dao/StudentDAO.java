package spring.jdbc.dao;

import java.util.List;

import spring.jdbc.api.Student;

public interface StudentDAO 
{
	public void insert(List<Student> students);
	public void insert(Student student);
	public boolean delete(int roll_no);
	public int deleteExtra(String name , String address);
	
	public void cleanUp();
	
	public List<Student> displayStudent();
	public Student findStudentByRollNo(int rollNo);
	public List<Student> findStudentByName(String name);
}
