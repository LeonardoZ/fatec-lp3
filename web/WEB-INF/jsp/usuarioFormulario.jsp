<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <h1 class="page-header">Cadastro de Usuário</h1>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/usuario/gravar" method="post">
            <input type="hidden" name="cod" value="${usuario.codUsuario}" />

            <div class="form-group">
                <label class="control-label" for="nome">Nome</label>
                <input class="form-control" id="nome" value="${usuario.nome}"
                       type="text" name="nome"  required />
            </div>

            <div class="row form-group">
                <div class="col-md-6 box">
                    <label class="control-label" for="ilogin">Login</label>
                    <input  ${usuario.codUsuario != 0 ? 'disabled' : '' }  autocomplete="off" class="form-control" id="ilogin" value="${usuario.codUsuario == 0 ? '' : usuario.login}"
                                                                           type="text" name="ilogin"  required  />
                </div>
                <div class="col-md-6 box-end">
                    <label class="control-label" for="isenha">Senha</label>
                    <input class="form-control" autocomplete="off" id="isenha" value="${usuario.codUsuario == 0 ? '' : usuario.senha}"
                           type="password" name="isenha" required  />
                </div>

            </div>

            <div class="btn btn-group pull-right">
                <button type="reset" class="btn btn-default btn-limpar">Limpar</button>
                <button type="submit" class="btn btn-success">Gravar</button>
            </div>  

        </form>
    </div>
</div>
<%@include file="layout/footer.jsp" %>