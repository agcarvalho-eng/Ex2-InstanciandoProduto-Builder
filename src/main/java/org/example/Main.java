package org.example;

import org.example.model.Produto;
import org.example.model.ProdutoBuilder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Produto válido com dataCadastro fornecida
        Produto p1 = new ProdutoBuilder(1L, "Smartphone X", "Samsung", 1999.99,
                LocalDate.of(2025, 8, 11), "Eletrônicos")
                .codigoEan("1234567890123")
                .modelo("X200")
                .estoque(50)
                .urlFoto("http://exemplo.com/foto.jpg")
                .dataUltimaAtualizacao(LocalDate.of(2025, 8, 12))
                .build();

        System.out.println(p1);

        // Teste complementar com dataUltimaAtualizacao anterior a dataCadastro (irá gerar um erro)
        try {
            new ProdutoBuilder(2L, "Produto inválido", "Marca", 150.0,
                    LocalDate.of(2025, 8, 11), "Categoria")
                    .dataUltimaAtualizacao(LocalDate.of(2025, 8, 10))
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
