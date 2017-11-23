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
		<link type="text/css" href="${pageContext.request.contextPath }/jsp/FieldManage/css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath }/jsp/FieldManage/css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/FieldManage/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/FieldManage/js/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/FieldManage/js/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/FieldManage/js/jquery-ui-timepicker-zh-CN.js"></script>
    <script type="text/javascript">
    $(function () {
        $(".ui_timepicker").datetimepicker({
            //showOn: "button",
            //buttonImage: "./css/images/icon_calendar.gif",
            //buttonImageOnly: true,
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        })
    })
    
        	function bac() {
    		var msg = "您确定要放弃新建租借吗？";
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
		<span><b>当前位置：场地管理 &gt;租借管理 &gt;更新记录</b></span>
	</div>
    <center>
	<p/>
	<s:form action="fieldrent_rentUpdate" method="post" namespace="/" theme="simple"> 
	<s:hidden name="fieldRentId" value="%{model.fieldRentId}"/>
	<s:hidden name="deleteStatus" value="%{model.deleteStatus}"/>
	<s:hidden name="rentNomber" value="%{model.rentNomber}"/>
	<s:hidden name="eventId" value="%{model.eventId}"/>
		<table border="0" cellspacing="0" cellpadding="5px" align="center">
			<tr>
				<td >场地名:</td>
				<td colspan="3"><s:select name="field.fieldId" list="fieldList" listKey="fieldId" listValue="fieldName" headerKey=""  headerValue="---选择场地---" value="%{field.fieldName}"/></td>
			</tr>
			<tr >
				<td>租借人:</td>
				<td ><s:textfield name="userName" value="%{model.userName}"/></td>
				<td >确认租借？:</td>
				<td><s:select name="rentStatus" list="#{true:'是',false:'让我想想...'}" headerKey=""  headerValue="---选择---" value="%{model.rentStatus}"/></td>
			</tr>
			<tr >
				<td>租借时间：</td>
				<td >
				<input type="text" name="rentStartTime"  class="ui_timepicker"  value="<s:date name="model.rentStartTime" format="yyyy-MM-dd HH:mm:ss"/>" />到
				</td>
				<td colspan="2">
				<input type="text" name="rentEndTime"  class="ui_timepicker"  value="<s:date name="model.rentEndTime" format="yyyy-MM-dd HH:mm:ss"/>" />
				</td>
			</tr>
			<tr><!-- 管理员权限 -->
				<td >是否失约:</td>
				<td><s:select name="missStatus" list="#{true:'是',false:'否'}" headerKey=""  headerValue="---选择---" value="%{model.missStatus}"/></td>
				<td>失约时间：</td>
				<td >
				<input type="text" name="rentMissTime"  class="ui_timepicker"  value="<s:date name="model.rentMissTime" format="yyyy-MM-dd HH:mm:ss"/>"/> 
				</td>
			</tr >
			<tr>
				<td >租借用途:</td>
				<td colspan="3"><s:textarea name="rentUsage" value="%{model.rentUsage}" rows="4" cols="50" cssStyle="overflow:hidden; resize:none;"/></td>
			</tr >
			<tr><!-- 管理员权限 -->
				<td >失约原因:</td>
				<td colspan="3"><s:textarea name="missReason" value="%{model.missReason}" rows="4" cols="50" cssStyle="overflow:hidden; resize:none;"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><s:submit value="保存"/>&emsp;<input type="button" onclick="javascript:return bac();" value="返回"/></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="5px"  align="center" width="100%">
			<tr >
				<td background="${pageContext.request.contextPath }/images/new_20.png" colspan="4"></td>
			</tr>
		</table>	
	</s:form>
	</center>
  </body>
</html>
