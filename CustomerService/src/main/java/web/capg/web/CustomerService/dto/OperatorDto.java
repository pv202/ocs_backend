package web.capg.web.CustomerService.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class OperatorDto {
	private Integer operatorId;
	@NotNull(message="This cannot be empty")
	private String firstName;
	@NotNull(message="This cannot be empty")
	private String lastName;
	@NotNull(message="This cannot be empty")
	@Email
	private String email;
	@NotNull(message="This cannot be empty")
	private String mobile;
	@NotNull(message="This cannot be empty")
	private String city;
	@NotNull(message="This cannot be empty")
	private String password;
	@NotNull(message="This cannot be empty")
	private Integer departmentID;
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public OperatorDto(Integer operatorId, String firstName, String lastName, String email, String mobile, String city,
			Integer departmentID,String password) {
		super();
		this.operatorId = operatorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.departmentID = departmentID;
		this.password=password;
	}
	public OperatorDto(){
		
	}
}
