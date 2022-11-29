package spring.jdbc.api;

public class Student 
{
	private int roll_no;
	private String name;
	private String address;
	
	public int getRoll_no() 
	{
		return roll_no;
	}
	public String getName() 
	{
		return name;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setRoll_no(int roll_no) 
	{
		this.roll_no = roll_no;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	@Override
	public String toString() 
	{
		return "Student [roll_no=" + roll_no + ", name=" + name + ", address=" + address + "]";
	}
}
