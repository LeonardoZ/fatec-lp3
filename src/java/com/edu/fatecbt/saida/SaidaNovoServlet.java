package com.edu.fatecbt.saida;

import com.edu.fatecbt.cliente.ClienteDAO;
import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaidaNovo", urlPatterns = AppUrls.SAIDA_NOVO)
public class SaidaNovoServlet extends ServletBase {
    

    private SaidaService service;
    private ClienteDAO clienteDAO;

    @Override
    public void init() throws ServletException {
        service = new SaidaService();
        clienteDAO = new ClienteDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Saida saida = new Saida();
        saida.setData(new Date());
        req.setAttribute("clientes", clienteDAO.selecionaTodos());
        req.setAttribute("saida", saida);
        req.setAttribute("produtos", service.selecionarProdutos());
        forward("saidaFormulario.jsp", req, resp);
    }
    
}
