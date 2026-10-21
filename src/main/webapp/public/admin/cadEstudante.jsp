<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.edu.ifms.portalrobotica.modelo.Coordenador" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>
    <jsp:include  page="/public/menu-layout.jsp">
        <jsp:param name="titulo" value="Novo Estudante" />
    </jsp:include>
    <br><br><br><br><br><br>
    <div class="mx-auto p-2" style="width: 800px;">
        <h1>Cadastrar novo estudante</h1>
        <c:if test="${not empty mensagem}">
            <div class="alert alert-success alert-dismissible fade show"
                 role="alert">

                <c:out value="${mensagem}" />

                <button type="button"
                        class="btn-close"
                        data-bs-dismiss="alert"
                        aria-label="Fechar">
                </button>
            </div>
        </c:if>
        <br>
        <form method="post" enctype='multipart/form-data' action="${pageContext.request.contextPath}/admin?acao=inserirEst">
            <div class="mb-3">
                <label class="form-label">Nome</label>
                <input type="text" name="nome" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Mini-Bio</label>
                <textarea name="minibio" class="form-control" placeholder="Escreva um pouco sobre você...."></textarea>
            </div>
            <div class="mb-3">
                <label for="formFile" class="form-label">Envie uma foto sua</label>
                <input class="form-control" type="file" name="foto">
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
    <br><br>
    <jsp:include page="/public/footer-layout.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
