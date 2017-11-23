package com.gmsys.dao;

import java.util.List;

import com.gmsys.entity.FieldType;

public interface FieldTypeDao {

	List<FieldType> findAll();

	void add(FieldType fieldType);

	FieldType findById(Integer fieldTypeId);

	void update(FieldType fieldType);

	void delete(FieldType fieldType);

	int findAllSize(FieldType fieldType);

	List<FieldType> findByPage(int begin, int pageSize);

}
