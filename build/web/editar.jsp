<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.*" %>

<%
    String tipo = (String) request.getAttribute("tipo");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Registro</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<div class="card">

    <h2>✏️ Editar - <%= tipo %></h2>

    <form action="FrontController?acao=atualizar&tipo=<%= tipo %>" method="post">

        <%
            if ("usuario".equals(tipo)) {
                Usuario u = (Usuario) request.getAttribute("usuario");
        %>

            <input type="hidden" name="id" value="<%= u.getId() %>">

            <label>Nome</label>
            <input type="text" name="nome" value="<%= u.getNome() %>">

            <label>Email</label>
            <input type="text" name="email" value="<%= u.getEmail() %>">

            <label>Senha</label>
            <input type="password" name="senha" value="<%= u.getSenha() %>">

            <label>Perfil</label>
            <input type="text" name="perfil" value="<%= u.getPerfil() %>">

        <%
            }
        %>

        <%
            if ("paciente".equals(tipo)) {

                Paciente p = (Paciente) request.getAttribute("paciente");
        %>

            <input type="hidden" name="id" value="<%= p.getId() %>">

            <label>Nome</label>
            <input type="text" name="nome" value="<%= p.getNome() %>">

            <label>CPF</label>
            <input type="text" name="cpf" value="<%= p.getCpf() %>">

            <label>Data de Nascimento</label>
            <input type="text" name="dataNascimento" value="<%= p.getDataNascimento() %>">

            <label>Endereço</label>
            <input type="text" name="endereco" value="<%= p.getEndereco() %>">

            <label>Telefone</label>
            <input type="text" name="telefone" value="<%= p.getTelefone() %>">

            <label>Email</label>
            <input type="text" name="email" value="<%= p.getEmail() %>">

            <label>Histórico Médico</label>
            <input type="text" name="historicoMedico" value="<%= p.getHistoricoMedico() %>">

            <label>Alergias</label>
            <input type="text" name="alergias" value="<%= p.getAlergias() %>">

            <label>Tipo Sanguíneo</label>
            <input type="text" name="tipoSanguineo" value="<%= p.getTipoSanguineo() %>">

            <label>Observações</label>
            <input type="text" name="observacoes" value="<%= p.getObservacoes() %>">

        <%
            }
        %>

        <%
            if ("medico".equals(tipo)) {

                Medico m = (Medico) request.getAttribute("medico");
        %>

            <input type="hidden" name="id" value="<%= m.getId() %>">

            <label>Nome</label>
            <input type="text" name="nome" value="<%= m.getNome() %>">

            <label>Email</label>
            <input type="text" name="email" value="<%= m.getEmail() %>">

            <label>CRM</label>
            <input type="text" name="crm" value="<%= m.getCrm() %>">

            <label>Especialidade</label>
            <input type="text" name="especialidade" value="<%= m.getEspecialidade() %>">

            <label>Telefone</label>
            <input type="text" name="telefone" value="<%= m.getTelefone() %>">

        <%
            }
        %>

        <%
            if ("consulta".equals(tipo)) {

                Consulta c = (Consulta) request.getAttribute("consulta");
        %>

            <input type="hidden" name="id" value="<%= c.getId() %>">

            <label>ID Paciente</label>
            <input type="text" name="idPaciente" value="<%= c.getIdPaciente() %>">

            <label>ID Médico</label>
            <input type="text" name="idMedico" value="<%= c.getIdMedico() %>">

            <label>Data</label>
            <input type="text" name="data" value="<%= c.getData() %>">

            <label>Hora</label>
            <input type="text" name="hora" value="<%= c.getHora() %>">

            <label>Descrição</label>
            <input type="text" name="descricao" value="<%= c.getDescricao() %>">

            <label>Status</label>
            <input type="text" name="status" value="<%= c.getStatus() %>">

        <%
            }
        %>

        <%
            if ("prontuario".equals(tipo)) {

                Prontuario p = (Prontuario) request.getAttribute("prontuario");
        %>

            <input type="hidden" name="id" value="<%= p.getId() %>">

            <label>ID Paciente</label>
            <input type="text" name="paciente_id" value="<%= p.getPaciente_id() %>">

            <label>Diagnóstico</label>
            <input type="text" name="diagnostico" value="<%= p.getDiagnostico() %>">

            <label>Tratamento</label>
            <input type="text" name="tratamento" value="<%= p.getTratamento() %>">

            <label>Observações</label>
            <input type="text" name="observacoes" value="<%= p.getObservacoes() %>">

            <label>Data do Registro</label>
            <input type="text" name="data_registro" value="<%= p.getData_registro() %>">

        <%
            }
        %>

        <button type="submit">Salvar Alterações</button>

    </form>

    <br>
    <a href="home.jsp">Voltar</a>

</div>

</body>
</html>