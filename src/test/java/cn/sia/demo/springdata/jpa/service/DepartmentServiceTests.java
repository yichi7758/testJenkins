package cn.sia.demo.springdata.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.sia.demo.springdata.jpa.domain.model.Department;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTests {

	@Autowired
	private DepartmentService ds;


	/*
	 * test case: add new department
	 * verify department creation service return true.
	 * verify department size.
	 */
	@Test
	public void addDepartment() throws Exception {

		List<Department> departments = ds.searchAll();
		int origSize = departments.size();

		boolean res = ds.create(7L, "newDepartment");
		assertThat(res, is(true));

		departments = ds.searchAll();
		assertEquals(origSize+1, departments.size());
	}

	/*
	 * test case: delete a department.
	 * verify department remove method execution.
	 * verify the size of department
	 */
	@Test
	public void removeDepartment() throws Exception {

		List<Department> departments = ds.searchAll();
		int origSize = departments.size();

		boolean res = ds.remove(7L);
		assertEquals(true, res);

		departments = ds.searchAll();
		assertThat(departments.size(), is(origSize-1));
	}


	/*
	 * test case: modify a department.
	 * change a department name, then verify the department name changed.
	 */
	@Test
	public void modifyDepartment() throws Exception {

		Department dep = new Department(1L, "newDepartment");
		boolean res = ds.modify(1L, dep);
		assertEquals(true, res);
		dep = ds.search(1L);
		assertEquals(true, dep != null);
		assertEquals("newDepartment", dep.getName());
	}

	/*
	 * test case: find a department.
	 * find record 2, check the value.
	 */
	@Test
	public void searchDepartment() throws Exception {
		Department c = ds.search(2L);
		assertThat(c != null, is(true));
	}
}
