package com.example.ecenter;

public class Client 
{
	private String firstName, lastName, address, email, startDate, phoneNumber;
	private long userId;
	public Client(String firstName, String lastName, String address, String email, String phoneNumber, String startDate, long userId)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.startDate = startDate;
	}
	
	public Client()
	{
		
	}
	
	public String getstartDate()
	{
		return startDate;
	}
	
	public void setstartDate(String startDate)
	{
		this.startDate = startDate;
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
	
	public String getphoneNumber()
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
	
	public void setphoneNumber(String phoneNumber)
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
