<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
	<head>
		<title><struts:text name="register.jsp.title" />
		</title>
		<struts:head theme="ajax" />
	</head>
	<body background="background.jpg">
		<struts:text name="register.jsp.heading" />
		<hr>
		<center>
			<struts:form action="register" method="post">
				<struts:textfield name="userName" key="register.jsp.label.username" />
				<struts:password name="psw1" key="register.jsp.label.psw1" />
				<struts:password name="psw2" key="register.jsp.label.psw2" />
				<struts:textfield name="sex" key="register.jsp.label.sex" />
				<struts:textfield name="age" key="register.jsp.label.age" />
				<struts:textfield name="telNum" key="register.jsp.label.telnum" />
				<struts:textfield name="email" key="register.jsp.label.email" />
				<struts:submit key="register.jsp.button.submit" />
			</struts:form>
		</center>
	</body>
</html>