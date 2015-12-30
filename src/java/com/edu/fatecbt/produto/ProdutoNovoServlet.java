package com.edu.fatecbt.produto;

import com.edu.fatecbt.departamento.DepartamentoDAO;
import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.sistema.controle.AppUrls;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoNovo", urlPatterns = {AppUrls.PRODUTO_NOVO})
public class ProdutoNovoServlet extends ServletBase {
    
    private DepartamentoDAO departamentoDAO;
    
    @Override
    public void init() throws ServletException {
        departamentoDAO = new DepartamentoDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();
        produto.setDataCadastro(new Date());
        request.setAttribute("departamentos", departamentoDAO.selecionaTodos());
        request.setAttribute("produto", produto);
        forward("produtoFormulario.jsp", request, response);
    }
    
}
