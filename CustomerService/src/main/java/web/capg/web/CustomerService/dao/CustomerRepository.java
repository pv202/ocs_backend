package web.capg.web.CustomerService.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.capg.web.CustomerService.entity.Customer;




@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findByFirstName(String firstName);
	public Customer findByEmail(String email);
	@Query(value="from Customer cust where cust.email=?1")
	public Customer checkCustomer(String email);
	@Query(value="from Customer cust where cust.password=?1")
	public Customer checkCustomerbyPassowrd(String password);
}
