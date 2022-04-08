package web.capg.web.CustomerService.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Call {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long callId;
	@NotNull
	@DateTimeFormat(pattern = "yyyyMMdd")
	private LocalDate callDate;
	@NotNull
	@NotEmpty
	private Double callDuration;
	@NotNull
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;
	@ManyToOne
	private Customer customer;
	@OneToOne
	private Issue issue;
	@ManyToOne
	private Operator receivedBy;

	public Call() {

	}

	public Call(Long callId, LocalDate callDate, Double callDuration, String phoneNumber, Customer customer, Issue issue,
			Operator receivedBy) {
		super();
		this.callId = callId;
		this.callDate = callDate;
		this.callDuration = callDuration;
		this.phoneNumber = phoneNumber;
		this.customer = customer;
		this.issue = issue;
		this.receivedBy = receivedBy;
	}

	public Long getCallId() {
		return callId;
	}

	public void setCallId(Long callId) {
		this.callId = callId;
	}

	public LocalDate getCallDate() {
		return callDate;
	}

	public void setCallDate(LocalDate callDate) {
		this.callDate = callDate;
	}

	public Double getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(Double callDuration) {
		this.callDuration = callDuration;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public Operator getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(Operator receivedBy) {
		this.receivedBy = receivedBy;
	}
}

