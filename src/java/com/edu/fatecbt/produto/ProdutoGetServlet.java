package com.edu.fatecbt.produto;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "ProdutoGetServlet", urlPatterns = {AppUrls.PRODUTO_GET})
public class ProdutoGetServlet extends ServletBase {

    private ProdutoDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProdutoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Produto produto = dao.get(strToInt(cod)).get();
        HashMap<String, Double> map = new HashMap<>();
        map.put("cod", Double.valueOf(produto.getCodProduto()));
        map.put("preco", produto.getPreco());
        map.put("precoCusto", produto.getPrecoCusto());
        Gson gson = new Gson();
        String json = gson.toJson(map);
        ServletOutputStream out = response.getOutputStream();
        out.print(json);
        out.flush();
    }

}
