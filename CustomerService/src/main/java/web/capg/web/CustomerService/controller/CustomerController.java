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
import web.capg.web.CustomerService.dao.*;
import web.capg.web.CustomerService.dao.IssueRepositry;
import web.capg.web.CustomerService.entity.*;
import web.capg.web.CustomerService.service.*;
@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {  
	@Autowired
	CustomerService service;
    
     @Autowired 
     IssueRepositry idao;
     @Autowired
     CustomerRepository customerDao;
     @PostMapping("/login/{email}/{password}") //Takes  Login in credentials and shows successful or  not
	public ResponseEntity<String> loginValidation(@Valid @PathVariable String email,@Valid @PathVariable String password)throws InvalidCredentialException {
		String str=service.customerLogin(email,password);
		if(str==null) {
			throw new InvalidCredentialException();
		}
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
     
	@PostMapping("/addCustomer") //adds customer for given input data given
	public String registerCustomer(@Valid @RequestBody Customer customer) {
		Customer cust = customerDao.checkCustomer(customer.getEmail());
		if(cust!=null)
		{
		throw new CustomerAlreadyExistingException();
		}
		service.registerCustomer(customer);
		return "Customer added";
		}
   
	@GetMapping("/viewAllIssue/{code}") //shows Issue having given id value and exception if it does not exist
	public ResponseEntity<List<Issue>> viewIssuesById(@PathVariable Integer code) throws IssueNotFoundException{
		List<Issue> response=service.viewAllIssuesById(code);
		if(!idao.findById(code).isPresent())
			throw new IssueNotFoundException();
		else
			return new ResponseEntity<List<Issue>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/viewSolutionsById/{code}") //Shows solution for given ID and exception if the ID value given does not exist
	public ResponseEntity<List<Solution>> viewSolutionsById(@PathVariable Integer code) throws SolutionNotFoundException{
		List<Solution> response=service.viewSolutionsById(code);
		if (response!=null)
			return new ResponseEntity<List<Solution>>(response,HttpStatus.OK);
		else 
			throw new SolutionNotFoundException();
	}
	@GetMapping("/Solutionsbyissueid/{code}")  //displays the solution table
	public ResponseEntity<Solution> ViewAllSolution(@PathVariable Integer code ) throws SolutionNotFoundException{
		Solution issues=service.ViewAllSolutions(code);
		if(issues!=null)
		    return new ResponseEntity<Solution>(issues,HttpStatus.OK);
		else 
			throw new SolutionNotFoundException();
	}
	@PutMapping("/ChangePassword")  //for given login credentials allows to update password
	public String changePassword(@RequestBody Customer customer) {
		if(!customerDao.existsById(customer.getCustomerId()))
			throw new CustomerNotFoundException();
		service.changePassword(customer);
		return "Updated";
	}
	@PutMapping("/reopenissue/{id}")  //re-activates issue for given id and exception if value does not exist
	public ResponseEntity<Issue> changeIssueStatus(@PathVariable Integer id) throws IssueNotFoundException {
		if(!idao.findById(id).isPresent())
			throw new IssueNotFoundException();
		else {
		Issue issues=service.reOpenIssue(id);
		return new ResponseEntity<Issue>(issues,HttpStatus.OK);
		}
		}
	@GetMapping("/issue/{id}")
	public ResponseEntity<Issue> ViewIssueById(@PathVariable Integer id) throws IssueNotFoundException{
		Issue issues = service.viewIssuesById(id);
		if(issues==null) {
			throw new IssueNotFoundException();
		}
		else {
		return  new ResponseEntity<Issue>(issues,HttpStatus.OK);
		}
	}

}


