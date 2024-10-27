<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 26/03/19
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>

<html>
<head>
    <title>Academia</title>
</head>
<body>
<center>
    <h1>Cliente</h1>
    <%
        List result = (List) request.getAttribute("clientes");
        Iterator iterator = result.iterator();

        out.println("<br> We have <br><br>");

        while(iterator.hasNext()){
          out.println(iterator.next() + "<br>");
        }
    %>
</center>

</body>
</html>
