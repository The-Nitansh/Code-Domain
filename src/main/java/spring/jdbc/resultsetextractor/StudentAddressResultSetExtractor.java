package spring.jdbc.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String , List<String>>> 
{

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException 
	{
		
		Map<String , List<String>> studentMap = new HashMap<>();
		while(rs.next())
		{
			String name = rs.getString(2);
			String city = rs.getString(3);
			
			if(studentMap.containsKey(city))
			{
				List<String> temp = studentMap.get(city);
				temp.add(name);
				studentMap.put(city, temp);
			}
			else
			{
				List<String> names = new LinkedList<>();
				names.add(name);
				studentMap.put(city, names);
			}	
		}
		
		return studentMap;
		
//		Map<String , List<String>> studentTable = new HashMap<>();
//		
//		while(rs.next())
//		{
//			String name = rs.getString("Student_name");
//			String city = rs.getString("Student_Address");
//			
//			List<String> studentList = studentTable.get(city);
//			
//			if(studentList == null)
//			{
//				ArrayList<String> list = new ArrayList<>();
//				list.add(name);
//				studentTable.put(city, list);
//			}
//			else
//				studentList.add(name);
//		}
//		
//		return studentTable;
	}

	

}
