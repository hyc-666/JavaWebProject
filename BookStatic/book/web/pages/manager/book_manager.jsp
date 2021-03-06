<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		//给删除图书的操作绑定单击事件，用于删除的确认提示
		$(function () {
			$("a.deleteClass").click(function () {
				return confirm("确定删除《" + $(this).parent().parent().find("td:first").text() + "》吗?")
			});

		});
	</script>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="../../static/img/logo.gif" >
	<span class="wel_word">图书管理系统</span>
	<%@include file="/pages/common/manager_menu.jsp"%>

</div>
	
	<div id="main">
		<!--  使用JSTL标签库来遍历输出list  -->
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.books}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
					<!--  通常，删除不会直接删除，二十要提示用户是否确定删除，给删除绑定单击事件  -->
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>

	<%@include file="/pages/common/feet.jsp"%>

</body>
</html>