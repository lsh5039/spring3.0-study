<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	tr:hover{background-color:#f1f1f1;}
	tr{cursor:pointer;}
</style>
</head>
<body>
	<h2>게시판 리스트</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>내용</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.pk }</td>
			<td>${vo.ct }</td>
			<td>${vo.nm }</td>
			<td>${vo.ct }</td>
			<td><button type="button"  onclick="goDel(${vo.pk })">삭제</button></td>
			<td><button type="button" onclick="goMod(${vo.pk })">수정</button></td>
		</tr>	
			
		
		</c:forEach>
		
	
	
	</table>
	
	<a href="write.do">글 쓰기</a>
	<script>
		
		function goDel(pk){
			if(confirm(pk+"번 게시물을 삭제하시겠습니까?")){
				location.href="del.do?pk="+pk;
			}
				
			
		}
		function goMod(pk){
			if(confirm(pk+"번 게시물을 수정하시겠습니까?")){
				location.href="mod.do?pk="+pk;
			}
		}
	
	</script>
</body>
</html>