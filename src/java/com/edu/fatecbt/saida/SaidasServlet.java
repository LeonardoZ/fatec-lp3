package com.edu.fatecbt.saida;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaidasServlet", urlPatterns = {AppUrls.SAIDA_TODOS})
public class SaidasServlet extends ServletBase {

    private SaidaService service;

    @Override
    public void init() throws ServletException {
        service = new SaidaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Saida> saidas = service.selecionarSaidas();
        req.setAttribute("saidas", saidas);
        forward("saidas.jsp", req, resp);
    }

}
