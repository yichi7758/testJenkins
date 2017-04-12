package cn.sia.demo.springdata.jpa.domain.repository;

import cn.sia.demo.springdata.jpa.domain.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	Company findByName(String name);
}
