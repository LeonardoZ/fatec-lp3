package com.edu.fatecbt.produto;

import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.sistema.controle.AppUrls;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoRemoverServlet", urlPatterns = {AppUrls.PRODUTO_REMOVER})
public class ProdutoRemoverServlet extends ServletBase {

    private ProdutoDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProdutoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parameter = request.getParameter("cod");
        int cod = Integer.valueOf(parameter);
        dao.deletar(dao.get(cod).get());
        request.getSession().setAttribute("successMessage", "Produto removido com sucesso.");
        redirect(AppUrls.PRODUTO_TODOS, response);

    }

}
