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
	<center>
		<table style="width:100% ;border:solid 1px #ccc;">
			<tr align="left" height="20px">
				<td width="20%" background=${pageContext.request.contextPath }/images/new_20.png>&emsp;场地编号</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>名称</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>类型</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>用途</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>操作</td>
			</tr>
			<tr align="left" height="20px">
				<td style="width: 20%;border:solid 1px #ccc ;">&emsp;<s:property value="fieldNomber"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="fieldName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="fieldType.fieldTypeName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="fieldUsage"/></td>
				<td></td>
			</tr>
		</table>
	</center>
</body>
</html>
