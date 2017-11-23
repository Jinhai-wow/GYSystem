package com.gmsys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gmsys.dao.FieldDao;
import com.gmsys.dao.FieldRentDao;
import com.gmsys.entity.Field;
import com.gmsys.util.Page;

/*
 * 场地管理业务逻辑实现类
 */
@Transactional
public class FieldServiceImpl implements FieldService {
	// 注入DAO类
	private FieldDao fieldDao;
	private FieldRentDao fieldRentDao;

	public void setFieldRentDao(FieldRentDao fieldRentDao) {
		this.fieldRentDao = fieldRentDao;
	}

	public void setFieldDao(FieldDao fieldDao) {
		this.fieldDao = fieldDao;
	}

	@Override
	// 根据序列ID加载
	public Object getById(Serializable id) {

		try {
			return this.fieldDao.load(getClass(), id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}


	@Override
	// 显示场地全部信息
	public Page<Field> findByPage(Integer currPage) {
		Page<Field> page = new Page<Field>();
		// 当前页数
		page.setCurrPage(currPage);
		// 每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		// 总记录数
		int totalSize = fieldDao.findAllSize();
		page.setTotalSize(totalSize);
		// 总页数
		double tc = totalSize;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		page.setPageCount(num.intValue());
		// 每页显示的数据
		int begin = (currPage - 1) * pageSize;// 当前页开始的记录数
		List<Field> list = fieldDao.findByPage(begin, pageSize);
		page.setList(list);

		return page;
	}

	@Override
	// 条件模糊分页查询
	public Page<Field> fieldFind(Integer currPage, String string) {
		Page<Field> fpage = new Page<Field>();
		// 当前页数
		fpage.setCurrPage(currPage);
		int totalSize = fieldDao.findSize(string);
		fpage.setTotalSize(totalSize);
		List<Field> list = fieldDao.find(string);
		fpage.setList(list);

		return fpage;
	}

	@Override
	// 增加方法
	public Field fieldAdd(Field field) {
		return this.fieldDao.add(field);

	}

	@Override
	// 场地更新方法
	public Field fieldUpdate(Field field) {
		Field field2 = fieldDao.updateOrSave(field);
		Field fList = fieldDao.findById(field2.getFieldId());
		return fList;// 返回修改成功的记录
	}

	@Override
	// 元素删除方法
	public void realDelete(Integer id) {
		fieldDao.realDelete(id);
	}

	@Override
	// 删除到回收站
	public void wantDelete(Integer id) {
		this.fieldDao.wantDelete(id);
	}

	@Override
	// 根据序列ID删除
	public void deleteById(Serializable id) {
		try {
			this.fieldDao.delete(getClass(), id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	// 根据fieldid获取详细信息
	public Field findById(Integer fieldId) {
		if (fieldRentDao.findRentNow(fieldId)) {
			Field field = fieldDao.findById(fieldId);
			field.setFieldRentStatus(true);//租借状态记1
			return fieldDao.updateOrSave(field);
		}else {
			Field field = fieldDao.findById(fieldId);
			field.setFieldRentStatus(false);//租借状态记0
			fieldDao.updateOrSave(field);
			return this.fieldDao.findById(fieldId);
		}
	}

	@Override
	//回收站
	public Page<Field> trashByPage(int currPage) {
		Page<Field> page = new Page<Field>();
		// 当前页数
		page.setCurrPage(currPage);
		// 每页显示记录
		int pageSize = 10;
		page.setPageSize(pageSize);
		// 总记录数
		int totalSize = fieldDao.findTrashSize();
		page.setTotalSize(totalSize);
		// 总页数
		double tc = totalSize;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		page.setPageCount(num.intValue());
		// 每页显示的数据
		int begin = (currPage - 1) * pageSize;// 当前页开始的记录数
		List<Field> list = fieldDao.trashByPage(begin, pageSize);
		page.setList(list);

		return page;
	}

	@Override
	//删除恢复
	public void trashRestore(Integer fieldId) {
		this.fieldDao.trashRestore(fieldId);
	}

	@Override
	//获得所有场地名
	public List<Field> findFieldName() {
		return this.fieldDao.findAllName();
	}

}
