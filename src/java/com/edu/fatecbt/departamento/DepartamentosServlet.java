package com.edu.fatecbt.departamento;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DepartamentosServlet", urlPatterns = AppUrls.DEPT_TODOS)
public class DepartamentosServlet extends ServletBase {
    
    private DepartamentoDAO dao;
    
    @Override
    public void init() throws ServletException {
        super.init();        
        dao = new DepartamentoDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("departamentos", dao.selecionaTodos());
        forward("departamentos.jsp", request, response);
    }
    
}
