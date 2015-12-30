package com.edu.fatecbt.produto;
// Generated 20/05/2015 20:15:32 by Hibernate Tools 4.3.1

import com.edu.fatecbt.departamento.Departamento;
import com.edu.fatecbt.entrada.Entrada;
import com.edu.fatecbt.saida.Saida;
import com.edu.fatecbt.usuario.Usuario;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "produto", catalog = "trabalho"
)
@NamedQueries({
    @NamedQuery(name = "produto.atualizaPrecoCusto", query = "update Produto "
            + "p set p.precoCusto = :novoPreco where p.codProduto = :cod"),
    @NamedQuery(name = "produto.aumentaQuantidade", query = "update Produto "
            + "p set p.quantidade = p.quantidade + :qtd where p.codProduto = :cod"),
    @NamedQuery(name = "produto.diminuiQuantidade", query = "update Produto "
            + "p set p.quantidade = p.quantidade - :qtd where p.codProduto = :cod"),
    @NamedQuery(name = "produto.selecionarPermitidos", query = "select p "
            + " from Produto p where p.quantidade > 0.0"),
    @NamedQuery(name = "produto.abaixoDaMargemDeEstoque", query = "select p "
            + " from Produto p where p.quantidade < p.margemEstoque")

})
public class Produto implements java.io.Serializable {

    private Integer codProduto = 0;
    private Departamento departamento;
    private Usuario usuario;
    private String descricao;
    private Double precoCusto;
    private Double preco;
    private Double quantidade;
    private Date dataCadastro;
    private Double margemEstoque;
    private Set<Saida> saidas = new HashSet<Saida>(0);
    private Set<Entrada> entradas = new HashSet<Entrada>(0);

    public Produto() {
    }

    public Produto(Departamento departamento, Usuario usuario) {
        this.departamento = departamento;
        this.usuario = usuario;
    }

    public Produto(Departamento departamento, Usuario usuario, String descricao, Double precoCusto, Double preco, Double quantidade, Date dataCadastro, Double margemEstoque, Set<Saida> saidas, Set<Entrada> entradas) {
        this.departamento = departamento;
        this.usuario = usuario;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.margemEstoque = margemEstoque;
        this.saidas = saidas;
        this.entradas = entradas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "codProduto", unique = true, nullable = false)
    public Integer getCodProduto() {
        return this.codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento", nullable = false)
    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", nullable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "descricao", length = 100)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "precoCusto", precision = 22, scale = 0)
    public Double getPrecoCusto() {
        return this.precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    @Column(name = "preco", precision = 22, scale = 0)
    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Column(name = "quantidade", precision = 22, scale = 0)
    public Double getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro", length = 10)
    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Column(name = "margemEstoque", precision = 22, scale = 0)
    public Double getMargemEstoque() {
        return this.margemEstoque;
    }

    public void setMargemEstoque(Double margemEstoque) {
        this.margemEstoque = margemEstoque;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
    public Set<Saida> getSaidas() {
        return this.saidas;
    }

    public void setSaidas(Set<Saida> saidas) {
        this.saidas = saidas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
    public Set<Entrada> getEntradas() {
        return this.entradas;
    }

    public void setEntradas(Set<Entrada> entradas) {
        this.entradas = entradas;
    }

    @Transient
    public boolean isValid() {
        return !descricao.isEmpty()
                && dataCadastro != null
                && getPreco() > -1
                && getPrecoCusto() > -1
                && getQuantidade() > -1;

    }

}
