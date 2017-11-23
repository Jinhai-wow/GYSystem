package com.gmsys.service;

import java.io.Serializable;
import java.util.List;

import com.gmsys.entity.FieldSave;
import com.gmsys.util.Page;

/**
 * 服务类接口
 * @author eIT
 *
 */
public interface FieldSaveService {

	FieldSave getById(Serializable id);

	FieldSave saveUpdate(FieldSave fieldSave);

	void realDelete(Integer integer);

	void deleteById(Serializable id);

	Page<FieldSave> findByPage(Integer currPage);

	FieldSave findById(Integer fieldSaveId);

	void wantDelete(Integer integer);
	
	Page<FieldSave> saveFind(Integer currPage, String string);

	FieldSave saveAdd(FieldSave fieldSave);

	Page<FieldSave> trashByPage(int currPage);

	void trashRestore(Integer fieldSaveId);

}
