package spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.jdbc.api.Student;

@Repository(value = "studentDAO")
public class StudentDAOImpl implements StudentDAO
{
	@Autowired
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
