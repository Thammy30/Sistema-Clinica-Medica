package dao;

import model.Paciente;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public boolean cadastrar(Paciente p) {

        String sql = "INSERT INTO paciente (nome, cpf, data_nascimento, endereco, telefone, email, historico_medico, alergias, tipo_sanguineo, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getDataNascimento());
            stmt.setString(4, p.getEndereco());
            stmt.setString(5, p.getTelefone());
            stmt.setString(6, p.getEmail());
            stmt.setString(7, p.getHistoricoMedico());
            stmt.setString(8, p.getAlergias());
            stmt.setString(9, p.getTipoSanguineo());
            stmt.setString(10, p.getObservacoes());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Paciente> listarTodos() {

        List<Paciente> lista = new ArrayList<>();

        String sql = "SELECT * FROM paciente ORDER BY nome";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Paciente p = new Paciente();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                p.setHistoricoMedico(rs.getString("historico_medico"));
                p.setAlergias(rs.getString("alergias"));
                p.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                p.setObservacoes(rs.getString("observacoes"));

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Paciente buscarPorId(int id) {

        String sql = "SELECT * FROM paciente WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Paciente p = new Paciente();

                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setCpf(rs.getString("cpf"));
                    p.setDataNascimento(rs.getString("data_nascimento"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setEmail(rs.getString("email"));
                    p.setHistoricoMedico(rs.getString("historico_medico"));
                    p.setAlergias(rs.getString("alergias"));
                    p.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                    p.setObservacoes(rs.getString("observacoes"));

                    return p;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Paciente p) {

        String sql = "UPDATE paciente SET nome=?, cpf=?, data_nascimento=?, endereco=?, telefone=?, email=?, historico_medico=?, alergias=?, tipo_sanguineo=?, observacoes=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getDataNascimento());
            stmt.setString(4, p.getEndereco());
            stmt.setString(5, p.getTelefone());
            stmt.setString(6, p.getEmail());
            stmt.setString(7, p.getHistoricoMedico());
            stmt.setString(8, p.getAlergias());
            stmt.setString(9, p.getTipoSanguineo());
            stmt.setString(10, p.getObservacoes());
            stmt.setInt(11, p.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM paciente WHERE id = ?";

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