<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/07/14, 10:40:56
    Author     : a-nkm
--%>

<%@page import="org.camp.servlet.ResultData" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <%
    ResultData data = (ResultData)request.getAttribute("DATA");
  %>
  <meta http-equiv="contentType" content="text/html: charset=UTF-8">
  <title>JSP Page</title>
  </head>
  <body>
  <%
    if(data != null){
      out.print("<h1>あなたの" + data.getDate() + "の運勢は、" + data.getLuck() + "です</h1>");
    }
  %>
  </body>
</html>
