package br.edu.ifms.portalrobotica.dao;

import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Estudante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {

    private Connection connection;

    public EstudanteDAO(Connection connection) {
        this.connection = connection;
    }

    public EstudanteDAO() {
    }

    public List<Estudante> listarTodos() throws SQLException {

        List<Estudante> estudantes = new ArrayList<>();

        String sql
                = "SELECT id, nome, foto, minibio "
                + "FROM estudante "
                + "ORDER BY nome";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conectar();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Estudante estudante
                        = new Estudante();

                estudante.setId(
                        rs.getInt("id")
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

                estudantes.add(estudante);
            }

            return estudantes;

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

    public Estudante inserirEstudante(Estudante estudante)
            throws SQLException {

        String sql = "INSERT INTO estudante "
                + "(nome, minibio, foto) "
                + "VALUES (?, ?, ?)";

        PreparedStatement statement = null;

        try {
            conectar();

            statement = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, estudante.getNome());
            statement.setString(2, estudante.getMinibio());
            statement.setString(3, estudante.getFoto());

            statement.executeUpdate();

            try (ResultSet generatedKeys
                    = statement.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    estudante.setId((int) generatedKeys.getLong(1));
                }
            }
            return estudante;

        } finally {
            if (statement != null) {
                statement.close();
            }
            desconectar();
        }
    }

    public Estudante buscarPorId(int id)
            throws SQLException {

        String sql
                = "SELECT id, nome, minibio, foto "
                + "FROM estudante "
                + "WHERE id = ?";

        try (PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs
                    = statement.executeQuery()) {

                if (rs.next()) {

                    Estudante estudante
                            = new Estudante();

                    estudante.setId(
                            rs.getInt("id")
                    );

                    estudante.setNome(
                            rs.getString("nome")
                    );

                    estudante.setMinibio(
                            rs.getString("minibio")
                    );

                    estudante.setFoto(
                            rs.getString("foto")
                    );

                    return estudante;
                }
            }
        }

        return null;
    }

    public boolean apagar(Estudante estudante) throws SQLException {
        String sql = "DELETE FROM estudante WHERE id = ?";

        conectar();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, estudante.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException(
                    "Erro ao apagar o contato de ID " + estudante.getId(), e);

        } finally {
            desconectar();
        }
    }

}
