package br.edu.ifms.portalrobotica.controller;

import br.edu.ifms.portalrobotica.dao.AtividadeDAO;
import br.edu.ifms.portalrobotica.dao.CoordenadorDAO;
import br.edu.ifms.portalrobotica.dao.EstudanteDAO;
import br.edu.ifms.portalrobotica.dao.ParticipacaoDAO;
import br.edu.ifms.portalrobotica.dao.PeriodoDAO;
import br.edu.ifms.portalrobotica.dao.AtividadePeriodoDAO;
import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Coordenador;
import br.edu.ifms.portalrobotica.modelo.Estudante;
import br.edu.ifms.portalrobotica.modelo.Participacao;
import br.edu.ifms.portalrobotica.modelo.Periodo;
import br.edu.ifms.portalrobotica.modelo.AtividadePeriodo;
import br.edu.ifms.portalrobotica.util.SupabaseStorage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import br.edu.ifms.portalrobotica.modelo.Atividade;
import java.util.Locale;
import javax.servlet.jsp.jstl.core.Config;
import br.edu.ifms.portalrobotica.util.I18nUtil;

@WebServlet("/admin")
@MultipartConfig
public class AdminController extends HttpServlet {

    private EstudanteDAO estudanteDAO;
    private AtividadeDAO atividadeDAO;
    private CoordenadorDAO coordenadorDAO;
    private ParticipacaoDAO participacaoDAO;
    private PeriodoDAO periodoDAO;
    private AtividadePeriodoDAO tempoDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processarRequisicao(request, response);
        } catch (SQLException ex) {
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (NamingException ex) {
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (InterruptedException ex) {
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (NamingException ex) {
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (InterruptedException ex) {
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void init() throws ServletException {
        estudanteDAO = new EstudanteDAO();
        atividadeDAO = new AtividadeDAO();
        coordenadorDAO = new CoordenadorDAO();
        participacaoDAO = new ParticipacaoDAO();
        periodoDAO = new PeriodoDAO();
        tempoDAO = new AtividadePeriodoDAO();
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException, InterruptedException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        switch (acao) {
            case "lista":
                abrirLista(request, response);
                break;
            case "cadEstudante":
                abrirNovoEstudante(request, response);
                break;
            case "cadAtividade":
                abrirNovaAtividade(request, response);
                break;
            case "participacao":
                abrirParticipacao(request, response);
                break;
            case "inserirParticipacao":
                gravarParticipacao(request, response);
                break;
            case "inserirEst":
                gravarEstudante(request, response);
                break;
            case "inserirAtv":
                gravarAtividade(request, response);
                break;
            case "excluirEstudante":
                excluirEstudante(request, response);
                break;
            case "excluirAtividade":
                excluirAtividade(request, response);
                break;
            case "excluirParticipacao":
                desvincularParticipacao(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/");
                break;
        }
    }

    private void abrirNovoEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/public/admin/cadEstudante.jsp");

        dispatcher.forward(request, response);
    }

    private void abrirNovaAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection connection = Conexao.getConnection();
            List<Coordenador> coordenadores
                    = coordenadorDAO.listarTodos();

            request.setAttribute("coordenadores", coordenadores);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/public/admin/cadAtividade.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NamingException ex) {
            System.getLogger(AdminController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private void abrirLista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        List<Estudante> estudantes = estudanteDAO.listarTodos();
        List<Atividade> atividades = atividadeDAO.listarTodos();
        List<Coordenador> coordenadores = coordenadorDAO.listarTodos();
        List<Participacao> participacoes = participacaoDAO.listarTodos();
        List<Periodo> periodos = periodoDAO.listarTodos();
        List<AtividadePeriodo> tempos = tempoDAO.listarTodos();

        request.setAttribute("tempos", tempos);
        request.setAttribute("participacoes", participacoes);
        request.setAttribute("periodos", periodos);
        request.setAttribute("coordenadores", coordenadores);
        request.setAttribute("estudantes", estudantes);
        request.setAttribute("atividades", atividades);
        request.setAttribute("supabaseUrl", "https://kbvkfvndninjqokcpzln.supabase.co");

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/public/admin/listagem.jsp");

        dispatcher.forward(request, response);
    }

    private void abrirParticipacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        List<Estudante> estudantes = estudanteDAO.listarTodos();
        List<Atividade> atividades = atividadeDAO.listarTodos();
        request.setAttribute("estudantes", estudantes);
        request.setAttribute("atividades", atividades);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/public/admin/ParticipMaker.jsp");

        dispatcher.forward(request, response);
    }

    private void gravarParticipacao(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String atividadeIdStr = request.getParameter("atividadeId");
        String estudanteIdStr = request.getParameter("estudanteId");

        int atividadeId = Integer.parseInt(atividadeIdStr);
        int estudanteId = Integer.parseInt(estudanteIdStr);
        String funcao = request.getParameter("funcao");
        String descricaoContribuicao = request.getParameter("descricaoContribuicao");

        try {
            Participacao participacao
                    = new Participacao(
                            atividadeId,
                            estudanteId,
                            funcao,
                            descricaoContribuicao
                    );

            participacaoDAO.inserirParticipacao(
                    participacao
            );

            request.setAttribute(
                    "mensagem",
                    "Vinculo criado com sucesso!"
            );

            request.getRequestDispatcher(
                    "/public/admin/ParticipMaker.jsp"
            ).forward(
                    request,
                    response
            );
        } catch (Exception e) {

            throw new ServletException(
                    "Não foi possível cadastrar o estudante.",
                    e
            );
        }
    }

    private void desvincularParticipacao(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int estudanteId = Integer.parseInt(
                request.getParameter("estudanteId")
        );

        int atividadeId = Integer.parseInt(
                request.getParameter("atividadeId")
        );

        try {

            participacaoDAO.desvincularEstudante(
                    estudanteId,
                    atividadeId
            );

            response.sendRedirect(
                    request.getContextPath()
                    + "/admin?acao=lista"
            );

        } catch (SQLException e) {

            throw new ServletException(
                    "Não foi possível desvincular o estudante da atividade.",
                    e
            );
        }
    }

    private void gravarEstudante(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nome
                = request.getParameter("nome");
        String minibio
                = request.getParameter("minibio");
        Part fotoPart
                = request.getPart("foto");

        String nomeArquivo = null;
        try {
            SupabaseStorage storage
                    = new SupabaseStorage();
            nomeArquivo
                    = storage.salvarImagem(fotoPart);
            Estudante estudante
                    = new Estudante(
                            nome,
                            minibio,
                            nomeArquivo
                    );

            estudanteDAO.inserirEstudante(
                    estudante
            );

            request.setAttribute(
                    "mensagem",
                    "Estudante gravado com sucesso!"
            );

            request.getRequestDispatcher(
                    "/public/admin/cadEstudante.jsp"
            ).forward(
                    request,
                    response
            );

        } catch (Exception e) {

            throw new ServletException(
                    "Não foi possível cadastrar o estudante.",
                    e
            );
        }
    }

    private void excluirEstudante(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, NamingException, InterruptedException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Estudante estudante = new Estudante();
            estudante.setId(id);

            String caminhoFoto
                    = estudante.getFoto();

            if (caminhoFoto != null
                    && !caminhoFoto.isBlank()) {

                SupabaseStorage storage
                        = new SupabaseStorage();

                storage.excluirImagem(caminhoFoto);
            }

            estudanteDAO.apagar(estudante);

            String path = request.getContextPath()
                    + request.getServletPath()
                    + "?acao=lista";

            response.sendRedirect(path);

        } catch (SQLException e) {
            getServletContext().log("Erro ao apagar contato", e);

            response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Não foi possível apagar o contato.");
        }
    }

    private void gravarAtividade(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // =========================================================
        // PEGA OS DADOS DO FORMULÁRIO
        // =========================================================
        String titulo = request.getParameter("titulo");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");

        // IMPORTANTE:
        // Esses nomes precisam ser iguais aos "name" do formulário.
        String dataInicioString = request.getParameter("data_inicio");
        String dataFimString = request.getParameter("data_fim");

        String situacao = request.getParameter("situacao");
        String coordenadorIdString = request.getParameter("coordenador");

        // Checkbox:
        // quando marcado, o navegador envia "on".
        String emAndamento = request.getParameter("em_andamento");

        // =========================================================
        // VALIDAÇÃO DA DATA DE INÍCIO
        // =========================================================
        LocalDate dataInicio;

        try {

            if (dataInicioString == null || dataInicioString.isBlank()) {

                request.setAttribute(
                        "erro",
                        "Informe a data de início da atividade."
                );

                recarregarFormularioAtividade(request, response);
                return;
            }

            dataInicio = LocalDate.parse(dataInicioString);

        } catch (java.time.format.DateTimeParseException e) {

            request.setAttribute(
                    "erro",
                    "A data de início informada é inválida."
            );

            recarregarFormularioAtividade(request, response);
            return;
        }

        // =========================================================
        // DATA DE FIM
        // =========================================================
        LocalDate dataFim = null;


        /*
     * Se a atividade ainda está acontecendo,
     * ela pode ficar sem data de fim.
         */
        if (!"on".equals(emAndamento)) {

            try {

                if (dataFimString == null || dataFimString.isBlank()) {

                    request.setAttribute(
                            "erro",
                            "Informe a data de fim ou marque que a atividade ainda está ocorrendo."
                    );

                    recarregarFormularioAtividade(request, response);
                    return;
                }

                dataFim = LocalDate.parse(dataFimString);

            } catch (java.time.format.DateTimeParseException e) {

                request.setAttribute(
                        "erro",
                        "A data de fim informada é inválida."
                );

                recarregarFormularioAtividade(request, response);
                return;
            }
        }

        // =========================================================
        // DATA FINAL NÃO PODE SER ANTERIOR À DATA INICIAL
        // =========================================================
        if (dataFim != null && dataFim.isBefore(dataInicio)) {

            request.setAttribute(
                    "erro",
                    "A data final não pode ser anterior à data inicial."
            );

            // Mantém os dados para o formulário
            request.setAttribute("titulo", titulo);
            request.setAttribute("tipo", tipo);
            request.setAttribute("descricao", descricao);
            request.setAttribute("data_inicio", dataInicioString);
            request.setAttribute("data_fim", dataFimString);
            request.setAttribute("situacao", situacao);
            request.setAttribute("coordenador", coordenadorIdString);
            request.setAttribute("em_andamento", emAndamento);

            recarregarFormularioAtividade(request, response);
            return;
        }

        // =========================================================
        // COORDENADOR
        // =========================================================
        int coordenadorId;

        try {

            if (coordenadorIdString == null
                    || coordenadorIdString.isBlank()) {

                request.setAttribute(
                        "erro",
                        "Selecione um coordenador."
                );

                recarregarFormularioAtividade(request, response);
                return;
            }

            coordenadorId
                    = Integer.parseInt(coordenadorIdString);

        } catch (NumberFormatException e) {

            request.setAttribute(
                    "erro",
                    "Selecione um coordenador válido."
            );

            recarregarFormularioAtividade(request, response);
            return;
        }

        // =========================================================
        // CRIA O OBJETO ATIVIDADE
        // =========================================================
        Atividade atividade = new Atividade();

        atividade.setTitulo(titulo);
        atividade.setTipo(tipo);
        atividade.setDescricao(descricao);

        atividade.setDataInicio(dataInicio);
        atividade.setDataFim(dataFim);

        atividade.setSituacao(situacao);
        atividade.setCoordenadorId(coordenadorId);

        // =========================================================
        // SALVA NO BANCO
        // =========================================================
        try {

            atividadeDAO.inserirAtividade(atividade);

            request.setAttribute(
                    "mensagem",
                    "Atividade cadastrada com sucesso!"
            );

            recarregarFormularioAtividade(request, response);

        } catch (SQLException e) {

            throw new ServletException(
                    "Não foi possível cadastrar a atividade.",
                    e
            );
        }
    }

    private void recarregarFormularioAtividade(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Connection connection = Conexao.getConnection();

            CoordenadorDAO coordenadorDAO
                    = new CoordenadorDAO(connection);

            List<Coordenador> coordenadores
                    = coordenadorDAO.listarTodos();

            request.setAttribute(
                    "coordenadores",
                    coordenadores
            );

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/public/admin/cadAtividade.jsp"
                    );

            dispatcher.forward(request, response);

        } catch (SQLException | NamingException e) {

            throw new ServletException(
                    "Não foi possível carregar o formulário de atividade.",
                    e
            );
        }
    }

    private void excluirAtividade(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, NamingException, InterruptedException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Atividade atividade = new Atividade();
            atividade.setId(id);

            atividadeDAO.apagar(atividade);

            String path = request.getContextPath()
                    + request.getServletPath()
                    + "?acao=lista";

            response.sendRedirect(path);

        } catch (SQLException e) {
            getServletContext().log("Erro ao apagar contato", e);

            response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Não foi possível apagar o contato.");
        }
    }
}
