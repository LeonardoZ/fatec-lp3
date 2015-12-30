<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>The Loja</title>
        <meta  http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js" type="text/javascript" async></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript" async></script>
        <script src="${pageContext.request.contextPath}/assets/js/mask.js" type="text/javascript" async></script>
        <script src="${pageContext.request.contextPath}/assets/js/lojinha.js" type="text/javascript" async></script>
    </head>
    <body>
        <div class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">The Loja</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/main" />Principal</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Produtos<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu"> 
                            <li><a  href="${pageContext.request.contextPath}/produtos">Cadastrados</a></li>
                            <li><a  href="${pageContext.request.contextPath}/produto/novo">Novo</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/produtos?opt=margemEstoque">Produtos abaixo/margem</a></li>
                        </ul>
                    </li>
                    <li><a  href="${pageContext.request.contextPath}/fornecedores" />Fornecedores</a></li>
                    <li class="dropdown">
                        <a href="${pageContext.request.contextPath}/produtos" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Movimentação<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a  href="${pageContext.request.contextPath}/entradas" />Entradas</a></li>
                            <li><a  href="${pageContext.request.contextPath}/saidas" />Saídas</a></li>
                        </ul>
                    </li>
                    <li><a  href="${pageContext.request.contextPath}/clientes" />Clientes</a></li>
                    <li><a  href="${pageContext.request.contextPath}/departamentos" />Departamentos</a></li>
                    <li><a  href="${pageContext.request.contextPath}/usuarios" />Usuários</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Usuário: ${sessionScope.usuario.nome}<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="${pageContext.request.contextPath}/usuario/editar">Editar</a></li>  
                            <li><a href="${pageContext.request.contextPath}/usuario/logout">Logout</a></li>
                        </ul>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="message-box">
                    <p class="${sessionScope.errorMessage != null ? 'alert alert-danger':''}">${sessionScope.errorMessage}</p>
                    <p class="${sessionScope.successMessage != null ? 'alert alert-success':''}">${sessionScope.successMessage}</p>
                    <% request.getSession().removeAttribute("errorMessage"); %>
                    <% request.getSession().removeAttribute("successMessage");%>
                </div>
                <div class="col-lg-12 content">