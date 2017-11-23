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
    		var msg = "您确定要删除这个租借吗？";
    		if (confirm(msg) == true) {
    			return true;
    		} else {
    			return false;
    		}
    	}
	</script>
  </head>
  
  <body>
  	<div style="width: 100%;border-bottom: dashed 1px #ccc;padding: 5px 0;">
		<span><b>当前位置：场地管理 &gt;租借管理 &gt;租借信息</b></span>
	</div>
    <center>
	<p/>
		<s:form theme="simple">
		<s:hidden name="fieldRentId" value="%{model.fieldRentId}"/>
		<table border="0" cellspacing="0" cellpadding="5px" align="center">
			<tr>
				<td >租借编号:</td>
				<td style="color: #555;"><s:text name="%{model.rentNomber}" /></td>
			</tr>
			<tr >
				<td >场地名</td>
				<td style="color: #555;"><s:text name="%{model.field.fieldName}"/></td>
			</tr>
			<tr >
				<td>租借人:</td>
				<td style="color: #555;"><s:text name="%{model.userName}"/></td>
			</tr>
			<tr >
				<td>租借时间：</td>
				<td style="color: #555;"><s:date name="model.rentStartTime" format="yyyy-MM-dd HH:mm:ss" />到<s:date name="model.rentEndTime" format="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<td >租借状态:</td>
				<td style="color: #555;">
					<s:if test="model.rentStatus == true"><s:text name="正在租借"/></s:if>
					<s:else><s:text name="已结束"/></s:else>	
				</td>
			</tr>
			<tr >
				<td >租借用途:</td>
				<td style="color: #555;"><s:text name="%{model.rentUsage}"/></td>
			</tr>
			<tr >
				<td >赛事记录ID:</td>
				<td style="color: #555;">
				<s:if test="model.eventId != null">
				<s:text name="%{model.eventId}"/></s:if>
				<s:else>无</s:else> </td>
			</tr>
			<tr>
				<td >是否已失约:</td>
				<td style="color: #555;">
					<s:if test="model.missStatus == true"><s:text name="是"/></s:if>
					<s:else>否</s:else>			
				</td>
			</tr>
			<tr >
				<td >失约时间:</td>
				<td style="color: #555;">
				<s:if test="model.rentMissTime != null">
				<s:date name="model.rentMissTime" format="yyyy-MM-dd HH:mm:ss" /></s:if>
				<s:else>无</s:else>
				</td>
			</tr>
			<tr >
				<td >失约原因:</td>
				<td style="color: #555;">
				<s:if test="model.missReason != null">
				<s:text name="%{model.missReason}"/></s:if>
				<s:else>无</s:else>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="4">
				<a href="${pageContext.request.contextPath }/jsp/FieldManage/fieldRent/rentIndex.jsp">返回首页</a>&emsp;
				<a href="${pageContext.request.contextPath }/fieldrent_toRentUpdate.action?fieldRentId=<s:property value="%{model.fieldRentId}"/>">更新</a>&emsp;
			<!-- 管理员权限 -->
				<a href="${pageContext.request.contextPath }/fieldrent_wantDelete.action?fieldRentId=<s:property value="%{model.fieldRentId}"/>" onclick="javascript: return del();">删除</a>
				</td>
			</tr>
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
