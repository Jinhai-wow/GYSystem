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
		<script type="text/javascript">
		  function del() {
    		var msg = "您确定要永久删除这个租借吗？";
    		if (confirm(msg) == true) {
    			return true;
    		} else {
    			return false;
    		}
    	}
	</script>
  </head>

<body>
	<center>
	<!-- 管理员权限 -->
		<table style="width:100% ; border-top:solid 1px #ccc ;" >
			<tr align="left" height="20px">
			    <td width="20%" background=${pageContext.request.contextPath }/images/new_20.png>&emsp;租借编号</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>租借人</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>租借场地</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>租借时间</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>操作</td>
			</tr>
			<s:iterator value="list" var="r">
			<tr align="left" height="20px">
				<td style="width: 20%;border:solid 1px #ccc ;">&emsp;<s:property value="#r.rentNomber"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#r.userName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#r.field.fieldName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:date name="#r.rentStartTime" format="yyyy-MM-dd HH:mm:ss" /><span>到</span><s:date name="#r.rentEndTime" format="yyyy-MM-dd HH:mm:ss" /></td>
				<td style="width: 20%;border:solid 1px #ccc ;">
				<a href="${pageContext.request.contextPath }/fieldrent_trashRestore.action?fieldRentId=<s:property value="#r.fieldRentId"/>" target="fieldMain">恢复</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldrent_rentRealDelete.action?fieldRentId=<s:property value="#r.fieldRentId"/>" target="fieldMain" onclick="javascript: return del();">永久删除</a>
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td align="right" colspan="6" >
					<span>总共<s:property value="totalSize"/>条</span>&nbsp;
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
