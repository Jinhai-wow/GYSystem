package com.gmsys.dao;

import java.io.Serializable;
import java.util.List;

import com.gmsys.entity.FieldRent;


/*
 * 场地租借管理Dao类接口
 */
public interface FieldRentDao {

	Object load(Class<?> clazz, Serializable id);

	FieldRent add(FieldRent fieldRent);

	void realDelete(Integer id);

	void delete(Class<?> clazz, Serializable id);

	int findAllSize();

	List<FieldRent> findByPage(int begin, int pageSize);
	
	FieldRent findById(Integer fieldRentId);

	FieldRent updateOrSave(FieldRent fieldRent);

	void wantDelete(Integer id);

	int findSize(String string);

	List<FieldRent> findById(FieldRent fieldRent2, Integer fieldRentId);

	List<FieldRent> find(String string);

	int findTrashSize();

	List<FieldRent> trashByPage(int begin, int pageSize);

	void trashRestore(Integer fieldRentId);

	int findRecordSize();

	List<FieldRent> findRecord(int begin, int pageSize);

	int findNoMissSize();

	List<FieldRent> findNoMiss(int begin, int pageSize);
	
	Boolean findRentNow(Integer fieldId);

	List<FieldRent> findByEid(Integer eventId);

}
