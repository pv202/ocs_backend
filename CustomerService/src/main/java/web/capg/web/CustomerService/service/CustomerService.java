package web.capg.web.CustomerService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.capg.web.CustomerService.Exception.InvalidCredentialException;
import web.capg.web.CustomerService.dao.CustomerRepository;
import web.capg.web.CustomerService.dao.IssueRepositry;
import web.capg.web.CustomerService.dao.SolutionRepository;
import web.capg.web.CustomerService.entity.Customer;
import web.capg.web.CustomerService.entity.Issue;
import web.capg.web.CustomerService.entity.Operator;
import web.capg.web.CustomerService.entity.Solution;


@Service
public class CustomerService implements ICustomerService{
	@Autowired
	CustomerRepository customerDao;
	@Autowired
	IssueRepositry issueDao;
	@Autowired
	SolutionRepository solutionDao;
	@Override
	public Customer registerCustomer(Customer customer)
	{
		Customer cust= customerDao.save(customer);
		return cust;	
	}
	public Issue viewIssuesById(Integer id) {
		Issue issues=issueDao.findById(id).get();
		return issues;
}
	//view issues using id
	@Override
	public List<Issue> viewAllIssuesById(Integer custid) {
			List<Issue> issues=issueDao.getCustIssue(custid);
			return issues;
	}
	
	//changing issue status
	@Override
	public Issue reOpenIssue(Integer id) {
		Issue result=issueDao.getById(id);
		result.setIssueStatus("Pending");
		issueDao.save(result);
		return result;}
		
	//viewing solution using ID
	@Override
	public List<Solution> viewSolutionsById(Integer opcode) {		
			List<Solution>soln= solutionDao.getSolutionByOpId(opcode);
			return soln;
	}
	//viewing all solution
	@Override
	public Solution ViewAllSolutions(Integer code)  {
		Solution response=solutionDao.getSolutionbyIssueId(code);
		return response;
	}


	@Override
	public String customerLogin(String email,String password) {
		Customer local = customerDao.findByEmail(email);
		Customer localpassword = customerDao.checkCustomerbyPassowrd(password);
		if (local != null && localpassword!=null) {
				return "login sucessfull";
		} else {
			throw new InvalidCredentialException();
		}
	}
	@Override
	public String changePassword(Customer customer) {
		int id=customer.getCustomerId();
		Customer cust=customerDao.findById(id).get();
		cust.setPassword(customer.getPassword());
		customerDao.save(cust);
		return "Updated";
		
	}
}
