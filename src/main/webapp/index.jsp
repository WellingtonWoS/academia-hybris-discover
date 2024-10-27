<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
<ul>
    <c:url value="/usuarios" var="usuarios"/>
    <li><a href="${usuarios}">Lista de Usuarios</a></li>
</ul>
</body>
</html>