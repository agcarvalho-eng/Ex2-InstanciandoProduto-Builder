package org.example.model;

import java.time.LocalDate;

/**
 * Classe que representa um produto no sistema.
 * Será utilizada a classe ProdutoBuilder para criar instâncias,
 * haja vista a existência de atributos não obrigatórios.
 */
public final class Produto {
    private final long id;
    private final String codigoEan;
    private final String descricao;
    private final String marca;
    private final String modelo;
    private final double preco;
    private final LocalDate dataCadastro;
    private final LocalDate dataUltimaAtualizacao;
    private final int estoque;
    private final String categoria;
    private final String urlFoto;

    Produto(ProdutoBuilder builder) {
        this.id = builder.getId();
        this.codigoEan = builder.getCodigoEan();
        this.descricao = builder.getDescricao();
        this.marca = builder.getMarca();
        this.modelo = builder.getModelo();
        this.preco = builder.getPreco();
        this.dataCadastro = builder.getDataCadastro();
        this.dataUltimaAtualizacao = builder.getDataUltimaAtualizacao();
        this.estoque = builder.getEstoque();
        this.categoria = builder.getCategoria();
        this.urlFoto = builder.getUrlFoto();
    }

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

    @Override
    public String toString() {
        return "Produto{" + '\n' +
                "id=" + id + '\n' +
                ", codigoEan='" + codigoEan + '\n' +
                ", descricao='" + descricao + '\n' +
                ", marca='" + marca + '\n' +
                ", modelo='" + modelo + '\n' +
                ", preco=" + preco + '\n' +
                ", dataCadastro=" + dataCadastro + '\n' +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao + '\n' +
                ", estoque=" + estoque + '\n' +
                ", categoria='" + categoria + '\n' +
                ", urlFoto='" + urlFoto + '\n' +
                '}';
    }
}
