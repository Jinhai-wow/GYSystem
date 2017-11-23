package com.gmsys.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gmsys.entity.FieldSave;
import com.gmsys.entity.FieldType;
/**
 * 场地类型Dao类实现
 * @author eIT
 *
 */
public class FieldTypeDaoImpl extends HibernateDaoSupport implements FieldTypeDao {

	@Override
	//查询场地类型
	public List<FieldType> findAll() {
		return (List<FieldType>) this.getHibernateTemplate().find("from FieldType");
	}

	@Override
	//添加类型
	public void add(FieldType fieldType) {
		this.getHibernateTemplate().save(fieldType);	
	}

	@Override
	//根据TypeID查询
	public FieldType findById(Integer fieldTypeId) {
		return this.getHibernateTemplate().get(FieldType.class, fieldTypeId);
	}

	@Override
	//类型更新
	public void update(FieldType fieldType) {
		this.getHibernateTemplate().update(fieldType);
	}

	@Override
	//删除
	public void delete(FieldType fieldType) {
		this.getHibernateTemplate().delete(fieldType);
	}

	@Override
	//查询总记录数
	public int findAllSize(FieldType fieldType) {
		String hql = "select count(*) from " + fieldType.getClass().getName() + "";
		List<Integer> list = (List<Integer>) this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return 0;
	}

	@Override
	//数据记录分页
	public List<FieldType> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getClass());
		List<FieldType> list = (List<FieldType>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
