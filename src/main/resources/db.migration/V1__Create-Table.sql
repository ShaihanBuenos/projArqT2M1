-- Drop tables if they exist
DROP TABLE IF EXISTS orcamento CASCADE;
DROP TABLE IF EXISTS cep CASCADE;
DROP TABLE IF EXISTS cidade CASCADE;

-- Create Cidade table
CREATE TABLE cidade
(
    id        SERIAL PRIMARY KEY,
    nome      VARCHAR(255),
    preco_base DECIMAL(15, 2),
    preco_imposto DECIMAL(15, 2)
);

-- Create CEP table
CREATE TABLE cep
(
    id        SERIAL PRIMARY KEY,
    numero    VARCHAR(10),
    cidade_id INTEGER REFERENCES Cidade (id)
);

-- Create Orcamento table
CREATE TABLE orcamento
(
    id               SERIAL PRIMARY KEY,
    id_origem        INTEGER REFERENCES CEP (id),
    id_destino       INTEGER REFERENCES CEP (id),
    peso             DOUBLE PRECISION,
    custo_base        DOUBLE PRECISION,
    custo_adicional   DOUBLE PRECISION,
    valor_impostos    DOUBLE PRECISION,
    desconto_aplicado DOUBLE PRECISION,
    valor_final       DOUBLE PRECISION,
    data_criacao DATE
);
