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
	<p />
	<div style="width: 100%;padding: 5px 30px 5px 0;" align="right">
		<span><a href="${pageContext.request.contextPath }/jsp/FieldManage/fieldRent/rentIndex.jsp">返回租借首页</a></span>
	</div>
	<p />
	<center>
		<table style="width:100% ;border:solid 1px #ccc;">
			<tr align="left" height="20px">
				<td width="20%" background=${pageContext.request.contextPath }/images/new_20.png>&emsp;租借编号</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>租借人</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>租借场地</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>租借时间</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>操作</td>
			</tr>
			<tr align="left" height="20px">
				<td style="width: 20%;border:solid 1px #ccc ;">&emsp;<s:property value="rentNomber"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="userName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="field.fieldName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:date name="rentStartTime" format="yyyy-MM-dd HH:mm:ss" /><span>到</span><s:date name="rentEndTime" format="yyyy-MM-dd HH:mm:ss" /></td>
				<td></td>
			</tr>
		</table>
		<div style="height: 100px;line-height: 100px;" align="center"><b>租借成功！</b><br/><span style="front-size:5 em ;color:red;">使用前请到管理员处缴纳租金<s:property value="field.fieldRentPrice"/>元！</span></div>
	</center>
</body>
</html>
