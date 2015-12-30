package com.edu.fatecbt.produto;

import com.edu.fatecbt.departamento.DepartamentoDAO;
import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.usuario.Usuario;
import com.edu.fatecbt.sistema.controle.AppUrls;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoGravar", urlPatterns = {AppUrls.PRODUTO_GRAVAR})
public class ProdutoGravarServlet extends ServletBase {

    private DepartamentoDAO departamentoDAO;
    private ProdutoDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProdutoDAO();
        departamentoDAO = new DepartamentoDAO();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String cod = request.getParameter("cod");
        String qtd = request.getParameter("quantidade");
        String preco = request.getParameter("preco");
        String precoCusto = request.getParameter("precoCusto");
        String margemEstoque = request.getParameter("margemEstoque");
        String data = request.getParameter("dataCadastro");
        String departamento = request.getParameter("departamento");

        Produto produto = new Produto();
        if (ehCodigoNovo(cod)) {
            produto.setCodProduto(strToInt(cod));
            produto.setQuantidade(strToDouble(qtd));
            produto.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
            produto.setDataCadastro(configData(data));
        } else {
            produto = dao.get(strToInt(cod)).orElse(new Produto());
        }
        produto.setDepartamento(departamentoDAO.get(strToInt(departamento)).get());
        produto.setDescricao(descricao);
        produto.setPreco(strToDouble(preco));
        produto.setMargemEstoque(strToDouble(margemEstoque));
        produto.setPrecoCusto(strToDouble(precoCusto));

        if (produto.isValid()) {
            dao.salvar(produto);
            adicionaMensagemDeSucessoCadastro(request);
            redirect(AppUrls.PRODUTO_TODOS, response);
        } else {
            adicionaMensagemDeErroCadastro(request);
            request.setAttribute("produto", produto);
            redirect(ehCodigoNovo(cod) ? AppUrls.PRODUTO_NOVO : AppUrls.PRODUTO_EDITAR + "?cod=" + cod,response);

        }
    }

}
