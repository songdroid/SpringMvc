<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
	<form method="POST" action="login.member?command=submit">
		<p>
			<label>
				이메일 : <br/>
				<input type="text" name="email" />
			</label>
		</p>
		<p>
			<label>
				패스워드 : <br/>
				<input type="password" name="password" />
			</label>
		</p>
		<p>
			<label>
				이메일 기억하기 : <input type="checkbox" name="rememberEmail" />
			</label>
		</p>
		<input type="submit" value="로그인 하기" />
	</form>
</body>
</html>