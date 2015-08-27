<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
Connection conn = null;
 conn = DriverManager.getConnection("proxool.digital");
 
  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
  String sql="select * from digital_users";   
  ResultSet rs=stmt.executeQuery(sql);   
  rs.next();
  
  out.print(rs.getString(1));
  
  rs.close();   
  stmt.close();   
  conn.close(); 
%>