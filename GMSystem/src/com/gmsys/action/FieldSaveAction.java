package com.gmsys.action;

import java.util.List;

import com.gmsys.entity.Field;
import com.gmsys.entity.FieldRent;
import com.gmsys.entity.FieldSave;
import com.gmsys.service.FieldSaveService;
import com.gmsys.service.FieldService;
import com.gmsys.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FieldSaveAction extends ActionSupport implements ModelDriven<FieldSave> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FieldSaveService fieldSaveService;
	private FieldService fieldService;

	// 首页页码
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	// structs与spring的按name自动匹配注入业务逻辑类
	public void setFieldSaveService(FieldSaveService fieldSaveService) {
		this.fieldSaveService = fieldSaveService;
	}

	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	// 模型驱动
	private FieldSave fieldSave = new FieldSave();

	@Override
	public FieldSave getModel() {
		// TODO Auto-generated method stub
		return fieldSave;
	}

	/***************************************************************************
	 * 场地维护管理Action
	 * 
	 * @return
	 ****************************************************************************/
	// 分页显示维护全部信息
	public String findAll() throws Exception {
		try {
			Page<FieldSave> page = fieldSaveService.findByPage(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "findAllSuccess";
	}

	// 维护条件模糊查询
	public String saveFind() throws Exception {
		String string = fieldSave.getSaveReason();
		try {
			Page<FieldSave> page = fieldSaveService.saveFind(currPage, string);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "findSuccess";

	}

	// 新增时获得场地名
	public String toAdd() throws Exception {
		List<Field> flist = fieldService.findFieldName();
		ActionContext.getContext().getValueStack().set("fieldList", flist);
		return "saveInput";
	}

	// 维护添加方法
	public String saveAdd() throws Exception{
		try {
			FieldSave list = fieldSaveService.saveAdd(fieldSave);
			ActionContext.getContext().getValueStack().push(list);
		} catch (Exception e) {
			e.printStackTrace();
			return "saveInput";
		}
		return "saveSuccess";
	}

	// 点击详细时获取所选租借的信息
	public String toSaveDetail() throws Exception {
		fieldSave = fieldSaveService.findById(fieldSave.getFieldSaveId());
		List<Field> flist = fieldService.findFieldName();
		ActionContext.getContext().getValueStack().set("fieldList", flist);
		return "toSaveDetail";
	}

	// 点击修改时获取所选维护Id
	public String toSaveUpdate() {
		fieldSave = fieldSaveService.findById(fieldSave.getFieldSaveId());
		List<Field> flist = fieldService.findFieldName();
		ActionContext.getContext().getValueStack().set("fieldList", flist);
		return "toSaveUpdate";
	}

	// 进行修改信息
	public String saveUpdate() {
		try {
			FieldSave list = fieldSaveService.saveUpdate(fieldSave);
			ActionContext.getContext().getValueStack().push(list);
		} catch (Exception e) {
			e.printStackTrace();
			return "updateInput";
		}
		return "updateSuccess";
	}

	// 删除到回收站，状态号记1
	public String wantDelete() {
		try {
			fieldSaveService.wantDelete(fieldSave.getFieldSaveId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 从数据库删除场地维护
	public String saveRealDelete() {
		try {
			fieldSaveService.realDelete(fieldSave.getFieldSaveId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 跳到回收站分页显示
	public String saveTrashCan() throws Exception {
		try {
			Page<FieldSave> page = fieldSaveService.trashByPage(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "trashSuccess";
	}

	// 从回收站恢复正常
	public String trashRestore() throws Exception {
		try {
			fieldSaveService.trashRestore(fieldSave.getFieldSaveId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

}
