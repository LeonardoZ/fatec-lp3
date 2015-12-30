package com.edu.fatecbt.entrada;

import com.edu.fatecbt.sistema.modelo.Movimentacao;
import com.edu.fatecbt.produto.Produto;
import com.edu.fatecbt.entrada.EntradaDAO;
import com.edu.fatecbt.produto.ProdutoDAO;
import java.util.List;
import java.util.Optional;

public class EntradaService {

    private EntradaDAO entradaDAO;
    private ProdutoDAO produtoDAO;

    public EntradaService() {
        entradaDAO = new EntradaDAO();
        produtoDAO = new ProdutoDAO();
    }

    public void inserir(Entrada entidade) {
        entradaDAO.salvar(entidade);
    }

    public List<Entrada> selecionarEntradas() {
        return entradaDAO.selecionaTodos();
    }

    public List<Produto> selecionarProdutos() {
        return produtoDAO.selecionaTodos();
    }
    
    public Optional<Entrada> getEntrada(int id) {
        return entradaDAO.get(id);
    }

    public void criarEntrada(Entrada entrada) {
        entradaDAO.salvar(entrada);
        Produto produto = entrada.getProduto();
        double preco = entrada.getPreco();
        double quantidade = entrada.getQuantidade();
        produtoDAO.atualizarQuantidade(produto, quantidade, Movimentacao.ENTRADA);
        produtoDAO.atualizarPrecoCusto(produto, preco);
    }

    public Optional<Produto> getProduto(int produto) {
        return produtoDAO.get(produto);
    }

}
