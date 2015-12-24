<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
<form method="POST">
	<p>
		1. 당신의 역할은?<br/>
			<label>
				<input type="radio" name="responses[0]" value="서버">
				서버 개발자
			</label>
			<label>
				<input type="radio" name="responses[0]" value="프론트">
				프론트 개발자
			</label>
			<label>
				<input type="radio" name="responses[0]" value="풀스택">
				풀스택 개발자
			</label>
	</p>
	<p>
		2. 가장 많이 사용하는 개발 도구는?<br/>
			<label>
				<input type="radio" name="responses[1]" value="Eclipse">
				Eclipse
			</label>
			<label>
				<input type="radio" name="responses[1]" value="IntelliJ">
				Intelli-J
			</label>
			<label>
				<input type="radio" name="responses[1]" value="Sublime">
				Sublime
			</label>
	</p>
	<p>
		3. 하고 싶은 말<br/>
		<input type="text" name="responses[2]" />
	</p>
	<p>
		<label>응답자의 위치</label>
		<input type="text" name="res.location">
	</p>
	<p>
		<label>응답자의 나이</label>
		<input type="text" name="res.age">
	</p>
	<input type="submit" value="전송" />
</form>
</body>
</html>