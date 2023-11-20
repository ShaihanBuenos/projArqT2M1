-- Inserindo dados na tabela cidade
INSERT INTO cidade (nome, preco_base, preco_imposto)
VALUES ('Porto Alegre', 25, 0.1),
       ('Florianopolis', 20, 0.09),
       ('Curitiba', 15, 0.03),
       ('São Paulo', 10, 0.02);

-- Inserindo dados na tabela cep
INSERT INTO cep (numero, cidade_id)
VALUES ('90000000', 1),
       ('90000001', 1),
       ('88000000', 2),
       ('88000003', 2),
       ('80000000', 3),
       ('80000001', 3),
       ('01000000', 4),
       ('01000001', 4);

-- Inserindo dados na tabela orcamento
INSERT INTO orcamento (id_origem, id_destino, peso, custo_base, custo_adicional, valor_impostos, desconto_aplicado,
                       valor_final, data_criacao)
SELECT o.id                          AS id_origem,
       d.id                          AS id_destino,
       10                            AS peso,              -- Exemplo de peso
       origem.preco_base             AS custo_base,
       5                             AS custo_adicional,   -- Exemplo de custo adicional
       2                             AS valor_impostos,    -- Exemplo de valor de impostos
       3                             AS desconto_aplicado, -- Exemplo de desconto aplicado
       origem.preco_base + 5 + 2 - 3 AS valor_final,        -- Exemplo de cálculo de valor final
       '2021-01-01'                  AS data_criacao
FROM cep o
         JOIN
     cidade origem ON o.cidade_id = origem.id
         JOIN
     cep d ON d.id <> o.id
         JOIN
     cidade destino ON d.cidade_id = destino.id;
