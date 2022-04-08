package web.capg.web.CustomerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.capg.web.CustomerService.entity.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator , Integer>{
	
	
	
	@Query(value = "from Operator operator where operator.email=?1")
	public Operator checkoperator(String email);
	@Query(value = "from Operator operator where operator.password=?1")
	public Operator checkoperatorbyPassowrd(String password);
}
