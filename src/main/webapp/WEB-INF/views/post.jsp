<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
body{
	background-image:url('https://i.pinimg.com/originals/19/e4/4a/19e44a1d69843a900d604a062b592093.gif');
	background-repeat:no-repeat;
	background-size:cover;
}

h2{font-family: 'Cafe24Ssukssuk';}

@font-face {
    font-family: 'Cafe24Ssukssuk';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Ssukssuk.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

</style>
<meta charset="UTF-8">
<meta charset="EUC-KR">
<title>Post</title>
</head>
<body align=center>

<form id=frmupda action="uppost" method=post>
<input type=hidden name=se value='${mdto.seqbbs}'>
<c:if test="${user_a == '' }">
	<h2 align=center>${mdto.title}</h2>
	내용: <textarea name=upcontent rows=10 cols=70 readonly>${mdto.content}</textarea><br><br>
	<button type=submit formaction='/member/' formmethod=post>취소</button>
</c:if>
<c:if test="${user_a != '' }">
	<c:if test="${user_a == mdto.writer }">
		제목: <input type=text name=uptitle value='${mdto.title}'><br><br>
		내용: <textarea name=upcontent rows=10 cols=70>${mdto.content}</textarea><br><br>
		<input type=submit value='수정'>&nbsp;
		<button type=submit formaction='/member/' formmethod=post>취소</button>&nbsp;
		<button type=submit formaction='depost?se=${mdto.seqbbs}' formmethod=post>삭제</button>
	</c:if>
	<c:if test="${user_a != mdto.writer }">
		<h2 align=center>${mdto.title}</h2>
		내용: <textarea name=upcontent rows=10 cols=70 readonly>${mdto.content}</textarea><br><br>
		<button type=submit formaction='/member/' formmethod=post>취소</button>
	</c:if>
</c:if>
</form>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
</script>
</html>