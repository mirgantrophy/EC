/*
 * Entity object pretty much complete here
 * finish Rest API implementation
 * connect UI to write to db
 */
package io.valhala.ecenter.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "clients")
public class Client implements Serializable, Cloneable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String firstName, lastName, address, email, startDate, phoneNumber;
	@Null
	private String medicine, pastTreatments, notes;

	
	protected Client(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	protected Client(long id, String firstName, String lastName, String address, String email, String phoneNumber, String startDate, String medicine, String pastTreatments, String notes)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.medicine = medicine;
		this.pastTreatments = pastTreatments;
		this.notes = notes;
	}
	
	public Client(String firstName, String lastName, String address, String email, String phoneNumber) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public Client() {}

	public String getMedicine() {return medicine;}
	
	public void setMedicine(String medicine) {this.medicine = medicine;}
	
	public String getTreatments() {return pastTreatments;}
	
	public void setTreatments(String pastTreatments) {this.pastTreatments = pastTreatments;}
	
	public String getstartDate() {return startDate;}
	
	public void setstartDate(String startDate) {this.startDate = startDate;}
	
	public String getfirstName() {return firstName;}
	
	public String getlastName() {return lastName;}
	
	public String getAddress() {return address;}
	
	public String getEmail() {return email;}
	
	public String getphoneNumber() {return phoneNumber;}
	
	public void setId(long id) {this.id = id;}
	
	public long getId() {return id;}
	
	public void setfirstName(String firstName) {this.firstName = firstName;}
	
	public void setlastName(String lastName) {this.lastName = lastName;}
	
	public void setAddress(String address) {this.address = address;}
	
	public void setEmail(String email) {this.email = email;}
	
	public void setphoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

	public void setNotes(String notes) {this.notes = notes;}
	
	public String getNotes() {return notes;}
	
	public String toString()
	{
		String result = "";
		
		result = "First Name: " + firstName + " Last Name: " + lastName;
		return result;
	}

}
