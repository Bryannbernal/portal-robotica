<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>
    <jsp:include page="menu-layout.jsp">
        <jsp:param name="titulo" value="Sobre Nos" />
    </jsp:include>
    <br><br><br><br><br><br>
    <main class="container my-5">


        <section class="mb-5">

            <div class="border-top border-primary border-3">

                <div class="bg-light p-3">

                    <h2 class="text-primary mb-0">
                        Memórias da Robótica
                    </h2>

                </div>

            </div>

            <div class="mt-4">

                <p>
                    A trajetória da Robótica no IFMS é construída a partir
                    de projetos, atividades, competições, oficinas e da
                    participação de estudantes e servidores.
                </p>

                <p>
                    Ao longo dessa trajetória, o laboratório tornou-se um
                    espaço de aprendizagem, experimentação e desenvolvimento
                    de soluções utilizando tecnologia, programação,
                    eletrônica e automação.
                </p>

                <p>
                    Este espaço reúne parte dessas memórias e registra as
                    pessoas, projetos e resultados que contribuíram para
                    a construção dessa história.
                </p>

            </div>

        </section>


        <section class="mb-5">

            <div class="border-top border-success border-3">

                <div class="bg-light p-3">

                    <h2 class="text-success mb-0">
                        Sobre o laboratório
                    </h2>

                </div>

            </div>

            <div class="mt-4">

                <p>
                    O laboratório de Robótica do IFMS promove atividades
                    relacionadas à tecnologia, inovação e aprendizagem
                    prática.
                </p>

                <p>
                    As atividades possibilitam que estudantes desenvolvam
                    conhecimentos por meio da construção de projetos,
                    participação em eventos, competições, oficinas e
                    outras iniciativas.
                </p>

            </div>

        </section>


        <section class="mb-5">

            <div class="border-top border-warning border-3">

                <div class="bg-light p-3">

                    <h2 class="text-warning mb-0">
                        Pessoas envolvidas
                    </h2>

                </div>

            </div>


            <div class="row g-4 mt-2">


                <div class="col-lg-7">

                    <h3 class="text-primary mb-4">
                        Estudantes
                    </h3>

                    <div class="row g-3">

                        <c:choose>

                            <%-- Verifica se existem estudantes --%>

                            <c:when test="${not empty estudantes}">

                                <c:forEach var="estudante"
                                           items="${estudantes}">
                                    <div class="col-md-6" >
                                        <div class="card h-100 shadow-sm text-center mx-auto d-block">
                                            <img
                                                src="${supabaseUrl}/storage/v1/object/public/portal-robotica/${estudante.foto}"
                                                alt="${estudante.nome}"
                                                style="height: 150px; width: 150px; margin-top: 2rem"
                                                >
                                            <div class="card-body">
                                                <small class="text-muted">
                                                    Estudante #
                                                    <c:out value="${estudante.id}" />
                                                </small>
                                                <h5 class="card-title mt-1">
                                                    <c:out value="${estudante.nome}" />
                                                </h5>
                                                <c:if test="${not empty estudante.minibio}">
                                                    <p class="card-text">
                                                        <c:out value="${estudante.minibio}" />
                                                    </p>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>


                            <%-- Caso não existam estudantes --%>

                            <c:otherwise>

                                <div class="col-12">

                                    <div class="alert alert-secondary">

                                        Ainda não há estudantes registrados
                                        como participantes das atividades.

                                    </div>

                                </div>

                            </c:otherwise>

                        </c:choose>

                    </div>

                </div>


                <div class="col-lg-5">

                    <h3 class="text-success mb-4">
                        Coordenadores
                    </h3>

                    <div class="row g-3">

                        <c:choose>

                            <%-- Verifica se existem coordenadores --%>

                            <c:when test="${not empty coordenadores}">

                                <c:forEach var="coordenador"
                                           items="${coordenadores}">

                                    <div class="col-12">

                                        <div class="card shadow-sm">

                                            <div class="card-body">

                                                <small class="text-muted">

                                                    Coordenador #

                                                    <c:out value="${coordenador.id}" />

                                                </small>


                                                <h5 class="card-title mt-1">

                                                    <c:out value="${coordenador.nome}" />

                                                </h5>


                                                <c:if test="${not empty coordenador.minibio}">

                                                    <p class="card-text">

                                                        <c:out value="${coordenador.minibio}" />

                                                    </p>

                                                </c:if>

                                            </div>

                                        </div>

                                    </div>

                                </c:forEach>

                            </c:when>


                            <%-- Caso não existam coordenadores --%>

                            <c:otherwise>

                                <div class="col-12">

                                    <div class="alert alert-secondary">

                                        Nenhum coordenador cadastrado.

                                    </div>

                                </div>

                            </c:otherwise>

                        </c:choose>

                    </div>

                </div>

            </div>

        </section>


        <section class="mb-5">

            <div class="border-top border-primary border-3">

                <div class="bg-light p-3">

                    <h2 class="text-primary mb-0">
                        Impacto social
                    </h2>

                </div>

            </div>

            <div class="mt-4">

                <p>
                    As ações de Robótica contribuem para aproximar estudantes
                    da tecnologia e estimular o desenvolvimento de habilidades
                    relacionadas à programação, eletrônica, resolução de
                    problemas e trabalho em equipe.
                </p>

                <p>
                    Além do ambiente acadêmico, as atividades podem alcançar
                    escolas, comunidades e outros públicos por meio de
                    oficinas, eventos, competições e ações de extensão.
                </p>

            </div>

        </section>

    </main>
    <jsp:include page="footer-layout.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
