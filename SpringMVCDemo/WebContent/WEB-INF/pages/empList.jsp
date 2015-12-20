<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".delA").click(function(){
		var link =$(this).attr("href");
		var name = $(this).attr("name");
		 if(confirm("确认删除 "+name+" 吗？")){
			 $("#delForm").attr("action",link).submit();
		 }
		return false;
	})
})
</script>
</head>
<body>
	<center>
		<c:if test="${empty pagedEmp.content}">
			<h2>现在还没有员工啊</h2>
		</c:if>
		<c:if test="${!empty pagedEmp.content}">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>lastName</td>
					<td>email</td>
					<td>birth</td>
					<td>createTime</td>
					<td>department</td>
					<td colspan="2">Action</td>
				</tr>
				<c:forEach items="${pagedEmp.content }" var="employee">
					<tr>
						<td>${employee.id }</td>
						<td >${employee.lastName}</td>
						<td>${employee.email }</td>
						<td>${employee.birth }</td>
						<td>${employee.createTime }</td>
						<td>${employee.department.departmentName }</td>
						<td><a href="${pageContext.request.contextPath }/toEdit/${employee.id}">EDIT</a> </td>
						<td><a class="delA" name="${employee.lastName }" href="${pageContext.request.contextPath }/delete/${employee.id}">DELETE</a> </td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<form id="delForm" action="" method="POST">
			<input type="hidden" name="_method" value="DELETE"/>  
		</form>
		<br>
		<a href="${pageContext.request.contextPath }/toAddPage">AddEmp</a>
	</center>
</body>
</html>