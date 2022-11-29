package spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.jdbc.api.Student;


public class StudentDAOImpl implements StudentDAO
{
	
	JdbcTemplate jdbcTemplate;	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void insert(Student student) 
	{
		String sql = "INSERT INTO STUDENT (Student_name , Student_address) VALUES (? , ?)";
		Object arg[] = {student.getName() , student.getAddress()};
		
		int rows = jdbcTemplate.update(sql,arg);
		
		System.out.println(rows + " row inserted");
	}

}
