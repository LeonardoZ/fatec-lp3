<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>
<div class="row">
    <div class="col-md-10 col-md-offset-1">

        <h1 class="page-header">Cadastro de Fornecedor</h1>

        <form class="form-horizontal"action="${pageContext.request.contextPath}/fornecedor/gravar" method="post">
            <input type="hidden" name="cod" value="${fornecedor.codFornecedor}" />

            <div class="form-group">
                <label class="control-label" for="nome">Nome</label>
                <input class="form-control" id="nome" value="${fornecedor.nome}"
                       type="text" name="nome"  required />
            </div>
            <div class="row form-group">
                <div class="col-md-4 box">
                    <label class="control-label" for="cnpj">CNPJ</label>
                    <input class="form-control cnpj text-center" id="cnpj" value="${fornecedor.cnpj}"
                           type="text" name="cnpj"  required  />
                </div>
                <div class="col-md-8 box-end">
                    <label class="control-label" for="endereco">Endereço</label>
                    <input class="form-control" id="endereco" value="${fornecedor.endereco }"
                           type="text" name="endereco" required  placeholder="Informe rua, número, bairro, cidade e estado" />
                </div>
            </div>
            <div class="btn btn-group pull-right">
                <button type="reset" class="btn btn-default btn-limpar">Limpar</button>
                <button type="submit" class="btn btn-success">Gravar</button>
            </div>  

    </div>  

</form>
</div>
</div>
<%@include file="layout/footer.jsp" %>