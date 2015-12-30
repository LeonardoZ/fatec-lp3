package com.edu.fatecbt.entrada;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntradasServlet", urlPatterns = {AppUrls.ENTRADA_TODOS})
public class EntradasServlet extends ServletBase {

    private EntradaService service;

    @Override
    public void init() throws ServletException {
        service = new EntradaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Entrada> entradas = service.selecionarEntradas();
        req.setAttribute("entradas", entradas);
        forward("entradas.jsp", req, resp);
    }

}
