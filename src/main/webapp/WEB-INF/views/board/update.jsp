<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
<h1>글수정 페이지</h1>
<form action="update.board" method="POST">
	제목 : <input type="text" name="b_title" /><br/><br/>
	작성자 : <input type="text" name="b_writer" /><br/><br/>
	내용 : <textarea rows="5" cols="50" name="b_content"></textarea><br/><br/>
	<input type="submit" value="저장" />
	<input type="button" value="리스트 페이지로 이동" />
</form>
</body>
</html>