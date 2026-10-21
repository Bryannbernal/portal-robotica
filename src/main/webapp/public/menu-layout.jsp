<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>${param.titulo}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
        <link
            rel="apple-touch-icon"
            sizes="180x180"
            href="${pageContext.request.contextPath}/resources/favicon/apple-touch-icon.png"
            />
        <link
            rel="icon"
            type="image/png"
            sizes="32x32"
            href="${pageContext.request.contextPath}/resources/favicon/favicon-32x32.png"
            />
        <link
            rel="icon"
            type="image/png"
            sizes="16x16"
            href="${pageContext.request.contextPath}/resources/favicon/favicon-16x16.png"
            />
        <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon/site.webmanifest" />
    </head>
    <nav class="navbar navbar-expand-lg navbar-site">
        <div class="container-fluid">
            <a href="${pageContext.request.contextPath}/" class="logo-ifms">
                <img
                    src="public/imagens/logo-ifms.png"
                    alt="Instituto Federal de Mato Grosso do Sul"
                    />
                <div class="logo-texto">
                    <strong> INSTITUTO FEDERAL </strong>
                    <small> Mato Grosso do Sul </small>
                </div>
            </a>
            <button
                class="navbar-toggler ms-auto"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menuPrincipal"
                aria-controls="menuPrincipal"
                aria-expanded="false"
                aria-label="Abrir menu"
                >
                <i class="bi bi-list"></i>
            </button>
            <div
                class="collapse navbar-collapse justify-content-end"
                id="menuPrincipal"
                >
                <ul class="navbar-nav align-items-lg-center">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/" class="nav-link menu-link">
                            <i class="bi bi-house-door"></i>
                            <fmt:message key="home.inicio" />
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/public?acao=sobre" class="nav-link menu-link"> 
                            <i class="bi bi-info-circle"></i>
                            <fmt:message key="home.sobre" />
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/public?acao=projetos" class="nav-link menu-link"> 
                            <i class="bi bi-robot"></i>
                            <fmt:message key="home.atividades" />
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/#contato" class="nav-link menu-link">
                            <fmt:message key="home.contato" />
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/public?acao=novidades" class="nav-link menu-link">
                            <i class="bi bi-newspaper"></i>
                            <fmt:message key="home.novidades" />
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-gear"></i>
                            <fmt:message key="home.administracao" />
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin?acao=lista"><fmt:message key="home.lista" /></a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin?acao=cadEstudante"><fmt:message key="home.estudante" /></a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin?acao=cadAtividade"><fmt:message key="home.atividade" /></a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-translate"></i>
                            <fmt:message key="home.tradutor" />
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/i18n?lingua=pt_BR">Português</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/i18n?lingua=en_US">English</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/i18n?lingua=es_ES">Español</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/i18n?lingua=fr_FR">français</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>