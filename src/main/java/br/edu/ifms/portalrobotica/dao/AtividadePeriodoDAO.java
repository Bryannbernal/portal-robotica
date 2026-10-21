package br.edu.ifms.portalrobotica.dao;

import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Atividade;
import br.edu.ifms.portalrobotica.modelo.AtividadePeriodo;
import br.edu.ifms.portalrobotica.modelo.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtividadePeriodoDAO {

    private Connection connection;

    public AtividadePeriodoDAO(Connection connection) {
        this.connection = connection;
    }

    public AtividadePeriodoDAO() {
    }

    public List<AtividadePeriodo> listarTodos() throws SQLException {

        List<AtividadePeriodo> tempos = new ArrayList<>();

        String sql = "SELECT "
                + "ap.atividade_id, "
                + "ap.periodo_id, "
                + "a.id AS a_id, "
                + "a.titulo AS a_titulo, "
                + "a.tipo AS a_tipo, "
                + "a.descricao AS a_descricao, "
                + "a.data_inicio AS a_data_inicio, "
                + "a.data_fim AS a_data_fim, "
                + "a.situacao AS a_situacao, "
                + "a.coordenador_id AS a_coordenador_id, "
                + "p.id AS p_id, "
                + "p.ano AS p_ano, "
                + "p.semestre AS p_semestre "
                + "FROM atividade_periodo ap "
                + "JOIN atividade a "
                + "ON a.id = ap.atividade_id "
                + "JOIN periodo_letivo p "
                + "ON p.id = ap.periodo_id";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conectar();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                AtividadePeriodo tempo = new AtividadePeriodo();

                tempo.setAtividadeId(
                        rs.getInt("atividade_id")
                );

                tempo.setPeriodoId(
                        rs.getInt("periodo_id")
                );

                tempos.add(tempo);

                // ATIVIDADE
                Atividade atividade = new Atividade();

                atividade.setId(
                        rs.getInt("a_id")
                );

                atividade.setTitulo(
                        rs.getString("a_titulo")
                );

                atividade.setTipo(
                        rs.getString("a_tipo")
                );

                atividade.setDescricao(
                        rs.getString("a_descricao")
                );

                atividade.setDataInicio(
                        rs.getDate("a_data_inicio").toLocalDate()
                );

                if (rs.getDate("a_data_fim") != null) {
                    atividade.setDataFim(
                            rs.getDate("a_data_fim").toLocalDate()
                    );
                }

                atividade.setSituacao(
                        rs.getString("a_situacao")
                );

                atividade.setCoordenadorId(
                        rs.getInt("a_coordenador_id")
                );

                // PERÍODO
                Periodo periodo = new Periodo();

                periodo.setId(
                        rs.getInt("p_id")
                );

                periodo.setAno(
                        rs.getInt("p_ano")
                );

                periodo.setSemestre(
                        rs.getInt("p_semestre")
                );

                // ASSOCIA OS OBJETOS
                tempo.setAtividade(atividade);
                tempo.setPeriodo(periodo);

                tempos.add(tempo);
            }

            return tempos;

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

    public AtividadePeriodo inserirTempo(AtividadePeriodo tempo)
            throws SQLException {

        String sql = "INSERT INTO atividade_periodo "
                + "(atividade_id, periodo_id) "
                + "VALUES (?, ?)";

        PreparedStatement statement = null;

        try {

            conectar();

            statement = connection.prepareStatement(sql);

            statement.setInt(
                    1,
                    tempo.getAtividadeId()
            );

            statement.setInt(
                    2,
                    tempo.getPeriodoId()
            );

            statement.executeUpdate();

            return tempo;

        } finally {

            if (statement != null) {
                statement.close();
            }

            desconectar();
        }
    }

    public boolean excluir(
            int atividadeId,
            int periodoId)
            throws SQLException {

        String sql = "DELETE FROM atividade_periodo "
                + "WHERE atividade_id = ? "
                + "AND periodo_id = ?";

        try {

            conectar();

            try (PreparedStatement statement
                    = connection.prepareStatement(sql)) {

                statement.setInt(1, atividadeId);
                statement.setInt(2, periodoId);

                return statement.executeUpdate() > 0;
            }

        } finally {

            desconectar();
        }
    }
}
