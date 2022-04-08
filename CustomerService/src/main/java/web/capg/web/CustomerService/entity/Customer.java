package web.capg.web.CustomerService.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
	private Integer customerId;
	@Column
	@NotNull (message="This field cannot be empty")
	private String firstName;
	@Column
	@NotNull (message="This field cannot be empty")
	private String lastName;
	@Column
	@NotNull(message="This field cannot be empty")
	@Email
	private String email;
	@Column
	@NotNull (message="This field cannot be empty")
	private String mobile;
	@Column
	@NotNull (message="This field cannot be empty")
	private String city;
	@Column
	@NotNull (message="This field cannot be empty")
	private String password;

	@OneToMany(mappedBy="customer")
	private List<Issue> issue;
	@OneToMany(mappedBy="customer")
	private List<Solution> soln;
	private Role role;
	public Customer(Integer customerId, String firstName, String lastName, String email, String mobile, String city,String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.password = password;
	}
	
	public Customer(Integer customerId, String firstName, String lastName, String email, String mobile, String city,
			String password, Role role) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.password = password;
		this.role = role;
	}
	
	public Customer(String firstName, String lastName, String email, String mobile, String city, String password,
			Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.password = password;
		this.role = role;
	}

	public Customer() {}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	
}
