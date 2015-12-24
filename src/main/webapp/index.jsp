<%@ page contentType="text/html; charset=UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<link rel="stylesheet"  href="/res/style.css"  type="text/css"/>
</head>
<body>
<h1>Main Page</h1>
<ul>
	<c:if test="${name == null}">
		<li><a href="register.member">회원 가입</a></li>
		<li><a href="login.member">로그인</a></li>
	</c:if>
	<c:if test="${name != null}">
		${name }님! 환영합니다.
		<li><a href="logout.member">로그 아웃</a></li>
		<li><a href="">비밀번호 변경하기</a></li>
	</c:if>
	
	<li><a href="list.board">게시판</a></li>
	<li><a href="form.survey">설문 조사</a></li>
</ul>
</body>
</html>
