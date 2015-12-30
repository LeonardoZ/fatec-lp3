<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div>
    <h1 class="page-header">Departamento</h1>
    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-row table-header">
                <td>Descricao</td>
                <td>Responsável</td>
                <td>Ações</td>
            </tr>
        </thead>
        <tbody>
        <a href="${pageContext.request.contextPath}/departamento/novo"  class="btn btn-primary margin-block">+ Novo departamento</a>
        <c:forEach items="${departamentos}" var="departamento">
            <tr >
                <td>${departamento.descricao}</td>
                <td>${departamento.usuario.nome}</td>
                <td>
                    <div class="btn btn-group btn-group-xs">
                        <a class="btn btn-success btn-xs"  href="${pageContext.request.contextPath}/departamento/editar?cod=${departamento.codDepartamento}">Editar</a>
                        <form action="${pageContext.request.contextPath}/departamento/remover" method="POST">
                            <input type="hidden" name="cod" value="${departamento.codDepartamento}" />
                            <button  class="btn btn-danger btn-xs">Remover</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="layout/footer.jsp" %>