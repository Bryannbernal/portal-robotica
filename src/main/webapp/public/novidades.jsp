<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>
    <jsp:include page="menu-layout.jsp">
        <jsp:param name="titulo" value="Editais e Processos" />
    </jsp:include>
    <br><br><br><br><br><br>

    <div class="container my-5">

        <div class="row g-4">

            <!-- ========================= -->
            <!-- COLUNA DOS EDITAIS        -->
            <!-- ========================= -->

            <div class="col-lg-4">

                <div class="border-top border-success border-3">

                    <div class="bg-light p-3">
                        <h3 class="text-success mb-0">
                            Editais
                        </h3>
                    </div>

                    <div class="p-3">

                        <!-- Edital 1 -->
                        <div class="mb-4">

                            <h5>
                                <a href="#"
                                   class="text-success text-decoration-none">
                                    › Edital nº 01/2026 - Robótica
                                </a>
                            </h5>

                            <p class="text-muted mb-1">
                                Seleção de estudantes para participação
                                em projetos de robótica do IFMS.
                            </p>

                            <small>
                                Inscrições abertas até
                                <strong>20 de outubro.</strong>
                            </small>

                        </div>


                        <!-- Edital 2 -->
                        <div class="mb-4">

                            <h5>
                                <a href="#"
                                   class="text-success text-decoration-none">
                                    › Edital nº 02/2026 - Equipes de Robótica
                                </a>
                            </h5>

                            <p class="text-muted mb-1">
                                Seleção de estudantes para formação
                                de equipes de competição.
                            </p>

                            <small>
                                Inscrições até
                                <strong>30 de outubro.</strong>
                            </small>

                        </div>


                        <!-- Edital 3 -->
                        <div class="mb-4">

                            <h5>
                                <a href="#"
                                   class="text-success text-decoration-none">
                                    › Edital nº 03/2026 - Projetos de Extensão
                                </a>
                            </h5>

                            <p class="text-muted mb-1">
                                Apoio a projetos de extensão relacionados
                                à robótica e tecnologia.
                            </p>

                            <small>
                                Resultado previsto para
                                <strong>15 de novembro.</strong>
                            </small>

                        </div>


                        <!-- Edital 4 -->
                        <div class="mb-4">

                            <h5>
                                <a href="#"
                                   class="text-success text-decoration-none">
                                    › Edital nº 04/2026 - Olimpíada de Robótica
                                </a>
                            </h5>

                            <p class="text-muted mb-1">
                                Inscrições para estudantes interessados
                                em representar o IFMS em competições.
                            </p>

                            <small>
                                Inscrições abertas.
                            </small>
                        </div>
                    </div>
                </div>
            </div>


            <!-- ========================= -->
            <!-- COLUNA DAS NOTÍCIAS       -->
            <!-- ========================= -->

            <div class="col-lg-8">

                <div class="border-top border-primary border-3">

                    <div class="bg-light p-3 mb-4">
                        <h3 class="text-primary mb-0">
                            Notícias
                        </h3>
                    </div>


                    <div class="row g-4">

                        <!-- NOTÍCIA 1 -->
                        <div class="col-md-6">

                            <div class="card h-100 shadow-sm">

                                <img src="${pageContext.request.contextPath}/public/imagens/programacao-e-robotica.jpeg"
                                     class="card-img-top"
                                     alt="Estudantes trabalhando com robótica">

                                <div class="card-body">
                                    <small class="text-primary">
                                        ROBÓTICA
                                    </small>

                                    <h5 class="card-title mt-2">
                                        Estudantes do IFMS desenvolvem
                                        projetos de robótica
                                    </h5>

                                    <p class="card-text text-muted">
                                        Alunos desenvolvem soluções utilizando
                                        programação, eletrônica e automação.
                                    </p>

                                    <a href="#"
                                       class="btn btn-outline-primary btn-sm">
                                        Leia mais
                                    </a>
                                </div>
                            </div>
                        </div>


                        <!-- NOTÍCIA 2 -->
                        <div class="col-md-6">

                            <div class="card h-100 shadow-sm">

                                <img src="${pageContext.request.contextPath}/public/imagens/equipe-na-competicao.jpeg"
                                     class="card-img-top"
                                     alt="Competição de robótica">

                                <div class="card-body">

                                    <small class="text-primary">
                                        COMPETIÇÃO
                                    </small>

                                    <h5 class="card-title mt-2">
                                        Equipe do IFMS participa de competição
                                        de robótica
                                    </h5>

                                    <p class="card-text text-muted">
                                        Estudantes representam o instituto
                                        em uma competição tecnológica.
                                    </p>

                                    <a href="#"
                                       class="btn btn-outline-primary btn-sm">
                                        Leia mais
                                    </a>
                                </div>
                            </div>
                        </div>


                        <!-- NOTÍCIA 3 -->
                        <div class="col-md-6">

                            <div class="card h-100 shadow-sm">

                                <img src="${pageContext.request.contextPath}/public/imagens/oficina-robotica.jpeg"
                                     class="card-img-top"
                                     alt="Oficina de robótica">

                                <div class="card-body">

                                    <small class="text-primary">
                                        EVENTO
                                    </small>

                                    <h5 class="card-title mt-2">
                                        IFMS promove oficina de robótica
                                    </h5>

                                    <p class="card-text text-muted">
                                        Oficina apresenta conceitos de
                                        programação e montagem de robôs.
                                    </p>

                                    <a href="#"
                                       class="btn btn-outline-primary btn-sm">
                                        Leia mais
                                    </a>
                                </div>
                            </div>
                        </div>


                        <!-- NOTÍCIA 4 -->
                        <div class="col-md-6">

                            <div class="card h-100 shadow-sm">

                                <img src="${pageContext.request.contextPath}/public/imagens/projeto-lego-1.jpeg"
                                     class="card-img-top"
                                     alt="Projeto de robótica do IFMS">

                                <div class="card-body">

                                    <small class="text-primary">
                                        PROJETO
                                    </small>

                                    <h5 class="card-title mt-2">
                                        Novo projeto amplia atividades
                                        de robótica no IFMS
                                    </h5>

                                    <p class="card-text text-muted">
                                        Projeto incentiva estudantes a desenvolver
                                        conhecimentos em tecnologia e inovação.
                                    </p>

                                    <a href="#"
                                       class="btn btn-outline-primary btn-sm">
                                        Leia mais
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <jsp:include page="footer-layout.jsp"/>
</body>
</html>
