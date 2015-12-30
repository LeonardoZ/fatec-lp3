<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div>
    <h1 class="page-header">Usuários cadastrados</h1>
    <table class="table table-striped table-condensed">
        <thead>
            <tr class="table-row table-header">
                <td>Nome</td>
                <td>Login</td>
            </tr>
        </thead>
        <tbody>
        <a href="${pageContext.request.contextPath}/usuario/novo" class="btn btn-primary margin-block">+ Novo usuário</a>
        <c:forEach items="${usuarios}" var="usuario">
            <tr >
                <td style="width: 20%">${usuario.nome}</td>
                <td style="width: 20%">${usuario.login}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="layout/footer.jsp" %>