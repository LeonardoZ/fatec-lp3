package com.edu.fatecbt.departamento;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DepartamentoNovoServlet", urlPatterns = AppUrls.DEPT_NOVO)
public class DepartamentoNovoServlet extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departamento", new Departamento());
        forward("departamentoFormulario.jsp", req, resp);
    }

    
    
    
}
