package com.edu.fatecbt.cliente;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "ClienteDeletarServlet", urlPatterns = {AppUrls.CLI_REMOVER})
public class ClienteRemoverServlet extends ServletBase {

    private ClienteDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Cliente c = dao.get(strToInt(cod)).get();
        redirect(AppUrls.CLI_TODOS, response);
    }

    private static final Logger LOG = Logger.getLogger(ClienteRemoverServlet.class.getName());
}
