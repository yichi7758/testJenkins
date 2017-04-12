package cn.sia.demo.springdata.jpa.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {
	@Id
	private Long id;
	private String name;
	private Date birthday;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	private Gender gender;
	private String phone;

	@ManyToOne
	private Company company;

	@ManyToOne
	private Department department;


	public Person() {
	}

	public Person(Long id, String name, Date birthday, Gender gender, String phone, Company company, Department department) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.company = company;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
