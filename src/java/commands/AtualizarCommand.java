package commands;

import dao.*;
import model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AtualizarCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo == null) {
            throw new ServletException("Tipo não informado");
        }

        try {

            switch (tipo) {

                case "usuario": {
                    Usuario u = new Usuario();
                    u.setId(Integer.parseInt(request.getParameter("id")));
                    u.setNome(request.getParameter("nome"));
                    u.setEmail(request.getParameter("email"));
                    u.setSenha(request.getParameter("senha"));
                    u.setPerfil(request.getParameter("perfil"));

                    new UsuarioDAO().atualizar(u);
                    break;
                }

                case "paciente": {
                    Paciente p = new Paciente();
                    p.setId(Integer.parseInt(request.getParameter("id")));
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

                    new PacienteDAO().atualizar(p);
                    break;
                }

                case "medico": {
                    Medico m = new Medico();
                    m.setId(Integer.parseInt(request.getParameter("id")));
                    m.setNome(request.getParameter("nome"));
                    m.setEmail(request.getParameter("email"));
                    m.setCrm(request.getParameter("crm"));
                    m.setEspecialidade(request.getParameter("especialidade"));
                    m.setTelefone(request.getParameter("telefone"));

                    Medico medicoAtual = new MedicoDAO().buscarPorId(m.getId());

                    if (medicoAtual != null) {
                        m.setAtivo(medicoAtual.isAtivo());
                    }

                    new MedicoDAO().atualizar(m);
                    break;
                }

                case "consulta": {
                    Consulta c = new Consulta();
                    c.setId(Integer.parseInt(request.getParameter("id")));
                    c.setIdPaciente(Integer.parseInt(request.getParameter("idPaciente")));
                    c.setIdMedico(Integer.parseInt(request.getParameter("idMedico")));
                    c.setData(request.getParameter("data"));
                    c.setHora(request.getParameter("hora"));
                    c.setDescricao(request.getParameter("descricao"));
                    c.setStatus(request.getParameter("status"));

                    new ConsultaDAO().atualizar(c);
                    break;
                }

                case "prontuario": {

                    Prontuario pr = new Prontuario();

                    pr.setId(Integer.parseInt(request.getParameter("id")));
                    pr.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));
                    pr.setDiagnostico(request.getParameter("diagnostico"));
                    pr.setTratamento(request.getParameter("tratamento"));
                    pr.setObservacoes(request.getParameter("observacoes"));
                    pr.setData_registro(request.getParameter("data_registro"));

                    new ProntuarioDAO().atualizar(pr);
                    break;
                }

                default:
                    throw new ServletException("Tipo inválido: " + tipo);
            }

            response.sendRedirect("FrontController?acao=listar&tipo=" + tipo);

        } catch (Exception e) {
            throw new ServletException("Erro ao atualizar " + tipo, e);
        }
    }
}