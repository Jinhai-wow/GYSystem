<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<HEAD>
<TITLE>FIELDMANAGE</TITLE> 
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<FRAMESET frameSpacing=0 rows=100,* frameBorder=0>
	<FRAME name=fieldTop src="${pageContext.request.contextPath }/jsp/FieldManage/fieldRent/rentTop.jsp" frameBorder=0 noResize
		scrolling=no>
	<FRAME name=fieldMain src="${pageContext.request.contextPath }/jsp/FieldManage/fieldRent/rentNoList.jsp" frameBorder=0 noResize
		scrolling=no>
</FRAMESET>
</HTML>

