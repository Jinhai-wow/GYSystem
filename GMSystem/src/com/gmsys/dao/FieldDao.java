package com.gmsys.dao;

import java.io.Serializable;
import java.util.List;

import com.gmsys.entity.Field;

/*
 * 场地管理Dao类接口
 */
public interface FieldDao {

	Object load(Class<?> clazz, Serializable id);

	List<Field> find(String string);

	Field findByNum(String string);

	Field add(Field field);

	void delete(Class<?> clazz, Serializable id);

	int findAllSize();

	List<Field> findByPage(int begin, int pageSize);

	int findSize(String string);

	Field findById(Integer fieldId);

	Field updateOrSave(Field field);

	void wantDelete(Integer id);

	void realDelete(Integer id);

	int findTrashSize();

	List<Field> trashByPage(int begin, int pageSize);

	void trashRestore(Integer fieldId);

	List<Field> findAllName();

}
