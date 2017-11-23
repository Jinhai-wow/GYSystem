package com.gmsys.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 场地管理Dao实现类
 * 
 * @author eIT
 *
 */
@Transactional
public class FieldDaoImpl extends HibernateDaoSupport implements FieldDao {
	@Override
	// 条件模糊查询方法
	public List<Field> find(String string) {
		List<Field> list = new ArrayList<Field>();
		DetachedCriteria c1 = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.like("fieldName", "%" + string + "%")).add(Restrictions.eq("fieldStatus", new Boolean(true)));
		List<Field> l1 = (List<Field>) getHibernateTemplate().findByCriteria(c1);
		list.addAll(l1);
		DetachedCriteria c2 = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.like("fieldNomber", "%" + string + "%")).add(Restrictions.eq("fieldStatus", new Boolean(true)));
		List<Field> l2 = (List<Field>) getHibernateTemplate().findByCriteria(c2);
		//
			list.addAll(l2);
		DetachedCriteria c3 = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.like("fieldUsage", "%" + string + "%")).add(Restrictions.eq("fieldStatus", new Boolean(true)));
		List<Field> l3 = (List<Field>) getHibernateTemplate().findByCriteria(c3);
			list.addAll(l3);
		HashSet<Field> hs = new HashSet<Field>(list);//去除重复
		list.clear();
		list.addAll(hs);
		return list;
	}

	/**
	 * 根据编号查询
	 */
	@Override
	public Field findByNum(String string) {
		DetachedCriteria c = DetachedCriteria.forClass(Field.class).add(Restrictions.eq("fieldNomber", string));
		return (Field) this.getHibernateTemplate().findByCriteria(c);
	}

	@Override
	// 根据类名加载相应类序列ID
	public Object load(Class<?> clazz, Serializable id) {
		return this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	// 增加方法
	public Field add(Field field) {
		Serializable id = getHibernateTemplate().save(field);
		return this.getHibernateTemplate().get(field.getClass(), id);
	}

	@Override
	// 更新方法
	public Field updateOrSave(Field field) {
		this.getHibernateTemplate().update(field);
		return this.getHibernateTemplate().get(Field.class, field.getFieldId());
	}

	@Override
	// 根据类的序列ID删除方法
	public void delete(Class<?> clazz, Serializable key) {
		this.getHibernateTemplate().delete(this.load(clazz, key));
	}

	@Override
	// 查找到的总记录数
	public int findAllSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.eq("fieldStatus", new Boolean(true)));
		List<Field> list = (List<Field>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}

	@Override
	// 模糊查询的记录数
	public int findSize(String string) {
		return this.find(string).size();

	}

	@Override
	// 数据分页显示
	public List<Field> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.eq("fieldStatus", new Boolean(true)));
		return (List<Field>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);

	}

	@Override
	// 根据FieldId获取详细信息
	public Field findById(Integer fieldId) {
		return this.getHibernateTemplate().get(Field.class, fieldId);
	}

	@Override
	// 状态号记0，移到回收站
	public void wantDelete(Integer id) {
		Field field = findById(id);
		field.setFieldStatus(false);
		field.setFieldRentStatus(false);
		field.setFieldRentStatus(false);
		this.getHibernateTemplate().update(field);
	}

	@Override
	// 根据ID删除方法
	public void realDelete(Integer id) {
		Field field = getHibernateTemplate().get(Field.class, id);
		this.getHibernateTemplate().delete(field);
	}

	@Override
	// 返回回收站的记录
	public int findTrashSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.eq("fieldStatus", new Boolean(false)));
		List<Field> list = (List<Field>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}

	@Override
	// 回收站分页显示
	public List<Field> trashByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.eq("fieldStatus", new Boolean(false)));
		return (List<Field>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}

	@Override
	//从回收站恢复
	public void trashRestore(Integer fieldId) {
		Field field = findById(fieldId);
		field.setFieldStatus(true);
		this.getHibernateTemplate().update(field);
	}

	@Override
	public List<Field> findAllName() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Field.class)
				.add(Restrictions.eq("fieldStatus", new Boolean(true)));
		return  (List<Field>) this.getHibernateTemplate().findByCriteria(criteria);
		
	}

}
