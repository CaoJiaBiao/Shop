<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
	<head>
		<title>购物车详细信息查询</title>
		<style type="text/css">
		 div{
		  float:right;
		 }
		</style>
	</head>
	<body>
		<center>
			<br />
			<h2>
				欢迎查看您购物车中所选商品的详细信息
			</h2>
			<br />
			<hr>
			<TABLE id=tb cellSpacing=2 cellPadding=5 width="95%" align=center
				border=2>
				<tr>
					<TD bgcolor=#0078B7 align="center" width="10%">
						用户名称
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						商品名称
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						商品类别
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						商品价格
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						商品折扣
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						订购数量
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						商品描述
					</TD>
					<TD bgcolor=#0078B7 align="center" width="10%">
						删除商品
					</TD>
				</tr>
				<struts:action name="showCart" executeResult="false" />
				<struts:iterator value="#request['cart']" id="cart">
					<tr>
						<td>
							<struts:property value="#cart.userName" />
						</td>
						<td>
							<struts:property value="#cart.productName" />
						</td>
						<td>
							<struts:property value="#cart.sortName" />
						</td>
						<td>
							<struts:property value="#cart.price" />
						</td>
						<td>
							<struts:property value="#cart.discount" />
						</td>
						<td>
							<struts:property value="#cart.count" />
						</td>
						<td>
							<struts:property value="#cart.discription" />
						</td>
						<td>
							<form action="updateCart.action" method="post">
							<input type="hidden" name="cartId" value="<struts:property value="#cart.cartId" />"/> 
							<input type="submit" value="删 除"/>
							</form>
						</td>
					</tr>
				</struts:iterator>
			</table>
			<br>
				<div>您购物车中存放商品的总价格为：<struts:property value="#request['totalPrice']"/>。若要结算，请&nbsp;&nbsp;&nbsp;<a href="accountCenter.jsp">进入结算中心</a></div>
		</center>
	</body>
</html>
