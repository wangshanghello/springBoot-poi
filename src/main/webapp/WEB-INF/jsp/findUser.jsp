<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
%>
</head>
<body>
	<table border="1">
		<tr>
			<th>name</th>
			<th>age</th>
		</tr>
		<c:forEach items="${user}" var="u">
		<tr>
			<td>${u.name}</td>
			<td>${u.age}</td>
		</tr>
		</c:forEach>
	</table><p>
<a href="<%=path%>/addUser">addUser</a>
<p>
<a href="<%=path%>/expor">导出</a>
</body>
</html>