package com.gmsys.dao;

import java.io.Serializable;
import java.util.List;

import com.gmsys.entity.FieldRent;
import com.gmsys.entity.FieldSave;


/*
 * 场地租借管理Dao类接口
 */
public interface FieldSaveDao {

	FieldSave load(Class<FieldSave> clazz, Serializable id);

	FieldSave add(FieldSave fieldSave);

	void realDelete(Integer id);

	void delete(Class<FieldSave> clazz, Serializable id);

	int findAllSize();

	List<FieldSave> findByPage(int begin, int pageSize);
	
	FieldSave findById(Integer fieldSaveId);

	FieldSave update(FieldSave fieldSave);

	void wantDelete(Integer id);

	int findSize(String string);

	List<FieldRent> findById(FieldRent fieldRent2, Integer fieldRentId);

	List<FieldSave> find(String string);

	int findTrashSize();

	List<FieldSave> trashByPage(int begin, int pageSize);

	void trashRestore(Integer fieldSaveId);


}
