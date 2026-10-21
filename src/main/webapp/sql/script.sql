CREATE TABLE estudante (
    id serial not null primary key,
    nome VARCHAR(150) NOT NULL,
    minibio TEXT,
    foto VARCHAR(255)
);

CREATE TABLE periodo_letivo (
    id serial not null primary key,
    ano INT NOT NULL,
    semestre INT NOT NULL,
    CONSTRAINT ck_periodo_semestre CHECK (semestre IN (1, 2)),
    CONSTRAINT uk_periodo_ano_semestre UNIQUE (ano, semestre)
);

CREATE TABLE coordenador (
    id serial not null primary key,
    nome VARCHAR(150) NOT NULL,
    minibio TEXT,
    foto VARCHAR(255)
);

CREATE TABLE atividade (
    id serial not null primary key,
    titulo VARCHAR(180) NOT NULL,
    tipo VARCHAR(40) NOT NULL,
    descricao TEXT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    situacao VARCHAR(30) NOT NULL,
    coordenador_id INT NOT NULL,
    CONSTRAINT fk_atividade_coordenador
        FOREIGN KEY (coordenador_id) REFERENCES coordenador(id)
        ON DELETE RESTRICT,
    CONSTRAINT ck_atividade_datas
        CHECK (data_fim IS NULL OR data_fim >= data_inicio)
);

CREATE TABLE atividade_periodo (
    atividade_id INT NOT NULL,
    periodo_id INT NOT NULL,
    PRIMARY KEY (atividade_id, periodo_id),
    CONSTRAINT fk_atividade_periodo_atividade
        FOREIGN KEY (atividade_id) REFERENCES atividade(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_atividade_periodo_periodo
        FOREIGN KEY (periodo_id) REFERENCES periodo_letivo(id)
        ON DELETE RESTRICT
);

CREATE TABLE participacao (
    estudante_id INT NOT NULL,
    atividade_id INT NOT NULL,
    funcao VARCHAR(100),
    descricao_contribuicao TEXT,
    PRIMARY KEY (estudante_id, atividade_id),
    CONSTRAINT fk_participacao_estudante
        FOREIGN KEY (estudante_id) REFERENCES estudante(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_participacao_atividade
        FOREIGN KEY (atividade_id) REFERENCES atividade(id)
        ON DELETE CASCADE
);

-- Esta tabela pertence à visão completa do portal.
-- O cadastro de conquistas não será exigido na N1.
CREATE TABLE conquista (
    id serial not null primary key,
    atividade_id INT NOT NULL,
    titulo VARCHAR(180) NOT NULL,
    data DATE,
    descricao TEXT,
    CONSTRAINT fk_conquista_atividade
        FOREIGN KEY (atividade_id) REFERENCES atividade(id)
        ON DELETE CASCADE
);

INSERT INTO periodo_letivo (ano, semestre) VALUES
    (2025, 1),
    (2025, 2),
    (2026, 1),
    (2026, 2);

INSERT INTO coordenador (nome, minibio, foto) VALUES
    ('Fábio Luiz Faria da Silva', NULL, NULL);