package com.edu.fatecbt.usuario;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {AppUrls.USUARIO_LOGIN})
public class LoginServlet extends ServletBase {

    private UsuarioService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean ehUsuarioLogado = service
                .ehUsuarioLogado(login, senha, request.getSession());
        if (ehUsuarioLogado) {
            redirect("/main", response);
        } else {
            request.getSession().setAttribute("errorMessage", "Usuário não autenticado");
            redirect("/index.jsp", response);
        }
    }

}
