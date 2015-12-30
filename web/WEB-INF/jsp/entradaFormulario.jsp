
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <h1 class="page-header">Cadastro de Entrada</h1>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/entrada/gravar" method="post">
            <input type="hidden" name="cod" value="${entrada.codEntrada}" />

            <div class="form-group">
                <label class="control-label" for="produto">Produto</label>
                <select class="form-control produto" id="produto"  name="produto">
                    <c:forEach items="${produtos}" var="p">
                        <option value="${p.codProduto}">${p.descricao} - Custo: R$ ${p.precoCusto}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label" for="fornecedor" >Fornecedor</label>
                <select class="form-control" id="fornecedor" name="fornecedor">
                    <c:forEach items="${fornecedores}" var="f">
                        <option value="${f.codFornecedor}">${f.nome}</option>
                    </c:forEach>
                </select>
            </div>       

            <div class="row form-group">
                <div class="col-md-4 box">
                    <label class="control-label" for="precoCusto">Preço</label>
                    <div class="input-group">
                        <div class="input-group-addon">R$</div>
                        <input class="form-control text-right"  required  id="precoCusto" value="${entrada.preco}"
                               type="text" name="preco" />
                    </div>
                </div>
                <div class="col-md-4 box">
                    <label class="control-label" for="quantidade">Quantidade</label>
                    <input class="form-control text-center"  required  id="quantidade"  value="${entrada.quantidade}"
                           type="text" name="quantidade" />
                </div>
                <div class="col-md-4 box-end">
                    <label class="control-label" for="data">Data</label>
                    <div class="input-group">
                        <div class="input-group-addon">dd/mm/aaaa</div>
                        <input  class="form-control data text-center"  required  id="data"  value="<fmt:formatDate type='date' 
                                        value="${entrada.data}"
                                        pattern="dd/MM/yyyy"/>"
                                type="text" name="data" />
                    </div>
                </div>

            </div>
            <div class="btn btn-group pull-right">
                <button type="reset" class="btn btn-default btn-limpar">Limpar</button>
                <button type="submit" class="btn btn-success">Gravar</button>
            </div>  

        </form>

    </div>
    <%@include file="layout/footer.jsp" %>