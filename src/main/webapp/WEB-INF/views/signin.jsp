<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
<form method=post action="signin_ch" id=frmSignin>
사용자아이디: <input type=text name=userid value='${uid}'><br>
비밀번호: <input type=password name=pwd id=pwd><br>
비밀번호 확인: <input type=password name=pwd1 id=pwd1><br>
이름: <input type=text name=name><br>
모바일: <input type=text name=mobile><br>
<input type=submit value='회원가입'>&nbsp;
<button type=submit formaction='login' formmethod=post>로그인</button>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(document)
.on('submit','#frmSignin',function(){
	if($('#pwd').val()!=$('#pwd1').val()){
		alert('비밀번호 확인');
		return false;
	}
	return true;
})
</script>
</html>