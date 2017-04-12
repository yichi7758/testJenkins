package cn.sia.demo.springdata.jpa.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sia.demo.springdata.jpa.domain.model.Department;
import cn.sia.demo.springdata.jpa.domain.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements BaseService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DepartmentRepository dr;

	public boolean create(Long id, String name) {

		if(dr.save(new Department(id, name)) == null) return false;

		return true;
	}

	public List<Department> searchAll() {
		List<Department>companies = new ArrayList<>();
		dr.findAll().forEach(companies::add);
		return companies;
	}

	public boolean remove(Long id) {
		if(dr.findOne(id) == null) return false;
		dr.delete(id);
		return true;
	}

	public boolean modify(Long id, Department com) {
		Department c = dr.findOne(id);
		if(c == null) return false;

		if(!com.getName().isEmpty()) {
			if(com.getName().equals(c.getName())) {
				return false;
			} else {
				c.setName(com.getName());
				dr.save(c);
				return true;
			}
		} else {
			return false;
		}
	}

	public Department search(Long id) {
		return dr.findOne(id);
	}
}
