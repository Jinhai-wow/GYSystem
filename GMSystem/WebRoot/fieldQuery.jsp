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
    
    <title>My JSP 'fieldQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<center>
	<b>场地信息</b>
	<p/>
	<s:form action="field_fin" method="post"> 
		<s:textfield name="fieldVO.fieldName" label="场地名" />
		<s:password name="fieldVO.fieldNomber" label="场地编号" />
		<s:textfield name="fieldVO.fieldType" label="场地类型" />	
		<s:textfield name="fieldVO.fieldUsage" label="场地用途" />
		<s:textfield name="fieldVO.fieldUsecase" label="场地使用情况" />	
	    <s:submit></s:submit>
	</s:form>
	</center>
  </body>
</html>
