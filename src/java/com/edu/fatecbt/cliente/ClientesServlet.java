package com.edu.fatecbt.cliente;

import com.edu.fatecbt.cliente.*;
import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClientesServlet", urlPatterns = AppUrls.CLI_TODOS)
public class ClientesServlet extends ServletBase {
    
    private ClienteDAO dao;
    
    @Override
    public void init() throws ServletException {
        super.init();        
        dao = new ClienteDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("clientes", dao.selecionaTodos());
        forward("clientes.jsp", request, response);
    }
    
}
