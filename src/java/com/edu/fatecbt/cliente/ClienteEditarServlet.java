package com.edu.fatecbt.cliente;

import com.edu.fatecbt.cliente.*;
import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteEditar", urlPatterns = {AppUrls.CLI_EDITAR})
public class ClienteEditarServlet extends ServletBase {

    private ClienteDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Optional<Cliente> got = dao.get(Integer.valueOf(cod == null ? "0" : cod));
        request.setAttribute("cliente", got.get());
        forward("clienteFormulario.jsp", request, response);
    }

}
