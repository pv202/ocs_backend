package web.capg.web.CustomerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.capg.web.CustomerService.entity.Department;

@Repository
public interface DepartmentRepositry extends JpaRepository<Department , Integer>{
	@Query(value = "from Department dept where dept.departmentID=?1")
	public Department getDeptById(Integer code);
	
	@Query(value="from Department dept where dept.departmentName=?1")
	public Department checkDept(String name);

	}
