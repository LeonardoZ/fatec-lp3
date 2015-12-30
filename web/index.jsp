<%-- 
    Document   : index
    Created on : Mar 31, 2015, 10:08:18 AM
    Author     : leonardo
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"  />
    </head>
    <body>

        <div id="login-form">
            <h1 class="page-header">The Loja - Login</h1>
            <form class="form" action="login" method="post">
                <div class="form-group">
                    <label class="control-label" for="login">Login</label>
                    <input class="form-control" id="login" type="text" name="login" />
                </div>
                <div class="form-group">
                    <label class="control-label" for="senha">Senha</label>
                    <input class="form-control" id="senha" type="password" name="senha" />
                </div>
                <div class="message-box">
                    <p class="error-message">${sessionScope.errorMessage}</p>
                    <% request.getSession().removeAttribute("errorMessage"); %>
                </div>
                <div class="form-group pull-right">
                    <button  type="reset" class="btn btn-success limpar">Limpar</button>
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </div>   
            </form>
        </div>

    </body>
</html>
