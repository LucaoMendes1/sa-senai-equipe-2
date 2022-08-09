-- Database: gestao

-- DROP DATABASE IF EXISTS gestao;

CREATE DATABASE gestao
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- Table: public.usuarios

-- DROP TABLE IF EXISTS public.usuarios;

CREATE TABLE IF NOT EXISTS public.usuarios
(
    id SERIAL NOT NULL,
    login character varying(20) COLLATE pg_catalog."default",
    nome_completo character varying(50) COLLATE pg_catalog."default",
    senha character varying(10) COLLATE pg_catalog."default",
    tipo character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuarios_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;


-- Table: public.facilitadores

-- DROP TABLE IF EXISTS public.facilitadores;

CREATE TABLE IF NOT EXISTS public.facilitadores
(
    id SERIAL NOT NULL,
    cpf character varying(14) COLLATE pg_catalog."default",
    formacao character varying(1000) COLLATE pg_catalog."default",
    rg character varying(10) COLLATE pg_catalog."default",
    usuario_id integer NOT NULL,
    CONSTRAINT facilitadores_pkey PRIMARY KEY (id),
    CONSTRAINT fk152a5q2vi8i1jrvgqcm3tj31f FOREIGN KEY (usuario_id)
        REFERENCES public.usuarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.facilitadores
    OWNER to postgres;


-- Table: public.treinamentos

-- DROP TABLE IF EXISTS public.treinamentos;

CREATE TABLE IF NOT EXISTS public.treinamentos
(
    id SERIAL NOT NULL,
    dt_localizacao date NOT NULL,
    descricao_longa character varying(1500) COLLATE pg_catalog."default",
    titulo character varying(100) COLLATE pg_catalog."default",
    facilitador_id integer NOT NULL,
    CONSTRAINT treinamentos_pkey PRIMARY KEY (id),
    CONSTRAINT fkfbabrglxcyb0jdpeig1iy	2eaj FOREIGN KEY (facilitador_id)
        REFERENCES public.facilitadores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.treinamentos
    OWNER to postgres;


INSERT INTO public.usuarios(
	login, nome_completo, senha, tipo)
	VALUES ('kevin', 'Kevin Albino Demetro', '123123', 'GESTOR');