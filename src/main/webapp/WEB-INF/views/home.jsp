<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
table{border-collapse:collapse;
		font-family: 'Cafe24Ssukssuk';
		font-size: 20px;
		background-color:white;
		}

th, td{border:1px solid brown;}

p{font-size: 18px;
	font-family: 'Cafe24Ssukssuk';
	color: brown;
	}
	
h1{font-family: 'Cafe24Ssukssuk';
	color:brown;
	}

body{
	background-image:url('https://i.pinimg.com/originals/19/e4/4a/19e44a1d69843a900d604a062b592093.gif');
	background-repeat:no-repeat;
	background-size:cover;
}

@font-face {
    font-family: 'Cafe24Ssukssuk';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Ssukssuk.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
</style>
<body>
<c:if test="${userinfo == '' }">
<p align=right><a href='login'>로그인</a>&nbsp;<a href='signin'>회원가입</a></p>
</c:if>
<c:if test="${userinfo != '' }">
<p align=right>${userinfo}🦝&nbsp;<a href='logout'>로그아웃</a></p>
</c:if>
<h1 align=center>도치의 게시판🦔</h1>
<table align=center>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th></tr>
<c:forEach var="i" items="${list }">
	<tr><th>${i.seqbbs }</th><th><a id=a_ href='post?se=${i.seqbbs }&vw=${i.vw }'>${i.title }</a></th><th>${i.writer }</th><th>${i.created }</th><th>${i.vw }</th></tr>
</c:forEach>
</table>
<c:if test="${userinfo != '' }">
<p align=center><a href='newpost'>새글작성</a></p>
</c:if>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
</script>
</html>
