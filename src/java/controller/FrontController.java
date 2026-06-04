package controller;

import factory.CommandFactory;
import commands.ICommand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processar(request, response);
    }

    private void processar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        String tipo = request.getParameter("tipo");
        String id = request.getParameter("id");

        System.out.println("==== FRONT CONTROLLER ====");
        System.out.println("ACAO: " + acao);
        System.out.println("TIPO: " + tipo);
        System.out.println("ID: " + id);

        if (acao == null || acao.trim().isEmpty()) {
            throw new ServletException("Ação não informada (acao está null)");
        }

        try {

            ICommand command = CommandFactory.criarComando(acao, tipo);

            if (command == null) {
                throw new ServletException(
                    "Command não encontrado para acao=" + acao + " tipo=" + tipo
                );
            }

            command.executar(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listar.jsp");
        }
    }
}