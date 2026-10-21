package br.edu.ifms.portalrobotica.controller;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

@WebServlet("/i18n")
public class I18nController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lingua = request.getParameter("lingua");

        // Idioma padrão
        if (!"pt_BR".equals(lingua)
                && !"en_US".equals(lingua)
                && !"es_ES".equals(lingua)
                && !"fr_FR".equals(lingua)) {

            lingua = "pt_BR";
        }

        // Divide, por exemplo: en_US -> en + US
        String[] partes = lingua.split("_");

        // CRIA O NOVO LOCALE
        Locale locale = new Locale.Builder()
                .setLanguage(partes[0])
                .setRegion(partes[1])
                .build();

        // Salva o idioma na sessão
        Config.set(
                request.getSession(),
                Config.FMT_LOCALE,
                locale
        );

        // Volta para a página inicial
        response.sendRedirect(request.getContextPath() + "/");
    }
}
