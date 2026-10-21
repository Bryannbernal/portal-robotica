package br.edu.ifms.portalrobotica.dao;

import br.edu.ifms.portalrobotica.dao.util.Conexao;
import br.edu.ifms.portalrobotica.modelo.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodoDAO {

    private Connection connection;

    public PeriodoDAO(Connection connection) {
        this.connection = connection;
    }

    public PeriodoDAO() {
    }

    public List<Periodo> listarTodos() throws SQLException {

        List<Periodo> periodos = new ArrayList<>();

        String sql = "SELECT id, semestre, ano FROM periodo_letivo";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conectar();

            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Periodo periodo = new Periodo();

                periodo.setId(rs.getInt("id"));
                periodo.setSemestre(rs.getInt("semestre"));
                periodo.setAno(rs.getInt("ano"));

                periodos.add(periodo);
            }

            return periodos;

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

    public Periodo buscarPorId(int id)
            throws SQLException {

        String sql = "SELECT id, semestre, ano FROM periodo_letivo";

        try (PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs
                    = statement.executeQuery()) {

                if (rs.next()) {

                    Periodo periodo
                            = new Periodo();

                    periodo.setId(
                            rs.getInt("id")
                    );
                    
                    periodo.setSemestre(
                            rs.getInt("semestre")
                    );

                    periodo.setAno(
                            rs.getInt("ano")
                    );

                    return periodo;
                }
            }
        }
        return null;
    }
}
