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
    		var msg = "您确定要放弃新建场地吗？";
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
		<span><b>当前位置：场地管理 &gt;基本管理 &gt;新建场地</b></span>
	</div>
    <center>
	<p/>
	<s:form action="field_fieldAdd" method="post" namespace="/" theme="simple" validate="true"> 
		<table border="0" cellspacing="0" cellpadding="5px" align="center">
			<tr>
				<td >场地名称:</td>
				<td ><s:textfield name="fieldName"/></td>
				<td>创建人：</td>
				<td ><s:textfield name="charger" value="username" readonly="true"/></td>
			</tr>
			<tr >
				<td>场地类型:</td>
				<td ><s:select  name="fieldType.fieldTypeId" list="typeList" listKey="fieldTypeId" listValue="fieldTypeName" headerKey=""  headerValue="---选择类型---"/></td>
			</tr>
			<tr>
				<td >场地状态:</td>
				<td ><s:select name="fieldStatus" list="#{true:'正常',false:'备用'}" headerKey=""  headerValue="---选择---"/></td>
				<td >当前时间:</td>
				<td > <input type="text" name="fieldStartTime"  class="ui_timepicker"  value="" /> </td>
			</tr>
			<tr >
				<td >场地用途:</td>
				<td ><s:textarea name="fieldUsage" rows="5" cols="25" cssStyle="overflow:hidden; resize:none;"/></td>
			</tr><s:actionerror cssStyle="color:red"/>
			<tr>
				<td colspan="4" align="center"><s:submit value="保存"/>&emsp;<input type="button" onclick="javascript:return bac();" value="返回"/></td>
			</tr>
		</table>	
	</s:form>
	</center>
  </body>
</html>
