<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN PAGE</title>
<style type="text/css">
body {background-image:url(Resources/Login.jpg);}
div{position: absolute;/*绝对定位*/
width: 300px;
height: 200px;
text-align: center;/*(让div中的内容居中)*/
top: 50%;
left: 50%;
margin-top: -200px;
margin-left: -150px;}
form {background-color:#ffffff;}
</style>
</head>
<body>
<div>
<form action="auth" method="post">
  <p>LOGIN:</p><input type="password" name="passwd" style="text-align:center;"/><br/>
  <br/>
  <input type="submit" value="Submit" />
</form>
</div>
</body>
</html>