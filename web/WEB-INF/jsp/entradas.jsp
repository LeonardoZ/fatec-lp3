<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div id="container-entradas">
    <h1 class="page-header">Entradas</h1>

    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-row table-header">
                <td>Fornecedor</td>
                <td>Data</td>
                <td>Produto</td>
                <td>Preço</td>
                <td>Total</td>
                <td>Quantidade</td>
                <td>Responsável</td>
            </tr>
        </thead>
        <tbody>

        <div class="btn btn-group">
            <a href="${pageContext.request.contextPath}/entrada/nova"  class="btn btn-primary margin-block">+ Nova entrada</a>
            <a target="_blank" href="${pageContext.request.contextPath}/relatorio?nome=entradas" class="btn btn-primary margin-block  pull right">Imprimir</a>

        </div>
        <c:forEach items="${entradas}" var="entrada">
            <tr >
                <td>${entrada.fornecedor.nome} - ${entrada.fornecedor.cnpj}</td>
                <td class="column-center">
                    <fmt:formatDate type='date' 
                                    value="${entrada.data}"
                                    pattern="dd/MM/yyyy"/>
                </td>
                <td>${entrada.produto.descricao}</td>
                <td>
                    <fmt:formatNumber value="${entrada.preco}" 
                                      currencySymbol="R$ " 
                                      type="currency"/>

                </td>
                <td>      
                    <fmt:formatNumber value="${entrada.total}" 
                                      currencySymbol="R$ " 
                                      type="currency"/></td>
                <td class="column-center">${entrada.quantidade}</td>
                <td>${entrada.usuario.nome}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="layout/footer.jsp" %>