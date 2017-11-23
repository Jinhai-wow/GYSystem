<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<script type="text/javascript">
		  function del() {
    		var msg = "您确定要永久删除这个场地吗？";
    		if (confirm(msg) == true) {
    			return true;
    		} else {
    			return false;
    		}
    	}
	</script>

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
		<table style="width:100% ; border-top:solid 1px #ccc ;" >
			<tr align="left" height="20px">
				<td  background=${pageContext.request.contextPath }/images/new_20.png>&emsp;场地编号</td>
				<td  background=${pageContext.request.contextPath }/images/new_20.png>名称</td>
				<td  background=${pageContext.request.contextPath }/images/new_20.png>类型</td>
				<td  background=${pageContext.request.contextPath }/images/new_20.png>用途</td>
				<td  background=${pageContext.request.contextPath }/images/new_20.png>操作</td>
			</tr>
			<s:iterator value="list" var="f">
			<tr align="left" height="20px">
				<td style="width: 20%;border:solid 1px #ccc ;">&emsp;<s:property value="#f.fieldNomber"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#f.fieldName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#f.fieldType.fieldTypeName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#f.fieldUsage"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;">
				<a href="${pageContext.request.contextPath }/field_trashRestore.action?fieldId=<s:property value="#f.fieldId"/>" target="fieldMain" onclick="javascript:return res();">恢复</a>&emsp;
				<a href="${pageContext.request.contextPath }/field_fieldRealDelete.action?fieldId=<s:property value="#f.fieldId"/>" target="fieldMain" onclick="javascript:return del();">永久删除</a></td>
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
