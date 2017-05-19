package com.example.ecenter;

public class Client 
{
	private String firstName, lastName, address, email;
	private long phoneNumber, userId;
	//private Date startDate
	public Client(String firstName, String lastName, String address, String email, long phoneNumber, long userId)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
	}
	
	public Client()
	{
		
	}
	
	public String getfirstName()
	{
		return firstName;
	}
	
	public String getlastName()
	{
		return lastName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public long getphoneNumber()
	{
		return phoneNumber;
	}
	
	public long getuserId()
	{
		return userId;
	}
	
	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setlastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setphoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setuserId(long userId)
	{
		
	}
	
	public String toString()
	{
		String result = "";
		
		result = "First Name: " + firstName + " Last Name: " + lastName;
		return result;
	}

}
