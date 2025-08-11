package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Builder para Produto.
 * Atributos obrigatórios: id, descricao, marca, preco, dataCadastro, categoria.
 * Atributos opcionais com defaults: codigoEan, modelo, dataUltimaAtualizacao, estoque, urlFoto.
 */
public class ProdutoBuilder {
    // Obrigatórios
    private final long id;
    private final String descricao;
    private final String marca;
    private final double preco;
    private final LocalDate dataCadastro;
    private final String categoria;

    // Opcionais (com valores default)
    private String codigoEan = "";
    private String modelo = "";
    private LocalDate dataUltimaAtualizacao = null;
    private int estoque = 0;
    private String urlFoto = "";

    public ProdutoBuilder(long id, String descricao, String marca, double preco, LocalDate dataCadastro, String categoria) {
        if (id <= 0) {
            throw new IllegalArgumentException("id deve ser maior que zero");
        }
        this.id = id;

        this.descricao = Objects.requireNonNull(descricao, "descricao não pode ser nula");
        if (this.descricao.isBlank()) {
            throw new IllegalArgumentException("descricao não pode ser vazia");
        }

        this.marca = Objects.requireNonNull(marca, "marca não pode ser nula");
        if (this.marca.isBlank()) {
            throw new IllegalArgumentException("marca não pode ser vazia");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("preco deve ser maior que zero");
        }
        this.preco = preco;

        this.dataCadastro = Objects.requireNonNull(dataCadastro, "dataCadastro não pode ser nula");

        this.categoria = Objects.requireNonNull(categoria, "categoria não pode ser nula");
        if (this.categoria.isBlank()) {
            throw new IllegalArgumentException("categoria não pode ser vazia");
        }
    }

    public ProdutoBuilder codigoEan(String codigoEan) {
        this.codigoEan = Objects.requireNonNull(codigoEan, "codigoEan não pode ser nulo");
        return this;
    }

    public ProdutoBuilder modelo(String modelo) {
        if (this.marca == null || this.marca.isBlank()) {
            throw new IllegalStateException("Não é possível informar modelo sem marca");
        }
        this.modelo = Objects.requireNonNull(modelo, "modelo não pode ser nulo");
        return this;
    }

    public ProdutoBuilder dataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        if (dataUltimaAtualizacao == null) {
            this.dataUltimaAtualizacao = null;
            return this;
        }
        if (dataUltimaAtualizacao.isBefore(this.dataCadastro)) {
            throw new IllegalArgumentException("Data de última atualização não pode ser anterior à data de cadastro");
        }
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        return this;
    }

    public ProdutoBuilder estoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
        this.estoque = estoque;
        return this;
    }

    public ProdutoBuilder urlFoto(String urlFoto) {
        this.urlFoto = Objects.requireNonNull(urlFoto, "urlFoto não pode ser nula");
        return this;
    }

    public Produto build() {
        if (this.modelo != null && !this.modelo.isBlank() && (this.marca == null || this.marca.isBlank())) {
            throw new IllegalStateException("Não é possível informar modelo sem marca");
        }
        return new Produto(this);
    }

    // Getters para Produto acessar os valores

    public long getId() { return id; }
    public String getCodigoEan() { return codigoEan; }
    public String getDescricao() { return descricao; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPreco() { return preco; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public LocalDate getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public int getEstoque() { return estoque; }
    public String getCategoria() { return categoria; }
    public String getUrlFoto() { return urlFoto; }
}
