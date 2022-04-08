package web.capg.web.CustomerService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import web.capg.web.CustomerService.dao.DepartmentRepositry;
import web.capg.web.CustomerService.Exception.*;
import web.capg.web.CustomerService.dao.*;
import web.capg.web.CustomerService.entity.*;
import web.capg.web.CustomerService.service.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {    //Admin is one of the three actors
	@Autowired
	AdminService service;
	@Autowired
	DepartmentRepositry deptDao;
	@Autowired
	OperatorRepository operDao;
	
	@PostMapping("/addDepartment")    // adds department for whatever values given to the members
	public String addDepartment(@Valid @RequestBody Department department) {
		Department dept=deptDao.checkDept(department.getDepartmentName());
		if(dept!=null)
		{
			throw new DepartmentAlreadyExistException();
		}
		service.addDepartment(department);
		return "Department added";
	
	}
	@DeleteMapping("/deleteDepartment/{code}")  //deletes the department having the given departmentID(integer given as ip)
	public String deleteDepartment(@PathVariable Integer code) throws DepartmentNotFoundException{
		if(deptDao.existsById(code)) {
			service.removeDepartment(code);
			return "Deleted";
		}
		else {
			throw new DepartmentNotFoundException();
		}
	}
	@PostMapping("/updateDepartment")    // Makes modification to department without altering primarykey and throws exception if ID not found
	public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department) throws DepartmentNotFoundException{
		if(deptDao.existsById(department.getDepartmentID())) {
			Department dept=deptDao.checkDept(department.getDepartmentName());
			if(dept!=null)
			{
				throw new DepartmentAlreadyExistException();
			}
			else {
				Department depart=service.modifyDepartment(department);
				return new ResponseEntity<Department>(depart,HttpStatus.OK);
			}
		}
		else {
			throw new DepartmentNotFoundException();
		}
	}
	@GetMapping("/findDepartment")   //Finds and shows department having given ID and throws exception if no ID number is found
	public ResponseEntity<Department> findDepartment(@RequestBody Integer code) throws DepartmentNotFoundException{
		if(deptDao.existsById(code)) {
			Department depart=service.findDepartmentById(code);
			return new ResponseEntity<Department>(depart,HttpStatus.OK);
		}
		else {
			throw new DepartmentNotFoundException();
		}
	}
	
	@DeleteMapping("/deleteOperator/{code}") //Deletes operator having given operatorID and throws exception if integer passed does not match any existing Id no 
	public String deleteOperator(@PathVariable Integer code) throws OperatorNotFoundException{
		if(operDao.existsById(code)) {
		service.removeOperator(code);
		return "Deleted";
		}
		else {
			throw new OperatorNotFoundException();
		}
	}
	@GetMapping("/findOperator/{code}") //Finds and shows operator having given operatorID and throws exception otherwise
	public ResponseEntity<Operator> findOperator(@PathVariable Integer code) throws OperatorNotFoundException{
		if(operDao.existsById(code)) {
			Operator operator=service.findOperator(code);
			return new ResponseEntity<Operator>(operator,HttpStatus.OK);
		}
		else {
			throw new OperatorNotFoundException();
		}
	}
	@GetMapping("/allOperators") //shows the list of operators or else gives exception if there are no operators
	public ResponseEntity<List<Operator>> findAll() throws OperatorNotFoundException{
		List<Operator> operators=service.findAllOperators();
		if(operators.size()>0) {
			return new ResponseEntity<List<Operator>>(operators,HttpStatus.OK);
		}
		else {
			throw new ListEmptyException();
		}
	}
	@PutMapping("/updateOperator")  //Modifies or updates for given ID number or exception otherwise
	public ResponseEntity<Operator> updateOperator(@Valid @RequestBody Operator operator) throws OperatorNotFoundException{
		if(operDao.existsById(operator.getOperatorId())) {
			Operator oper=service.modifyOperator(operator);
			return new ResponseEntity<Operator>(oper,HttpStatus.OK);
		}
		else {
			throw new OperatorNotFoundException();
		}
		
	}

	@GetMapping("/allDepartments") //Displays all departments and exception if table is empty
	public ResponseEntity<List<Department>> findAll1(){
		List<Department> response=service.findAllDepartments();
		if(response.size()>0) {
			return new ResponseEntity<List<Department>>(response,HttpStatus.OK);
		}
		else {
			throw new ListEmptyException();
		}
	}
	
}
