<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FieldInput.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>  
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
		function del() {
    		var msg = "您确定要放弃添加维护吗？";
    		if (confirm(msg) == true) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    </script>
  </head>
  
  <body>
  	<div style="width: 100%;border-bottom: dashed 1px #ccc;padding: 5px 0;">
		<span><b>当前位置：场地管理 &gt;租借管理 &gt;租借信息</b></span>
	</div>
    <center>
	<p/>
		<s:form theme="simple">
		<s:hidden name="fieldSaveId" value="%{model.fieldSaveId}"/>
		<table border="0" cellspacing="0" cellpadding="5px" align="center">
			<tr>
				<td >维护编号:</td>
				<td style="color: #555;"><s:text name="%{model.saveNomber}"/></td>
			</tr>
			<tr>
				<td >维护人：</td>
				<td style="color: #555;"><s:text name="%{model.fieldSaver}"/></td>
			</tr>
			<tr >
				<td>维护场地:</td>
				<td style="color: #555;"><s:text name="%{model.field.fieldName}"/></td>
			</tr>
			<tr>
				<td >维护状态：</td>
				<td style="color: #555;">
				<s:if test="model.saveStatus == true"><s:text name="正在维护"></s:text></s:if>
				<s:else><s:text name="已完成"></s:text></s:else>
				</td>
			</tr>
			<tr>
				<td >维护时间:</td>
				<td style="color: #555;"><s:date name="%{model.saveTime}" format="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<td >维护费用:</td>
				<td style="color: #555;"><s:text name="%{model.savePrice}"/>元
				</td>
			</tr>
			<tr >
				<td >维护原因:</td>
				<td style="color: #555;"><s:text name="%{model.saveReason}"/></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="4">
				<a href="${pageContext.request.contextPath }/jsp/FieldManage/fieldSave/saveIndex.jsp">返回首页</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldsave_toSaveUpdate.action?fieldSaveId=<s:property value="%{model.fieldSaveId}"/>">更新</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldsave_wantDelete.action?fieldSaveId=<s:property value="%{model.fieldSaveId}"/>" onclick="javascript:return del();">删除</a>
				</td>
			</tr>
		<table border="0" cellspacing="0" cellpadding="5px"  align="center" width="100%">
			<tr >
				<td background="${pageContext.request.contextPath }/images/new_20.png" colspan="4"></td>
			</tr>
		</table>
		</table>
		</s:form>	
	</center>
  </body>
</html>
