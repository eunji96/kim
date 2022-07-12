<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성</title>
</head>
<style>
body{
	background-image:url('https://i.pinimg.com/originals/19/e4/4a/19e44a1d69843a900d604a062b592093.gif');
	background-repeat:no-repeat;
	background-size:cover;
}
</style>
<body align=center>
<form id=frmAddnew method=get action="postwriter">
제목: <input type=text id=title name=title><br><br>
내용: <textarea id=content name=content rows=10 cols=70></textarea><br><br>
<input type=submit id=btnNew value='작성'>&nbsp;
<button type=submit formaction='/member/' formmethod=post>취소</button>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
/* $(document)
.on('click','#btnList',function(){
	document.location='/member';
}) */
/* .on('click','#btnNew',function(){
	document.location='postwriter';
}) */
</script>
</html>