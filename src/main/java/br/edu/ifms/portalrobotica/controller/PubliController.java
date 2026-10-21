package br.edu.ifms.portalrobotica.controller;

import br.edu.ifms.portalrobotica.dao.AtividadeDAO;
import br.edu.ifms.portalrobotica.dao.CoordenadorDAO;
import br.edu.ifms.portalrobotica.dao.EstudanteDAO;
import br.edu.ifms.portalrobotica.modelo.Atividade;
import br.edu.ifms.portalrobotica.modelo.Coordenador;
import br.edu.ifms.portalrobotica.modelo.Estudante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Locale;
import javax.servlet.jsp.jstl.core.Config;
import br.edu.ifms.portalrobotica.util.I18nUtil;

@WebServlet("/public")
public class PubliController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EstudanteDAO estudanteDAO;
    private AtividadeDAO atividadeDAO;
    private CoordenadorDAO coordenadorDAO;

    @Override
    public void init() throws ServletException {
        estudanteDAO = new EstudanteDAO();
        atividadeDAO = new AtividadeDAO();
        coordenadorDAO = new CoordenadorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processarRequisicao(request, response);
        } catch (SQLException ex) {
            System.getLogger(PubliController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            processarRequisicao(request, response);
        } catch (SQLException ex) {
            System.getLogger(PubliController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        switch (acao) {
            case "sobre":
                abrirSobre(request, response);
                break;
            case "projetos":
                abrirProjetos(request, response);
                break;
            case "novidades":
                abrirNovidades(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/");
                break;
        }
    }

    private void abrirSobre(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        List<Estudante> estudantes = estudanteDAO.listarTodos();
        List<Coordenador> coordenadores = coordenadorDAO.listarTodos();

        request.setAttribute("coordenadores", coordenadores);
        request.setAttribute("estudantes", estudantes);

        request.setAttribute("estudantes", estudantes);
        request.setAttribute("coordenadores", coordenadores);
        request.setAttribute("supabaseUrl", "https://kbvkfvndninjqokcpzln.supabase.co");

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/public/sobre.jsp");

        dispatcher.forward(request, response);
    }

    private void abrirProjetos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();

        List<Atividade> atividades = atividadeDAO.listarTodos();

        request.setAttribute("atividades", atividades);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/public/projetos.jsp");

        dispatcher.forward(request, response);
    }

    private void abrirNovidades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/public/novidades.jsp");

        dispatcher.forward(request, response);
    }
}
