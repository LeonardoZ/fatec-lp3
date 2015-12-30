package com.edu.fatecbt.entrada;

import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.produto.Produto;
import com.edu.fatecbt.fornecedor.FornecedorDAO;
import com.edu.fatecbt.sistema.controle.AppUrls;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntradaGravar", urlPatterns = {AppUrls.ENTRADA_GRAVAR})
public class EntradaGravarServlet extends ServletBase {

    private EntradaService service;
    private FornecedorDAO fornecedorDAO;

    @Override
    public void init() throws ServletException {
        service = new EntradaService();
        fornecedorDAO = new FornecedorDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Entrada entrada = new Entrada();
        String codStr = request.getParameter("cod");
        String qtdStr = request.getParameter("quantidade");
        String produtoCod = request.getParameter("produto");
        String fornecedor = request.getParameter("fornecedor");
        String preco = request.getParameter("preco");
        Optional<Produto> produto = service
                .getProduto(Integer.valueOf(
                                produtoCod.isEmpty() ? "0" : produtoCod)
                );
        String data = request.getParameter("data");

        entrada.setCodEntrada(strToInt(codStr));
        entrada.setFornecedor(fornecedorDAO.get(Integer.valueOf(fornecedor)).get());
        entrada.setPreco(strToDouble(preco));
        entrada.setQuantidade(strToDouble(qtdStr));
        entrada.calcularTotal();
        entrada.setProduto(produto.get());
        entrada.setUsuario(getUsuarioAtivo(request));
        entrada.setData(configData(data));

        if (entrada.isValid()) {
            service.criarEntrada(entrada);
            adicionaMensagemDeSucessoCadastro(request);
            redirect(AppUrls.ENTRADA_TODOS, resp);
        } else {
            adicionaMensagemDeErroCadastro(request);
            request.setAttribute("entrada", entrada);
            redirect(AppUrls.ENTRADA_NOVO, resp);

        }
    }

}
