package web.capg.web.CustomerService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.capg.web.CustomerService.Exception.InvalidCredentialException;
import web.capg.web.CustomerService.dao.CustomerRepository;
import web.capg.web.CustomerService.dao.DepartmentRepositry;
import web.capg.web.CustomerService.dao.IssueRepositry;
import web.capg.web.CustomerService.dao.OperatorRepository;
import web.capg.web.CustomerService.dao.SolutionRepository;
import web.capg.web.CustomerService.dto.IssueDto;
import web.capg.web.CustomerService.dto.OperatorDto;
import web.capg.web.CustomerService.dto.SolutionDto;
import web.capg.web.CustomerService.entity.Customer;
import web.capg.web.CustomerService.entity.Department;
import web.capg.web.CustomerService.entity.Issue;
import web.capg.web.CustomerService.entity.Operator;
import web.capg.web.CustomerService.entity.Solution;
@Service
public class OperatorService implements IOperatorService{
@Autowired
CustomerRepository customerDao;
@Autowired
IssueRepositry issueDao;
@Autowired
OperatorRepository operatorDao;
@Autowired
SolutionRepository solutionDao;
//@Autowired
//ChatDao chatDao;
@Autowired
DepartmentRepositry departMentDao;
//Add customer method
@Override
public Issue addCustomerIssue(IssueDto issueDto){
	Issue issues=new Issue();
	issues.setIssueStatus(issueDto.getIssueStatus());
	issues.setIssueType(issueDto.getIssueType());
	issues.setDescription(issueDto.getDescription());
	Customer cust=customerDao.findById(issueDto.getCustomerID()).get();
	Operator op=operatorDao.findById(issueDto.getOperatorId()).get();
	issues.setCustomer(cust);
	issues.setOperator(op);
	return issueDao.save(issues);		
}
@Override
public boolean addOperator(OperatorDto operatordto){
	Operator operator=new Operator();
	operator.setFirstName(operatordto.getFirstName());
	operator.setLastName(operatordto.getLastName());
	operator.setEmail(operatordto.getEmail());
	operator.setCity(operatordto.getCity());
	operator.setMobile(operatordto.getMobile());
	operator.setPassword(operatordto.getPassword());
	Department dept=departMentDao.getById(operatordto.getDepartmentID());
	operator.setDepartment(dept);
	operatorDao.save(operator);
	return true;
}

//closing customer issue
@Override
public Issue closeCustomerIssue(Integer Id){	
	Issue result=issueDao.getById(Id);
	result.setIssueStatus("Closed");
	issueDao.save(result);
	return result;
}
//modifying issue
@Override
public Issue modifyCustomerIssue(Issue issue){
	int id=issue.getIssueId();
	Issue result=issueDao.getById(id);
	result.setDescription(issue.getDescription());
	result.setIssueType(issue.getIssueType());
	result.setIssueStatus(issue.getIssueStatus());
	issueDao.save(result);
	return result;
}

//finding customer using Id
@Override
public Customer findCustomerById(Integer id){
	return customerDao.findById(id).get();
}
//finding customer by Name
@Override
public List<Customer> findCustomerByName(String firstName)
{
	return customerDao.findByFirstName(firstName);
}

//finding customer by Email
@Override
public Customer findCustomerByEmail(String email)
{
	return customerDao.findByEmail(email);
}
//adding solution by operator
@Override
public Solution addSolution(SolutionDto solutiondto){
	Solution soln=new Solution();
	LocalDate todaysDate = LocalDate.now();
	soln.setSolutionDate(todaysDate);
	soln.setSolutionDescription(solutiondto.getSolutionDescription());
	Operator operator=operatorDao.findById(solutiondto.getOperatorId()).get();
     soln.setOperator(operator);
	Issue issue=issueDao.getById(solutiondto.getIssueId());
	soln.setIssue(issue);
	Customer customer=customerDao.findById(solutiondto.getCustomerId()).get();
	soln.setCustomer(customer);
	return solutionDao.save(soln);
}
@Override
public String operatorlogin(String email, String password) {
	Operator local = operatorDao.checkoperator(email);
	Operator localpassword = operatorDao.checkoperatorbyPassowrd(password);
	if (local != null && localpassword!=null) {
		
			return "login sucessful";

	} else {
		throw new InvalidCredentialException();
	}
}

@Override
public String changePassword(OperatorDto operatordto) {
	Integer id=operatordto.getOperatorId();
	Operator dto=operatorDao.findById(id).get();
	dto.setPassword(operatordto.getPassword());
	operatorDao.save(dto);
	return "updated";
}
@Override
public List<Issue> ViewAllIssues(Integer code) {
	List<Issue> response=issueDao.getCustIssue(code);
	return response;
}
@Override
public Solution modifySolution(Solution sol) {
	int id=sol.getSolutionId();
	Solution solution=solutionDao.findById(id).get();
	solution.setSolutionDescription(sol.getSolutionDescription());
	//solution.setSolutionDate(sol.getSolutionDate());
	solutionDao.save(solution);
	return solution;  
}

}
