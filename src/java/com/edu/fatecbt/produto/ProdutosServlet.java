package com.edu.fatecbt.produto;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "ProdutosServlet", urlPatterns = {AppUrls.PRODUTO_TODOS})
public class ProdutosServlet extends ServletBase {

    private ProdutoDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProdutoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opt = request.getParameter("opt");
        if (opt != null && opt.equals("margemEstoque")) {
            request.setAttribute("produtos", dao.selecionarAbaixoDaMargem());
            request.setAttribute("titulo", "Produtos abaixo da margem de estoque");
        } else {
            request.setAttribute("produtos", dao.selecionaTodos());
            request.setAttribute("titulo", "Produtos");
        }
        forward("produtos.jsp", request, response);
    }

}
