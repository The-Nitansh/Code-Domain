package spring.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import spring.jdbc.api.Student;

public class StudentRowMapper implements RowMapper<Student>
{
		
	/* 
	 * 
	 * NOTE : For every row present in the database this method will be called.
	 * 		: During each call <rowNum> parameter will be incremented thus indicating number of the record
	 * 		: row count starts from 0
	 * 
	 */
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		System.out.println("*******************************\n"+"          rows : "+rowNum+"\n*******************************");
		Student student = new Student();
		
		student.setRoll_no(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setAddress(rs.getString(3));
		
		return student;
	}

}