<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div id="container-saidas">
    <h1 class="page-header">Saidas</h1>
    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-header">
                <td>Cliente</td>
                <td>Data</td>
                <td>Produto</td>
                <td>Preço</td>
                <td>Total</td>
                <td>Quantidade</td>
                <td>Responsável</td>
            </tr>
        </thead>
        <tbody>
        <a href="${pageContext.request.contextPath}/saida/nova"  class="btn btn-primary margin-block">+ Nova saida</a>
        <c:forEach items="${saidas}" var="saida">
            <tr >
                <td>${saida.cliente.nome}</td>
                <td class="column-center">
                    <fmt:formatDate type='date' 
                                    value="${saida.data}"
                                    pattern="dd/MM/yyyy"/>
                </td>
                <td>${saida.produto.descricao}</td>
                <td>
                    <fmt:formatNumber value="${saida.preco}" 
                                      currencySymbol="R$ " 
                                      type="currency"/>
                </td>
                <td>
                    <fmt:formatNumber value="${saida.total}" 
                                      currencySymbol="R$ " 
                                      type="currency"/>
                </td>
                <td class="column-center">${saida.quantidade}</td>
                <td>${saida.usuario.nome}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="layout/footer.jsp" %>