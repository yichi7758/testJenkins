package cn.sia.demo.springdata.jpa.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Department {
	@Id
	private Long id;
	private String name;

	@OneToMany(mappedBy = "department")
	private Collection<Person> employees = new ArrayList<>();

	public Department() {
	}

	public Department(Long id, String name) {
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
