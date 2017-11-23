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
    		var msg = "您确定要删除这个场地吗？";
    		if (confirm(msg) == true) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	 function checkRent(b) {
    		if(b){
    		alert("该场地正在使用中，不能租借！")
    		return false;
    		}else{
    			return true;
    		}	
    	}
	</script>

  </head>
  
  <body>
  	<div style="width: 100%;border-bottom: dashed 1px #ccc;padding: 5px 0;">
		<span><b>当前位置：场地管理 &gt;基本管理 &gt;场地信息</b></span>
	</div>
    <center>
	<p/>
		<s:form theme="simple">
		<s:hidden name="fieldId" value="%{model.fieldId}"/>
		<table border="0" cellspacing="0" cellpadding="5px"  align="center">
			<tr>
				<td >场地名称:</td>
				<td width="50%" style="color: #555;"><s:text name="%{model.fieldName}" /></td>
				<td >租借状态:</td>
				<td style="color: #555;">
				<s:if test="model.fieldRentStatus == true">
				<s:text name="正在租借" /></s:if>
				<s:else>
				<s:text name="无" /></s:else>
				</td>
			</tr>
			<tr >
				<td >场地编号</td>
				<td style="color: #555;"><s:text name="%{model.fieldNomber}"/></td>
				<td >维护状态:</td>
				<td style="color: #555;">
				<s:if test="model.fieldSaveStatus == true">
				<s:text name="正在维护"/></s:if>
				<s:else><s:text name="无" /></s:else>
				</td>
			</tr>
			<tr >
				<td>场地类型:</td>
				<td style="color: #555;"><s:text name="%{model.fieldType.fieldTypeName}"/></td>
				<td >租借次数：</td>
				<td style="color: #555;"><s:text name="%{model.fieldRentCounts}"/></td>
			</tr>
			<tr>
			<td>租借单价：</td>
			<td style="color: #555;" colspan="3"><s:text name="%{model.fieldType.rentPrice}"/>元/小时</td>
			</tr>
			<tr >
				<td>创建人：</td>
				<td style="color: #555;"><s:text name="%{model.charger}"/></td>
				<td >维护次数：</td>
				<td style="color: #555;"><s:text name="%{model.fieldRentCounts}"/></td>
			</tr>
			<tr >
				<td>创建时间：</td>
				<td style="color: #555;"><s:date name="%{model.fieldStartTime}" format="yyyy-MM-dd HH:mm:ss"/></td>
				<td >场地状态:</td>
				<td style="color: #555;">
				<s:if test="model.fieldStatus == true">
				<s:text name="正常"/></s:if>
				</td>
			</tr>
			<tr >
				<td >场地用途:</td>
				<td style="color: #555;" colspan="3"><s:text name="%{model.fieldUsage}"/></td>
			</tr>
			<tr align="center">
				<td colspan="4">
				<a href="${pageContext.request.contextPath }/jsp/FieldManage/fieldIndex.jsp">返回首页</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldrent_toAdd.action?field.fieldId?<s:property value="%{model.fieldId}"/>" onclick="javascript:return checkRent(${model.fieldRentStatus} );">租借</a>&emsp;
				<!-- 管理员权限 --><a href="${pageContext.request.contextPath }/fieldsave_saveAdd.action?field.fieldId?<s:property value="%{model.fieldId}"/>">维护</a>&emsp;
				<!-- 管理员权限 --><a href="${pageContext.request.contextPath }/field_toFieldUpdate.action?fieldId=<s:property value="%{model.fieldId}"/>">更新</a>&emsp;
				<!-- 管理员权限 --><a href="${pageContext.request.contextPath }/field_wantDelete.action?fieldId=<s:property value="%{model.fieldId}"/>" onclick="javascript:return del();">删除</a>
			<tr></tr>
			<tr></tr>
			<tr></tr>
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
