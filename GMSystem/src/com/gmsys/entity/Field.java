package com.gmsys.entity;

import java.io.Serializable;
import java.util.Date;


/*
 * 场地管理PO类
 */
public class Field implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer fieldId;
	private String fieldName;
	private String fieldNomber;
//	private Integer fieldType;//场地类型
	private String fieldUsage;//用途描述
//	private String fieldUsecase;//使用情况
	private Date fieldStartTime;//创建时间
	private String charger;//创建人
	private Integer fieldRentCounts;//租借次数
	private Integer fieldSaveCounts;//维护次数
	private Boolean fieldStatus;//表状态标记，1未删除，0已删除
	private Boolean fieldRentStatus;//使用状态，1未租借，0已租借
	private Boolean fieldSaveStatus;//维护状态，1未维护，0正在维护
	private Double fieldRentPrice;//租借单价
	private FieldType fieldType;//场地类型
	

	public Double getFieldRentPrice() {
		return fieldRentPrice;
	}

	public void setFieldRentPrice(Double fieldRentPrice) {
		this.fieldRentPrice = fieldRentPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldNomber() {
		return fieldNomber;
	}

	public void setFieldNomber(String fieldNomber) {
		this.fieldNomber = fieldNomber;
	}

	public String getFieldUsage() {
		return fieldUsage;
	}

	public void setFieldUsage(String fieldUsage) {
		this.fieldUsage = fieldUsage;
	}

	public Date getFieldStartTime() {
		return fieldStartTime;
	}

	public void setFieldStartTime(Date fieldStartTime) {
		this.fieldStartTime = fieldStartTime;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

	public Integer getFieldRentCounts() {
		return fieldRentCounts;
	}

	public void setFieldRentCounts(Integer fieldRentCounts) {
		this.fieldRentCounts = fieldRentCounts;
	}

	public Integer getFieldSaveCounts() {
		return fieldSaveCounts;
	}

	public void setFieldSaveCounts(Integer fieldSaveCounts) {
		this.fieldSaveCounts = fieldSaveCounts;
	}

	public Boolean getFieldStatus() {
		return fieldStatus;
	}

	public void setFieldStatus(Boolean fieldStatus) {
		this.fieldStatus = fieldStatus;
	}

	public Boolean getFieldRentStatus() {
		return fieldRentStatus;
	}

	public void setFieldRentStatus(Boolean fieldRentStatus) {
		this.fieldRentStatus = fieldRentStatus;
	}

	public Boolean getFieldSaveStatus() {
		return fieldSaveStatus;
	}

	public void setFieldSaveStatus(Boolean fieldSaveStatus) {
		this.fieldSaveStatus = fieldSaveStatus;
	}

	
	public Field() {
		// TODO Auto-generated constructor stub
	}
	
	
}
