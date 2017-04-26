package cn.sia.demo.springdata.jpa.service;

import cn.sia.demo.springdata.jpa.domain.model.Company;
import cn.sia.demo.springdata.jpa.domain.model.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.sia.demo.springdata.jpa.domain.model.Department;
import cn.sia.demo.springdata.jpa.domain.model.Gender;
import cn.sia.demo.springdata.jpa.domain.repository.CompanyRepository;
import cn.sia.demo.springdata.jpa.domain.repository.DepartmentRepository;
import cn.sia.demo.springdata.jpa.domain.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonService implements BaseService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PersonRepository pr;

	@Autowired
	private CompanyRepository cr;

	@Autowired
	private DepartmentRepository dr;

	public List<Person> searchAll() {
		List<Person> people = new ArrayList<>();
		pr.findAll().forEach(people::add);
		return people;
	}

	//public Person search(Long id) {
		Person p = pr.findOne(id);
		return p;
	}

	public boolean create(Long id, String name, Date birthday,
	                      Gender gender, String phone, Long companyId,
	                      Long departmentId) {

		if(cr.findOne(id) != null) return false;

		Company company = cr.findOne(companyId);
		if(company == null) return false;

		Department department = dr.findOne(departmentId);
		if(department == null) return false;

		if(pr.save(new Person(id, name, birthday, gender, phone, company, department)) == null) return false;

		return true;
	}

	public boolean modify(Long id, String name, Date birthday,
	                      Gender gender, String phone, Long companyId,
	                      Long departmentId) {
		Person p = pr.findOne(id);
		if(p == null) return false;

		Company c = cr.findOne(companyId);
		if(c == null) return false;

		Department d = dr.findOne(departmentId);
		if(d == null) return false;

		Person np = new Person(id, name, birthday, gender, phone, c, d);
		if(pr.save(np) == null) return false;

		return true;
	}

	public boolean remove(Long id) {
		if(pr.findOne(id) == null) return false;

		pr.delete(id);
		return true;
	}

	public List<Person> findByLastName(String lastName) {
		List<Person> people = pr.findByLastName(lastName);
		return people;
	}

	public List<Person> findByBirthdayBefore(Date date) {
		List<Person> people = pr.findByBirthdayBefore(date);
		return people;
	}

	public List<Person> findByCompany(String companyName) {
		Company c = cr.findByName(companyName);
		if(c == null) return null;

		List<Person> employees =  pr.findByCompany(c);
		return employees;
	}
}
