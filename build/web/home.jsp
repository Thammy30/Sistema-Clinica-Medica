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
    <title>Home - Clínica Médica</title>

    <link rel="stylesheet" href="assets/css/style.css">

    <style>
        .section-title {
            margin: 25px 0 15px;
            color: #555;
            font-size: 1.2rem;
        }

        .search-box {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            display: flex;
            gap: 10px;
            align-items: center;
            margin-bottom: 25px;
        }

        .search-box select,
        .search-box input {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(180px, 1fr));
            gap: 15px;
        }

        .card {
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="sidebar">
    <h2>🏥 Clínica Médica</h2>

    <a href="home.jsp">🏠 Início</a>

    <a href="cadastroUsuario.jsp">👤 Usuários</a>
    <a href="cadastroPaciente.jsp">🧑 Pacientes</a>
    <a href="cadastroMedico.jsp">👨‍⚕️ Médicos</a>
    <a href="cadastroConsulta.jsp">📅 Consultas</a>
    <a href="cadastroProntuario.jsp">📋 Prontuários</a>
    <a href="FrontController?acao=logout">🚪 Sair</a>
</div>

<div class="content">

    <h1>Bem-vindo 👋</h1>

    <h3 class="section-title">🔍 Buscar por ID</h3>

    <form action="FrontController" method="get" class="search-box">

        <input type="hidden" name="acao" value="buscar">

        <select name="tipo" required>
            <option value="paciente">Paciente</option>
            <option value="medico">Médico</option>
            <option value="usuario">Usuário</option>
            <option value="consulta">Consulta</option>
            <option value="prontuario">Prontuário</option>
        </select>

        <input type="number" name="id" placeholder="Digite o ID..." required>

        <button type="submit">Buscar</button>
    </form>

    <h3 class="section-title">📋 Listagens</h3>

    <div class="card-container">

        <div class="card" onclick="location.href='FrontController?acao=listar&tipo=usuario'">
            <h3>👤 Usuários</h3>
        </div>

        <div class="card" onclick="location.href='FrontController?acao=listar&tipo=paciente'">
            <h3>🧑 Pacientes</h3>
        </div>

        <div class="card" onclick="location.href='FrontController?acao=listar&tipo=medico'">
            <h3>👨‍⚕️ Médicos</h3>
        </div>

        <div class="card" onclick="location.href='FrontController?acao=listar&tipo=consulta'">
            <h3>📅 Consultas</h3>
        </div>

        <div class="card" onclick="location.href='FrontController?acao=listar&tipo=prontuario'">
            <h3>📋 Prontuários</h3>
        </div>

    </div>

</div>

</body>
</html>