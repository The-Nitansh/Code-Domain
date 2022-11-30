package spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

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

	

	// DML : Data Manipulation Language 
	// DML commands use <update()>
	
	public void insert(Student student) 
	{
		String sql = "INSERT INTO STUDENT (Student_name , Student_address) VALUES (? , ?)";
		Object arg[] = {student.getName() , student.getAddress()};
		
		int rows = jdbcTemplate.update(sql,arg);
		
		System.out.println(rows + " row inserted");
	}


	@Override
	public boolean delete(int roll_no) 
	{
		String sql = "DELETE FROM STUDENT WHERE ROLL_NO = ?	";
		
		int rows = jdbcTemplate.update(sql,roll_no);
		
		return rows==1 ? true : false ;
		
	}


	@Override
	public int deleteExtra(String name, String address) 
	{
		String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? AND STUDENT_ADDRESS = ?";
		Object arg[] = { name , address};
		
		int rows = jdbcTemplate.update(sql,arg);
		
		return rows;
		
	}



	@Override
	public void insert(List<Student> studentsL) 
	{
		String sql = "INSERT INTO STUDENT (STUDENT_NAME  , STUDENT_ADDRESS) VALUES (? ,? )";
		
		// Will store the data of all the students
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		
		for(Student student : studentsL)
		{
//			fetching data from the instances stored in the list
			Object[] studentData = {student.getName(), student.getAddress()};
			
//			inserting into the list
			sqlArgs.add(studentData);
		}
		
		jdbcTemplate.batchUpdate(sql,sqlArgs);
		
		System.out.println("Batch Inserted");
	}



	
	// DDL : Data Definition Language
	// DDL commands use <execute()>
	

	public void cleanUp()
	{
		String sql = "TRUNCATE TABLE STUDENT";
		
		jdbcTemplate.execute(sql);
		
		System.out.println("Table clean up done");
	}

}

/*
 * NOTE :
 * 		 DDL commands use <execute()> 
 * 		 DML commands use <update()> 
 * 		 DQL commands use <query()>
 */