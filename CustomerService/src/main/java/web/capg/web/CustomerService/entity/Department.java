package web.capg.web.CustomerService.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="departmentID")
	private Integer departmentID;
	@Column(name="departmentName")
	@NotNull(message="This cannot be empty")
	private String departmentName;
	public Department(Integer departmentID, String departmentName) { // department 
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}
	
	@OneToMany(mappedBy="department")
	private List<Operator> operator;
	public Department() {}
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
