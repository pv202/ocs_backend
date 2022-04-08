package web.capg.web.CustomerService.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class SolutionDto {
	private Integer solutionId;
	@NotNull (message="This field cannot be empty")
	private String solutionDescription;
	//@NotNull (message="This field cannot be empty")
	private LocalDate solutionDate;
	@NotNull (message="This field cannot be empty")
	private Integer issueId;
	@NotNull (message="This field cannot be empty")
	private int operatorId;
	@NotNull (message="This field cannot be empty")
	private Integer customerId;
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
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public SolutionDto(Integer solutionId, String solutionDescription, LocalDate solutionDate, Integer issueId, Integer operatorId,Integer customerId) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.solutionDate = solutionDate;
		this.issueId = issueId;
		this.operatorId = operatorId;
		this.customerId=customerId;
	}
	public SolutionDto() {}
}
