<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form:form action="${pageContext.request.contextPath }/add" modelAttribute="employee" method="post">
		lastName	<form:input path="lastName"/><br>
		email	<form:input path="email"/><br>
		birth	<form:input path="birth"/><br>
			department<form:select path="department.id"  >
				<form:option value="请选择"/>
				<form:options items="${departments }" itemValue="id"  itemLabel="departmentName"/>
			</form:select><br>
			<input type="submit" value="Submit"/>	
		</form:form>
</center>
</body>
</html>