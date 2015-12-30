<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <h1 class="page-header">Cadastro de produto</h1>

        <form class="form-horizontal" action="${pageContext.request.contextPath}/produto/gravar" method="post">
            <input type="hidden" name="cod" value="${produto.codProduto}" />
            <div class="form-group">
                <label class="control-label" for="descricao">Descrição</label>
                <input class="form-control"  required id="descricao" value="${produto.descricao}"
                       type="text" name="descricao" />
            </div>
            <div class="row form-group">
                <div class="col-md-3 box" >
                    <label class="control-label box" for="preco">Preço</label>
                    <div class="input-group">
                        <div class="input-group-addon">R$</div>
                        <input class="form-control text-right dinheiro"  required  id="preco" value="${produto.preco}"
                               type="text" name="preco" />
                    </div>
                </div>
                <div class="col-md-3 box">
                    <label class="control-label box" for="precoCusto">Preço de custo</label>
                    <div class="input-group">
                        <div class="input-group-addon">R$</div>
                        <input class="form-control text-right dinheiro"  required id="precoCusto" 
                               value="${produto.precoCusto }"
                               type="text" name="precoCusto" />
                    </div>
                </div>
                <div class="col-md-3 box">
                    <label class="control-label box" for="margemEstoque">Margem de estoque</label>
                    <input class="form-control numerico text-center" id="margemEstoque" value="${produto.margemEstoque }"
                           type="text" name="margemEstoque"  required  />
                </div>
                <div class="col-md-3 box-end " >
                    <label class="control-label" for="quantidade">Quantidade</label>
                    <input class="form-control numerico text-center"  ${produto.codProduto != 0 ? 'disabled' : '' } id="quantidade"  value="${produto.quantidade}"
                           type="text" name="quantidade"  required />
                </div>
            </div>

            <div class="row form-group">
                <div class="col-md-8 box">
                    <label class="control-label" for="departamento" >Departamento</label>
                    <select class="form-control" id="departamento" name="departamento">
                        <c:forEach items="${departamentos}" var="d">
                            <option ${d.codDepartamento == produto.departamento.codDepartamento ? 'selected':''} 
                                value="${d.codDepartamento}">${d.descricao}</option>
                        </c:forEach>
                    </select>
                </div>                       

                <div class="col-md-4 box-end">
                    <label class="control-label" for="dataCadastro">Data de cadastro</label>
                    <div class="input-group">
                        <div class="input-group-addon">dd/mm/aaaa</div>

                        <input class="form-control data text-center" id="dataCadastro"  ${produto.codProduto != 0 ? 'disabled' : '' }
                               value="<fmt:formatDate type='date' 
                                               value="${produto.dataCadastro }"
                                               pattern="dd/MM/yyyy"/>"                   
                               type="text" name="dataCadastro"  required />
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