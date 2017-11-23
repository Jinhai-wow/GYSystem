package com.gmsys.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 场地维护实体
 * @author eIT
 *
 */
public class FieldSave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer fieldSaveId;
	private String saveNomber;
	private Date saveTime;
	private String saveReason;
	private String fieldSaver;
	private Boolean saveStatus;
	private Double savePrice;
	private Boolean deleteStatus;//是否删除记录
	private Field field = new Field();//n-1关联
	
	
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
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
	public Integer getFieldSaveId() {
		return fieldSaveId;
	}
	public void setFieldSaveId(Integer fieldSaveId) {
		this.fieldSaveId = fieldSaveId;
	}
	public String getSaveNomber() {
		return saveNomber;
	}
	public void setSaveNomber(String saveNomber) {
		this.saveNomber = saveNomber;
	}
	public Date getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
	public String getSaveReason() {
		return saveReason;
	}
	public void setSaveReason(String saveReason) {
		this.saveReason = saveReason;
	}
	public String getFieldSaver() {
		return fieldSaver;
	}
	public void setFieldSaver(String fieldSaver) {
		this.fieldSaver = fieldSaver;
	}
	public Boolean getSaveStatus() {
		return saveStatus;
	}
	public void setSaveStatus(Boolean saveStatus) {
		this.saveStatus = saveStatus;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	
	public FieldSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
