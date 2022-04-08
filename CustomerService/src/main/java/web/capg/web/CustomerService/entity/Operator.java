package web.capg.web.CustomerService.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="operator")
public class Operator {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="operatorId")
		private int operatorId;
		@Column
		@NotNull (message="This field cannot be empty")
		private String firstName;
		@Column
		@NotNull(message="This cannot be empty")
		private String lastName;
		@Column
		@NotNull(message="This cannot be empty")
		@Email
		private String email;
		@Column
		@NotNull(message="This cannot be empty")
		private String mobile;
		@Column
		@NotNull(message="This cannot be empty")
		private String city;
		@Column
		@NotNull(message="This cannot be empty")
		private String password;
		@OneToMany(mappedBy="operator")
		private List<Solution> solution;
		@ManyToOne
	    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID")
		private Department department;
		@OneToMany(mappedBy="operator")
		private List<Issue> issue;
		public Operator()
		{}
		public Operator(Integer operatorId, String firstName, String lastName, String email, String mobile, String city,String password) {
			super();
			this.operatorId = operatorId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobile = mobile;
			this.city = city;
			this.password=password;
		}
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
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		//public Solution getSolution() {
		//	return solution;
		//}
		public void setSolution(List<Solution> solution) {
			this.solution = solution;
		}
		public Department getDepartment() {
			return department;
		}
		public void setDepartment(Department department) {
			this.department = department;
		}
		
		
}