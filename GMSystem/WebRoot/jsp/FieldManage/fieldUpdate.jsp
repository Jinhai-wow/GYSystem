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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
    	function bac() {
    		var msg = "您确定要放弃更新场地吗？";
    		if (confirm(msg) == true) {
    			return history.go(-1);
    		} else {
    			return false;
    		}
    	}
    </script>
  </head>
  
  <body>
  	<div style="width: 100%;border-bottom: dashed 1px #ccc;padding: 5px 0;">
		<span><b>当前位置：场地管理 &gt;基本管理 &gt;更新场地</b></span>
	</div>
    <center>
	<p/>
	<s:form action="field_fieldUpdate" method="post" namespace="/" theme="simple"> 
	<s:hidden name="fieldId" value="%{model.fieldId}"/>
	<s:hidden name="fieldStartTime" value="%{model.fieldStartTime}"/>
	<s:hidden name="fieldRentCounts" value="%{model.fieldRentCounts}"/>
	<s:hidden name="fieldSaveCounts" value="%{model.fieldSaveCounts}"/>
	<s:hidden name="fieldStatus" value="%{model.fieldStatus}"/>
	<s:hidden name="fieldSaveStatus" value="%{model.fieldSaveStatus}"/>
	<s:hidden name="fieldRentStatus" value="%{model.fieldRentStatus}"/>
	<s:hidden name="fieldNomber" value="%{model.fieldNomber}"/>
	<s:hidden name="fieldRentPrice" value="%{model.fieldType.rentPrice}"/>
		<table border="0" cellspacing="0" cellpadding="5px" align="center">
			<tr>
				<td >场地名称:</td>
				<td colspan="3"><s:textfield name="fieldName" value="%{model.fieldName}"/></td>
				<td>场地类型:</td>
				<td><s:select name="fieldType.fieldTypeId" list="typeList" listKey="fieldTypeId" listValue="fieldTypeName" headerKey="0"  headerValue="---选择类型---" value="%{model.fieldType.fieldTypeId}"/></td>
			</tr>
			<tr >
				<td>创建人：</td>
				<td><s:textfield name="charger" value="%{model.charger}" readonly="true"/></td>
			</tr>
			<tr>
				<td >场地状态:</td>
				<td ><s:select name="fieldStatus" list="#{true:'正常',fals:'备用'}" headerKey=""  headerValue="---选择---" value="%{model.fieldStatus}"/></td>
			</tr>
			<tr >
				<td >场地用途:</td>
				<td ><s:textarea name="fieldUsage" value="%{model.fieldUsage}" rows="5" cols="25" cssStyle="overflow:hidden; resize:none;"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><s:submit value="保存"/>&emsp;<input type="button" onclick="javascript:return bac();" value="返回"/></td>
			</tr>	
	</s:form>
	</center>
  </body>
</html>
