package com.edu.fatecbt.saida;

import com.edu.fatecbt.sistema.modelo.Movimentacao;
import com.edu.fatecbt.produto.Produto;
import com.edu.fatecbt.produto.ProdutoDAO;
import java.util.List;
import java.util.Optional;

public class SaidaService {

    private SaidaDAO saidaDAO;
    private ProdutoDAO produtoDAO;

    public SaidaService() {
        saidaDAO = new SaidaDAO();
        produtoDAO = new ProdutoDAO();
    }

    public void inserir(Saida entidade) {
        saidaDAO.salvar(entidade);
    }

    public List<Saida> selecionarSaidas() {
        return saidaDAO.selecionaTodos();
    }

    public List<Produto> selecionarProdutos() {
        return produtoDAO.selecionarPermitidos();
    }

    public Optional<Saida> getSaida(int id) {
        return saidaDAO.get(id);
    }

    public void criarSaida(Saida saida) {
        saidaDAO.salvar(saida);
        Produto produto = saida.getProduto();
        double qtd = saida.getQuantidade();
        produtoDAO.atualizarQuantidade(produto, qtd, Movimentacao.SAIDA);
    }

    public Optional<Produto> getProduto(int produto) {
        return produtoDAO.get(produto);
    }

}
