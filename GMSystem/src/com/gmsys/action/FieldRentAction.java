package com.gmsys.action;

import java.util.List;

import com.gmsys.entity.Field;
import com.gmsys.entity.FieldRent;
import com.gmsys.entity.FieldType;
import com.gmsys.service.FieldRentService;
import com.gmsys.service.FieldService;
import com.gmsys.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FieldRentAction extends ActionSupport implements ModelDriven<FieldRent> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FieldRentService fieldRentService;
	private FieldService fieldService;

	// 首页页码
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	// structs与spring的按name自动匹配注入业务逻辑类
	public void setFieldRentService(FieldRentService fieldRentService) {
		this.fieldRentService = fieldRentService;
	}

	public void setFieldRent(FieldRent fieldRent) {
		this.fieldRent = fieldRent;
	}

	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	// 模型驱动
	private FieldRent fieldRent = new FieldRent();

	@Override
	public FieldRent getModel() {
		// TODO Auto-generated method stub
		return fieldRent;
	}

	/***************************************************************************
	 * 场地租借管理Action
	 * 
	 * @return
	 ****************************************************************************/
	// 分页显示租借全部信息
	public String findAll(){
		try {
			Page<FieldRent> page = fieldRentService.findByPage(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "findAllSuccess";
	}

	// 租借条件模糊查询
	public String rentFind(){
		String string = fieldRent.getRentUsage();
		try {
			Page<FieldRent> page = fieldRentService.rentFind(currPage, string);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "findSuccess";

	}

	// 新增时获得场地名
	public String toAdd(){
		List<Field> flist = fieldService.findFieldName();
		ActionContext.getContext().getValueStack().set("fieldList", flist);
		return "rentInput";
	}

	// 租借添加方法
	public String rentAdd()  {
		try {
			FieldRent list = fieldRentService.rentAdd(fieldRent);
			ActionContext.getContext().getValueStack().push(list);
			if (list.getEventId()!=null) {
				return "rentEventSuccess";
			}else {
				return "rentSuccess";
			}
		} catch (Exception e) {
			return "rentInput";
		}
		
	}

	// 点击详细时获取所选租借的信息
	public String toRentDetail(){
		fieldRent = fieldRentService.findById(fieldRent.getFieldRentId());
		List<Field> flist = fieldService.findFieldName();
		ActionContext.getContext().getValueStack().set("fieldList", flist);
		return "toRentDetail";
	}

	// 点击修改时获取所选租借Id
	public String toRentUpdate(){
		fieldRent = fieldRentService.findById(fieldRent.getFieldRentId());
		List<Field> flist = fieldService.findFieldName();
		ActionContext.getContext().getValueStack().set("fieldList", flist);
		return "toRentUpdate";
	}

	// 进行修改信息
	public String rentUpdate(){
		try {
			FieldRent list = fieldRentService.rentUpdate(fieldRent);
			ActionContext.getContext().getValueStack().push(list);
		} catch (Exception e) {
			e.printStackTrace();
			return "updateInput";
		}
		return "updateSuccess";
	}

	// 删除到回收站，状态号记1
	public String wantDelete(){
		try {
			fieldRentService.wantDelete(fieldRent.getFieldRentId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 从数据库删除场地
	public String rentRealDelete(){
		try {
			fieldRentService.realDelete(fieldRent.getFieldRentId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 跳到回收站分页显示
	public String rentTrashCan(){
		try {
			Page<FieldRent> page = fieldRentService.trashByPage(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "trashSuccess";
	}

	// 从回收站恢复正常
	public String trashRestore() {
		try {
			fieldRentService.trashRestore(fieldRent.getFieldRentId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 失约记录
	public String missRecord() {
		try {
			Page<FieldRent> page = fieldRentService.findRecord(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "recordSuccess";
	}

	// 没有失约的记录
	public String noMiss() {
		try {
			Page<FieldRent> page = fieldRentService.findNoMiss(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "noMissSuccess";
	}
	//根据赛事ID查询场地
	public String findByEventId(){
		try {
			List<FieldRent> list = fieldRentService.findByEId(fieldRent.getEventId());
			ActionContext.getContext().getValueStack().set("list", list);;
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}	
		return "eventList";
	}

}
