<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div id="container-produtos">
    <h1 class="page-header">${titulo}</h1>
    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-row table-header">
                <td>Descrição</td>
                <td>Preço</td>
                <td>Custo</td>
                <td>Quantidade</td>
                <td>Margem</td>
                <td>Data de cadastro</td>
                <td>Responsável</td>
                <td>Ações</td>
            </tr>
        </thead>
        <tbody>
        <div class="btn btn-group">
            <a href="${pageContext.request.contextPath}/produto/novo" class="btn btn-primary margin-block">+ Novo produto</a>
            <a target="_blank" href="${pageContext.request.contextPath}/relatorio?nome=produtos_margem" class="btn btn-primary margin-block  pull right">Imprimir produtos abaixo margem</a>
            
        </div>
        <c:forEach items="${produtos}" var="produto">
            <tr class="${produto.quantidade < produto.margemEstoque ? 'danger' : ''}" >
                <td>${produto.descricao}</td>
                <td>
                    <fmt:formatNumber value="${produto.preco}" 
                                      currencySymbol="R$ " 
                                      type="currency"/>
                </td>
                <td> 
                    <fmt:formatNumber value="${produto.precoCusto}" 
                                      currencySymbol="R$ " 
                                      type="currency"/></td>
                <td class="column-center">${produto.quantidade}</td>
                <td>
                    ${produto.margemEstoque}
                </td>
                <td class="column-center">
                    <fmt:formatDate type='date' 
                                    value="${produto.dataCadastro}"
                                    pattern="dd/MM/yyyy"/>
                </td>
                <td>${produto.usuario.nome}</td>
                <td>
                    <div class="btn btn-group btn-group-xs">
                        <a class="btn btn-success  btn-xs"  href="${pageContext.request.contextPath}/produto/editar?cod=${produto.codProduto}">Editar</a>
                        <form action="${pageContext.request.contextPath}/produto/remover" method="POST">
                            <input type="hidden" name="cod" value="${produto.codProduto}" />
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