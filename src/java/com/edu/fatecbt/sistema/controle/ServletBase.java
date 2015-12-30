package com.edu.fatecbt.sistema.controle;

import com.edu.fatecbt.usuario.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBase extends HttpServlet {

    public void forward(String path, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher d
                = request.getRequestDispatcher("/WEB-INF/jsp/" + path);
        d.forward(request, response);
    }

    public void redirect(String path, HttpServletResponse response) throws IOException {
        response.sendRedirect(base(path));
    }

    protected Usuario getUsuarioAtivo(HttpServletRequest request) {
        return (Usuario) request.getSession().getAttribute("usuario");
    }

    public void adicionaMensagemDeErroRemocao(HttpServletRequest request) {
        request.getSession().setAttribute("errorMessage", "Esse registro possui dependentes.");
    }

    public void adicionaMensagemDeErroCadastro(HttpServletRequest request) {
        request.getSession().setAttribute("errorMessage", "Preencha todos os campos corretamente");
    }

    public void adicionaMensagemDeSucessoCadastro(HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "Registro salvo com sucesso");
    }

    public boolean ehCodigoNovo(String cod) {
        return cod == null || cod.isEmpty() || cod.equals("0");
    }

    public String base(String url) {
        return getServletContext().getContextPath() + url;
    }

    public Date configData(String sdata) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            return sdf.parse(sdata);
        } catch (ParseException ex) {
            Logger.getLogger(ServletBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String intoToStr(int param) {
        return String.valueOf(param);
    }

    public int strToInt(String param) {
        if (param.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(param);
    }

    public double strToDouble(String param) {
        if (param.isEmpty()) {
            return 0;
        }
//        if(param.contains(",")){
//            param = param.replaceAll("\\.", "").replaceAll(",", ".");
//        }
        return Double.valueOf(param);
    }

    public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response, String nomeRelatorio) {
        ;
    }

}
