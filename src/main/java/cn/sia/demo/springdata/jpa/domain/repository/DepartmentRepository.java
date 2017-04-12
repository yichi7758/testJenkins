package cn.sia.demo.springdata.jpa.domain.repository;

import org.springframework.data.repository.CrudRepository;
import cn.sia.demo.springdata.jpa.domain.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
