package br.edu.ifms.portalrobotica.dao;

import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Atividade;
import br.edu.ifms.portalrobotica.modelo.Coordenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {

    private Connection connection;

    public AtividadeDAO(Connection connection) {
        this.connection = connection;
    }

    public AtividadeDAO() {
    }

    public List<Atividade> listarTodos() throws SQLException {

        List<Atividade> atividades = new ArrayList<>();

        String sql
                = "SELECT "
                + "a.id, "
                + "a.titulo, "
                + "a.tipo, "
                + "a.descricao, "
                + "a.data_inicio, "
                + "a.data_fim, "
                + "a.situacao, "
                + "a.coordenador_id, "
                + "c.id AS coordenador_id, "
                + "c.nome AS coordenador_nome, "
                + "c.minibio AS coordenador_minibio, "
                + "c.foto AS coordenador_foto "
                + "FROM atividade a "
                + "INNER JOIN coordenador c "
                + "ON c.id = a.coordenador_id ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conectar();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Atividade atividade = new Atividade();

                atividade.setId(
                        rs.getInt("id")
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

                atividade.setCoordenadorId(
                        rs.getInt("coordenador_id")
                );

                Coordenador coordenador
                        = new Coordenador();

                coordenador.setId(
                        rs.getInt("coordenador_id")
                );

                coordenador.setNome(
                        rs.getString("coordenador_nome")
                );

                coordenador.setMinibio(
                        rs.getString("coordenador_minibio")
                );

                coordenador.setFoto(
                        rs.getString("coordenador_foto")
                );

                atividade.setCoordenador(
                        coordenador
                );

                atividades.add(atividade);
            }

            return atividades;

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

    public Atividade inserirAtividade(Atividade atividade)
            throws SQLException {

        String sql = "INSERT INTO atividade"
                + "(titulo, tipo, descricao, data_inicio, data_fim, situacao, coordenador_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = null;

        try {
            conectar();

            statement = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, atividade.getTitulo());
            statement.setString(2, atividade.getTipo());
            statement.setString(3, atividade.getDescricao());
            statement.setObject(4, atividade.getDataInicio());
            statement.setObject(5, atividade.getDataFim());
            statement.setString(6, atividade.getSituacao());
            statement.setInt(7, atividade.getCoordenadorId());

            statement.executeUpdate();

            try (ResultSet generatedKeys
                    = statement.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    atividade.setId((int) generatedKeys.getLong(1));
                }
            }
            return atividade;

        } finally {
            if (statement != null) {
                statement.close();
            }
            desconectar();
        }
    }

    public Atividade buscarPorId(int id)
            throws SQLException {

        String sql
                = "SELECT "
                + "a.id, "
                + "a.titulo, "
                + "a.tipo, "
                + "a.descricao, "
                + "a.data_inicio, "
                + "a.data_fim, "
                + "a.situacao, "
                + "a.coordenador_id "
                + "FROM atividade a "
                + "WHERE a.id = ?";

        try {

            conectar();

            try (PreparedStatement statement
                    = connection.prepareStatement(sql)) {

                statement.setInt(1, id);

                try (ResultSet rs
                        = statement.executeQuery()) {

                    if (rs.next()) {

                        Atividade atividade
                                = new Atividade();

                        atividade.setId(
                                rs.getInt("id")
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
                        }

                        atividade.setSituacao(
                                rs.getString("situacao")
                        );

                        atividade.setCoordenadorId(
                                rs.getInt("coordenador_id")
                        );

                        return atividade;
                    }
                }
            }

            return null;

        } finally {
            desconectar();
        }
    }

    public boolean apagar(Atividade atividade) throws SQLException {
        String sql = "DELETE FROM atividade WHERE id = ?";

        conectar();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, atividade.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException(
                    "Erro ao apagar o contato de ID " + atividade.getId(), e);

        } finally {
            desconectar();
        }
    }

}
