package com.gmsys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gmsys.dao.FieldRentDao;
import com.gmsys.entity.Field;
import com.gmsys.entity.FieldRent;
import com.gmsys.util.Page;

/*
 * 场地管理业务逻辑实现类
 */
@Transactional
public class FieldRentServiceImpl implements FieldRentService{
	// 注入DAO类
	private FieldRentDao fieldRentDao;
	

	public void setFieldRentDao(FieldRentDao fieldRentDao) {
		this.fieldRentDao = fieldRentDao;
	}

	@Override
	//根据序列ID加载
	public Object getById(Serializable id) {

		try {
			return this.fieldRentDao.load(getClass(), id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	//显示场地全部信息
	public Page<FieldRent> findByPage(Integer currPage) {
		FieldRent fieldRent = new FieldRent();
		Page<FieldRent> page = new Page<FieldRent>();
		//当前页数
		page.setCurrPage(currPage);
		//每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		//总记录数
		int totalSize = fieldRentDao.findAllSize();
		page.setTotalSize(totalSize);
		//总页数
		double tc = totalSize;
		Double num = Math.ceil(tc/pageSize);//向上取整
		page.setPageCount(num.intValue());
		//每页显示的数据
		int begin =(currPage - 1)*pageSize;//当前页开始的记录数
		List<FieldRent> list = fieldRentDao.findByPage(begin,pageSize);
		page.setList(list);
		
		return page;
	}
	
	@Override
	//条件模糊分页查询
	public Page<FieldRent> rentFind(Integer currPage, String string) {		
		Page<FieldRent> rpage = new Page<FieldRent>();
		// 当前页数
		rpage.setCurrPage(currPage);
		int totalSize = fieldRentDao.findSize(string);
		rpage.setTotalSize(totalSize);
		List<FieldRent> list = fieldRentDao.find(string);
		rpage.setList(list);

		return rpage;
	}


	@Override
	// 场地更新方法
	public FieldRent rentUpdate(FieldRent fieldRent) {
//		FieldRent rList = fieldRentDao.findById(fieldRent2, fieldRent2.getFieldRentId());
		return fieldRentDao.updateOrSave(fieldRent);//返回修改成功的记录
	}

	

	@Override
	//元素删除方法
	public void realDelete(Integer id) {
		fieldRentDao.realDelete(id);
	}
	
	@Override
	//删除到回收站
	public void wantDelete(Integer id) {
		
		this.fieldRentDao.wantDelete(id);
	}
	
	@Override
	//根据序列ID删除
	public void deleteById(Serializable id) {
		try {
			this.fieldRentDao.delete(getClass(), id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	@Override
	//根据fieldRenid获取信息
	public FieldRent findById(Integer fieldRentId) {	
		return fieldRentDao.findById(fieldRentId);
	}

	@Override
	//增加方法
	public FieldRent rentAdd(FieldRent fieldRent) {
		return this.fieldRentDao.add(fieldRent);
	}

	@Override
	public List<FieldRent> findRentName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<FieldRent> trashByPage(int currPage) {
		Page<FieldRent> page = new Page<FieldRent>();
		// 当前页数
		page.setCurrPage(currPage);
		// 每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		// 总记录数
		int totalSize = fieldRentDao.findTrashSize();
		page.setTotalSize(totalSize);
		// 总页数
		double tc = totalSize;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		page.setPageCount(num.intValue());
		// 每页显示的数据
		int begin = (currPage - 1) * pageSize;// 当前页开始的记录数
		List<FieldRent> list = fieldRentDao.trashByPage(begin, pageSize);
		page.setList(list);

		return page;
	}

	@Override
	public void trashRestore(Integer fieldRentId) {
		this.fieldRentDao.trashRestore(fieldRentId);
		
	}

	@Override
	//查找失约记录
	public Page<FieldRent> findRecord(int currPage) {
		FieldRent fieldRent = new FieldRent();
		Page<FieldRent> page = new Page<FieldRent>();
		//当前页数
		page.setCurrPage(currPage);
		//每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		//总记录数
		int totalSize = fieldRentDao.findRecordSize();
		page.setTotalSize(totalSize);
		//总页数
		double tc = totalSize;
		Double num = Math.ceil(tc/pageSize);//向上取整
		page.setPageCount(num.intValue());
		//每页显示的数据
		int begin =(currPage - 1)*pageSize;//当前页开始的记录数
		List<FieldRent> list = fieldRentDao.findRecord(begin,pageSize);
		page.setList(list);
		
		return page;
	}

	@Override
	public Page<FieldRent> findNoMiss(int currPage) {
		FieldRent fieldRent = new FieldRent();
		Page<FieldRent> page = new Page<FieldRent>();
		//当前页数
		page.setCurrPage(currPage);
		//每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		//总记录数
		int totalSize = fieldRentDao.findNoMissSize();
		page.setTotalSize(totalSize);
		//总页数
		double tc = totalSize;
		Double num = Math.ceil(tc/pageSize);//向上取整
		page.setPageCount(num.intValue());
		//每页显示的数据
		int begin =(currPage - 1)*pageSize;//当前页开始的记录数
		List<FieldRent> list = fieldRentDao.findNoMiss(begin,pageSize);
		page.setList(list);
		
		return page;
	}

	@Override
	///查询赛事场地
	public List<FieldRent> findByEId(Integer eventId) {
		List<FieldRent> list = fieldRentDao.findByEid(eventId);
		return list;
	}






}
