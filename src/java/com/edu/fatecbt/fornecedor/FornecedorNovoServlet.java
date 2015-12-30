package com.edu.fatecbt.fornecedor;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedorNovoServlet", urlPatterns = AppUrls.FORN_NOVO)
public class FornecedorNovoServlet extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("fornecedor", new Fornecedor());
        forward("fornecedorFormulario.jsp", req, resp);
    }

    
    
    
}
