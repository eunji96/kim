<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
<h1>login</h1>
<form method=post action="user_check">
<input type=text name=userid><br>
<input type=password name=pwd><br>
<input type=submit value='로그인'>&nbsp;
<button type=submit formaction='signin' formmethod=post>회원가입</button>
${ss }
</form>
</body>
</html>