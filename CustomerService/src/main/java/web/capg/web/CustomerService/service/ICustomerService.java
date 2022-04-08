package web.capg.web.CustomerService.service;

import java.util.List;


import web.capg.web.CustomerService.entity.Customer;
import web.capg.web.CustomerService.entity.Issue;
import web.capg.web.CustomerService.entity.Solution;

public interface ICustomerService {
	public String customerLogin(String email,String password);
	public Customer registerCustomer(Customer customer);
	public List<Issue> viewAllIssuesById(Integer issueid);
	Issue reOpenIssue(Integer id) ;
	public Issue viewIssuesById(Integer id);
	public Solution ViewAllSolutions(Integer issueId);
	public List<Solution> viewSolutionsById(Integer code) ;	
	public String changePassword(Customer customer);
}
