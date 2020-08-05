package jp.co.internous.ocean.model.domain;

import java.sql.Timestamp;

import jp.co.internous.ocean.model.form.DestinationForm;


public class MstDestination {
	
	private int id;
	
	private int userId;
	
	private String familyName;
	
	private String firstName;
	
	private String telNumber;
	
	private  String address;
	
	private int status;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	
	public MstDestination () {}
	
	
	public MstDestination(DestinationForm df) {
		userId = df.getUserId();
		familyName = df.getFamilyName();
		firstName = df.getFirstName();
		telNumber = df.getTelNumber();
		address = df.getAddress();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	public String getAddress() {
		return  address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}