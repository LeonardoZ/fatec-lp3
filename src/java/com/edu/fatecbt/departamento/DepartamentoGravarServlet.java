package com.edu.fatecbt.departamento;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DepartamentoGravar", urlPatterns = AppUrls.DEPT_GRAVAR)
public class DepartamentoGravarServlet extends ServletBase {

    private DepartamentoDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new DepartamentoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cod = req.getParameter("cod");
        String descricao = req.getParameter("descricao");
        Departamento departamento = null;
        // Novo departamento
        if (ehCodigoNovo(cod)) {
            departamento = new Departamento();
            departamento.setUsuario(getUsuarioAtivo(req));
        } else {
            departamento = dao.get(strToInt(cod)).orElseThrow(IllegalArgumentException::new);
        }
        departamento.setDescricao(descricao);

        if (departamento.isValid()) {
            dao.salvar(departamento);
            adicionaMensagemDeSucessoCadastro(req);
            redirect(AppUrls.DEPT_TODOS, resp);
        } else {
            adicionaMensagemDeErroCadastro(req);
            req.setAttribute("departamento", departamento);
            String destino = ehCodigoNovo(cod) ? AppUrls.DEPT_NOVO : AppUrls.DEPT_EDITAR + "?cod=" + cod;
            redirect(destino, resp);
        }

    }

}
