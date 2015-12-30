package com.edu.fatecbt.departamento;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DepartamentoEditar", urlPatterns = {AppUrls.DEPT_EDITAR})
public class DepartamentoEditarServlet extends ServletBase {

    private DepartamentoDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new DepartamentoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Optional<Departamento> got = dao.get(Integer.valueOf(cod == null ? "0" : cod));
        request.setAttribute("departamento", got.get());
        forward("departamentoFormulario.jsp", request, response);
    }

}
