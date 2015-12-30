package com.edu.fatecbt.entrada;

import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.fornecedor.FornecedorDAO;
import com.edu.fatecbt.sistema.controle.AppUrls;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntradaNovo", urlPatterns = AppUrls.ENTRADA_NOVO)
public class EntradaNovoServlet extends ServletBase {

    private EntradaService service;
    private FornecedorDAO fornecedorDAO;

    @Override
    public void init() throws ServletException {
        service = new EntradaService();
        fornecedorDAO = new FornecedorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Entrada entrada = new Entrada();
        entrada.setData(new Date());
        req.setAttribute("entrada", entrada);
        req.setAttribute("produtos", service.selecionarProdutos());
        req.setAttribute("fornecedores", fornecedorDAO.selecionaTodos());
        forward("entradaFormulario.jsp", req, resp);
    }

}
