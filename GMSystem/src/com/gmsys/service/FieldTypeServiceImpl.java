package com.gmsys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gmsys.dao.FieldTypeDao;
import com.gmsys.entity.FieldSave;
import com.gmsys.entity.FieldType;
import com.gmsys.util.Page;

/**
 * 场地类型服务实现
 * @author eIT
 *
 */
@Transactional
public class FieldTypeServiceImpl implements FieldTypeService {
	//注入Dao类
	private FieldTypeDao fieldTypeDao;
	
	public void setFieldTypeDao(FieldTypeDao fieldTypeDao) {
		this.fieldTypeDao = fieldTypeDao;
	}

	@Override
	//查询场地类型
	public List<FieldType> findFieldType() {
		
		return fieldTypeDao.findAll();
	}

	@Override
	//添加类型
	public void typeAdd(FieldType fieldType) {
		this.fieldTypeDao.add(fieldType);
	}

	@Override
	public FieldType findById(Integer fieldTypeId) {
		return fieldTypeDao.findById(fieldTypeId);
	}

	@Override
	public void typeUpdate(FieldType fieldType) {
		this.fieldTypeDao.update(fieldType);
	}

	@Override
	public void realDelete(FieldType fieldType) {
		this.fieldTypeDao.delete(fieldType);
	}

	@Override
	public Page<FieldType> findByPage(int currPage) {
		FieldType fieldType = new FieldType();
		Page<FieldType> tpage = new Page<FieldType>();
		//当前页数
		tpage.setCurrPage(currPage);
		//每页显示记录
		int pageSize = 10;
		tpage.setPageSize(pageSize);
		//总记录数
		int totalSize = fieldTypeDao.findAllSize(fieldType);
		tpage.setTotalSize(totalSize);
		//总页数
		double tc = totalSize;
		Double num = Math.ceil(tc/pageSize);//向上取整
		tpage.setPageCount(num.intValue());
		//每页显示的数据
		int begin =(currPage - 1)*pageSize;//当前页开始的记录数
		List<FieldType> list = fieldTypeDao.findByPage(begin,pageSize);
		tpage.setList(list);
		
		return tpage;
	}

}
