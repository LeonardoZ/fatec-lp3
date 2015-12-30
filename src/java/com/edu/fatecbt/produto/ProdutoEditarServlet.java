package com.edu.fatecbt.produto;

import com.edu.fatecbt.departamento.DepartamentoDAO;
import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoEditar", urlPatterns = {AppUrls.PRODUTO_EDITAR})
public class ProdutoEditarServlet extends ServletBase {

    private DepartamentoDAO departamentoDAO;
    private ProdutoDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProdutoDAO();
        departamentoDAO = new DepartamentoDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Optional<Produto> got = dao.get(Integer.valueOf(cod.isEmpty() ? "0" : cod));
        request.setAttribute("departamentos", departamentoDAO.selecionaTodos());
        request.setAttribute("produto", got.get());
        forward("produtoFormulario.jsp", request, response);
    }

}
