package web.capg.web.CustomerService.entity;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="solution")
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="solutionId")
	private Integer solutionId;
	@Column
	@NotNull (message="This field cannot be empty")
	private String solutionDescription;
	@Column
	//@NotNull (message="This field cannot be empty")
	private LocalDate solutionDate;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", referencedColumnName = "issueId")
	private Issue issue;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operatorId", referencedColumnName = "operatorId")
	private Operator operator;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;
   
	public Solution()
    {
    }
	public Solution(int solutionId, String solutionDescription, LocalDate solutionDate) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.solutionDate = solutionDate;
	}
	 public void setCustomer(Customer customer) {
			this.customer = customer;
		}
	/*public Operator getOperator() {
		return operator;
	}*/
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Integer getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}
	public String getSolutionDescription() {
		return solutionDescription;
	}
	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}
	public LocalDate getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(LocalDate solutionDate) {
		this.solutionDate = solutionDate;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}