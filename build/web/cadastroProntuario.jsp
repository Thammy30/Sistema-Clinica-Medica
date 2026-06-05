<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Paciente"%>
<%@page import="dao.PacienteDAO"%>

<%
    String usuario = (String) session.getAttribute("usuarioLogado");
    if (usuario == null) {
        response.sendRedirect("index.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Prontuário</title>
    <link rel="stylesheet" href="assets/css/style.css">

    <style>
        .info-paciente {
            margin-top: 10px;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background: #f8f9fa;
        }

        textarea, input[type="date"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-family: inherit;
        }

        .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>

<body class="page-center">

<div class="card">

    <h2>📋 Cadastro de Prontuário</h2>

    <form action="FrontController?acao=cadastrar&tipo=prontuario" method="post">

        <div class="form-group">

            <label>Paciente</label>

            <select name="paciente_id" id="paciente_id" required>
                <option value="">Selecione o paciente...</option>

                <%
                    List<Paciente> pacientes = new PacienteDAO().listarTodos();

                    for (Paciente pac : pacientes) {
                %>

                <option value="<%= pac.getId() %>"
                        data-cpf="<%= pac.getCpf() %>"
                        data-telefone="<%= pac.getTelefone() %>"
                        data-sangue="<%= pac.getTipoSanguineo() %>">

                    <%= pac.getNome() %>

                </option>

                <%
                    }
                %>

            </select>

            <div class="info-paciente">
                <p><strong>CPF:</strong> <span id="cpfPaciente">-</span></p>
                <p><strong>Telefone:</strong> <span id="telefonePaciente">-</span></p>
                <p><strong>Sangue:</strong> <span id="sanguePaciente">-</span></p>
            </div>

        </div>

        <div class="form-group">
            <label>Diagnóstico</label>
            <textarea name="diagnostico" required></textarea>
        </div>

        <div class="form-group">
            <label>Tratamento</label>
            <textarea name="tratamento"></textarea>
        </div>

        <div class="form-group">
            <label>Observações</label>
            <textarea name="observacoes"></textarea>
        </div>

        <div class="form-group">
            <label>Data do Registro</label>
            <input type="date" name="data_registro" required>
        </div>

        <button type="submit">Salvar Prontuário</button>

    </form>

    <br>
    <button type="button" onclick="location.href='home.jsp'">Voltar</button>

</div>

<script>

document.getElementById("paciente_id").addEventListener("change", function () {

    const op = this.options[this.selectedIndex];

    document.getElementById("cpfPaciente").textContent =
        op.dataset.cpf || "-";

    document.getElementById("telefonePaciente").textContent =
        op.dataset.telefone || "-";

    document.getElementById("sanguePaciente").textContent =
        op.dataset.sangue || "-";
});

</script>

</body>
</html>