<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>
    <jsp:include page="/public/menu-layout.jsp">
        <jsp:param name="titulo" value="IFMS Robotica" />
    </jsp:include>
    <section id="inicio" class="hero">
        <div class="hero-fundo-branco"></div>
        <div class="forma-verde-topo"></div>
        <div class="hero-imagem">
            <img
                src="${pageContext.request.contextPath}/public/imagens/hero.jpg"
                alt="Colagem"
                />
        </div>
        <div class="container-fluid hero-conteudo">
            <div class="hero-texto">
                <!-- LOGO ROBÓTICA-->

                <div class="logo-robotica-principal">
                    <img src="${pageContext.request.contextPath}/public/imagens/logo-robotica.png" alt="Portal de Robótica" />
                </div>
                <!-- TÍTULO-->

                <h1 class="hero-titulo">
                    <fmt:message key="home.titulo1" />

                    <span> <fmt:message key="home.titulo2" /> </span>
                </h1>
                <!-- DESCRIÇÃO-->

                <p class="hero-descricao">
                    <fmt:message key="home.descricao1" />

                </p>
                <!-- BOTÃO-->

                <a href="${pageContext.request.contextPath}/public?acao=novidades" class="btn-projetos">
                    <fmt:message key="home.verNews" />

                    <i class="bi bi-arrow-right"></i>
                </a>
            </div>
        </div>
        <!-- DETALHE VERDE-->

        <div class="forma-verde-inferior"></div>
    </section>

    <section id="sobre" class="sobre">
        <div class="container"> 
            <div class="titulo-secao">
                <span class="subtitulo-secao"><fmt:message key="home.conhecer" /></span>

                <h2>
                    <fmt:message key="home.titulo1" />

                    <span> <fmt:message key="home.titulo2" /> </span>
                </h2>

                <p>
                    <fmt:message key="home.descricao2" />
                </p>
            </div>

            <div class="row g-4">

                <div class="col-md-6">
                    <div class="servico">
                        <div class="servico-icone">
                            <i class="bi bi-robot"></i>
                        </div>

                        <div>
                            <h3><fmt:message key="home.titulo3" /></h3>

                            <p>
                                <fmt:message key="home.descricao3" />

                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="servico">
                        <div class="servico-icone">
                            <i class="bi bi-people"></i>
                        </div>

                        <div>
                            <h3><fmt:message key="home.titulo4" /></h3>
                            <p>
                                <fmt:message key="home.descricao4" />
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="servico">
                        <div class="servico-icone">
                            <i class="bi bi-rocket-takeoff"></i>
                        </div>

                        <div>

                            <h3><fmt:message key="home.titulo5" /></h3>

                            <p>
                                <fmt:message key="home.descricao5" />

                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="servico">
                        <div class="servico-icone">
                            <i class="bi bi-lightbulb"></i>
                        </div>

                        <div>
                            <h3><fmt:message key="home.titulo6" /></h3>

                            <p>
                                <fmt:message key="home.descricao6" />
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </section>

    <section id="projetos" class="projetos">
        <div class="container">

            <div class="titulo-secao">
                <h2>
                    <fmt:message key="home.titulo7" />
                    <span><fmt:message key="home.titulo8" /></span>
                </h2>

                <p>
                    <fmt:message key="home.descricao7" />
                </p>
            </div>

            <div class="row g-4">

                <div class="col-md-4">
                    <div class="projeto-card">

                        <div class="projeto-icone">
                            <i class="bi bi-robot"></i>
                        </div>

                        <h3><fmt:message key="home.titulo9" /></h3>

                        <p>
                            <fmt:message key="home.descricao8" />

                        </p>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="projeto-card">

                        <div class="projeto-icone">
                            <i class="bi bi-code-slash"></i>
                        </div>

                        <h3><fmt:message key="home.titulo10" /></h3>

                        <p>
                            <fmt:message key="home.descricao9" />

                        </p>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="projeto-card">

                        <div class="projeto-icone">
                            <i class="bi bi-lightbulb"></i>
                        </div>

                        <h3><fmt:message key="home.titulo11" /></h3>

                        <p><fmt:message key="home.descricao10" />
                        </p>

                    </div>
                </div>

            </div>
        </div>
    </section>
    <section id="contato" class="contato">
        <div class="container">
            <div class="contato-box text-center">
                <div class="contato-icone">
                    <i class="bi bi-chat-dots"></i>
                </div>

                <h2>
                    <fmt:message key="home.titulo12" />
                    <span style="color: var(--verde-ifms)"><fmt:message key="home.titulo13" /> </span>
                </h2>
                <br><br>
                <div class="d-flex justify-content-center gap-3">

                    <a href="mailto:robotica.cg@ifms.edu.br?subject=Contato%20via%20site" target="_blank" class="btn-projetos border-0">
                        <i class="bi bi-envelope"></i>
                        Email
                    </a>
                    <a href="https://www.instagram.com/robotican.cg?stkn=MXdwNno5MWgyZnJobA==" target="_blank" class="btn-projetos border-0">
                        <i class="bi bi-instagram"></i>
                        Instagram
                    </a>
                    <a href="${pageContext.request.contextPath}/#contato" class="btn-projetos border-0">
                        <i class="bi bi-whatsapp"></i>
                        Whatsapp
                    </a>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/public/footer-layout.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>