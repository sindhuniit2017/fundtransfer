
<%@page import="java.sql.*" %>


<%
  String a1,a2,a3,a4;
  a1=request.getParameter("t1");
  a2=request.getParameter("t2");
  a3=request.getParameter("t3");

  try
  {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
      PreparedStatement stat=con.prepareStatement("insert into trans values(?,?,?)");
      stat.setString(1,a1);
      stat.setString(2,a2);
      stat.setString(3,a3);
      stat.executeUpdate();
      
      response.sendRedirect("succ.jsp");
      PreparedStatement stat1=con.prepareStatement("select * from trans");
      ResultSet res=stat1.executeQuery();
      while(res.next())
      {
       out.println(res.getString(1));   
       out.println(res.getString(2));
       out.println(res.getString(3));
      }
      }
    
  
  catch(Exception e)
  {
   out.println(e); 
    
  } 
    
    
    
  %>