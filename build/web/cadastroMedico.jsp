<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Médico</title>

    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body class="page-center">

<div class="card">

    <h2>🏥 Cadastrar Médico</h2>

    <%
        String msg = (String) request.getAttribute("msg");

        if (msg != null) {
    %>
        <p style="color:green; text-align:center; font-weight:bold; margin-bottom: 15px;">
            <%= msg %>
        </p>
    <%
        }
    %>

    <form action="FrontController?acao=cadastrar&tipo=medico" method="post">

        <input type="hidden" name="acao" value="cadastrarMedico">

        <div class="form-group">
            <label>Nome</label>
            <input type="text" name="nome" required>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" required>
        </div>

        <div class="form-group">
            <label>CRM</label>
            <input type="text" name="crm" required>
        </div>

        <div class="form-group">
            <label>Especialidade</label>
            <input type="text" name="especialidade" required>
        </div>

        <div class="form-group">
            <label>Telefone</label>
            <input type="text" name="telefone">
        </div>

        <button type="submit">Cadastrar Médico</button>

    </form>

    <br>

    <a href="home.jsp">
        <button type="button">Voltar</button>
    </a>

</div>

</body>
</html>