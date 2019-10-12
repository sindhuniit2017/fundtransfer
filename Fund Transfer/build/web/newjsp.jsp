<html>
<head>
</head>
<body>
<form name="loginform" method="post" action="auth.jsp">
<br><br>
<table align="center"><tr><td><h2>Login Authentication</h2></td></tr></table>
<table width="300px" align="center" style="border:1px solid #000000;background-color:#efefef;">
<tr><td colspan=2></td></tr>
<tr><td colspan=2>&nbsp;</td></tr>
<tr>
<td><b>Login Name</b></td>
<td><input type="text" name="username" value=""></td>
</tr>
<tr>
<td><b>Password</b></td>
<td><input type="password" name="password" value=""></td>
</tr>

<tr>
<td></td>
<td><input type="submit" name="Submit" value="Submit"></td>
</tr>
<tr><td colspan=2>&nbsp;</td></tr>
</table>
</form>
</body>
</html>



<%@ page language="Java" import="java.sql.*" %>
<%
Connection conn = null;
String url = "jdbc:derby://localhost:1527/sample";;
String dbName = "";
String driver = "org.apache.derby.jdbc.ClientDriver";
String userName = "app";
String password = "app";
try {
Class.forName(driver).newInstance();
conn = DriverManager.getConnection(url+dbName,userName,password);
if(request.getParameter("username")!=null && request.getParameter("username")!="" && request.getParameter("password")!=null && request.getParameter("password")!="")
{
String username = request.getParameter("username");
String userpass = request.getParameter("password");;
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select * from user where username='"+username+"' and password='"+userpass+"'");
int count=0;
if(rs.next()){ %>
<a href="index.jsp">Cash Transaction</a>
<%
}
else {
response.sendRedirect("login.jsp");
}

}
}
catch(Exception e){}
%>