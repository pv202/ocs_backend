package web.capg.web.CustomerService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.capg.web.CustomerService.Exception.*;
import web.capg.web.CustomerService.dao.CustomerRepository;
import web.capg.web.CustomerService.dao.DepartmentRepositry;
import web.capg.web.CustomerService.dao.IssueRepositry;
import web.capg.web.CustomerService.dao.OperatorRepository;
import web.capg.web.CustomerService.dao.SolutionRepository;
import web.capg.web.CustomerService.dto.IssueDto;
import web.capg.web.CustomerService.dto.OperatorDto;
import web.capg.web.CustomerService.dto.SolutionDto;
import web.capg.web.CustomerService.entity.*;
import web.capg.web.CustomerService.service.OperatorService;

@RestController
@RequestMapping("/operator")
@CrossOrigin(origins="http://localhost:3000")
public class OperatorController {
	@Autowired
	OperatorService service;
	@Autowired
	IssueRepositry issueDao;
	@Autowired
	OperatorRepository operatordao;
	@Autowired
	CustomerRepository customerDao;
	@Autowired
	DepartmentRepositry departmentDao;
	@Autowired
	SolutionRepository solutionDao;
	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<String> loginValidation(@Valid @PathVariable String email,@Valid @PathVariable String password){
		String str=service.operatorlogin(email,password);
		if(str==null)
			throw new InvalidCredentialException();
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@PostMapping("/addOperator")  //adds operator to existing operators
	public String addOperator(@Valid @RequestBody OperatorDto dto) {
		Operator op=operatordao.checkoperator(dto.getEmail());
		if(op!=null)
			throw new OperatorAlreadyExistingException();
		Department department=departmentDao.getDeptById(dto.getDepartmentID());
	    if(department==null)
	    	throw new DepartmentNotFoundException();
		else {
	if(service.addOperator(dto))
		return "operator added";
	else
		return "Could not insert";
	}
	}
	@PostMapping("/addCustomerIssue") //adds customer having given issue(foreign key) 
	public ResponseEntity<Issue> addCustomerIssue(@Valid @RequestBody IssueDto issueDto) {	
		Customer cust=customerDao.findById(issueDto.getCustomerID()).get();
		if(cust==null)
			throw new CustomerNotFoundException();
		Operator op=operatordao.findById(issueDto.getOperatorId()).get();
		if(op==null)
			throw new OperatorNotFoundException();
		else
		{
	Issue response=service.addCustomerIssue(issueDto);
	return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	}
	@PutMapping("/updateCustomerIssue")   //update issue of the customer and exception if input is invalid ie if Id does not exist
	public ResponseEntity<Issue> modifyCustomerIssue(@Valid @RequestBody Issue issue){
		if(!issueDao.existsById(issue.getIssueId()))
			throw new IssueNotFoundException();
		else {
		Issue response=service. modifyCustomerIssue(issue);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	}
	@PutMapping("/closeCustomer/{Id}") // close the customer by changing issue status and exception if issue id does not exist
	public ResponseEntity<Issue> closeCustomerIssue(@PathVariable Integer Id){
		if(!issueDao.existsById(Id))
			throw new IssueNotFoundException();
		else {
		Issue response=service. closeCustomerIssue(Id);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	}
	@GetMapping("/findCustomerById/{code}")  //displays customer having given Id and exception if ID does not match
	public ResponseEntity<Customer> findCustomerById(@PathVariable int code){
		Customer response=service.findCustomerById(code);
		if(response==null)
			throw new CustomerNotFoundException();
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerByName/{name}")  //Takes input as string and shows the detail of customer and exception if name does not exist
	public ResponseEntity<List<Customer>> findCustomerByName(@PathVariable String name){
		List<Customer> response=service.findCustomerByName(name);
		if(response.size()<=0)
			throw new ListEmptyException();
		return new ResponseEntity<List<Customer>>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerByEmail/{email}")  //Takes input as email(text) and shows customer or exception if email does not exist
	public ResponseEntity<Customer> findCustomerByEmail(@PathVariable String email){
		Customer response=service.findCustomerByEmail(email);
		if(response==null)
			throw new CustomerNotFoundException();
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	
	@PostMapping("/addSolution")  //Adds solution having given details and members into the tables
	public ResponseEntity<Solution> addSolution(@Valid @RequestBody SolutionDto solutiondto) {
		Issue issue=issueDao.getIssueById(solutiondto.getIssueId());
		if(issue==null) 
			throw new IssueNotFoundException();
        Operator op=operatordao.findById(solutiondto.getOperatorId()).get();
		if(op==null)
		   throw new OperatorNotFoundException();
		Customer cust=customerDao.findById(solutiondto.getCustomerId()).get();
		if(cust==null)
			throw new CustomerNotFoundException();
			else {
			Solution response=service.addSolution(solutiondto);
			return new ResponseEntity<Solution>(response,HttpStatus.OK);
		}
	}
	@PutMapping("/ChangePassword")  //for given login credentials allows to update password
	public String changePassword(@RequestBody OperatorDto dto){
		if(!operatordao.existsById(dto.getOperatorId()))
			throw new OperatorNotFoundException();
		else {
		service.changePassword(dto);
		return "Updated";
	}
	}
	@GetMapping("/allIssues/{code}") //shows the issue table and exception if table is empty 
	public ResponseEntity<List<Issue>> ViewAllIssues(@PathVariable Integer code) throws IssueNotFoundException{
		List<Issue> issues=service.ViewAllIssues(code);
		if (issues!=null)
			return new ResponseEntity<List<Issue>>(issues,HttpStatus.OK);
		else 
			throw new IssueNotFoundException();
	}
@PutMapping("/updateSol")   //update issue of the customer and exception if input is invalid ie if Id does not exist
public ResponseEntity<Solution> modifySolution(@Valid @RequestBody Solution solution){
	if(!solutionDao.existsById(solution.getSolutionId()))
		throw new SolutionNotFoundException();
	else {
	Solution response=service.modifySolution(solution);
	return 
			new ResponseEntity<Solution>(response,HttpStatus.OK);}
	}
}