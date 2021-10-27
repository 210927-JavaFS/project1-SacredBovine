package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="ers_reimbursement_status")
public class ReimbStatus {
	
	@Id
	@Column (name="reimb_status_id")
	private int statusId;
	@Column (name="reimb_status")
	private String status;
	
	public ReimbStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(status, statusId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbStatus other = (ReimbStatus) obj;
		return Objects.equals(status, other.status) && statusId == other.statusId;
	}
	@Override
	public String toString() {
		return "ReimbStatus [statusId=" + statusId + ", " + (status != null ? "status=" + status : "") + "]";
	}


}
