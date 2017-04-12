package cn.sia.demo.springdata.jpa.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Company {

	@Id
	private Long id;
	private String name;

	/*
	Note: Other way to do @OneToMany, it will create a relational table.
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ref_company_person",
			joinColumns={ @JoinColumn(name="company_id", referencedColumnName = "id")},
			inverseJoinColumns = { @JoinColumn(name="person_id", referencedColumnName = "id")})
	*/
	@OneToMany(mappedBy = "company")
	private Collection<Person> employees = new ArrayList<>();

	public Company() {
	}

	public Company(Long id, String name) {
		this.id = id;
		this.name = name;
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
}
