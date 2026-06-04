package dao;

import model.Consulta;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public boolean cadastrar(Consulta c) {

        String sql = "INSERT INTO consulta " +
                "(paciente_id, medico_id, data, hora, descricao, status_consulta) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getIdPaciente());
            stmt.setInt(2, c.getIdMedico());
            stmt.setString(3, c.getData());
            stmt.setString(4, c.getHora());
            stmt.setString(5, c.getDescricao());
            stmt.setString(6, c.getStatus() != null ? c.getStatus() : "AGENDADA");

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Consulta> listarTodos() {

        List<Consulta> lista = new ArrayList<>();

        String sql =
                "SELECT c.*, " +
                "p.nome AS paciente_nome, " +
                "m.nome AS medico_nome " +
                "FROM consulta c " +
                "LEFT JOIN paciente p ON c.paciente_id = p.id " +
                "LEFT JOIN medico m ON c.medico_id = m.id " +
                "ORDER BY c.id DESC";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Consulta c = new Consulta();

                c.setId(rs.getInt("id"));
                c.setIdPaciente(rs.getInt("paciente_id"));
                c.setIdMedico(rs.getInt("medico_id"));

                c.setData(rs.getString("data"));
                c.setHora(rs.getString("hora"));
                c.setDescricao(rs.getString("descricao"));

                c.setStatus(rs.getString("status_consulta"));

                c.setPacienteNome(rs.getString("paciente_nome"));
                c.setMedicoNome(rs.getString("medico_nome"));

                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Consulta buscarPorId(int id) {

        String sql =
                "SELECT c.*, " +
                "p.nome AS paciente_nome, " +
                "m.nome AS medico_nome " +
                "FROM consulta c " +
                "LEFT JOIN paciente p ON c.paciente_id = p.id " +
                "LEFT JOIN medico m ON c.medico_id = m.id " +
                "WHERE c.id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Consulta c = new Consulta();

                    c.setId(rs.getInt("id"));
                    c.setIdPaciente(rs.getInt("paciente_id"));
                    c.setIdMedico(rs.getInt("medico_id"));

                    c.setData(rs.getString("data"));
                    c.setHora(rs.getString("hora"));
                    c.setDescricao(rs.getString("descricao"));

                    c.setStatus(rs.getString("status_consulta"));

                    c.setPacienteNome(rs.getString("paciente_nome"));
                    c.setMedicoNome(rs.getString("medico_nome"));

                    return c;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Consulta c) {

        String sql =
                "UPDATE consulta SET " +
                "paciente_id=?, medico_id=?, data=?, hora=?, descricao=?, status_consulta=? " +
                "WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getIdPaciente());
            stmt.setInt(2, c.getIdMedico());
            stmt.setString(3, c.getData());
            stmt.setString(4, c.getHora());
            stmt.setString(5, c.getDescricao());
            stmt.setString(6, c.getStatus());
            stmt.setInt(7, c.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM consulta WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}