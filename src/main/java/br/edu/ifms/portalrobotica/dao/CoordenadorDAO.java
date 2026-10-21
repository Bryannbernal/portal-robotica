package br.edu.ifms.portalrobotica.dao;

import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Coordenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorDAO {

    private Connection connection;

    public CoordenadorDAO(Connection connection) {
        this.connection = connection;
    }

    public CoordenadorDAO() {
    }

    public List<Coordenador> listarTodos() throws SQLException {

        List<Coordenador> coordenadores = new ArrayList<>();

        String sql = "SELECT id, nome, foto, minibio FROM coordenador ORDER BY nome";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conectar();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Coordenador coordenador = new Coordenador();

                coordenador.setId(rs.getInt("id"));
                coordenador.setNome(rs.getString("nome"));
                coordenador.setFoto(rs.getString("foto"));
                coordenador.setMinibio(rs.getString("minibio"));

                coordenadores.add(coordenador);
            }

            return coordenadores;

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
    
    public Coordenador buscarPorId(int id)
            throws SQLException {

        String sql
                = "SELECT id, nome, minibio, foto "
                + "FROM coordenador "
                + "WHERE id = ?";

        try (PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs
                    = statement.executeQuery()) {

                if (rs.next()) {

                    Coordenador coordenador
                            = new Coordenador();

                    coordenador.setId(
                            rs.getInt("id")
                    );

                    coordenador.setNome(
                            rs.getString("nome")
                    );

                    coordenador.setMinibio(
                            rs.getString("minibio")
                    );

                    coordenador.setFoto(
                            rs.getString("foto")
                    );

                    return coordenador;
                }
            }
        }

        return null;
    }
}
