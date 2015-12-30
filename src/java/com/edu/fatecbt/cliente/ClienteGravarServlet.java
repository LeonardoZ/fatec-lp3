package com.edu.fatecbt.cliente;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteGravar", urlPatterns = AppUrls.CLI_GRAVAR)
public class ClienteGravarServlet extends ServletBase {

    private ClienteDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cod = req.getParameter("cod");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String endereco = req.getParameter("endereco");
        String dataAniversario = req.getParameter("dataAniversario");

        Cliente cliente = null;
        // Novo cliente
        if (ehCodigoNovo(cod)) {
            cliente = new Cliente();
            cliente.setUsuario(getUsuarioAtivo(req));
        } else {
            cliente = dao.get(strToInt(cod)).orElseThrow(IllegalArgumentException::new);
        }
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setDataAniversario(configData(dataAniversario));

        if (cliente.isValid()) {
            dao.salvar(cliente);
            adicionaMensagemDeSucessoCadastro(req);
            redirect(AppUrls.CLI_TODOS, resp);
        } else {
            adicionaMensagemDeErroCadastro(req);
            req.setAttribute("cliente", cliente);
            String destino = ehCodigoNovo(cod) ? AppUrls.CLI_NOVO : AppUrls.CLI_EDITAR + "?cod=" + cod;
            redirect(destino, resp);
        }

    }

}
