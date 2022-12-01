package spring.jdbc.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.jdbc.api.Student;
import spring.jdbc.resultsetextractor.StudentAddressResultSetExtractor;
import spring.jdbc.resultsetextractor.StudentResultSetExtractor;

@Repository("studentDAO")
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
	public void insert(List<Student> students) 
	{
		String sql = "INSERT INTO STUDENT (STUDENT_NAME  , STUDENT_ADDRESS) VALUES (? ,? )";
		
		// Will store the data of all the students
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		
		for(Student student : students)
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



	@Override
	public List<Student> displayStudent() 
	{
		String sql = "SELECT * FROM STUDENT";
		
		// Will fetch whole database
//		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		List<Student> students = jdbcTemplate.query(sql, new StudentResultSetExtractor());
		
		return students;
	}



	@Override
	public Student findStudentByRollNo(int rollNo) 
	{
		// Use this if database attribute are not same as class variables
		String sql = "SELECT "
				+ "	Roll_no as roll_no ,"
				+ "Student_name as name ,"
				+ "Student_address as address"
				+ "		 FROM STUDENT  WHERE ROLL_NO = ?";
		
		
		
//		To fetch the single object
//		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper() ,rollNo);
		
		Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class) ,rollNo);

		return student;
	}



	@Override
	public List<Student> findStudentByName(String name) 
	{
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME = ?";
		
		List<Student> students = jdbcTemplate.query(sql , new StudentResultSetExtractor(), name);
		
		return students;
	}



	@Override
	public Map<String, List<String>> groupByAddress() 
	{
		String sql = "SELECT * FROM STUDENT";
		Map<String , List<String>> details = jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());
		return details;
	}



	@Override
	public int updateStudent(Student student) 
	{
		String sql = "UPDATE school.STUDENT SET STUDENT_ADDRESS = ? WHERE ROLL_NO = ?";
		Object args[] = {student.getAddress() , student.getRoll_no()};
		
		return jdbcTemplate.update(sql , args);
	
	}


	public int updateStudentTable(List<Student> students)
	{
		String sql = "UPDATE school.STUDENT SET STUDENT_ADDRESS = ? WHERE ROLL_NO = ?";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() 
		{
			// This method will set the values in sql queries
			@Override
			public void setValues(PreparedStatement pstmt, int index) throws SQLException 
			{
				
				/*
				 * 1st argument will replace the first ? in string sql and second argument is the value
				 * i.e. 1 for the address
				 * 		2 for the roll no.
				 */
				pstmt.setString(1, students.get(index).getAddress()); // Sets the address in the prepared statement
				pstmt.setInt(2, students.get(index).getRoll_no());    // Sets the roll no in the prepared statement
				
			}
			
			@Override
			public int getBatchSize() 
			{
				return students.size();
			}
		});
		
		return students.size();
	}

}

/*
 * TODO 
 * BeanPropertyRowMapper<Student> 
 * DEFINITION : It will create the instance of specified class and map the attributes of the table to the variables of the specified class 
 * > PROS : No need to create custom row mapper 
 * > CONS : variable of specified class should match the table attributes
 *
 */


/*
 * NOTE :
 * 		 DDL commands use <execute()> 
 * 		 DML commands use <update()> 
 * 		 DQL commands use <query()>
 */