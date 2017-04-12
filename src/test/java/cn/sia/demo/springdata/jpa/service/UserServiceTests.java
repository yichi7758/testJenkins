package cn.sia.demo.springdata.jpa.service;

import cn.sia.demo.springdata.jpa.domain.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.sia.demo.springdata.jpa.domain.model.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	PersonService ps;

	private Date getDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * test case: create a person
	 * verify the orig person service size.
	 * create new person.
	 * check new size.
	 */
	@Test
	public void createPerson() throws Exception {

		List<Person>people = ps.searchAll();
		int origSize = people.size();

		boolean res = ps.create(15L, "newuser", getDate("2000-01-01"), Gender.MALE,
			"1234567890", 1L, 1L);

		assertThat(res, is(true));

		people = ps.searchAll();
		assertEquals(origSize+1, people.size());
	}

	/*
	 * test case: modify a person
	 * change person name, verify name changed.
	 */
	@Test
	public void modifyPerson() throws Exception {
		Person p = ps.search(1L);
		assertEquals(true, p != null);

		boolean res = ps.modify(1L, "newPersonName", p.getBirthday(), p.getGender(), p.getPhone(), p.getCompany().getId(), p.getDepartment().getId());
		assertEquals(true, res);

		p = ps.search(1L);
		assertEquals("newPersonName", p.getName());
	}

	/*
     * test case: remove a person
     * verify the orig person service size.
	 * remove a person.
	 * check new size.
	 */
	@Test
	public void removePerson() throws Exception {
		List<Person>people = ps.searchAll();
		int origSize = people.size();

		boolean res = ps.remove(12L);

		assertThat(res, is(true));

		people = ps.searchAll();
		assertEquals(origSize-1, people.size());
	}


	/*
	 * test case: find a person by lastname
	 * find last name is wang, check the number of the people
	 * create new person.
	 * check new size.
	 */
	@Test
	public void findPeopleByLastName() {
		List<Person> people = ps.findByLastName("wang");
		assertEquals(6, people.size());
	}

	/*
	 * test case: create a person
	 * verify the orig person service size.
	 * create new person.
	 * check new size.
	 */
	@Test
	public void findPeopleByBirthdayBefore() {
		List<Person> people = ps.findByBirthdayBefore(getDate("1985-03-01"));
		assertEquals(8, people.size());
	}

	/*
	 * test case: create a person
	 * verify the orig person service size.
	 * create new person.
	 * check new size.
	 */
	@Test
	public void findPeopleByCompany() {
		List<Person> people = ps.findByCompany("huawei");
		assertEquals(4, people.size());
	}
}
