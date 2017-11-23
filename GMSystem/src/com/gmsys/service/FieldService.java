package com.gmsys.service;

import java.io.Serializable;
import java.util.List;

import com.gmsys.entity.Field;
import com.gmsys.util.Page;

/**
 * 服务类接口
 * 
 * @author eIT
 *
 */
public interface FieldService {

	Page<Field> fieldFind(Integer currPage, String string);

	Object getById(Serializable id);

	Field fieldAdd(Field field);

	Field fieldUpdate(Field field);

	void realDelete(Integer integer);

	void deleteById(Serializable id);

	Page<Field> findByPage(Integer currPage);

	Field findById(Integer fieldId);

	void wantDelete(Integer integer);

	Page<Field> trashByPage(int currPage);

	void trashRestore(Integer fieldId);

	List<Field> findFieldName();

}
