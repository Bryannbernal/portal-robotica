package br.edu.ifms.portalrobotica.dao;

import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Atividade;
import br.edu.ifms.portalrobotica.modelo.Estudante;
import br.edu.ifms.portalrobotica.modelo.Participacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParticipacaoDAO {

    private Connection connection;

    public ParticipacaoDAO(Connection connection) {
        this.connection = connection;
    }

    public ParticipacaoDAO() {
    }

    public List<Participacao> listarTodos() throws SQLException {

        List<Participacao> participacoes = new ArrayList<>();

        String sql
                = "SELECT "
                + "p.estudante_id, "
                + "p.atividade_id, "
                + "p.funcao, "
                + "p.descricao_contribuicao, "
                + "a.id AS atividade_id_resultado, "
                + "a.titulo, "
                + "a.tipo, "
                + "a.descricao, "
                + "a.data_inicio, "
                + "a.data_fim, "
                + "a.situacao, "
                + "e.id AS estudante_id_resultado, "
                + "e.nome, "
                + "e.foto, "
                + "e.minibio "
                + "FROM participacao p "
                + "JOIN atividade a "
                + "ON a.id = p.atividade_id "
                + "JOIN estudante e "
                + "ON e.id = p.estudante_id "
                + "ORDER BY e.nome, a.titulo";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conectar();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Participacao participacao
                        = new Participacao();

                participacao.setEstudanteId(
                        rs.getInt("estudante_id")
                );

                participacao.setAtividadeId(
                        rs.getInt("atividade_id")
                );

                participacao.setFuncao(
                        rs.getString("funcao")
                );

                participacao.setDescricaoContribuicao(
                        rs.getString("descricao_contribuicao")
                );

                // =========================
                // ATIVIDADE
                // =========================
                Atividade atividade
                        = new Atividade();

                atividade.setId(
                        rs.getInt("atividade_id_resultado")
                );

                atividade.setTitulo(
                        rs.getString("titulo")
                );

                atividade.setTipo(
                        rs.getString("tipo")
                );

                atividade.setDescricao(
                        rs.getString("descricao")
                );

                atividade.setDataInicio(
                        rs.getDate("data_inicio")
                                .toLocalDate()
                );

                if (rs.getDate("data_fim") != null) {

                    atividade.setDataFim(
                            rs.getDate("data_fim")
                                    .toLocalDate()
                    );

                } else {

                    atividade.setDataFim(null);
                }

                atividade.setSituacao(
                        rs.getString("situacao")
                );

                // =========================
                // ESTUDANTE
                // =========================
                Estudante estudante
                        = new Estudante();

                estudante.setId(
                        rs.getInt("estudante_id_resultado")
                );

                estudante.setNome(
                        rs.getString("nome")
                );

                estudante.setFoto(
                        rs.getString("foto")
                );

                estudante.setMinibio(
                        rs.getString("minibio")
                );

                // =========================
                // RELACIONAMENTOS
                // =========================
                participacao.setAtividade(
                        atividade
                );

                participacao.setEstudante(
                        estudante
                );

                participacoes.add(
                        participacao
                );
            }

            return participacoes;

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            desconectar();
        }
    }

    private void conectar() throws SQLException {

        try {
            if (connection == null || connection.isClosed()) {
                connection = Conexao.getConnection();
            }
        } catch (Exception e) {
            throw new SQLException(
                    "Não foi possível obter uma conexão com o banco de dados.",
                    e
            );
        }
    }

    private void desconectar() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Participacao inserirParticipacao(Participacao participacao)
            throws SQLException {

        String sql = "INSERT INTO participacao "
                + "(estudante_id, atividade_id, funcao, descricao_contribuicao) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement statement = null;

        try {
            conectar();

            statement = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            statement.setInt(1, participacao.getEstudanteId());
            statement.setInt(2, participacao.getAtividadeId());
            statement.setString(3, participacao.getFuncao());
            statement.setString(4, participacao.getDescricaoContribuicao());

            statement.executeUpdate();

            return participacao;

        } finally {
            if (statement != null) {
                statement.close();
            }
            desconectar();
        }
    }

    public boolean desvincularEstudante(
            int estudanteId,
            int atividadeId)
            throws SQLException {

        String sql
                = "DELETE FROM participacao "
                + "WHERE estudante_id = ? "
                + "AND atividade_id = ?";

        try {

            conectar();

            try (PreparedStatement statement
                    = connection.prepareStatement(sql)) {

                statement.setInt(1, estudanteId);
                statement.setInt(2, atividadeId);

                return statement.executeUpdate() > 0;
            }

        } finally {
            desconectar();
        }
    }
}
