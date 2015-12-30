package com.edu.fatecbt.usuario;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioNovo", urlPatterns = AppUrls.USUARIO_NOVO)
public class UsuarioNovoServlet extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        req.setAttribute("usuario", usuario);
        forward("usuarioFormulario.jsp", req, resp);
    }

}
