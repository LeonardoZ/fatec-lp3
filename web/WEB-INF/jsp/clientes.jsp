<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div>
    <h1 class="page-header">Clientes</h1>
    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-row table-header">
                <td>Nome</td>
                <td>CPF</td>
                <td>Endereço</td>
                <td>Aniversário</td>
                <td>Responsável</td>
                <td>Ações</td>
            </tr>
        </thead>
        <tbody>
        <a href="${pageContext.request.contextPath}/cliente/novo" class="btn btn-primary margin-block">+ Novo cliente</a>
        <c:forEach items="${clientes}" var="cliente">
            <tr >
                <td style="width: 20%">${cliente.nome}</td>
                <td style="width: 20%">${cliente.cpf}</td>
                <td style="width: 20%">${cliente.endereco}</td>
                <td class="column-center" style="width: 5%">
                    <fmt:formatDate type='date' 
                                    value="${cliente.dataAniversario}"
                                    pattern="dd/MM/yyyy"/>
                </td>
                <td>${cliente.usuario.nome}</td>
                <td>
                    <div class="btn btn-group btn-group-xs">
                        <a class="btn btn-success"  href="${pageContext.request.contextPath}/cliente/editar?cod=${cliente.codCliente}">Editar</a>
                        <form class="remover" action="${pageContext.request.contextPath}/cliente/remover" method="POST">
                            <input type="hidden" name="cod" value="${cliente.codCliente}" />
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