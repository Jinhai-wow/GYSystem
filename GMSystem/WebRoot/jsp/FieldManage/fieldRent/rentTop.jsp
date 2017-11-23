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
		<span><b>当前位置：场地管理 &gt;租借与失约</b></span>
	</div>
	<p />
	<center>
	<!-- 管理员权限 -->
		<s:form id="fieldSearch" action="fieldrent_rentFind" method="post" target="fieldMain"
			namespace="/" theme="simple">
			<s:textfield name="rentUsage"/>
			<s:submit value="查询" action=""/>
		</s:form>
		<table style="width:100% ; ">
			<tr style="height:25px; line-height: 25px;">
				<td align="left">
				<span>
					<!-- 管理员权限 -->&emsp;<a href="${pageContext.request.contextPath }/fieldrent_rentTrashCan.action" target="fieldMain">回收站</a>
					<!-- 管理员权限 -->&emsp;<a href="${pageContext.request.contextPath }/fieldrent_findAll.action" target="fieldMain">已租借</a>
					<!-- 管理员权限 -->&emsp;<a href="${pageContext.request.contextPath }/fieldrent_missRecord.action" target="fieldMain">失约记录</a>
				&emsp;<a href="${pageContext.request.contextPath }/fieldrent_toAdd.action" target="main">新建租借</a>
				</span>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
