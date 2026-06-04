package commands;

import dao.MedicoDAO;
import model.Medico;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarMedicoCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Medico m = new Medico();

            m.setNome(request.getParameter("nome"));
            m.setEmail(request.getParameter("email"));
            m.setCrm(request.getParameter("crm"));
            m.setEspecialidade(request.getParameter("especialidade"));
            m.setTelefone(request.getParameter("telefone"));

            new MedicoDAO().cadastrar(m);

            request.setAttribute("msg", "Médico cadastrado com sucesso!");

            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao cadastrar médico", e);
        }
    }
}