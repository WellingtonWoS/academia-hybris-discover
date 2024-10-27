<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<c:url var="homepage" value="/"/>
<c:url var="novousuario" value="/usuario"/>
<c:url var="listausuario" value="/usuarios"/>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <script src="<c:url value="/resources/js/common.js" />"></script>
    <script src="<c:url value="/resources/js/register-user-script.js" />"></script>

    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/common.css" />'>
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/register-user.css" />'>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Usuario</title>

</head>
<body>
<custom:scripts/>
<custom:confirmDialog title="Confirma&ccedil;&atilde;o" message="Deseja confirmar essa opera&ccedil;&atilde;o"/>

<div class="page-container">
    <div class="page-title"> Usuario</div>

    <div class="order-header">
        <div class="sub-title">Header</div>
<c:url value="/usuario/salvar" var="salvarusuario"/>
        <form:form id="regForm" modelAttribute="user" action="${salvarusuario}" method="post">
            <form:hidden path="id" id="id_user"/>

            <c:set var="disabled" value="${user.id > 0}"/>

            <div class="flex-layout">
                <div class="flex-row">
                    <div class="flex-group ">
                        <div class="flex-col"><form:label path="username">Username</form:label></div>
                        <div class="flex-col">
                            <form:input path="username" name="username" id="username" disabled="${disabled}"
                                        class="input-width-100"/>
                        </div>
                    </div>
                </div>

                <div class="flex-row">
                    <div class="flex-group">
                        <div class="flex-col"><form:label path="senha">Password</form:label></div>
                        <div class="flex-col">
                            <form:password path="senha" name="password" id="password" class="input-width-100"/>
                        </div>
                    </div>
                </div>

                <div class="flex-row">
                    <div class="flex-group flex-group-width">
                        <div class="flex-col"><form:label path="primeiroNome">FirstName</form:label></div>
                        <div class="flex-col">
                            <form:input path="primeiroNome" name="firstname" id="firstname" class="input-width-100"/>
                        </div>
                    </div>
                </div>

                <div class="flex-row">
                    <div class="flex-group flex-group-width">
                        <div class="flex-col"><form:label path="sobrenome">LastName</form:label></div>
                        <div class="flex-col">
                            <form:input path="sobrenome" name="lastname" id="lastname" class="input-width-100"/>
                        </div>
                    </div>
                </div>

                <div class="flex-row">
                    <div class="flex-group flex-group-width">
                        <div class="flex-col"><form:label path="email">Email</form:label></div>
                        <div class="flex-col">
                            <form:input path="email" name="email" id="email" class="input-width-100"/>
                        </div>
                    </div>
                </div>

                <div class="flex-row">
                    <div class="flex-group flex-group-width">
                        <div class="flex-col"><form:label path="endereco">Address</form:label></div>
                        <div class="flex-col">
                            <form:input path="endereco" name="address" id="address" class="input-width-100"/>
                        </div>
                    </div>
                </div>

                <div class="flex-row">
                    <div class="flex-group">
                        <div class="flex-col"><form:label path="telefone">Phone</form:label></div>
                        <div class="flex-col">
                            <form:input path="telefone" name="phone" id="phone" class="input-width-100"/>
                        </div>
                    </div>
                </div>

            </div>

            <div class="user-footer">
                <div>
                    <form:button id="register" name="register">Register</form:button>
                    <button type="button" class="js-delete-user" ${disabled == false ? 'disabled="true"' :'' }>Delete
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</div>

<div class="page-footer">
    <a href="${homepage}">Home</a> |
    <a href="${listausuario}">Lista de Usuarios</a> |
    <a href="${novousuario}">Novo Usuario</a>
</div>

</body>
</html>