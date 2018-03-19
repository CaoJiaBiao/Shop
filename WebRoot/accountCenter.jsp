<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
	<head>
		<title>结算中心</title>
		<struts:head theme="ajax" />
	</head>
	<body>
		<center>
			<br/>
			<h2>
				请输入您的联系方式
			</h2>
			<br/>
			<hr>
			<struts:form action="account" method="post">
				<struts:textfield name="address" label="用户地址" />
				<struts:textfield name="e_mail" label="电子邮箱"/>
				<struts:textfield name="telNum" label="用户电话" />
				<struts:submit label="确定" />
			</struts:form>
		</center>
	</body>
</html>
