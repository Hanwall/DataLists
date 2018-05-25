<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Page</title>
</head>
<body>
	<%@ page import="com.hanwall.data.source.bean.Account"%>
	<%@ page import="java.util.*"%>
	<%
		String acc = (String) request.getAttribute("haha");
	%>
	<%
		List<Account> account = (List<Account>) request.getAttribute("account");
	%>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>SYSID</td>
			<td>USERNAME</td>
			<td>EMAIL</td>
			<td>PASSWD</td>
			<td>PHONENUM</td>
			<td>IDENTIFY</td>
			<td>LINK</td>
			<td>KEYWORDID</td>
			<td>IDTYPE</td>
			<td>STATUS</td>
			<td>EVIDENCE</td>
		</tr>
		<%
			for (Account a : account) {
		%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getSysid()%></td>
			<td><%=a.getUsername()%></td>
			<td><%=a.getEmail()%></td>
			<td><%=a.getPasswd()%></td>
			<td><%=a.getPhoneNum()%></td>
			<td><%=a.getIdentify()%></td>
			<td><%=a.getLink()%></td>
			<td><%=a.getKeywordid()%></td>
			<td><%=a.getIdtype().name()%></td>
			<td><%=a.getStatus()%></td>
			<td><%= a.getEvidence() %></td>
		</tr>
		<% }; %>

	</table>

</body>
</html>