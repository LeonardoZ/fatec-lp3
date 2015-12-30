package com.edu.fatecbt.saida;

import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.produto.Produto;
import com.edu.fatecbt.cliente.ClienteDAO;
import com.edu.fatecbt.sistema.controle.AppUrls;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaidaGravar", urlPatterns = AppUrls.SAIDA_GRAVAR)
public class SaidaGravarServlet extends ServletBase {

    private SaidaService service;
    private ClienteDAO clienteDAO;

    @Override
    public void init() throws ServletException {
        service = new SaidaService();
        clienteDAO = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Saida saida = new Saida();
        String cliente = request.getParameter("cliente");
        String codStr = request.getParameter("cod");
        String qtdStr = request.getParameter("quantidade");
        String produtoCod = request.getParameter("produto");
        String preco = request.getParameter("preco");
        Optional<Produto> produto
                = service.getProduto(strToInt(produtoCod.isEmpty() ? "0" : produtoCod));
        String data = request.getParameter("data");

        saida.setCodSaida(strToInt(codStr));
        saida.setCliente(clienteDAO.get(strToInt(cliente)).get());
        saida.setPreco(strToDouble(preco));
        saida.setQuantidade(strToDouble(qtdStr));
        saida.calcularTotal();
        saida.setProduto(produto.orElseGet(null));
        saida.setUsuario(getUsuarioAtivo(request));
        saida.setData(configData(data));
        if (saida.isValid()) {
            service.criarSaida(saida);
            adicionaMensagemDeSucessoCadastro(request);
            redirect(AppUrls.SAIDA_TODOS, resp);
        } else {
            adicionaMensagemDeErroCadastro(request);
            request.setAttribute("saida", saida);
            redirect(AppUrls.SAIDA_NOVO, resp);

        }
    }

}
