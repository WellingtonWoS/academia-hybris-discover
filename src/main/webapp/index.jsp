<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
<ul>
    <c:url var="listUser" value="/users"/>
    <c:url var="notFound" value="/not-found"/>
    <c:url var="listOrder" value="/orders"/>

    <li><a href="${listUser}">Lista de Usuarios</a></li>
    <li><a href="${listOrder}">Lista de Pedidos</a></li>
    <li><a href="${notFound}">Not Found Page</a></li>
</ul>
</body>
</html>