package com.gmsys.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 场地租借实体
 * @author eIT
 *
 */
public class FieldRent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer fieldRentId;
	private String rentNomber;
	private String userName;
	private Date rentStartTime;
	private Date rentEndTime;
	private Boolean rentStatus;
	private Boolean missStatus;//是否失约
	private Date rentMissTime;
	private String missReason;
	private Boolean deleteStatus;//是否删除
	private String rentUsage;
	private Integer eventId;//赛事表ID
	private Field field = new Field();//n-1关联
	
	
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Date getRentMissTime() {
		return rentMissTime;
	}

	public void setRentMissTime(Date rentMissTime) {
		this.rentMissTime = rentMissTime;
	}

	public String getMissReason() {
		return missReason;
	}

	public void setMissReason(String missReason) {
		this.missReason = missReason;
	}

	public Boolean getMissStatus() {
		return missStatus;
	}

	public void setMissStatus(Boolean missStatus) {
		this.missStatus = missStatus;
	}
	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRentUsage() {
		return rentUsage;
	}

	public void setRentUsage(String rentUsage) {
		this.rentUsage = rentUsage;
	}

	public Integer getFieldRentId() {
		return fieldRentId;
	}

	public void setFieldRentId(Integer fieldRentId) {
		this.fieldRentId = fieldRentId;
	}

	public String getRentNomber() {
		return rentNomber;
	}

	public void setRentNomber(String rentNomber) {
		this.rentNomber = rentNomber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRentStartTime() {
		return rentStartTime;
	}

	public void setRentStartTime(Date rentStartTime) {
		this.rentStartTime = rentStartTime;
	}

	public Date getRentEndTime() {
		return rentEndTime;
	}

	public void setRentEndTime(Date rentEndTime) {
		this.rentEndTime = rentEndTime;
	}

	public Boolean getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(Boolean rentStatus) {
		this.rentStatus = rentStatus;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	
	public FieldRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
