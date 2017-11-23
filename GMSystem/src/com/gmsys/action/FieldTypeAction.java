package com.gmsys.action;

import java.util.List;

import com.gmsys.entity.FieldSave;
import com.gmsys.entity.FieldType;
import com.gmsys.service.FieldTypeService;
import com.gmsys.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FieldTypeAction extends ActionSupport implements ModelDriven<FieldType> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private FieldTypeService fieldTypeService;
	// structs与spring的按name自动匹配注入业务逻辑类
	public void setFieldTypeService(FieldTypeService fieldTypeService) {
		this.fieldTypeService = fieldTypeService;
	}

	//首页页码
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	//模型驱动
	private FieldType fieldType = new FieldType();
	@Override
	public FieldType getModel() {
		// TODO Auto-generated method stub
		return fieldType;
	}
	
	/***************************************************************************
	 * 场地类型管理Action
	 * 
	 * @return
	 ****************************************************************************/	
	
	//分页显示类型全部信息
			public String findPage() throws Exception {
				try {
					Page<FieldType> page = fieldTypeService.findByPage(currPage);
					ActionContext.getContext().getValueStack().set("allFieldTypeList", page);
				} catch (Exception e) {
					e.printStackTrace();
					return "fail";
				}
					return "success";
			}
			
	//查询所有类型
	public String find(){
		List<FieldType> list = fieldTypeService.findFieldType();
		ActionContext.getContext().getValueStack().set("typeList", list);
		return "type";
	}
	
		//类型添加方法
		public String typeAdd(){
			try {
				fieldTypeService.typeAdd(fieldType);
			} catch (Exception e) {
				e.printStackTrace();
				return "typeInput";
			}
			return "type";
		}
		
		//点击修改时获取所选TypeId
		public String toMissUpdate(){
			fieldType = fieldTypeService.findById(fieldType.getFieldTypeId());
			return "toTypeUpdate";
		}
		//进行修改信息 
		public String typeUpdate() {
			try {
				fieldTypeService.typeUpdate(fieldType);
			} catch (Exception e) {
				e.printStackTrace();
				return "typeInput";
			}
			return "type";
		}
		
		//从数据库删除类型
		public String missRealDelete(){
			try {
				fieldTypeService.realDelete(fieldType);
			} catch (Exception e) {
				e.printStackTrace();
				return "deleteFail";
			}
			return "type";
		}



}
