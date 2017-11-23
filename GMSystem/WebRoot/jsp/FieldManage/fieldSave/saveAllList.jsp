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
    
    <title>维护管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function del() {
    		var msg = "您确定要删除这个维护吗？";
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
		<table style="width:100% ; border-top:solid 1px #ccc ;" >
			<tr align="left" height="20px">
		        <td width="20%" background=${pageContext.request.contextPath }/images/new_20.png>&emsp;维护编号</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>场地名</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>维护时间</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>维护原因</td>
				<td background=${pageContext.request.contextPath }/images/new_20.png>操作</td>
			</tr>
			<s:iterator value="list" var="s">
			<tr align="left" height="20px">
				<td style="width: 20%;border:solid 1px #ccc ;">&emsp;<s:property value="#s.saveNomber"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#s.field.fieldName"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:date name="#s.saveTime" format="yyyy-MM-dd HH:mm:ss" /></td>
				<td style="width: 20%;border:solid 1px #ccc ;"><s:property value="#s.saveReason"/></td>
				<td style="width: 20%;border:solid 1px #ccc ;">
				<a href="${pageContext.request.contextPath }/fieldsave_toSaveDetail.action?fieldSaveId=<s:property value="#s.fieldSaveId"/>" target="main" >详细</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldsave_toSaveUpdate.action?fieldSaveId=<s:property value="#s.fieldSaveId"/>" target="main">更新</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldsave_wantDelete.action?fieldSaveId=<s:property value="#s.fieldSaveId"/>" target="fieldMain" onclick="javascript:return del();">删除</a>
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td align="right" colspan="6" >
					<span>第<s:property value="currPage"/>/<s:property value="pageCount"/>页</span>&nbsp;
					<span>总共<s:property value="totalSize"/>条</span>&nbsp;
					<span>
					<s:if test="currPage != 1">
						<a href="${pageContext.request.contextPath }/fieldsave_findAll.action?currPage=1">首页</a>&nbsp;
						<a href="${pageContext.request.contextPath }/fieldsave_findAll.action?currPage=<s:property value="currPage-1"/>">上一页</a>&nbsp;
					</s:if>
					<s:if test="currPage != pageCount">
						<a href="${pageContext.request.contextPath }/fieldsave_findAll.action?currPage=<s:property value="currPage+1"/>">下一页</a>&nbsp;
						<a href="${pageContext.request.contextPath }/fieldsave_findAll.action?currPage=<s:property value="pageCount"/>">尾页</a>&emsp;
					</s:if>
					</span>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
