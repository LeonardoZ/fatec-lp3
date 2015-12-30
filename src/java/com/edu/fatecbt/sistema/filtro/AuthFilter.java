package com.edu.fatecbt.sistema.filtro;

import com.edu.fatecbt.usuario.Usuario;
import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"},
        dispatcherTypes = {DispatcherType.REQUEST,
            DispatcherType.FORWARD,
            DispatcherType.INCLUDE})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("!!!AUTH ");
        HttpServletRequest hsr = ((HttpServletRequest) request);
        String path = ((HttpServletRequest) request).getRequestURI();
        String base = request.getServletContext().getContextPath();
        if (path.equals(base + "/index.jsp")
                || path.equals(base + "/")
                || path.startsWith(base + "/assets")
                || path.contains(base + "/login")
                || path.contains(base + "/default-error-page.jsp")) {
            chain.doFilter(request, response); // Just continue chain.
        } else {
            HttpSession ses = ((HttpServletRequest) request).getSession();
            Usuario usuario = (Usuario) ses.getAttribute("usuario");
            if (usuario == null) {
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
