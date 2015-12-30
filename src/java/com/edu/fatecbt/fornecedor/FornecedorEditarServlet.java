package com.edu.fatecbt.fornecedor;

import com.edu.fatecbt.produto.*;
import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedorEditar", urlPatterns = {AppUrls.FORN_EDITAR})
public class FornecedorEditarServlet extends ServletBase {

    private FornecedorDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new FornecedorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Optional<Fornecedor> got = dao.get(Integer.valueOf(cod == null ? "0" : cod));
        request.setAttribute("fornecedor", got.get());
        forward("fornecedorFormulario.jsp", request, response);
    }

}
