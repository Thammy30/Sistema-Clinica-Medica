package dao;

import model.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/clinica",
            "root",
            ""
        );
    }

    public boolean cadastrar(Medico m) {

        String sql = "INSERT INTO medico (nome, email, crm, especialidade, telefone, status_ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getEmail());
            stmt.setString(3, m.getCrm());
            stmt.setString(4, m.getEspecialidade());
            stmt.setString(5, m.getTelefone());
            stmt.setBoolean(6, true);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Medico> listarTodos() {

        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico ORDER BY nome";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Medico m = new Medico();

                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setEmail(rs.getString("email"));
                m.setCrm(rs.getString("crm"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setTelefone(rs.getString("telefone"));
                m.setAtivo(rs.getBoolean("status_ativo"));

                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Medico buscarPorId(int id) {

        String sql = "SELECT * FROM medico WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    Medico m = new Medico();

                    m.setId(rs.getInt("id"));
                    m.setNome(rs.getString("nome"));
                    m.setEmail(rs.getString("email"));
                    m.setCrm(rs.getString("crm"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setTelefone(rs.getString("telefone"));
                    m.setAtivo(rs.getBoolean("status_ativo"));

                    return m;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Medico m) {

        String sql = "UPDATE medico SET nome=?, email=?, crm=?, especialidade=?, telefone=?, status_ativo=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getEmail());
            stmt.setString(3, m.getCrm());
            stmt.setString(4, m.getEspecialidade());
            stmt.setString(5, m.getTelefone());
            stmt.setBoolean(6, m.isAtivo());
            stmt.setInt(7, m.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM medico WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}