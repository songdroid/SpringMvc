<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>����Ŭ ���� �׽�Ʈ</h1>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = DriverManager.getConnection(url, "scott", "1111");
		
		if(con != null){
			out.println("���� ����");
		}
		
	}
	catch(Exception err){
		System.out.println("���� ���� : " + err);
	}
%>
</body>
</html>