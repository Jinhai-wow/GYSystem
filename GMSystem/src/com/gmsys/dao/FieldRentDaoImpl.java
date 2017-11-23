package com.gmsys.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.scenario.effect.Merge;

/**
 * 场地管理Dao实现类
 * 
 * @author eIT
 *
 */
@Transactional
public class FieldRentDaoImpl extends HibernateDaoSupport implements FieldRentDao {

//	private Field field;
//	Session session = currentSession();

	
	@Override
	//条件模糊分页查询方法
	public List<FieldRent> find(String string) {
		List<FieldRent> list = new ArrayList<FieldRent>();
		DetachedCriteria c1 = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.like("rentNomber", "%" + string + "%" )).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> l1 = (List<FieldRent>) getHibernateTemplate().findByCriteria(c1);
		list.addAll(l1);
		DetachedCriteria c2 = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.like("rentUsage", "%" + string + "%")).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> l2 = (List<FieldRent>) getHibernateTemplate().findByCriteria(c2);
			list.addAll(l2);
		DetachedCriteria c3 = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.like("rentStartTime", "%" + string + "%")).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> l3 = (List<FieldRent>) getHibernateTemplate().findByCriteria(c3);
			list.addAll(l3);
		DetachedCriteria c4 = DetachedCriteria.forClass(FieldRent.class)
					.add(Restrictions.like("rentEndTime", "%" + string + "%")).add(Restrictions.eq("deleteStatus", new Boolean(false)));
			List<FieldRent> l4 = (List<FieldRent>) getHibernateTemplate().findByCriteria(c4);
				list.addAll(l4);
		HashSet<FieldRent> hs = new HashSet<FieldRent>(list);//去除重复
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
	public Object load(Class<?> clazz, Serializable id) {
		return this.getHibernateTemplate().get(clazz, id);
	}

	
	@Override
	//增加方法
	public FieldRent add(FieldRent fieldRent) {
		getHibernateTemplate().save(fieldRent);
		return this.getHibernateTemplate().get(fieldRent.getClass(), fieldRent.getFieldRentId());
	}

	
	@Override
	//更新方法
	public FieldRent updateOrSave(FieldRent fieldRent) {
		this.getHibernateTemplate().update(fieldRent);
		return this.getHibernateTemplate().get(fieldRent.getClass(), fieldRent.getFieldRentId());
	}

	
	@Override
	//根据类的序列ID删除方法
	public void delete(Class<?> clazz, Serializable key) {
		this.getHibernateTemplate().delete(this.load(clazz, key));
	}

	
	@Override
	//元素删除方法
	public void realDelete(Integer id) {
		FieldRent fieldRent = getHibernateTemplate().get(FieldRent.class, id);
		this.getHibernateTemplate().delete(fieldRent);
	}

	
	@Override
	//查找到的总记录数
	public int findAllSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}
	
	
	@Override
	//模糊查询的记录数
	public int findSize(String string) {
		return this.find(string).size();
	}


	@Override
	//数据分页显示
	public List<FieldRent> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(false)));
		return (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);

	}

	@Override
	//根据FieldRentId获取信息
	public FieldRent findById(Integer fieldRentId) {	
		return this.getHibernateTemplate().get(FieldRent.class, fieldRentId);
	}

	@Override
	//状态号记1，移到回收站
	public void wantDelete(Integer id) {
		FieldRent fieldRent = findById(id);
		fieldRent.setDeleteStatus(true);
		fieldRent.setRentStatus(false);
		fieldRent.setMissStatus(false);
		this.getHibernateTemplate().update(fieldRent);
	}
	@Override
	//回收站记录
	public int findTrashSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(true)));
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}
	@Override
	//回收站分页显示
	public List<FieldRent> trashByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("deleteStatus", new Boolean(true)));
		return (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}
	@Override
	//删除恢复
	public void trashRestore(Integer fieldRentId) {
		FieldRent fieldRent = findById(fieldRentId);
		fieldRent.setDeleteStatus(false);
		this.getHibernateTemplate().update(fieldRent);
	}
	
	@Override
	//失约记录数
	public int findRecordSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("missStatus", new Boolean(true))).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}
	
	@Override
	//失约记录分页
	public List<FieldRent> findRecord(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("missStatus", new Boolean(true))).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		return (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}
	
	@Override
	public int findNoMissSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("missStatus", new Boolean(false))).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size();
	}
	@Override
	public List<FieldRent> findNoMiss(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("missStatus", new Boolean(false))).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		return (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}
	
	@Override
	//根据场地ID查询当前是否正在租借
	public Boolean findRentNow(Integer fieldId) {
		long times = System.currentTimeMillis();
		Timestamp ts = new Timestamp(times);
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("field.fieldId", fieldId)).add(Restrictions.lt("rentStartTime", ts)).add(Restrictions.gt("rentEndTime", ts));
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list.size()!=0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	//查询赛事
	public List<FieldRent> findByEid(Integer eventId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldRent.class)
				.add(Restrictions.eq("eventId", eventId)).add(Restrictions.eq("deleteStatus", new Boolean(false)));
		List<FieldRent> list = (List<FieldRent>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
	

}
