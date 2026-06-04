package dao;

import model.Prontuario;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    public boolean cadastrar(Prontuario pr) {

        String sql = "INSERT INTO prontuario (paciente_id, diagnostico, tratamento, observacoes, data_registro) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pr.getPaciente_id());
            stmt.setString(2, pr.getDiagnostico());
            stmt.setString(3, pr.getTratamento());
            stmt.setString(4, pr.getObservacoes());
            stmt.setString(5, pr.getData_registro());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Prontuario> listarTodos() {

        List<Prontuario> lista = new ArrayList<>();

        String sql ="SELECT pr.*, p.nome AS paciente_nome " +
             "FROM prontuario pr " +
             "LEFT JOIN paciente p ON pr.paciente_id = p.id ";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Prontuario pr = new Prontuario();

                pr.setId(rs.getInt("id"));
                pr.setPaciente_id(rs.getInt("paciente_id"));
                pr.setDiagnostico(rs.getString("diagnostico"));
                pr.setTratamento(rs.getString("tratamento"));
                pr.setObservacoes(rs.getString("observacoes"));
                pr.setData_registro(rs.getString("data_registro"));
                pr.setPacienteNome(rs.getString("paciente_nome"));

                lista.add(pr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Prontuario buscarPorId(int id) {

        String sql =
            "SELECT pr.*, p.nome AS paciente_nome " +
            "FROM prontuario pr " +
            "INNER JOIN paciente p ON pr.paciente_id = p.id " +
            "WHERE pr.id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Prontuario pr = new Prontuario();

                    pr.setId(rs.getInt("id"));
                    pr.setPaciente_id(rs.getInt("paciente_id"));
                    pr.setDiagnostico(rs.getString("diagnostico"));
                    pr.setTratamento(rs.getString("tratamento"));
                    pr.setObservacoes(rs.getString("observacoes"));
                    pr.setData_registro(rs.getString("data_registro"));
                    pr.setPacienteNome(rs.getString("paciente_nome"));

                    return pr;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Prontuario pr) {

        String sql =
            "UPDATE prontuario SET paciente_id=?, diagnostico=?, tratamento=?, observacoes=?, data_registro=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pr.getPaciente_id());
            stmt.setString(2, pr.getDiagnostico());
            stmt.setString(3, pr.getTratamento());
            stmt.setString(4, pr.getObservacoes());
            stmt.setString(5, pr.getData_registro());
            stmt.setInt(6, pr.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void excluir(int id) {
    String sql = "DELETE FROM prontuario WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }
