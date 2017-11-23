package com.gmsys.service;

import java.util.List;

import com.gmsys.entity.FieldType;
import com.gmsys.util.Page;

public interface FieldTypeService {

	List<FieldType> findFieldType();

	void typeAdd(FieldType fieldType);

	FieldType findById(Integer fieldTypeId);

	void typeUpdate(FieldType fieldType);

	void realDelete(FieldType fieldType);

	Page<FieldType> findByPage(int currPage);


}
