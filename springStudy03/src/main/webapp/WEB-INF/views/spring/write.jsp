<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/write.do" method="post" commandName="vo">
	<div>제목<form:input path="title"/> </div>
	<div>내용<form:textarea path="ct"/> </div>
	<div>글쓴이<form:input path="nm"/> </div>
	<div><input type="submit" value="글쓰기"> </div>
	</form:form>
	<p>${msg }</p>

</body>
</html>