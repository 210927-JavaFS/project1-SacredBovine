package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="ers_reimbursement_type")
public class ReimbType {
	
	@Id
	@Column (name="reimb_type_id")
	private int typeId;
	@Column (name="reimb_type")
	private String type;
	
	public ReimbType() {
		super();
	}
	
	public ReimbType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type, typeId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbType other = (ReimbType) obj;
		return Objects.equals(type, other.type) && typeId == other.typeId;
	}
	@Override
	public String toString() {
		return "ReimbType [typeId=" + typeId + ", " + (type != null ? "type=" + type : "") + "]";
	}
	
	

}
