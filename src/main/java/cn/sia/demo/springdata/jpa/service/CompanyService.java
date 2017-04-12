package cn.sia.demo.springdata.jpa.service;

import cn.sia.demo.springdata.jpa.domain.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import cn.sia.demo.springdata.jpa.domain.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements BaseService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private CompanyRepository cr;

	public boolean create(Long id, String name) {

		if(cr.save(new Company(id, name)) == null) {
			logger.error("create company operation failed.");
			return false;
		}

		logger.info("create company operation success.");
		return true;
	}

	public List<Company> searchAll() {
		List<Company>companies = new ArrayList<>();
		cr.findAll().forEach(companies::add);
		return companies;
	}

	public boolean remove(Long id) {
		if(cr.findOne(id) == null) return false;
		cr.delete(id);
		return true;
	}

	public boolean modify(Long id, Company com) {
		Company c = cr.findOne(id);
		if(c == null) return false;

		if(!com.getName().isEmpty()) {
			if(com.getName().equals(c.getName())) {
				return false;
			} else {
				c.setName(com.getName());
				cr.save(c);
				return true;
			}
		} else {
			return false;
		}
	}

	public Company search(Long id) {
		return cr.findOne(id);
	}
}
