<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
	<head>
		<title>显示您所查询的商品信息</title>
		<style type="text/css">
		 body{
				 /*background: url(image/content.png) 100% 0  no-repeat;*/
				 background:url(image/body_bg.gif);
				 background-repeat: repeat;
				 color:#00458c;
				 margin-top:0;
				 margin-right:0;
		 	}
		 	.title{
		 	 color:white;
		 	}
		 	.title TD{
		 	 background:#0078B7;
		 	}
		</style>
	</head>
	<body>
		<center>
			<br />
			<h2>
				欢迎选购商品
			</h2>
			<br />
			<hr>
			<TABLE id=tb cellSpacing=2 cellPadding=5 width="95%" align=center
				border=2>
				<tr class="title">
					<TD align="center" width="10%">
						商品照片
					</TD>
					<TD align="center" width="10%">
						商品名称
					</TD>
					<TD align="center" width="10%">
						商品价格
					</TD>
					<TD align="center" width="10%">
						折扣信息
					</TD>
					<TD align="center" width="10%">
						描述信息
					</TD>
					<TD align="center" width="10%">
						库存量
					</TD>
					<TD align="center" width="10%">
						购买量
					</TD>
				</tr>
				<struts:action name="selectProductBySort" executeResult="false" />
				<struts:iterator value="#request['productInfo']" id="productInfo">
					<tr>
						<td>
							<img src="/Shop/productImages/<struts:property value="#productInfo.picture"/>" width="100">
						</td>
						<td>
							<struts:property value="#productInfo.productName" />
						</td>
						<td>
							<struts:property value="#productInfo.price" />
						</td>
						<td>
							<struts:property value="#productInfo.discount" />
						</td>
						<td>
							<struts:property value="#productInfo.discription" />
						</td>
						<td>
							<struts:property value="#productInfo.inventory" />
						</td>
						<td>
							<form action="addCart.action" method="post">
							<input type="text" name="count" size=4 value="1"/>
							<input type="hidden" name="productId" value="<struts:property value="#productInfo.id" />"/> 
							<input type="submit" value="购买"/>
							</form>
						</td>
					</tr>
				</struts:iterator>
			</table>
		</center>
	</body>
</html>
