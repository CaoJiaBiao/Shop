<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html lang="true">
	<head>
		<title><struts:text name="registerSuccess.jsp.title" /></title>
		<struts:head theme="ajax" />
	</head>
	<body background="background.jpg">
		<center>
			<struts:text name="registerSuccess.jsp.heading" />
		</center>
		<hr>
		<struts:text name="registerSuccess.jsp.label.welcome" />
		<struts:property value="userName" />
		<struts:fielderror/>
	</body>
</html>