package dao;

import model.Paciente;

public class TestePacienteDAO {

    public static void main(String[] args) {

        Paciente paciente = new Paciente();

        paciente.setNome("Maria Silva");
        paciente.setCpf("12345678900");
        paciente.setDataNascimento("1995-05-10");
        paciente.setEndereco("Rua Central");
        paciente.setTelefone("11999999999");
        paciente.setEmail("maria@gmail.com");
        paciente.setHistoricoMedico("Diabetes");
        paciente.setAlergias("Penicilina");
        paciente.setTipoSanguineo("O+");
        paciente.setObservacoes("Paciente em observação");

        PacienteDAO dao = new PacienteDAO();

        dao.cadastrar(paciente);

    }
}