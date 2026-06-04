package commands;

import dao.ProntuarioDAO;
import model.Prontuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarProntuarioCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Prontuario p = new Prontuario();

            String pacienteId = request.getParameter("paciente_id");
            System.out.println("paciente_id = " + pacienteId);

            p.setPaciente_id(Integer.parseInt(pacienteId));

            p.setDiagnostico(request.getParameter("diagnostico"));
            p.setTratamento(request.getParameter("tratamento"));
            p.setObservacoes(request.getParameter("observacoes"));
            p.setData_registro(request.getParameter("data_registro"));

            // AGORA DIRETO NO DAO (SEM SERVICE)
            ProntuarioDAO dao = new ProntuarioDAO();
            boolean sucesso = dao.cadastrar(p);

            if (sucesso) {
                request.setAttribute("msg", "Prontuário cadastrado com sucesso!");
            } else {
                request.setAttribute("msg", "Não foi possível cadastrar o prontuário.");
            }

            request.getRequestDispatcher("home.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao cadastrar prontuário", e);
        }
    }
}