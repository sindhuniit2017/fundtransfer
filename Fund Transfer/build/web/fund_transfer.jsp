<%@page import="java.sql.*"%>
<%
int acc1=Integer.parseInt(request.getParameter("no"));
int bal=Integer.parseInt(request.getParameter("amount"));
int acc2=Integer.parseInt(request.getParameter("to"));

try {
Class.forName("");
Connection con = DriverManager.getConnection("", "app", "app");
Statement st = con.createStatement();

ResultSet rs = st.executeQuery( "select balance from bank where ano='"+acc1+"'");

int balance1=0;
while (rs.next()) {
balance1=rs.getInt("balance");
}
ResultSet rs1 = st.executeQuery( "select balance from bank where ano='"+acc2+"'");

int balance2=0;
while (rs1.next()) {
balance2=rs1.getInt("balance");
}

int bal1=balance1-bal;
int bal2=balance2+bal;

st.addBatch("update bank set balance="+bal1+" where ano='"+acc1+"'");
st.addBatch("update bank set balance="+bal2+" where ano='"+acc2+"'");
st.executeBatch();
out.println("Transaction has been successfully done.");
}
catch(Exception e){}
%>