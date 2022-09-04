package com.mindtree.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="specialistField")
	private String specialistField;
	
    public Doctor() {
		
	}
    public Doctor(String name,int age,String gender,String specialistField) {
		super();
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.specialistField=specialistField;
		}
	
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age=age;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender=gender;
	}
	public String getspecialistField() {
		return specialistField;
	}
	public void setspecialistField(String specialistField) {
		this.specialistField=specialistField;
	}
}
