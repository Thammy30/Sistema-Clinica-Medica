<%@ page contentType="text/html;charset=UTF-8" %>

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
    <title>Cadastrar Usuário</title>

    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body class="page-center">

<div class="card">

    <h2>🏥 Sistema Clínica Médica</h2>

    <h3>Cadastrar Usuário</h3>

    <form action="FrontController?acao=cadastrar&tipo=usuario" method="post">

        <input type="hidden" name="acao" value="cadastrarUsuario">

        <label>Nome</label>
        <input type="text" name="nome" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Senha</label>
        <input type="password" name="senha" required>

        <label>Perfil</label>
        <select name="perfil" required>
            <option value="ADMIN">Administrador</option>
            <option value="USER">Usuário</option>
        </select>

        <button type="submit">Salvar Usuário</button>

    </form>

    <br>

    <a href="home.jsp">
        <button type="button">Voltar</button>
    </a>

</div>

</body>
</html>