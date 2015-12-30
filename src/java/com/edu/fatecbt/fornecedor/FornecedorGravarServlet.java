package com.edu.fatecbt.fornecedor;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedorGravar", urlPatterns = AppUrls.FORN_GRAVAR)
public class FornecedorGravarServlet extends ServletBase {
    
    private FornecedorDAO dao;
    
    @Override
    public void init() throws ServletException {
        dao = new FornecedorDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cod = req.getParameter("cod");
        String cnpj = req.getParameter("cnpj");
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        
        Fornecedor fornecedor = null;
        // Novo fornecedor
        if (ehCodigoNovo(cod)) {
            fornecedor = new Fornecedor();
            fornecedor.setUsuario(getUsuarioAtivo(req));
        } else {
            fornecedor = dao.get(strToInt(cod)).orElse(new Fornecedor());
        }
        fornecedor.setCnpj(cnpj);
        fornecedor.setEndereco(endereco);
        fornecedor.setNome(nome);
        
        if (fornecedor.isValid()) {
            dao.salvar(fornecedor);
            
            adicionaMensagemDeSucessoCadastro(req);
            redirect(AppUrls.FORN_TODOS, resp);
        } else {
            adicionaMensagemDeErroCadastro(req);
            req.setAttribute("fornecedor", fornecedor);
            String destino = ehCodigoNovo(cod) ? AppUrls.FORN_NOVO : AppUrls.FORN_EDITAR + "?cod=" + cod;
            redirect(destino, resp);
        }
        
    }
    
}
