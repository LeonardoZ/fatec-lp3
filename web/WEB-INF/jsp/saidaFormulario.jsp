<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div class="row">
    <div class="col-md-10 col-md-offset-1">

        <h1 class="page-header">Cadastro de Saida</h1>

        <form class="form-horizontal" action="${pageContext.request.contextPath}/saida/gravar" method="post">
            <input type="hidden" name="cod" value="${saida.codSaida}" />

            <div class="form-group">
                <label class="control-label" for="cliente">Cliente</label>
                <select class="form-control produto" id="cliente"  name="cliente">
                    <c:forEach items="${clientes}" var="c">
                        <option value="${c.codCliente}">${c.nome}</option>
                    </c:forEach>
                </select>
            </div>

            <div class=" form-group">
                <label class="control-label" for="produto">Produto</label>
                <select class="form-control produto" id="produto"  name="produto">
                    <c:forEach items="${produtos}" var="p">
                        <option value="${p.codProduto}">${p.descricao} - Preco: R$ ${p.preco} - qtd.: ${p.quantidade}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="row form-group">
                <div class="col-md-4 box">
                    <label class="control-label" for="preco">Preço</label>
                    <div class="input-group">
                        <div class="input-group-addon">R$</div>
                        <input class="form-control text-right" id="preco" value="${saida.preco}"
                               type="text" name="preco" required  />
                    </div>
                </div>
                <div class="col-md-4 box">
                    <label class="control-label" for="quantidade">Quantidade</label>
                    <input class="form-control text-center" id="quantidade"  value="${saida.quantidade}"
                           type="text" name="quantidade" required  />
                </div>
                <div class="col-md-4 box-end">
                    <label class="control-label" for="data">Data</label>
                    <div class="input-group">
                        <div class="input-group-addon">dd/mm/aaaa</div>
                        <input class="form-control data" id="data"  value="<fmt:formatDate type='date' 
                                        value="${saida.data}"
                                        pattern="dd/MM/yyyy"/>"
                               type="text" name="data"  required />
                    </div>
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