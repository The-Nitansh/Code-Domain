package spring.jdbc.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import spring.jdbc.api.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>>
{

	/* 
	 * 
	 * Fetch all the records at once rather than going each time 
	 * 
	 */
	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException 
	{
		List<Student> studentList = new ArrayList<Student>();
		
		while(rs.next())
		{
			Student student = new Student();
			
			student.setRoll_no(rs.getInt(1));;
			student.setName(rs.getString(2));
			student.setAddress(rs.getString(3));
			
			studentList.add(student);
		}
		return studentList;
	}
	
}
