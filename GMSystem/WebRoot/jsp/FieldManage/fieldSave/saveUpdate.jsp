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
    		var msg = "您确定要放弃更新维护吗？";
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
		<span><b>当前位置：场地管理 &gt;场地维护 &gt;更新维护记录</b></span>
	</div>
    <center>
	<p/>
	<s:form action="fieldsave_saveUpdate" method="post" namespace="/" theme="simple"> 
	<s:hidden name="fieldSaveId" value="%{model.fieldSaveId}"/>
	<s:hidden name="deleteStatus" value="%{model.deleteStatus}"/>
		<table border="0" cellspacing="0" cellpadding="5px" align="center">
			<tr>
				<td >维护编号:</td>
				<td ><s:textfield name="saveNomber" value="%{model.saveNomber}"/></td>
				<td >维护人：</td>
				<td ><s:textfield name="fieldSaver" value="%{model.fieldSaver}" readonly="true"/></td>
			</tr>
			<tr >
				<td>维护场地:</td>
				<td><s:select name="field.fieldId" list="fieldList" listKey="fieldId" listValue="fieldName" headerKey="0"  headerValue="---选择场地---" value="%{model.field.fieldName}"/></td>
				<td >维护状态：</td>
				<td ><s:select name="saveStatus" list="#{true:'正在维护',false:'维护完成'}" headerKey=""  headerValue="---选择---" value="%{model.saveStatus}"/></td>
			</tr>
			<tr>
				<td >维护费用:</td>
				<td ><s:textfield name="savePrice" value="%{model.savePrice}"/></td>
				<td >维护时间:</td>
				<td ><input type="text" name="saveTime"  class="ui_timepicker"  value="<s:date name="model.saveTime" format="yyyy-MM-dd HH:mm:ss"/></td>" /> 
				</td>
			</tr>
			<tr >
				<td >维护原因:</td>
				<td ><s:textarea name="rentUsage" value="%{model.saveReason}" rows="5" cols="30" cssStyle="overflow:hidden; resize:none;"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><s:submit value="保存"/>&emsp;<input type="button" onclick="javascript:return bac();" value="返回"/></td>
			</tr>	
	</s:form>
	</center>
  </body>
</html>
