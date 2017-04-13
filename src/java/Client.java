/* CHANGELOG
 * 4/13/17 - modified return statements for SQL insertions
 */
package test;

import java.sql.Date;

public class Client 
{
	private String dateStarted, firstName, lastName, email, address, priorTreatment, medicalHistory, prevMethod;
	private Date dob;
	private int phoneNumber;
	public Client(String firstName, String lastName, String email, String address, String dateStarted, int phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.dateStarted = dateStarted;
		this.phoneNumber = phoneNumber;
	}
	
	public Client()
	{
		
	}
	
	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getfirstName()
	{
		return firstName;
	}
	public void setlastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getlastName()
	{
		return lastName;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAddress()
	{
		return address;
	}
	public void setpriorTreatment(String priorTreatment)
	{
		this.priorTreatment = priorTreatment;	
	}
	public String getpriorTreatment()
	{
		return priorTreatment;
	}
	public void setpreviousMethod(String prevMethod)
	{
		this.prevMethod = prevMethod;
	}
	public String getpreviousMethod()
	{
		return prevMethod;
	}
	public void setHistory(String medicalHistory)
	{
		this.medicalHistory = medicalHistory;
	}
	public String getHistory()
	{
		return medicalHistory;
	}
	public void setDate(String dateStarted)
	{
		this.dateStarted = dateStarted;
	}
	public String getDate()
	{
		return dateStarted;
	}
	public void setdob(Date dob)
	{
		this.dob = dob;
	}
	public Date getdob()
	{
		return dob;
	}
	public void setPhone(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public int getPhone()
	{
		return phoneNumber;
	}
}
