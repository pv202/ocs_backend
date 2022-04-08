package web.capg.web.CustomerService.dto;

import javax.validation.constraints.NotNull;

public class IssueDto {
	private Integer issueID;
	@NotNull (message="This field cannot be empty")
	private Integer customerID;
	@NotNull (message="This field cannot be empty")
	private String issueType;
	@NotNull (message="This field cannot be empty")
	private String description;
	@NotNull (message="This field cannot be empty")
	private String issueStatus;
	@NotNull (message="This field cannot be empty")
	private Integer operatorId;
	public Integer getIssueID() {
		return issueID;
	}
	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}
	
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomer(Integer customerID) {
		this.customerID = customerID;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public IssueDto(Integer issueID,  Integer customerID, String issueType, String description,
			String issueStatus,Integer operatorId) {
		super();
		this.issueID = issueID;
		this.customerID = customerID;
		this.issueType = issueType;
		this.description = description;
		this.issueStatus = issueStatus;
		this.operatorId=operatorId;
	}
	public IssueDto() {}
	
}
