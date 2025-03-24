--
-- PostgreSQL database dump
--

-- Dumped from database version 13.8
-- Dumped by pg_dump version 13.8

-- Started on 2025-03-23 19:39:30 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

--CREATE SCHEMA public;


--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 208 (class 1259 OID 16471)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16385)
-- Name: moeda; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.moeda (
    id bigint NOT NULL,
    nome character varying,
    codigo character varying,
    reino character varying
);


--
-- TOC entry 204 (class 1259 OID 16415)
-- Name: moeda_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.moeda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 204
-- Name: moeda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.moeda_id_seq OWNED BY public.moeda.id;


--
-- TOC entry 201 (class 1259 OID 16393)
-- Name: produto; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.produto (
    id bigint NOT NULL,
    nome character varying,
    valor double precision,
    id_moeda_ref bigint,
    reino character varying,
    taxa_especifica double precision DEFAULT 1
);


--
-- TOC entry 205 (class 1259 OID 16418)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 205
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 203 (class 1259 OID 16410)
-- Name: taxa_cambio; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.taxa_cambio (
    id bigint NOT NULL,
    id_moeda_origem bigint,
    id_moeda_destino bigint,
    valor_taxa double precision,
    data timestamp with time zone DEFAULT now(),
    codigo character varying(255),
    nome character varying(255)
);


--
-- TOC entry 206 (class 1259 OID 16421)
-- Name: taxa_cambio_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.taxa_cambio_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 206
-- Name: taxa_cambio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.taxa_cambio_id_seq OWNED BY public.taxa_cambio.id;


--
-- TOC entry 202 (class 1259 OID 16401)
-- Name: transacao; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.transacao (
    id bigint NOT NULL,
    id_produto bigint,
    valor_final double precision,
    data timestamp with time zone DEFAULT now(),
    reino character varying,
    id_moeda_origem bigint,
    id_moeda_destino bigint,
    protocolo character varying
);


--
-- TOC entry 207 (class 1259 OID 16424)
-- Name: transacao_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.transacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 207
-- Name: transacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.transacao_id_seq OWNED BY public.transacao.id;


--
-- TOC entry 2889 (class 2604 OID 16417)
-- Name: moeda id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.moeda ALTER COLUMN id SET DEFAULT nextval('public.moeda_id_seq'::regclass);


--
-- TOC entry 2890 (class 2604 OID 16420)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 2894 (class 2604 OID 16423)
-- Name: taxa_cambio id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.taxa_cambio ALTER COLUMN id SET DEFAULT nextval('public.taxa_cambio_id_seq'::regclass);


--
-- TOC entry 2892 (class 2604 OID 16426)
-- Name: transacao id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transacao ALTER COLUMN id SET DEFAULT nextval('public.transacao_id_seq'::regclass);


--
-- TOC entry 3040 (class 0 OID 16385)
-- Dependencies: 200
-- Data for Name: moeda; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.moeda VALUES (1, 'Ouro Real', 'ORl', 'Humanos');
INSERT INTO public.moeda VALUES (2, 'Tibar', 'TIB', 'Anões');


--
-- TOC entry 3041 (class 0 OID 16393)
-- Dependencies: 201
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.produto VALUES (2, 'Madeira', 10, 1, NULL, 1);
INSERT INTO public.produto VALUES (3, 'Hidromel', 30, 2, NULL, 1);
INSERT INTO public.produto VALUES (1, 'Pele', 20, 1, NULL, 3);


--
-- TOC entry 3043 (class 0 OID 16410)
-- Dependencies: 203
-- Data for Name: taxa_cambio; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.taxa_cambio VALUES (1, 1, 2, 3, '2025-03-22 12:34:04.389159+00', NULL, NULL);
INSERT INTO public.taxa_cambio VALUES (2, 2, 1, 0.3333333333333333, '2025-03-22 12:34:04.389159+00', NULL, NULL);


