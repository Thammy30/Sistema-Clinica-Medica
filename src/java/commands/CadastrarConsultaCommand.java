package commands;

import dao.ConsultaDAO;
import model.Consulta;
import solucao_decorator.Notificacao;
import solucao_decorator.EmailNotificacao;
import solucao_decorator.SmsDecorator;
import solucao_decorator.WhatsAppDecorator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarConsultaCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Consulta c = new Consulta();

            c.setIdPaciente(Integer.parseInt(request.getParameter("idPaciente")));
            c.setIdMedico(Integer.parseInt(request.getParameter("idMedico")));
            c.setData(request.getParameter("data"));
            c.setHora(request.getParameter("hora"));
            c.setDescricao(request.getParameter("descricao"));
            c.setStatus("AGENDADA");

            new ConsultaDAO().cadastrar(c);
            
            String destino = "Paciente ID: " + c.getIdPaciente();
            
            Notificacao notificacao = new WhatsAppDecorator(
                                        new SmsDecorator(
                                            new EmailNotificacao()
                                        )
                                    );
            notificacao.enviar(
                "Consulta agendada com sucesso em " + c.getData() + " às " + c.getHora(),
                destino
            );

            request.setAttribute("msg", "Consulta cadastrada com sucesso!");
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao cadastrar consulta", e);
        }
    }
}