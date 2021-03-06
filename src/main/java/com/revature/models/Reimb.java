package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="ers_reimbursement")
public class Reimb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="reimb_id")
	private int reimbId;
	@Column (name="reimb_amount")
	private double reimbAmount;
	@Column (name="reimb_submitted")
	private Timestamp reimbSubmitted;
	@Column (name="reimb_resolved")
	private Timestamp reimbResolved;
	@Column (name="reimb_description")
	private String reimbDescription;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="reimb_author", referencedColumnName="ers_user_id")
	private User reimbAuthor;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="reimb_resolver", referencedColumnName="ers_user_id")
	private User reimbResolver;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="statusId")
	private ReimbStatus reimbStatus;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="typeId") 
	private ReimbType reimbType;
	
	public Reimb() {
		super();
	}
	public Reimb(double reimbAmount, String reimbDescription, User reimbAuthor, ReimbStatus reimbStatus,
			ReimbType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	public Reimb(int reimbId, double reimbAmount, String reimbDescription, User reimbAuthor, ReimbStatus reimbStatus,
			ReimbType reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	public Reimb(double reimbAmount, Timestamp reimbSubmitted, String reimbDescription, User reimbAuthor,
			ReimbStatus reimbStatus, ReimbType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public User getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(User reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public User getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(User reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public ReimbStatus getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(ReimbStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public ReimbType getReimbType() {
		return reimbType;
	}
	public void setReimbType(ReimbType reimbType) {
		this.reimbType = reimbType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbAuthor, reimbDescription, reimbId, reimbResolved, reimbResolver,
				reimbStatus, reimbSubmitted, reimbType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimb other = (Reimb) obj;
		return reimbAmount == other.reimbAmount && Objects.equals(reimbAuthor, other.reimbAuthor)
				&& Objects.equals(reimbDescription, other.reimbDescription) && reimbId == other.reimbId
				&& Objects.equals(reimbResolved, other.reimbResolved)
				&& Objects.equals(reimbResolver, other.reimbResolver) && Objects.equals(reimbStatus, other.reimbStatus)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && Objects.equals(reimbType, other.reimbType);
	}
	
	@Override
	public String toString() {
		return "Reimb [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", "
				+ (reimbSubmitted != null ? "reimbSubmitted=" + reimbSubmitted + ", " : "")
				+ (reimbResolved != null ? "reimbResolved=" + reimbResolved + ", " : "")
				+ (reimbDescription != null ? "reimbDescription=" + reimbDescription + ", " : "")
				+ (reimbAuthor != null ? "reimbAuthor=" + reimbAuthor + ", " : "")
				+ (reimbResolver != null ? "reimbResolver=" + reimbResolver + ", " : "")
				+ (reimbStatus != null ? "reimbStatus=" + reimbStatus + ", " : "")
				+ (reimbType != null ? "reimbType=" + reimbType : "") + "]";
	}
}