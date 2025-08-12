# Projeto Instanciando Classe Produto usando o Padrão Builder 

Descrição

Este projeto implementa a classe Produto utilizando o Padrão de Projeto Builder, que é indicado para situações onde:

    # Existem atributos obrigatórios e opcionais na construção de um objeto;
    # Alguns atributos possuem dependências entre si;
    # Regras de validação complexas devem ser aplicadas durante a instanciação;
    # O construtor tradicional ficaria muito extenso, confuso e difícil de manter.

Atributos da classe Produto:
| Atributo                          | Obrigatório | Observações                                                 |
| --------------------------------- | ----------- | ----------------------------------------------------------- |
| `long id`                         | Sim         | Deve ser maior que zero                                     |
| `String codigoEan`                | Não         | Código de barras, não pode ser null (default: string vazia) |
| `String descricao`                | Sim         | Não pode ser null ou vazio                                  |
| `String marca`                    | Sim         | Não pode ser null ou vazio                                  |
| `String modelo`                   | Não         | Não pode ser informado se `marca` estiver vazia ou null     |
| `double preco`                    | Sim         | Deve ser maior que zero                                     |
| `LocalDate dataCadastro`          | Sim         | Deve ser fornecida na construção, não pode ser null         |
| `LocalDate dataUltimaAtualizacao` | Não         | Se informada, não pode ser anterior a `dataCadastro`        |
| `int estoque`                     | Não         | Valor padrão 0, não pode ser negativo                       |
| `String categoria`                | Sim         | Não pode ser null ou vazio                                  |
| `String urlFoto`                  | Não         | Não pode ser null (default: string vazia)                   |

## Padrão de Projeto Utilizado: Builder

O Builder foi utilizado para facilitar a criação de objetos complexos com muitas propriedades, algumas obrigatórias, outras opcionais, e com regras de validação e dependência entre atributos. Isso traz vários benefícios:

    # Código mais legível e organizado;
    # Facilita manutenção e extensão;
    # Evita construtores longos e confusos;
    # Permite validação consistente e centralizada no processo de construção;
    # Permite imutabilidade da classe Produto após a construção.

## Validações aplicadas

    # id deve ser maior que zero;
    # descricao, marca e categoria não podem ser nulos ou vazios;
    # preco deve ser maior que zero;
    # dataCadastro deve ser informada e não pode ser nula;
    # modelo só pode ser informado se marca estiver preenchida;
    # dataUltimaAtualizacao, se fornecida, não pode ser anterior a dataCadastro;
    # estoque não pode ser negativo;
    # Nenhum atributo String pode ser null (valores padrão são strings vazias).

## Como usar

Para criar um produto, instancie o ProdutoBuilder passando os parâmetros obrigatórios no construtor, e depois configure os opcionais com métodos encadeados:

Produto produto = new ProdutoBuilder(
    1L, "Descrição do Produto", "MarcaX", 100.0,
    LocalDate.of(2025, 8, 11), "CategoriaY")
    .codigoEan("1234567890123")
    .modelo("ModeloX")
    .estoque(50)
    .urlFoto("http://exemplo.com/foto.jpg")
    .dataUltimaAtualizacao(LocalDate.of(2025, 8, 12))
    .build();

## Observações finais

    # As validações lançam exceções (IllegalArgumentException ou IllegalStateException) caso alguma regra seja violada;
    # O objeto Produto é imutável após sua criação;
    # O Builder fica em uma classe separada para melhor organização.
