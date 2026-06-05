<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Medico"%>
<%@page import="model.Paciente"%>
<%@page import="dao.MedicoDAO"%>
<%@page import="dao.PacienteDAO"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Consulta</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body class="page-center">

<div class="card">

    <h2>📅 Cadastro de Consulta</h2>

    <%
        String msg = (String) request.getAttribute("msg");

        if (msg != null) {
    %>
        <p style="color:green; text-align:center; font-weight:bold; margin-bottom: 10px;">
            <%= msg %>
        </p>
    <%
        }
    %>

    <form action="FrontController?acao=cadastrar&tipo=consulta" method="post">

        <input type="hidden" name="acao" value="cadastrarConsulta">

        <div class="form-group">
            <label>Paciente</label>
            <select name="idPaciente" required>
                <option value="">Selecione o Paciente...</option>
                <%
                    List<Paciente> pacientes = new dao.PacienteDAO().listarTodos();

                    for (Paciente p : pacientes) {
                %>
                    <option value="<%= p.getId() %>">
                        <%= p.getNome() %> (CPF: <%= p.getCpf() %>)
                    </option>
                <%
                        }
                %>
            </select>
        </div>

        <div class="form-group">
            <label>Médico</label>
            <select name="idMedico" required>
                <option value="">Selecione o Médico...</option>
                <%
                   List<Medico> medicos = new MedicoDAO().listarTodos();
                   
                   for(Medico m: medicos) {
                %>
                    <option value="<%= m.getId() %>">
                        Dr(a). <%= m.getNome() %> (<%= m.getEspecialidade() %>)
                    </option>
                <%
                        }
                %>
            </select>
        </div>

        <div class="form-group">
            <label>Data</label>
            <input type="date" name="data" required>
        </div>

        <div class="form-group">
            <label>Hora</label>
            <input type="time" name="hora" required>
        </div>

        <div class="form-group">
            <label>Descrição</label>
            <input type="text" name="descricao">
        </div>
            
        <div class="form-group">
    <label>Notificações Adicionais:</label>
    <div style="display: flex; gap: 15px; margin-top: 5px;">
        <label>
            <input type="checkbox" name="enviarSms" value="true"> SMS
        </label>
        <label>
            <input type="checkbox" name="enviarWhatsApp" value="true"> WhatsApp
        </label>
      </div>
    </div>

        <button type="submit">Cadastrar Consulta</button>

    </form>

    <br>

    <a href="home.jsp">
        <button type="button">Voltar</button>
    </a>

</div>

</body>
</html>