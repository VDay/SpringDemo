<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<a href="${pageContext.request.contextPath }/pagedEmps?pageNo=1">ToEmpList</a>
		<br>
		<br>
		<form action="${pageContext.request.contextPath }/addNewEmployee" method="POST">
			新建一个employee<input type="text" name="employee" ><br>
			<input type="submit" value="SUBMIT">
		</form>
	</center>
</body>
</html>