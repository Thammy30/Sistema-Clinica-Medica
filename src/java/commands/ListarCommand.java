package commands;

import dao.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListarCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ServletException("Tipo não informado na listagem");
        }

        try {

            Object lista;

            switch (tipo.toLowerCase()) {

                case "paciente":
                    lista = new PacienteDAO().listarTodos();
                    break;

                case "medico":
                    lista = new MedicoDAO().listarTodos();
                    break;

                case "usuario":
                    lista = new UsuarioDAO().listarTodos();
                    break;

                case "consulta":
                    lista = new ConsultaDAO().listarTodos();
                    break;

                case "prontuario":
                    lista = new ProntuarioDAO().listarTodos();
                    break;

                default:
                    throw new ServletException("Tipo inválido: " + tipo);
            }

            request.setAttribute("lista", lista);
            request.setAttribute("tipo", tipo);

            request.getRequestDispatcher("listar.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erro ao listar " + tipo, e);
        }
    }
}