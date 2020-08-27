<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet">
				<!--  由于一个页面要完成图书添加和修改的操作，因此value的值要是动态变化的，不能写死
				  	这里通过判断request域中是否有book的值来判断区分是修改操作还是添加操作
				  	也就是说，如果是修改操作，请求会先经过bookServlet程序，并且在request域中是会存储一个图书信息的
				  	而添加页面是直接跳转到book_edit.jsp页面的，request域中不含book的值
				  -->
				<input type="hidden" name="action" value="${empty requestScope.book ? "add" : "update"}">
				<!--  修改图书要根据id的值来修改，因此在请求的参数里要把id也带上  -->
				<input type="hidden" name="id" value="${requestScope.book.id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<!-- 需要属性名和javaBean的属性名对应 -->
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="/pages/common/feet.jsp"%>

</body>
</html>