package com.edu.fatecbt.sistema.filtro;

import com.edu.fatecbt.sistema.dados.HibernateUtil;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(filterName = "A1OpenSessionViewFilter", urlPatterns = {"/*",},
        dispatcherTypes = {DispatcherType.REQUEST,
            DispatcherType.FORWARD})
public class OpenSessionViewFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(OpenSessionViewFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getRequestURI();
        if (path.equals("/theloja/")
                || path.equals("/theloja/index.jsp")
                || path.startsWith("/theloja/assets")
                || path.contains("/theloja/default-error-page.jsp")) {
            chain.doFilter(request, response); // Just continue chain.
        } else {
            Transaction transaction = null;
            Session session = null;
            try {
                Session ssession = HibernateUtil.getSessionFactory().getCurrentSession();
                if (ssession.getTransaction().isActive()) {
                    chain.doFilter(request, response);
                } else {
                    transaction = ssession.beginTransaction();
                    chain.doFilter(request, response);
                    transaction.commit();
                }
            } catch (Exception e) {
                if ((transaction != null) && (transaction.isActive())) {
                    transaction.rollback();
                }
                e.printStackTrace();
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
