package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class ReimbDTO {

	private int reimbId;
	private int reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatus;
	private int reimbType;
	public ReimbDTO() {
		super();
	}
	
	
	public ReimbDTO(int reimbId, int reimbAmount, Timestamp reimbSubmitted, String reimbDescription) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDescription = reimbDescription;
	}


	public ReimbDTO(int reimbAmount, Timestamp reimbSubmitted, String reimbDescription, int reimbAuthor,
			int reimbStatus, int reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	
	
	public ReimbDTO(int reimbId, int reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, int reimbAuthor, int reimbResolver, int reimbStatus, int reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(int reimbAmount) {
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
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public int getReimbType() {
		return reimbType;
	}
	public void setReimbType(int reimbType) {
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
		ReimbDTO other = (ReimbDTO) obj;
		return reimbAmount == other.reimbAmount && reimbAuthor == other.reimbAuthor
				&& Objects.equals(reimbDescription, other.reimbDescription) && reimbId == other.reimbId
				&& Objects.equals(reimbResolved, other.reimbResolved) && reimbResolver == other.reimbResolver
				&& reimbStatus == other.reimbStatus && Objects.equals(reimbSubmitted, other.reimbSubmitted)
				&& reimbType == other.reimbType;
	}
	@Override
	public String toString() {
		return "ReimbDTO [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", "
				+ (reimbSubmitted != null ? "reimbSubmitted=" + reimbSubmitted + ", " : "")
				+ (reimbResolved != null ? "reimbResolved=" + reimbResolved + ", " : "")
				+ (reimbDescription != null ? "reimbDescription=" + reimbDescription + ", " : "") + "reimbAuthor="
				+ reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus + ", reimbType="
				+ reimbType + "]";
	}
	
	public Reimb toUser() {
		/*User author = new User();
		author.setErsUserID(this.reimbAuthor);
		User resolver = new User();
		resolver.setErsUserID(this.reimbResolver);
		*/
		ReimbStatus status = new ReimbStatus();
		switch (this.getReimbStatus()) {
			case 1 :
				status.setStatusId(1); 
				status.setStatus("pending");
				break;
			case 2 :
				status.setStatusId(2); 
				status.setStatus("approved");
				break;
			case 3 :
				status.setStatusId(3); 
				status.setStatus("denied");
				break;
		}
		
		ReimbType type = new ReimbType();
		switch (this.getReimbType()) {
			case 1: 
				type.setTypeId(1);
				type.setType("lodging");
				break;
			case 2: 
				type.setTypeId(2);
				type.setType("travel");
				break;
			case 3: 
				type.setTypeId(3);
				type.setType("food");
				break;
			case 4: 
				type.setTypeId(4);
				type.setType("other");
				break;
		}
		
		Reimb reimb = new Reimb(this.getReimbId(), this.getReimbAmount(), this.getReimbSubmitted(),// this.getReimbResolved(),
				this.getReimbDescription(), status, type); //, author, resolver, type
		return reimb;
	}
	
	
}
