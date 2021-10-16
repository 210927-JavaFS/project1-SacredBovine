package com.revature.models;

import java.util.Objects;

public class Reimb {
	
	private int reimbAmount;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private int reimbAuthor;
	private int reimbResolver;
	private String reimbStatus;
	private String reimbType;
	
	public Reimb(int reimbAmount, String reimbSubmitted, String reimbResolved, String reimbDescription, int reimbAuthor,
			int reimbResolver, String reimbStatus, String reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public int getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
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

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	
	

	@Override
	public String toString() {
		return "Reimb [reimbAmount=" + reimbAmount + ", "
				+ (reimbSubmitted != null ? "reimbSubmitted=" + reimbSubmitted + ", " : "")
				+ (reimbResolved != null ? "reimbResolved=" + reimbResolved + ", " : "")
				+ (reimbDescription != null ? "reimbDescription=" + reimbDescription + ", " : "") + "reimbAuthor="
				+ reimbAuthor + ", reimbResolver=" + reimbResolver + ", "
				+ (reimbStatus != null ? "reimbStatus=" + reimbStatus + ", " : "")
				+ (reimbType != null ? "reimbType=" + reimbType : "") + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbAuthor, reimbDescription, reimbResolved, reimbResolver, reimbStatus,
				reimbSubmitted, reimbType);
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
		return reimbAmount == other.reimbAmount && reimbAuthor == other.reimbAuthor
				&& Objects.equals(reimbDescription, other.reimbDescription)
				&& Objects.equals(reimbResolved, other.reimbResolved) && reimbResolver == other.reimbResolver
				&& Objects.equals(reimbStatus, other.reimbStatus)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && Objects.equals(reimbType, other.reimbType);
	}


}
