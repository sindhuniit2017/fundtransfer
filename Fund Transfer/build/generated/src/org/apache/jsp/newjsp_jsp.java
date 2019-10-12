package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form name=\"loginform\" method=\"post\" action=\"auth.jsp\">\n");
      out.write("<br><br>\n");
      out.write("<table align=\"center\"><tr><td><h2>Login Authentication</h2></td></tr></table>\n");
      out.write("<table width=\"300px\" align=\"center\" style=\"border:1px solid #000000;background-color:#efefef;\">\n");
      out.write("<tr><td colspan=2></td></tr>\n");
      out.write("<tr><td colspan=2>&nbsp;</td></tr>\n");
      out.write("<tr>\n");
      out.write("<td><b>Login Name</b></td>\n");
      out.write("<td><input type=\"text\" name=\"username\" value=\"\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><b>Password</b></td>\n");
      out.write("<td><input type=\"password\" name=\"password\" value=\"\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td></td>\n");
      out.write("<td><input type=\"submit\" name=\"Submit\" value=\"Submit\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr><td colspan=2>&nbsp;</td></tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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
if(rs.next()){ 
      out.write("\n");
      out.write("<a href=\"index.jsp\">Cash Transaction</a>\n");

}
else {
response.sendRedirect("login.jsp");
}

}
}
catch(Exception e){}

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
