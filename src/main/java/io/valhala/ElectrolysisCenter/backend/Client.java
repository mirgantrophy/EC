package io.valhala.ElectrolysisCenter.backend;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Table(name="client_data")
@Entity
public class Client implements Serializable, Cloneable 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String firstName, lastName, phone;
	@Null
	private String address, email, notes, medication;
	
	public Client() {}
	
	public Client(String firstName, String lastName, String phone)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
	@Column(name="id")
	public long getId() {return id;}
	
	public void setId(long id) {this.id = id;}
	
	@Column(name="first_name")
	public String getFirstName() {return firstName;}
	
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	@Column(name="last_name")
	public String getLastName() {return lastName;}
	
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	@Column(name="phone_number")
	public String getPhone() {return phone;}
	
	public void setPhone(String phone) {this.phone = phone;}
	
	@Column(name="address")
	public String getAddress() {return address;}
	
	public void setAddress(String address) {this.address = address;}
	
	@Column(name="email")
	public String getEmail() {return email;}
	
	public void setEmail(String email) {this.email = email;}
	
	@Column(name="notes")
	public String getNotes() {return notes;}
	
	public void setNotes(String notes) {this.notes = notes;}
	
	@Column(name="medication")
	public String getMedication() {return medication;}
	
	public void setMedication(String medication) {this.medication = medication;}

}
