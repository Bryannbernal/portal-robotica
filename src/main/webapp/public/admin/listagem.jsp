<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<body>
    <jsp:include page="/public/menu-layout.jsp">
        <jsp:param name="titulo" value="Listagem" />
    </jsp:include>
    <br><br><br><br><br><br>
    <h1 style="text-align: center;">Painel de controle</h1>
    <br>
    <hr>
    <br>

    <!-- ========================================================= -->
    <!-- SEÇÃO 1 - ESTUDANTES E ATIVIDADES                         -->
    <!-- ========================================================= -->

    <section id="estudantes-atividades">

        <div class="container text-center">
            <div class="row">

                <!-- ===================== -->
                <!-- ESTUDANTES             -->
                <!-- ===================== -->

                <div class="col">

                    <div class="table-responsive">

                        <h1>
                            Estudantes:
                            <c:out value="${estudantes.size()}" />
                        </h1>

                        <br>

                        <table class="table table-striped table-hover table-bordered">

                            <thead class="table-dark">
                                <tr>
                                    <th>Foto</th>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Minibio</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>

                            <tbody>

                                <c:forEach var="estudante" items="${estudantes}">

                                    <tr>

                                        <td class="align-middle text-center">
                                            <img
                                                src="${supabaseUrl}/storage/v1/object/public/portal-robotica/${estudante.foto}"
                                                alt="${estudante.nome}"
                                                width="50"
                                                >
                                                </td>

                                                <td class="align-middle text-center">
                                            <c:out value="${estudante.id}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${estudante.nome}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${estudante.minibio}" />
                                        </td>

                                        <td class="align-middle text-center">

                                            <a
                                                href="${pageContext.request.contextPath}/admin?acao=excluirEstudante&id=${estudante.id}"
                                                class="btn btn-danger btn-sm"
                                                data-bs-toggle="modal"
                                                data-bs-target="#modalExcluir${estudante.id}"
                                                >
                                                <i class="bi bi-trash"></i>
                                                Apagar
                                            </a>

                                        </td>

                                    </tr>

                                    <!-- Modal de exclusão do estudante -->

                                <div
                                    class="modal fade"
                                    id="modalExcluir${estudante.id}"
                                    tabindex="-1"
                                    aria-labelledby="modalExcluirLabel${estudante.id}"
                                    aria-hidden="true"
                                    >
                                    <div class="modal-dialog modal-dialog-centered">

                                        <div class="modal-content">

                                            <div class="modal-header">

                                                <h5
                                                    class="modal-title"
                                                    id="modalExcluirLabel${estudante.id}"
                                                    >
                                                    Confirmar exclusão
                                                </h5>

                                                <button
                                                    type="button"
                                                    class="btn-close"
                                                    data-bs-dismiss="modal"
                                                    aria-label="Fechar"
                                                    ></button>

                                            </div>

                                            <div class="modal-body">

                                                <p>
                                                    Tem certeza que deseja excluir o estudante
                                                    <strong>
                                                        <c:out value="${estudante.nome}" />
                                                    </strong>?
                                                </p>

                                                <p class="text-danger mb-0">
                                                    Esta ação não poderá ser desfeita.
                                                </p>

                                            </div>

                                            <div class="modal-footer">

                                                <button
                                                    type="button"
                                                    class="btn btn-secondary"
                                                    data-bs-dismiss="modal"
                                                    >
                                                    Cancelar
                                                </button>

                                                <a
                                                    href="${pageContext.request.contextPath}/admin?acao=excluirEstudante&id=${estudante.id}"
                                                    class="btn btn-danger"
                                                    >
                                                    Sim, excluir
                                                </a>

                                            </div>

                                        </div>

                                    </div>
                                </div>

                            </c:forEach>

                            </tbody>

                        </table>

                    </div>

                </div>

                <!-- ===================== -->
                <!-- ATIVIDADES             -->
                <!-- ===================== -->

                <div class="col">

                    <div class="table-responsive">

                        <h1>
                            Atividades:
                            <c:out value="${atividades.size()}" />
                        </h1>

                        <br>

                        <table class="table table-striped table-hover table-bordered">

                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Título</th>
                                    <th>Tipo</th>
                                    <th>Descrição</th>
                                    <th>Início</th>
                                    <th>Fim</th>
                                    <th>Situação</th>
                                    <th>Coordenador</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>

                            <tbody>

                                <c:forEach var="atividade" items="${atividades}">

                                    <tr>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.id}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.titulo}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.tipo}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.descricao}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.dataInicioFormatada}" />
                                        </td>

                                        <td class="align-middle text-center">

                                            <c:choose>

                                                <c:when test="${empty atividade.dataFim}">
                                                    Atual
                                                </c:when>

                                                <c:otherwise>
                                                    <c:out value="${atividade.dataFimFormatada}" />
                                                </c:otherwise>

                                            </c:choose>

                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.situacao}" />
                                        </td>

                                        <td class="align-middle text-center">
                                            <c:out value="${atividade.coordenador.nome}" />
                                        </td>

                                        <td class="align-middle text-center">

                                            <a
                                                href="${pageContext.request.contextPath}/admin?acao=excluirAtividade&id=${atividade.id}"
                                                class="btn btn-danger btn-sm"
                                                data-bs-toggle="modal"
                                                data-bs-target="#modalExcluirAtividade${atividade.id}"
                                                >
                                                <i class="bi bi-trash"></i>
                                                Apagar
                                            </a>

                                        </td>

                                    </tr>

                                    <!-- Modal de exclusão da atividade -->

                                <div
                                    class="modal fade"
                                    id="modalExcluirAtividade${atividade.id}"
                                    tabindex="-1"
                                    aria-labelledby="modalExcluirAtividadeLabel${atividade.id}"
                                    aria-hidden="true"
                                    >
                                    <div class="modal-dialog modal-dialog-centered">

                                        <div class="modal-content">

                                            <div class="modal-header">

                                                <h5
                                                    class="modal-title"
                                                    id="modalExcluirAtividadeLabel${atividade.id}"
                                                    >
                                                    Confirmar exclusão
                                                </h5>

                                                <button
                                                    type="button"
                                                    class="btn-close"
                                                    data-bs-dismiss="modal"
                                                    aria-label="Fechar"
                                                    ></button>

                                            </div>

                                            <div class="modal-body">

                                                <p>
                                                    Tem certeza que deseja excluir a atividade
                                                    <strong>
                                                        <c:out value="${atividade.titulo}" />
                                                    </strong>?
                                                </p>

                                                <p class="text-danger mb-0">
                                                    Esta ação não poderá ser desfeita.
                                                </p>

                                            </div>

                                            <div class="modal-footer">

                                                <button
                                                    type="button"
                                                    class="btn btn-secondary"
                                                    data-bs-dismiss="modal"
                                                    >
                                                    Cancelar
                                                </button>

                                                <a
                                                    href="${pageContext.request.contextPath}/admin?acao=excluirAtividade&id=${atividade.id}"
                                                    class="btn btn-danger"
                                                    >
                                                    Sim, excluir
                                                </a>

                                            </div>

                                        </div>

                                    </div>
                                </div>

                            </c:forEach>

                            </tbody>

                        </table>

                    </div>

                </div>

            </div>
        </div>

        <br>

        <div style="text-align: center;">

            <a
                href="${pageContext.request.contextPath}/admin?acao=participacao"
                class="btn btn-secondary"
                >
                Vincular estudantes a atividades
            </a>

        </div>

    </section>

    <br>
    <hr>
    <br>

    <!-- ========================================================= -->
    <!-- SEÇÃO 2 - COORDENADORES, PERÍODOS, CONQUISTAS             -->
    <!-- ========================================================= -->

    <section id="coordenadores-periodos-conquistas">

        <div class="container text-center">

            <div class="row">

                <!-- ===================== -->
                <!-- COORDENADORES          -->
                <!-- ===================== -->

                <div class="col">

                    <div class="card" style="width: 18rem;">

                        <div class="card-body">

                            <h4 class="card-title">
                                Número de coordenadores:
                                <c:out value="${coordenadores.size()}" />
                            </h4>

                            <hr>

                            <c:forEach
                                var="coordenador"
                                items="${coordenadores}"
                                >

                                <h5 class="card-subtitle mb-2">
                                    Coordenador
                                    <c:out value="${coordenador.id}" />:
                                </h5>

                                <h6 class="card-subtitle mb-2 text-body-secondary">
                                    <c:out value="${coordenador.nome}" />
                                </h6>

                                <p class="card-text">
                                    <c:out value="${coordenador.minibio}" />
                                </p>

                                <hr>

                            </c:forEach>

                        </div>

                    </div>

                </div>

                <!-- ===================== -->
                <!-- PERÍODOS               -->
                <!-- ===================== -->

                <div class="col">

                    <div class="card" style="width: 18rem;">

                        <div class="card-body">

                            <h4 class="card-title">
                                Número de períodos:
                                <c:out value="${periodos.size()}" />
                            </h4>

                            <hr>

                            <c:forEach
                                var="periodo"
                                items="${periodos}"
                                >

                                <h5 class="card-subtitle mb-2">
                                    Período
                                    <c:out value="${periodo.id}" />:
                                </h5>

                                <div class="row">

                                    <div class="col">

                                        <h6 class="card-subtitle mb-2 text-body-secondary">
                                            Ano:
                                        </h6>

                                        <p class="card-text">
                                            <c:out value="${periodo.ano}"/>
                                        </p>

                                    </div>

                                    <div class="col">

                                        <h6 class="card-subtitle mb-2 text-body-secondary">
                                            Semestre:
                                        </h6>

                                        <p class="card-text">
                                            <c:out value="${periodo.semestre}" />
                                        </p>

                                    </div>

                                </div>

                                <hr>

                            </c:forEach>

                        </div>

                    </div>

                </div>

                <!-- ===================== -->
                <!-- CONQUISTAS            -->
                <!-- ===================== -->

                <div class="col">

                    <div class="card" style="width: 18rem;">

                        <div class="card-body">

                            <h4 class="card-title">
                                Número de conquistas: 0
                            </h4>

                            <hr>

                            <h5 class="card-subtitle mb-2">
                                Nome:
                            </h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">
                                Ano:
                            </h6>
                            <p class="card-text">
                                Descrição:
                            </p>

                            <hr>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </section>

    <br>
    <hr>
    <br>

    <!-- ========================================================= -->
    <!-- SEÇÃO 3 - PARTICIPAÇÕES                                   -->
    <!-- ========================================================= -->

    <section id="participacoes">

        <h1 style="text-align: center;">
            Participações
        </h1>

        <br>

        <div class="container">

            <div class="row g-4">

                <c:forEach
                    var="participacao"
                    items="${participacoes}"
                    >

                    <div class="col-12 col-md-6 col-lg-3">

                        <div class="card" style="width: 18rem;">

                            <img
                                class="card-img-top"
                                src="${supabaseUrl}/storage/v1/object/public/portal-robotica/${participacao.estudante.foto}"
                                alt="${participacao.estudante.nome}"
                                width="100"
                                >

                            <div class="card-body">

                                <h5 class="card-title">
                                    Aluno:
                                    <c:out value="${participacao.estudante.nome}" />
                                </h5>

                                <p class="card-text">
                                    Atividade:
                                    <c:out value="${participacao.atividade.titulo}" />
                                </p>

                                <p class="card-text">
                                    Descrição:
                                    <c:out value="${participacao.atividade.descricao}" />
                                </p>

                                <p class="card-text">
                                    Situação:
                                    <c:out value="${participacao.atividade.situacao}" />
                                </p>

                                <a href="#" class="btn btn-primary">
                                    Excluir
                                </a>

                            </div>

                        </div>

                    </div>

                </c:forEach>

            </div>

        </div>

    </section>

    <br><br><br>

    <jsp:include page="/public/footer-layout.jsp"/>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"
    ></script>

</body>
</html>