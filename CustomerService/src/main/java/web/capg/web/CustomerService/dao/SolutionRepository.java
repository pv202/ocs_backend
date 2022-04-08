package web.capg.web.CustomerService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.capg.web.CustomerService.entity.Solution;

@Repository
public interface SolutionRepository extends JpaRepository<Solution , Integer>{
	@Query(value = "from Solution solution where solution.operator.operatorId=?1")
	public List<Solution> getSolutionByOpId(Integer code);
	
	@Query(value="from Solution solution where solution.issue.issueId=?1")
	public Solution getSolutionbyIssueId(Integer code);
}

