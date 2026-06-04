package factory;

import commands.*;

public class CommandFactory {

    public static ICommand criarComando(String acao, String tipo) {

        if (acao == null || acao.trim().isEmpty()) {
            throw new IllegalArgumentException("Ação não pode ser nula");
        }

        switch (acao) {

            case "login":
                return new LoginCommand();

            case "logout":
                return new LogoutCommand();

            case "listar":
                return new ListarCommand();

            case "editar":
                return new EditarCommand();

            case "excluir":
                return new ExcluirCommand();

            case "atualizar":
                return new AtualizarCommand();

            case "cadastrar":

                if (tipo == null || tipo.trim().isEmpty()) {
                    throw new IllegalArgumentException("Tipo não pode ser nulo no cadastro");
                }

                switch (tipo) {
                    case "paciente":
                        return new CadastrarPacienteCommand();

                    case "medico":
                        return new CadastrarMedicoCommand();

                    case "consulta":
                        return new CadastrarConsultaCommand();

                    case "prontuario":
                        return new CadastrarProntuarioCommand();

                    case "usuario":
                        return new CadastrarUsuarioCommand();

                    default:
                        throw new IllegalArgumentException("Tipo inválido: " + tipo);
                }

            default:
                throw new IllegalArgumentException("Ação inválida: " + acao);
        }
    }
}