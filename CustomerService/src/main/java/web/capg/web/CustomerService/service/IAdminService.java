package web.capg.web.CustomerService.service;

import java.util.List;

import web.capg.web.CustomerService.entity.Department;
import web.capg.web.CustomerService.entity.Operator;

public interface IAdminService {
	public boolean addDepartment(Department dept);
	public boolean removeDepartment(Integer departmentID);
	public Department modifyDepartment(Department dept);
	public Department findDepartmentById(Integer id);
	public List<Department> findAllDepartments();
	public boolean removeOperator(Integer operatorID);
	public Operator modifyOperator(Operator operator);
	public Operator findOperator(Integer id);
	public List<Operator> findAllOperators();
	
}
