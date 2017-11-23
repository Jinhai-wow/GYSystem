package com.gmsys.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.gmsys.entity.Field;
import com.gmsys.entity.FieldRent;
import com.gmsys.entity.FieldSave;

/**
 * 场地维护管理Dao实现类
 * 
 * @author eIT
 *
 */
@Transactional
public class FieldSaveDaoImpl extends HibernateDaoSupport implements FieldSaveDao {

//	private Field field;

	
	@Override
	//条件模糊分页查询方法
	public List<FieldSave> find(String string) {
		List<FieldSave> list = new ArrayList<FieldSave>();
		DetachedCriteria c1 = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.like("saveTime", "%" + string + "%"));
		List<FieldSave> l1 = (List<FieldSave>) getHibernateTemplate().findByCriteria(c1);
		list.addAll(l1);
		DetachedCriteria c2 = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.like("saveNomber", "%" + string + "%"));
		List<FieldSave> l2 = (List<FieldSave>) getHibernateTemplate().findByCriteria(c2);
			list.addAll(l2);
		DetachedCriteria c3 = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.like("fieldSaver", "%" + string + "%"));
		List<FieldSave> l3 = (List<FieldSave>) getHibernateTemplate().findByCriteria(c3);
			list.addAll(l3);
		DetachedCriteria c4 = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.like("saveReason", "%" + string + "%"));
		List<FieldSave> l4 = (List<FieldSave>) getHibernateTemplate().findByCriteria(c4);
			list.addAll(l4);
		HashSet<FieldSave> hs = new HashSet<FieldSave>(list);//去除重复
		list.clear();
		list.addAll(hs);
		return list;
	}
	/**
	 * 根据编号查询
	 */
	@Override
	public List<FieldRent> findById(FieldRent fieldRent, Integer fieldRentId) {
		String hql = "select * from " + fieldRent + " where " + FieldRent.class.getName() + "" + "Id = " + fieldRentId.toString();
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().find(hql);
		return list;
	}

	
	@Override
	//根据类名加载相应类序列ID
	public FieldSave load(Class<FieldSave> clazz, Serializable id) {
		return this.getHibernateTemplate().get(clazz, id);
	}

	
	@Override
	//增加方法
	public FieldSave add(FieldSave fieldSave) {
		Serializable id = getHibernateTemplate().save(fieldSave);
		return this.getHibernateTemplate().get(fieldSave.getClass(), id);
	}

	
	@Override
	//更新方法
	public FieldSave update(FieldSave fieldSave) {
		this.getHibernateTemplate().update(fieldSave);
		return getHibernateTemplate().get(fieldSave.getClass(), fieldSave.getFieldSaveId());
	}

	
	@Override
	//根据类的序列ID删除方法
	public void delete(Class<FieldSave> clazz, Serializable key) {
		this.getHibernateTemplate().delete(this.load(clazz, key));
	}

	
	@Override
	//元素删除方法
	public void realDelete(Integer id) {
		FieldSave fieldSave = getHibernateTemplate().get(FieldSave.class, id);
		this.getHibernateTemplate().delete(fieldSave);
	}

	
	@Override
	//查找到的总记录数
	public int findAllSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldSave> list = (List<FieldSave>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}
	
	
	@Override
	//模糊查询的记录数
	public int findSize(String string) {
		return this.find(string).size();
	}


	@Override
	//数据分页显示
	public List<FieldSave> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(false)));
		return (List<FieldSave>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);

	}

	@Override
	//根据FieldSaveId获取信息
	public FieldSave findById(Integer fieldSaveId) {	
		return this.getHibernateTemplate().get(FieldSave.class, fieldSaveId);
	}

	@Override
	//状态号记1，移到回收站
	public void wantDelete(Integer id) {
		FieldSave fieldSave = findById(id);
		fieldSave.setDeleteStatus(true);
		fieldSave.setSaveStatus(false);
		this.getHibernateTemplate().update(fieldSave);
	}
	@Override
	public int findTrashSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(true)));
		List<FieldSave> list = (List<FieldSave>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}
	@Override
	public List<FieldSave> trashByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldSave.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(true)));
		return (List<FieldSave>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	
	}
	@Override
	public void trashRestore(Integer fieldSaveId) {
		FieldSave fieldSave = findById(fieldSaveId);
		fieldSave.setDeleteStatus(false);
		fieldSave.setSaveStatus(true);
		this.getHibernateTemplate().update(fieldSave);}
}
