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
    <title>场地管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

<body>
	<div style="width: 100%;border-bottom: dashed 1px #ccc;padding: 5px 0;">
		<span><b>当前位置：场地管理 &gt;场地维护</b></span>
	</div>
	<p />
	<center>
		<s:form id="fieldSearch" action="fieldsave_saveFind" method="post" target="fieldMain"
			namespace="/" theme="simple">
			<s:textfield name="saveReason"/>
			<s:submit value="查询" action=""/>
		</s:form>
		<table style="width:100% ; ">
			<tr style="height:25px; line-height: 25px;">
				<td align="left">
				<span>
				&emsp;<a href="${pageContext.request.contextPath }/fieldsave_saveTrashCan.action" target="fieldMain">回收站</a>
				&emsp;<a href="${pageContext.request.contextPath }/fieldsave_findAll.action" target="fieldMain">全部记录</a>
				&emsp;<a href="${pageContext.request.contextPath }/fieldsave_toAdd.action" target="main">新建</a>
				</span>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
