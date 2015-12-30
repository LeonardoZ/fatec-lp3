package com.edu.fatecbt.fornecedor;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedoresServlet", urlPatterns = AppUrls.FORN_TODOS)
public class FornecedoresServlet extends ServletBase {
    
    private FornecedorDAO dao;
    
    @Override
    public void init() throws ServletException {
        super.init();        
        dao = new FornecedorDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("fornecedores", dao.selecionaTodos());
        forward("fornecedores.jsp", request, response);
    }
    
}
