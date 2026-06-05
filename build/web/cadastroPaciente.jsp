<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Paciente</title>

    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body class="page-center">

<div class="card">

    <h2>🏥 Cadastro de Paciente</h2>

    <form action="FrontController?acao=cadastrar&tipo=paciente" method="post">

        <input type="hidden" name="acao" value="cadastrarPaciente">

        <div class="form-group">
            <label>Nome</label>
            <input type="text" name="nome" required>
        </div>

        <div class="form-group">
            <label>CPF</label>
            <input type="text" name="cpf" required>
        </div>

        <div class="form-group">
            <label>Data de Nascimento</label>
            <input type="date" name="dataNascimento" required>
        </div>

        <div class="form-group">
            <label>Tipo Sanguíneo</label>
            <input type="text" name="tipoSanguineo">
        </div>

        <div class="form-group">
            <label>Telefone</label>
            <input type="text" name="telefone">
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email">
        </div>

        <div class="form-group full-width">
            <label>Endereço</label>
            <input type="text" name="endereco">
        </div>

        <div class="form-group full-width">
            <label>Histórico Médico</label>
            <textarea name="historicoMedico"></textarea>
        </div>

        <div class="form-group full-width">
            <label>Alergias</label>
            <textarea name="alergias"></textarea>
        </div>

        <div class="form-group full-width">
            <label>Observações</label>
            <textarea name="observacoes"></textarea>
        </div>

        <button type="submit" class="full-width">
            Cadastrar Paciente
        </button>

    </form>

    <br>

    <a href="home.jsp">
        <button type="button">Voltar</button>
    </a>

</div>

</body>
</html>