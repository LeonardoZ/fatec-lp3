<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div>
    <h1 class="page-header">Fornecedores</h1>
    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-header">
                <td>Nome</td>
                <td>CNPJ</td>
                <td>Endereço</td>
                <td>Responsável</td>
                <td>Ações</td>
            </tr>
        </thead>
        <tbody>
        <a class="btn btn-primary margin-block" href="${pageContext.request.contextPath}/fornecedor/novo" class="btn btn-primary margin-block">+ Novo fornecedor</a>
        <c:forEach items="${fornecedores}" var="fornecedor">
            <tr>
                <td>${fornecedor.nome}</td>
                <td>${fornecedor.cnpj}</td>
                <td>${fornecedor.endereco}</td>
                <td>${fornecedor.usuario.nome}</td>
                <td>
                    <div class="btn btn-group btn-group-xs">
                        <a class="btn btn-success btn-xs remover" href="${pageContext.request.contextPath}/fornecedor/editar?cod=${fornecedor.codFornecedor}">Editar</a>
                        <form action="${pageContext.request.contextPath}/fornecedor/remover" method="POST">
                            <input type="hidden" name="cod" value="${fornecedor.codFornecedor}" />
                            <button class="btn btn-danger btn-xs">Remover</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="layout/footer.jsp" %>