/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    function cleanupFields() {
        var $inputs = $(':input');
        $.each($inputs, function (i, e) {
            $e = $(e);
            if ($e.prop('disabled') === false && $e.attr('type') !== 'hidden') {
                $e.attr('value', '');
            }
        });
        $('select').attr("selected", false);
    }

    function configuraLimparGenerico() {
        $("button.btn-limpar").click(function () {
            cleanupFields();
        });
    }
    function configuraMascaras() {
        $(".cpf").mask("999.999.999-99",{placeholder:"___.___.___-__"});
        $(".data").mask("99/99/9999",{placeholder:"  /  /  "});
//        $('.dinheiro').mask("#.##0,00", {reverse: true});
        $('.cnpj').mask("99.999.999/9999-99",{placeholder:"__.___.___/____-__"});

    }

    function configuraRemover() {
        $("form.remover").submit(function (e) {
            if (confirm('Deseja excluir o registro selecionado?')) {
                $(e).submit();
            } else {
                e.preventDefault();
            }
        });
    }

    function vincularSelectProdutoPreco() {
        vincularProdutoComTipoDePreco(
                function (data, textStatus) {
                    if (textStatus === "success") {
                        var preco = data.preco;
                        $("#preco").attr("value", preco);
                    }
                });

    }
    function vincularSelectProdutoPrecoCusto() {
        vincularProdutoComTipoDePreco(
                function (data, textStatus) {
                    if (textStatus === "success") {
                        var preco = data.precoCusto;
                        $("#precoCusto").attr("value", preco);
                    }
                });


    }

    function vincularProdutoComTipoDePreco(success) {
        $('select.produto').on('change', function (e) {
            var valueSelected = this.value;
            $.getJSON("/theloja/produto?cod=" + valueSelected, null, success);
        });
    }

    configuraMascaras();
    configuraRemover();
    configuraLimparGenerico();
    vincularSelectProdutoPreco();
    vincularSelectProdutoPrecoCusto();

});