--
-- TOC entry 3042 (class 0 OID 16401)
-- Dependencies: 202
-- Data for Name: transacao; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.transacao VALUES (1, 1, 1200, '2025-03-22 12:41:33.111454+00', 'Elfos', 1, 2, NULL);
INSERT INTO public.transacao VALUES (2, 2, 800, '2025-03-22 12:41:33.111454+00', 'Anões', 2, 1, NULL);
INSERT INTO public.transacao VALUES (3, 1, 250, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (4, 1, 250, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (5, 1, 450, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (6, 1, 450, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (7, 1, 450, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (8, 1, 450, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (9, 1, 450, NULL, NULL, 1, 2, NULL);
INSERT INTO public.transacao VALUES (10, 1, 500, '2025-03-22 20:00:44.076569+00', 'Anões', 1, 2, NULL);
INSERT INTO public.transacao VALUES (11, 1, 575, '2025-03-22 20:26:42.282028+00', 'Anões', 1, 2, NULL);
INSERT INTO public.transacao VALUES (12, 1, 575, '2025-03-22 21:53:05.774917+00', 'Anões', 1, 2, NULL);
INSERT INTO public.transacao VALUES (13, 1, 700, '2025-03-22 22:16:49.283132+00', 'Anões', 1, 2, '4beafe96-a1e9-4509-afab-8eada9e79673');
INSERT INTO public.transacao VALUES (14, 1, 2520, '2025-03-23 19:20:05.690801+00', 'Anões', 1, 2, '582ac714-3ce9-4093-853d-18d14446ad49');


--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 208
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 204
-- Name: moeda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.moeda_id_seq', 2, true);


--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 205
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.produto_id_seq', 3, true);


--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 206
-- Name: taxa_cambio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.taxa_cambio_id_seq', 9, true);


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 207
-- Name: transacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.transacao_id_seq', 14, true);


--
-- TOC entry 2897 (class 2606 OID 16392)
-- Name: moeda moeda_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.moeda
    ADD CONSTRAINT moeda_pkey PRIMARY KEY (id);


--
-- TOC entry 2899 (class 2606 OID 16400)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- TOC entry 2903 (class 2606 OID 16414)
-- Name: taxa_cambio taxa_cambio_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.taxa_cambio
    ADD CONSTRAINT taxa_cambio_pkey PRIMARY KEY (id);


--
-- TOC entry 2901 (class 2606 OID 16409)
-- Name: transacao transacao_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transacao
    ADD CONSTRAINT transacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2904 (class 2606 OID 16427)
-- Name: produto produto_moeda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_moeda_fkey FOREIGN KEY (id_moeda_ref) REFERENCES public.moeda(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2909 (class 2606 OID 16437)
-- Name: taxa_cambio taxa_cambio_moeda_destino_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.taxa_cambio
    ADD CONSTRAINT taxa_cambio_moeda_destino_fkey FOREIGN KEY (id_moeda_destino) REFERENCES public.moeda(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2908 (class 2606 OID 16432)
-- Name: taxa_cambio taxa_cambio_moeda_origem_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.taxa_cambio
    ADD CONSTRAINT taxa_cambio_moeda_origem_fkey FOREIGN KEY (id_moeda_origem) REFERENCES public.moeda(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2907 (class 2606 OID 16452)
-- Name: transacao transacao_moeda_destino_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transacao
    ADD CONSTRAINT transacao_moeda_destino_fkey FOREIGN KEY (id_moeda_destino) REFERENCES public.moeda(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2906 (class 2606 OID 16447)
-- Name: transacao transacao_moeda_origem_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transacao
    ADD CONSTRAINT transacao_moeda_origem_fkey FOREIGN KEY (id_moeda_origem) REFERENCES public.moeda(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2905 (class 2606 OID 16442)
-- Name: transacao transacao_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transacao
    ADD CONSTRAINT transacao_produto_fkey FOREIGN KEY (id_produto) REFERENCES public.produto(id) ON UPDATE CASCADE ON DELETE SET NULL;


-- Completed on 2025-03-23 19:39:36 UTC

--
-- PostgreSQL database dump complete
--

