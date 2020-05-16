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
	<form:form action="/mod.do" method="post" commandName="one">
	<form:hidden path="pk" value="${one.pk }"/>
	<div>제목<form:input path="title"  value="${one.title }" /> </div>
	<div>내용<form:textarea path="ct" value="${one.ct }"/> </div>
	<div>글쓴이<form:input path="nm" value="${one.nm }"/> </div>
	<div><input type="submit" value="수정"> </div>
	</form:form>
	<p>${msg }</p>

</body>
</html>