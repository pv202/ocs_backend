package web.capg.web.CustomerService.service;

import java.util.List;

import web.capg.web.CustomerService.dto.IssueDto;
import web.capg.web.CustomerService.dto.OperatorDto;
import web.capg.web.CustomerService.dto.SolutionDto;
import web.capg.web.CustomerService.entity.Customer;
import web.capg.web.CustomerService.entity.Issue;
import web.capg.web.CustomerService.entity.Operator;
import web.capg.web.CustomerService.entity.Solution;


public interface IOperatorService {
	public String operatorlogin(String email, String password);
	public Issue modifyCustomerIssue(Issue issue) ;
	public Issue addCustomerIssue(IssueDto issueDto);
	public Issue closeCustomerIssue(Integer Id) ;
	public Customer findCustomerById(Integer id);
	public List<Customer> findCustomerByName(String firstName);
	public Customer findCustomerByEmail(String email) ;
	public Solution addSolution(SolutionDto solutiondto); 
	public boolean addOperator(OperatorDto operatordto);
	public String changePassword(OperatorDto operatordto);
	public List<Issue> ViewAllIssues(Integer code);
	public Solution modifySolution(Solution sol);  
}
