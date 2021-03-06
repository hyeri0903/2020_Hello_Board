<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시물 조회 </title>
</head>
<body>


<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

	<div class = "title">
		<span> 제목 : </span>${view.title}
	</div>
	<hr />
	
	<div class = "writer">
		<span> 작성자 : </span>${view.writer}
	</div>
	<hr />
	
	<div class = "writer">
		<span> 내용 : </span>${view.content}
	</div>
	<hr />

	<div>
	<a href = "/board/modify?bno=${view.bno}">게시물 수정</a><br />
	<a href="/board/delete?bno=${view.bno}">게시물 삭제</a>
	</div>

</body>
</html>