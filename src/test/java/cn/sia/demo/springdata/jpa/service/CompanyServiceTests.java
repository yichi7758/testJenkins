package cn.sia.demo.springdata.jpa.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import cn.sia.demo.springdata.jpa.domain.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTests {

	@Autowired
	private CompanyService cs;


	/*
	 * test case: add new company
	 * verify company creation service return true.
	 * verify company size.
	 */
	@Test
	public void addCompany() throws Exception {

		List<Company> companies = cs.searchAll();
		int originalCompanySize = companies.size();

		boolean res = cs.create(7L, "newCompany");
		assertThat(res, is(true));

		companies = cs.searchAll();
		assertEquals(originalCompanySize+1, companies.size());
	}

	/*
	 * test case: delete a company.
	 * verify company remove method execution.
	 * verify the size of company
	 */
	@Test
	public void removeCompany() throws Exception {

		List<Company> companies = cs.searchAll();
		int origSize = companies.size();

		boolean res = cs.remove(7L);
		assertEquals(true, res);

		companies = cs.searchAll();
		assertThat(companies.size(), is(origSize-1));
	}


	/*
	 * test case: modify a company.
	 * change a company name, then verify the company name changed.
	 */
	@Test
	public void modifyCompany() throws Exception {

		Company com = new Company(1L, "newCompany");
		boolean res = cs.modify(1L, com);
		assertEquals(true, res);
		com = cs.search(1L);
		assertEquals(true, com != null);
		assertEquals("newCompany", com.getName());
	}

	/*
	 * test case: find a company.
	 * find record 2, check the value.
	 */
	@Test
	public void searchCompany() throws Exception {
		Company c = cs.search(2L);
		assertThat(c != null, is(true));
	}
}
