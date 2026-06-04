package commands;

import dao.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditarCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");
        String idParam = request.getParameter("id");

        if (tipo == null || idParam == null || idParam.isEmpty()) {
            throw new ServletException("Tipo ou ID não informado no EditarCommand");
        }

        try {

            int id = Integer.parseInt(idParam);

            Object obj;

            switch (tipo) {

                case "paciente":
                    obj = new PacienteDAO().buscarPorId(id);
                    break;

                case "medico":
                    obj = new MedicoDAO().buscarPorId(id);
                    break;

                case "usuario":
                    obj = new UsuarioDAO().buscarPorId(id);
                    break;

                case "consulta":
                    obj = new ConsultaDAO().buscarPorId(id);
                    break;

                case "prontuario":
                    obj = new ProntuarioDAO().buscarPorId(id);
                    break;

                default:
                    throw new ServletException("Tipo inválido: " + tipo);
            }

            if (obj == null) {
                throw new ServletException("Registro não encontrado para edição");
            }

            request.setAttribute(tipo, obj);
            request.setAttribute("tipo", tipo);
            request.setAttribute("id", id);

            request.getRequestDispatcher("editar.jsp")
                   .forward(request, response);

        } catch (NumberFormatException e) {
            throw new ServletException("ID inválido: " + idParam, e);

        } catch (Exception e) {
            throw new ServletException("Erro ao abrir tela de edição", e);
        }
    }
}