<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="layout/header.jsp" %>

<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <h1 class="page-header">Cadastro de Cliente</h1>

        <form class="form-horizontal" action="${pageContext.request.contextPath}/cliente/gravar" method="post">
            <input type="hidden" name="cod" value="${cliente.codCliente}" />

            <div class="row form-group">
                <div class="col-md-8 box">
                    <label class="control-label" for="nome">Nome</label>
                    <input class="form-control" id="nome" value="${cliente.nome}"
                           type="text" name="nome"  required />
                </div>
                <div class="col-md-4 box-end">
                    <label class="control-label" for="cpf">CPF</label>
                    <input class="form-control cpf text-center" id="cpf" 
                           type="text" name="cpf" value="${cliente.cpf}" required  />
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-8 box">
                    <label class="control-label" for="endereco">Endereço</label>
                    <input class="form-control" id="endereco" value="${cliente.endereco }" required 
                           type="text" name="endereco"  placeholder="Informe rua, número, bairro, cidade e estado" />
                </div>        
                <div class="col-md-4 box-end">
                    <label class="control-label" for="dataAniversario">Data de aniversário</label>
                    <div class="input-group">
                        <div class="input-group-addon">dd/mm/aaaa</div>
                        <input class="form-control data text-center" id="dataAniversario"  required  value="<fmt:formatDate type='date' 
                                        value="${cliente.dataAniversario}"
                                        pattern="dd/MM/yyyy"/>"
                               type="text" name="dataAniversario" />
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

