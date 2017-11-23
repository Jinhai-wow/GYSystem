package com.gmsys.action;

import java.util.Date;
import java.util.List;

import com.gmsys.entity.Field;
import com.gmsys.entity.FieldType;
import com.gmsys.service.FieldService;
import com.gmsys.service.FieldTypeService;
import com.gmsys.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*********************************************************************************
 ***************************** 场地查询Action类 **************************************
 ********************************************************************************/
public class FieldAction extends ActionSupport implements ModelDriven<Field> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FieldService fieldService;
	private FieldTypeService fieldTypeService;

	public void setFieldTypeService(FieldTypeService fieldTypeService) {
		this.fieldTypeService = fieldTypeService;
	}

	// 首页
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	// 模型驱动
	private Field field = new Field();

	@Override
	public Field getModel() {
		// TODO Auto-generated method stub
		return field;
	}

	// structs与spring的按name自动匹配注入业务逻辑类
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	/*************************************************************************
	 * 场地管理Action
	 * 
	 * @return
	 *************************************************************************/
	// 分页显示场地全部信息
	public String findAll() throws Exception {
		try {
			Page<Field> page = fieldService.findByPage(currPage);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "findAllSuccess";
	}

	// 场地条件模糊查询
	public String fieldFind() throws Exception {
		String string = field.getFieldName();
		try {
			Page<Field> page = fieldService.fieldFind(currPage, string);
			ActionContext.getContext().getValueStack().push(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "findSuccess";

	}

	// 新增时获得场地类型
	public String toAdd() throws Exception{
		List<FieldType> tlist = fieldTypeService.findFieldType();
		ActionContext.getContext().getValueStack().set("typeList", tlist);
		return "fieldInput";
	}

	// 场地添加方法
	public String fieldAdd() throws Exception {
		try {
			Field flist = fieldService.fieldAdd(field);
			ActionContext.getContext().getValueStack().push(flist);
		} catch (Exception e) {
			e.printStackTrace();
			return "fieldInput";
		}
		return "saveSuccess";
	}

	// 点击详细时获取所选场地的信息
	public String toFieldDetail() throws Exception{
		field = fieldService.findById(field.getFieldId());
		List<FieldType> tlist = fieldTypeService.findFieldType();
		ActionContext.getContext().getValueStack().set("typeList", tlist);
		return "toFieldDetail";
	}

	// 点击修改时获取所选场地Id和类型
	public String toFieldUpdate() throws Exception{
		field = fieldService.findById(field.getFieldId());
		List<FieldType> tlist = fieldTypeService.findFieldType();
		ActionContext.getContext().getValueStack().set("typeList", tlist);
		return "toFieldUpdate";
	}

	// 进行修改信息
	public String fieldUpdate() throws Exception{
		try {
			Field list = fieldService.fieldUpdate(field);
			ActionContext.getContext().getValueStack().push(list);
		} catch (Exception e) {
			e.printStackTrace();
			return "updateInput";
		}
		return "updateSuccess";
	}

	// 删除到回收站，状态号记0
	public String wantDelete() throws Exception{
		try {
			fieldService.wantDelete(field.getFieldId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 从数据库删除场地
	public String fieldRealDelete() throws Exception{
		try {
			fieldService.realDelete(field.getFieldId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

	// 跳到回收站分页显示
	public String fieldTrashCan() throws Exception {
		try {
			Page<Field> page = fieldService.trashByPage(currPage);
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
			fieldService.trashRestore(field.getFieldId());
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}
	
	

}
