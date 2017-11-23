package com.gmsys.entity;

import java.io.Serializable;
/**
 * 场地类型实体类
 * @author
 *
 */
public class FieldType implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer fieldTypeId;
	private String fieldTypeName;
	private Double rentPrice;//租借单价
	private String fieldTypeDesc;//类型描述	
//	private Set<Field> fields = new HashSet<Field>();//1-n
	
	
	public Integer getFieldTypeId() {
		return fieldTypeId;
	}
	public Double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setFieldTypeId(Integer fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}
	public String getFieldTypeName() {
		return fieldTypeName;
	}
	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
	public String getFieldTypeDesc() {
		return fieldTypeDesc;
	}
	public void setFieldTypeDesc(String fieldTypeDesc) {
		this.fieldTypeDesc = fieldTypeDesc;
	}
//	public Set<Field> getFields() {
//		return fields;
//	}
//	public void setFields(Set<Field> fields) {
//		this.fields = fields;
//	}
	
	
	public FieldType() {
		super();
	}


	
}
