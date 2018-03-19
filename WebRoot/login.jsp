<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
	<head>
		<title>登录页面</title>
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">/* 没做好 */
			$(document).ready(function(){
				$(".please").css("display","none");
			});
		</script>
		<style type="text/css">
			.plase{
			display:none;
			}
		</style>
	</head>
	<body>
		<struts:hidden name="pleaseLoginIn" id="pleaseLoginIn " value=""></struts:hidden>
		<center>
			<h2>用户登录</h2>
		<p>
			<struts:form action="login" method="post">
				<struts:text name="请登录"/>
				<struts:textfield name="userName" label="账号" />
				<struts:password name="userPsw" label="密码" />
				<struts:submit value="登录"></struts:submit>
			</struts:form>
		</center>
	</body>
</html>