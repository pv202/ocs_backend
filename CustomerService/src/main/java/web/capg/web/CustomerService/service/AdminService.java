package web.capg.web.CustomerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.capg.web.CustomerService.dao.DepartmentRepositry;
import web.capg.web.CustomerService.dao.OperatorRepository;
import web.capg.web.CustomerService.entity.Department;
import web.capg.web.CustomerService.entity.Operator;

@Service
public class AdminService implements IAdminService{
@Autowired
DepartmentRepositry departMentDao;
@Autowired
OperatorRepository operatorDao;
//adding department
@Override
public boolean addDepartment(Department dept){
	departMentDao.save(dept);
	return true;
}
//removing department
@Override
public boolean removeDepartment(Integer departmentID){
	departMentDao.deleteById(departmentID);
	return !(departMentDao.existsById(departmentID));
	}
//modifying department name
@Override
public Department modifyDepartment(Department dept){
	int id=dept.getDepartmentID();
	Department department=departMentDao.findById(id).get();
	department.setDepartmentName(dept.getDepartmentName());
	departMentDao.save(department);
	return department;
}

//finding department by ID
@Override
public Department findDepartmentById(Integer id){
		return departMentDao.getById(id);
	
}
//removing operator
@Override
public boolean removeOperator(Integer operatorID){ 
	operatorDao.deleteById(operatorID);
	return !(operatorDao.existsById(operatorID));
}
//modifying operator
@Override
public Operator modifyOperator(Operator operator){
	int id=operator.getOperatorId();
	Operator oper=operatorDao.findById(id).get();
	oper.setFirstName(operator.getFirstName());
	oper.setLastName(operator.getLastName());
	oper.setMobile(operator.getMobile());
	oper.setEmail(operator.getEmail());
	oper.setCity(operator.getCity());
	oper.setPassword(operator.getPassword());
	operatorDao.save(oper);
	return oper;
}
//finding operator using ID
@Override
public Operator findOperator(Integer id){
	return operatorDao.findById(id).get();
}
//view all operators
@Override
public List<Operator> findAllOperators(){
	List<Operator> operators = operatorDao.findAll();
	return operators;
}
//view all department
@Override
public List<Department> findAllDepartments(){
	List<Department> departments = departMentDao.findAll();
	return departments;
}

}
