package com.edu.fatecbt.produto;

import com.edu.fatecbt.sistema.modelo.Movimentacao;
import com.edu.fatecbt.sistema.dados.GenericDAO;
import java.util.Collections;
import java.util.List;

public class ProdutoDAO extends GenericDAO<Produto> {


    public void atualizarQuantidade(Produto produto, double quantidade, Movimentacao movimentacao) {
        getSession().getNamedQuery(movimentacao == Movimentacao.ENTRADA
                ? "produto.aumentaQuantidade"
                : "produto.diminuiQuantidade"
        )
                .setParameter("qtd", quantidade)
                .setParameter("cod", produto.getCodProduto())
                .executeUpdate();
    }

    public void atualizarPrecoCusto(Produto produto, double preco) {
        getSession().getNamedQuery("produto.atualizaPrecoCusto")
                .setParameter("novoPreco", preco)
                .setParameter("cod", produto.getCodProduto())
                .executeUpdate();

    }

    public List<Produto> selecionarPermitidos() {
        return Collections.checkedList(getSession().getNamedQuery("produto.selecionarPermitidos").list(),getClasse());
    }
    
       public List<Produto> selecionarAbaixoDaMargem() {
        return Collections.checkedList(getSession().getNamedQuery("produto.abaixoDaMargemDeEstoque").list(),getClasse());
    }


}
