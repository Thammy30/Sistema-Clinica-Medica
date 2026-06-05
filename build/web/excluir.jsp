<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Excluir Registro</title>
</head>
<body>

<div class="card">

    <h2>🗑 Confirmar Exclusão</h2>

    <p>Tem certeza que deseja excluir este registro?</p>

    <%
        String tipo = request.getParameter("tipo");
        String id = request.getParameter("id");
    %>

    <a href="FrontController?acao=Excluir&id=<%= id %>&tipo=<%= tipo %>">
    <button style="background:red;color:white;">Sim, Excluir</button>
    </a>
    <a href="home.jsp">
        <button>Cancelar</button>
    </a>

</div>

</body>
</html>