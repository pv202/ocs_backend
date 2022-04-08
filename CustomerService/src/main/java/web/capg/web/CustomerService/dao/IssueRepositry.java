package web.capg.web.CustomerService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.capg.web.CustomerService.entity.Issue;


@Repository
public interface IssueRepositry extends JpaRepository<Issue , Integer>{
	@Query(value = "from Issue issue where issue.issueId=?1")
	public Issue getIssueById(Integer code);
	
//	@Query(value="from Issue issue where issue.operator.operatorId=?1")
//	public List<Issue> getOpIssue(int code);
	
	@Query(value="from Issue issue where issue.customer.customerId=?1")
	public List<Issue> getCustIssue(Integer code);
	
}
