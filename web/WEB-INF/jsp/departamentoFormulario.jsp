
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <h1 class="page-header">Cadastro de Departamento</h1>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/departamento/gravar" method="post">
            <input type="hidden" name="cod" value="${departamento.codDepartamento}" />
            <div class="form-group">
                <label class="control-label" for="descricao">Descrição</label>
                <input class="form-control" id="descricao" value="${departamento.descricao}"
                       type="text" name="descricao" required />
            </div>
            <div class="btn btn-group pull-right">
                <button type="reset" class="btn btn-default btn-limpar">Limpar</button>
                <button type="submit" class="btn btn-success">Gravar</button>
            </div>  

        </form>
    </div>
</div>
<%@include file="layout/footer.jsp" %>