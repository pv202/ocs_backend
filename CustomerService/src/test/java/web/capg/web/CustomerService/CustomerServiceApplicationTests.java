package web.capg.web.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.capg.web.CustomerService.Exception.CustomerAlreadyExistingException;
import web.capg.web.CustomerService.Exception.*;
import web.capg.web.CustomerService.dao.CustomerRepository;
import web.capg.web.CustomerService.dao.DepartmentRepositry;
import web.capg.web.CustomerService.dao.IssueRepositry;
import web.capg.web.CustomerService.dao.OperatorRepository;
import web.capg.web.CustomerService.dao.SolutionRepository;
import web.capg.web.CustomerService.dto.OperatorDto;
import web.capg.web.CustomerService.entity.*;
import web.capg.web.CustomerService.entity.Issue;
import web.capg.web.CustomerService.entity.Role;
import web.capg.web.CustomerService.service.AdminService;
import web.capg.web.CustomerService.service.CustomerService;
import web.capg.web.CustomerService.service.OperatorService;

@SpringBootTest
class CustomerServiceApplicationTests {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private IssueRepositry issuerepositiry;
	@Autowired
	private SolutionRepository solutionrepositiry;
	@Autowired
	private OperatorRepository operatorRepository;
	@Autowired
	private DepartmentRepositry departmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private IssueRepositry issueRepository;
//	@Test
//	public void testAddCustomer() {
//		Customer customer=new Customer();
//		customer.setPassword("nik@123");
//		customer.setFirstName("Nikhil");
//		customer.setLastName("Naik");
//		customer.setEmail("nik@gmail.com");
//		customer.setMobile("9988776655");
//		customer.setCity("Mangalore");
//		customerService.registerCustomer(customer);
//		Assertions.assertNotNull(customer.getCustomerId());
//	}
//	@Test
//	public void testfindIssueById() throws IssueNotFoundException {
//		Issue issue=issuerepositiry.findById(2).get();
//		assertEquals(2, issue.getIssueId());
//	}
//	@Test
//	public void testfindSolutionById() throws SolutionNotFoundException {
//		Solution issue=solutionrepositiry.findById(1).get();
//		Assertions.assertNotNull(issue.getSolutionId());
//		assertEquals(1, issue.getSolutionId());
//	}
//	@Test
//	public void testAddOperator() {
//		OperatorDto customer=new OperatorDto();
//		customer.setPassword("nik@123");
//		customer.setFirstName("Nikhil");
//		customer.setLastName("Naik");
//		customer.setEmail("nikil@gmail.com");
//		customer.setMobile("9988776655");
//		customer.setCity("Mangalore");
//		customer.setDepartmentID(1);
//		boolean newCustomer = operatorService.addOperator(customer);
//		Assertions.assertNotNull(customer.getOperatorId());
//		assertEquals(true,newCustomer);
//	}
//	@Test
//	public void findOperatorById() throws OperatorNotFoundException {
//		Operator operator = operatorRepository.findById(1).get();
//		assertEquals(1, operator.getOperatorId());
//	}
//	@Test
//	public void modifyDepartmentTest() {
//		Department newDepartment = departmentRepository.findById(1).get();
//		newDepartment.setDepartmentName("HR");
//		Department savedDepartment = adminService.modifyDepartment(newDepartment);
//		assertEquals(newDepartment.getDepartmentName(), savedDepartment.getDepartmentName());
//	}
//
//	@Test
//	public void addIssueTest() {
//		Issue issue = new Issue("Recharge not done", "Money deducted but recharge not done", "Pending");
//		Issue newIssue = operatorService.addCustomerIssue(issue);
//		assertEquals(issue.getIssueId(), newIssue.getIssueId());
//	}
//
//	@Test
//	public void testAddDepartment() throws DepartmentNotFoundException {
//		Department department=new Department();
//		department.setDepartmentName("Marketing");
//		boolean newDepartment = adminService.addDepartment(department);
//		Assertions.assertNotNull(department.getDepartmentID());
//		assertEquals(true,newDepartment);
//	}
//
//
//	@Test
//	public void removeCustomerTest() {
//		User user = userRepository.findById(13).get();
//		boolean newUser = operatorService.removeCustomer(user.getCustomerId());
//		assertEquals(false, newUser);
//	}
	@Test
	public void closeCustomerIssueTest() {
		Issue issue = issueRepository.findById(3).get();
		Issue newIssue = operatorService.closeCustomerIssue(issue.getIssueId());
		assertEquals("Closed", newIssue.getIssueStatus());
	}
//
//	@Test
//	public void addIssueSolutionTest() {
//		Date solutionDate = new Date();
//		Solution solution = new Solution("please contact after 2 days", solutionDate);
//		Solution newSolution = operatorService.addIssueSolution(solution);
//		assertEquals(solution.getSolutionDescription(), newSolution.getSolutionDescription());
//	}
//
//	@Test
//	public void removeDepartmentTest() throws DepartmentNotFoundException {
//		Department department = departmentRepository.findById(5).get();
//		boolean newDepartment = adminService.removeDepartment(department.getDepartmentID());
//		assertEquals(true, newDepartment);
//	}
//
//	@Test
//	public void findDepartmentByIdTest() {
//		Department department = departmentRepository.findById(1).get();
//		assertEquals(1, department.getDepartmentId());
//	}
//	@Test
//	public void findOperatorByIdTest() {
//		Operator operator = operatorRepository.findById(3).get();
//		assertEquals(3, operator.getOperatorId());
//	}
//	@Test
//	public void modifyCustomerIssueTest() {
//		Issue issue = issueRepository.findById(22L).get();
//		issue.setSolution(new Solution(14L, null, null,
//				new Operator(12, null, null, null, null, null, null, new Department(20, null))));
//		Issue savedIssue = operatorService.modifyCustomerIssue(issue);
//		assertEquals(issue.getIssueType(), savedIssue.getIssueType());
//	}
//	@Test
//	public void testfindCustomerById() throws CustomerNotFoundException {
//		Customer customer=customerRepository.findById(1).get();
//		Assertions.assertNotNull(customer.getCustomerId());
//		assertEquals(1, customer.getCustomerId());;
//	}
//	
//	@Test
//	public void testfindCustomerByEmail() throws CustomerNotFoundException {
//		Customer customer=customerRepository.checkCustomer("nik@gmail.com");
//		assertEquals("nik@gmail.com", customer.getEmail());
//	}
	//Testing getAllOperator method
//	@Test
//	public void testGetAllOperator() throws OperatorNotFoundException {
//		List<Operator> operators=operatorRepository.findAll();
//		assertEquals(3,operators.size());
//	}
//	@Test
//	public void testGetAllDepartments() throws DepartmentNotFoundException {
//		
//	List<Department> list = adminService.findAllDepartments();
//	Assertions.assertEquals(2, list.size());
//	}
//	@Test
//	public void testRemoveOperator() throws DepartmentNotFoundException {
//		Operator operator = new Operator();
//		adminService.removeOperator(4);
//		assertEquals(true,!(operatorRepository.existsById(operator.getOperatorId())));
//	}	
		 
		
	


}
