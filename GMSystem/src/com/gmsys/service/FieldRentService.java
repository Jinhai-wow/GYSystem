package com.gmsys.service;

import java.io.Serializable;
import java.util.List;

import com.gmsys.entity.FieldRent;
import com.gmsys.util.Page;

/**
 * 服务类接口
 * @author eIT
 *
 */
public interface FieldRentService {

	Object getById(Serializable id);

	FieldRent rentUpdate(FieldRent fieldRent);

	void realDelete(Integer integer);

	void deleteById(Serializable id);

	Page<FieldRent> findByPage(Integer currPage);

	FieldRent findById(Integer fieldRentId);

	void wantDelete(Integer integer);
	
	Page<FieldRent> rentFind(Integer currPage, String string);

	FieldRent rentAdd(FieldRent fieldRent);

	List<FieldRent> findRentName();

	Page<FieldRent> trashByPage(int currPage);

	void trashRestore(Integer fieldRentId);

	Page<FieldRent> findRecord(int currPage);

	Page<FieldRent> findNoMiss(int currPage);

	List<FieldRent> findByEId(Integer eventId);

}
