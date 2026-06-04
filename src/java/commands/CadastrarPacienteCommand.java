package commands;

import dao.PacienteDAO;
import model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarPacienteCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Paciente p = new Paciente();

            p.setNome(request.getParameter("nome"));
            p.setCpf(request.getParameter("cpf"));
            p.setDataNascimento(request.getParameter("dataNascimento"));
            p.setEndereco(request.getParameter("endereco"));
            p.setTelefone(request.getParameter("telefone"));
            p.setEmail(request.getParameter("email"));
            p.setHistoricoMedico(request.getParameter("historicoMedico"));
            p.setAlergias(request.getParameter("alergias"));
            p.setTipoSanguineo(request.getParameter("tipoSanguineo"));
            p.setObservacoes(request.getParameter("observacoes"));

            new PacienteDAO().cadastrar(p);

            request.setAttribute("msg", "Paciente cadastrado com sucesso!");

            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao cadastrar paciente", e);
        }
    }
}