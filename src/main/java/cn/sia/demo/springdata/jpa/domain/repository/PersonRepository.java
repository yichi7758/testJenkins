package cn.sia.demo.springdata.jpa.domain.repository;

import cn.sia.demo.springdata.jpa.domain.model.Company;
import cn.sia.demo.springdata.jpa.domain.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

	@Query(value = "SELECT * FROM person WHERE NAME LIKE ?1%", nativeQuery = true)
	List<Person> findByLastName(String lastName);

	List<Person> findByBirthdayBefore(Date date);

	List<Person> findByCompany(Company company);
}
