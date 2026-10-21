<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>
    <jsp:include page="menu-layout.jsp">
        <jsp:param name="titulo" value="Projetos" />
    </jsp:include>
    <main class="container my-5">

        <section class="mb-5">

            <div class="border-top border-success border-3">

                <div class="bg-light p-3">

                    <h2 class="text-success mb-0">
                        Projetos e atividades
                    </h2>

                </div>

            </div>


            <div class="row g-4 mt-2">

                <c:choose>

                    <c:when test="${not empty atividades}">

                        <c:forEach var="atividade" items="${atividades}">

                            <div class="col-lg-6">

                                <div class="card h-100 shadow-sm">

                                    <div class="card-body">

                                        <small class="text-muted">
                                            Atividade #
                                            <c:out value="${atividade.id}" />
                                        </small>


                                        <c:if test="${not empty atividade.tipo}">

                                            <div class="mt-2 mb-2">

                                                <span class="badge bg-primary">

                                                    <c:out value="${atividade.tipo}" />

                                                </span>

                                            </div>

                                        </c:if>


                                        <h4 class="card-title">

                                            <c:out value="${atividade.titulo}" />

                                        </h4>


                                        <c:if test="${not empty atividade.descricao}">

                                            <p class="card-text">

                                                <c:out value="${atividade.descricao}" />

                                            </p>

                                        </c:if>


                                        <c:if test="${not empty atividade.dataInicio}">

                                            <p class="mb-1">

                                                <strong>
                                                    Início:
                                                </strong>

                                                <c:out value="${atividade.dataInicio}" />

                                            </p>

                                        </c:if>


                                        <c:if test="${not empty atividade.dataFim}">

                                            <p class="mb-2">

                                                <strong>
                                                    Término:
                                                </strong>

                                                <c:out value="${atividade.dataFim}" />

                                            </p>

                                        </c:if>


                                        <c:if test="${not empty atividade.coordenador}">

                                            <p class="mb-2">

                                                <strong>
                                                    Coordenador:
                                                </strong>

                                                <c:out value="${atividade.coordenador.nome}" />

                                            </p>

                                        </c:if>


                                        <c:choose>

                                            <c:when test="${atividade.situacao}">

                                                <span class="badge bg-success">
                                                    Em andamento
                                                </span>

                                            </c:when>

                                            <c:otherwise>

                                                <span class="badge bg-secondary">
                                                    Encerrado
                                                </span>

                                            </c:otherwise>

                                        </c:choose>

                                    </div>

                                </div>

                            </div>

                        </c:forEach>

                    </c:when>

                    <c:otherwise>

                        <div class="col-12">

                            <div class="alert alert-secondary">

                                Nenhum projeto ou atividade foi cadastrado ainda.

                            </div>

                        </div>

                    </c:otherwise>

                </c:choose>

            </div>

        </section>


        <section class="mb-5">

            <div class="border-top border-primary border-3">

                <div class="bg-light p-3">

                    <h2 class="text-primary mb-0">
                        Resultados
                    </h2>

                </div>

            </div>


            <div class="row g-4 mt-2">

                <div class="col-md-4">

                    <div class="card h-100 shadow-sm">

                        <div class="card-body">

                            <h4 class="text-primary">
                                Competições
                            </h4>

                            <p>
                                Participação em competições e eventos
                                relacionados à Robótica e tecnologia.
                            </p>

                        </div>

                    </div>

                </div>


                <div class="col-md-4">

                    <div class="card h-100 shadow-sm">

                        <div class="card-body">

                            <h4 class="text-success">
                                Protótipos
                            </h4>

                            <p>
                                Desenvolvimento de protótipos e soluções
                                utilizando programação, eletrônica e
                                automação.
                            </p>

                        </div>

                    </div>

                </div>


                <div class="col-md-4">

                    <div class="card h-100 shadow-sm">

                        <div class="card-body">

                            <h4 class="text-warning">
                                Formação
                            </h4>

                            <p>
                                Desenvolvimento de conhecimentos e
                                experiências práticas pelos estudantes.
                            </p>

                        </div>

                    </div>

                </div>

            </div>

        </section>

    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
