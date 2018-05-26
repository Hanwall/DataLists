<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Refresh List Page</title>
</head>

<body>
	<script type="text/javascript">
		function request(id) {

			
			var xmlHttpReg = null;
			if (window.ActiveXObject) {
				xmlHttpReg = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				xmlHttpReg = new XMLHttpRequest(); 
			}

			
			if (xmlHttpReg != null) {
				xmlHttpReg.open("get", "/data/" + id, true);
				xmlHttpReg.send(null);
				xmlHttpReg.onreadystatechange = doResult; 

			}

			
			function doResult() {
				if (xmlHttpReg.readyState == 4) {
					if (xmlHttpReg.status == 200) {
						alert("send success");
					} else {
						
					}
				}
			}
		}
	</script>


	<%@ page import="com.hanwall.data.source.bean.Account"%>
	<%@ page import="java.util.*"%>
	<%
		List<Account> account = (List<Account>) request.getSession().getAttribute("account");
		out.print(account.size());
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
			<td><%=a.getEvidence()%></td>
		</tr>
		<%
			}
			;
		%>

	</table>

	<input type="button" value="refresh" onclick="request('refresh')" />
	<input type="button" value="add" onclick="request('add')" />
	<input type="button" value="delete" onclick="request('delete')" />
	<input type="button" value="change" onclick="request('change')" />
</body>
</html>