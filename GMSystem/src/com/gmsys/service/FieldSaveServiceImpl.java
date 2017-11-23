package com.gmsys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gmsys.dao.FieldSaveDao;
import com.gmsys.entity.Field;
import com.gmsys.entity.FieldSave;
import com.gmsys.util.Page;

/*
 * 场地管理业务逻辑实现类
 */
@Transactional
public class FieldSaveServiceImpl implements FieldSaveService{
	// 注入DAO类
	private FieldSaveDao fieldSaveDao;

	public void setFieldSaveDao(FieldSaveDao fieldSaveDao) {
		this.fieldSaveDao = fieldSaveDao;
	}

	@Override
	//根据序列ID加载
	public FieldSave getById(Serializable id) {

		try {
			return this.fieldSaveDao.load(FieldSave.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	//显示场地全部信息
	public Page<FieldSave> findByPage(Integer currPage) {
		FieldSave fieldSave = new FieldSave();
		Page<FieldSave> spage = new Page<FieldSave>();
		//当前页数
		spage.setCurrPage(currPage);
		//每页显示记录
		int pageSize = 10;
		spage.setPageSize(pageSize);
		//总记录数
		int totalSize = fieldSaveDao.findAllSize();
		spage.setTotalSize(totalSize);
		//总页数
		double tc = totalSize;
		Double num = Math.ceil(tc/pageSize);//向上取整
		spage.setPageCount(num.intValue());
		//每页显示的数据
		int begin =(currPage - 1)*pageSize;//当前页开始的记录数
		List<FieldSave> list = fieldSaveDao.findByPage(begin,pageSize);
		spage.setList(list);
		
		return spage;
	}
	
	@Override
	//条件模糊分页查询
	public Page<FieldSave> saveFind(Integer currPage, String string) {		
		Page<FieldSave> spage = new Page<FieldSave>();
		// 当前页数
		spage.setCurrPage(currPage);
		int totalSize = fieldSaveDao.findSize(string);
		spage.setTotalSize(totalSize);
		List<FieldSave> list = fieldSaveDao.find(string);
		spage.setList(list);

		return spage;
	}


	@Override
	// 场地更新方法
	public FieldSave saveUpdate(FieldSave fieldSave) {
//		FieldRent rList = fieldRentDao.findById(fieldRent2, fieldRent2.getFieldRentId());
		return fieldSaveDao.update(fieldSave);//返回修改成功的记录
	}

	

	@Override
	//元素删除方法
	public void realDelete(Integer id) {
		fieldSaveDao.realDelete(id);
	}
	
	@Override
	//删除到回收站
	public void wantDelete(Integer id) {
		
		this.fieldSaveDao.wantDelete(id);
	}
	
	@Override
	//根据序列ID删除
	public void deleteById(Serializable id) {
		try {
			this.fieldSaveDao.delete(FieldSave.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	@Override
	//根据fieldSaveid获取信息
	public FieldSave findById(Integer fieldSaveId) {	
		return fieldSaveDao.findById(fieldSaveId);
	}

	@Override
	//增加方法
	public FieldSave saveAdd(FieldSave fieldSave) {
		return this.fieldSaveDao.add(fieldSave);
		
	}

	@Override
	public Page<FieldSave> trashByPage(int currPage) {
		Page<FieldSave> page = new Page<FieldSave>();
		// 当前页数
		page.setCurrPage(currPage);
		// 每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		// 总记录数
		int totalSize = fieldSaveDao.findTrashSize();
		page.setTotalSize(totalSize);
		// 总页数
		double tc = totalSize;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		page.setPageCount(num.intValue());
		// 每页显示的数据
		int begin = (currPage - 1) * pageSize;// 当前页开始的记录数
		List<FieldSave> list = fieldSaveDao.trashByPage(begin, pageSize);
		page.setList(list);

		return page;
	}

	@Override
	public void trashRestore(Integer fieldSaveId) {
		 this.fieldSaveDao.trashRestore(fieldSaveId);	
	}






}
