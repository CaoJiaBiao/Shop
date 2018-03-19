<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>成功登录页面</title>
	</head>
	<body>
		<center>
			<h2>欢迎登录</h2>
		</center>
		<br>
			当前登录用户：<struts:property value="userName"/>
	</body>
</html>