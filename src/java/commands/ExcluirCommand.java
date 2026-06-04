package commands;

import dao.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");
        String idParam = request.getParameter("id");

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ServletException("Tipo não informado para exclusão.");
        }

        if (idParam == null || idParam.trim().isEmpty()) {
            throw new ServletException("ID não informado para exclusão.");
        }

        try {
            int id = Integer.parseInt(idParam);

            switch (tipo.toLowerCase()) {

                case "paciente":
                    new PacienteDAO().excluir(id);
                    break;

                case "medico":
                    new MedicoDAO().excluir(id);
                    break;

                case "usuario":
                    new UsuarioDAO().excluir(id);
                    break;

                case "consulta":
                    new ConsultaDAO().excluir(id);
                    break;

                case "prontuario":
                    new ProntuarioDAO().excluir(id);
                    break;

                default:
                    throw new ServletException("Tipo inválido para exclusão: " + tipo);
            }

            response.sendRedirect("FrontController?acao=listar&tipo=" + tipo);

        } catch (NumberFormatException e) {
            throw new ServletException("ID de exclusão inválido: " + idParam, e);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erro ao processar exclusão.", e);
        }
    }
}