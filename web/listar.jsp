<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de <%= request.getAttribute("tipo") != null ? request.getAttribute("tipo").toString().toUpperCase() : "Registros" %></title>
</head>

<body>

<div class="content">

<%
    String tipo = (String) request.getAttribute("tipo");
    List<?> lista = (List<?>) request.getAttribute("lista");

    if (tipo == null) tipo = "registros";
%>

<h2>📋 Lista de <%= tipo.toUpperCase() %></h2>

<table border="1" style="width:100%; border-collapse:collapse; margin-top:20px;">

<thead>
<tr>
    <th>ID</th>
    <th>Nome</th>
    <th>Descrição</th>
    <th>Ações</th>
</tr>
</thead>

<tbody>

<%
if (lista != null && !lista.isEmpty()) {

    for (Object obj : lista) {

        String id = "";
        String nome = "-";
        String descricao = "-";

        try {

            Object rawId = obj.getClass().getMethod("getId").invoke(obj);
            id = (rawId != null) ? rawId.toString() : "";

            try {
                Object rawNome = obj.getClass().getMethod("getNome").invoke(obj);
                nome = (rawNome != null) ? rawNome.toString() : "-";
            } catch (Exception e) {
                try {
                    Object rawNome = obj.getClass().getMethod("getPacienteNome").invoke(obj);
                    nome = (rawNome != null) ? rawNome.toString() : "-";
                } catch (Exception e2) {
                    nome = "-";
                }
            }

            if ("usuario".equals(tipo)) {

                Object email = obj.getClass().getMethod("getEmail").invoke(obj);
                descricao = (email != null) ? email.toString() : "-";

            } else if ("medico".equals(tipo)) {

                try {
                    Object esp = obj.getClass().getMethod("getEspecialidade").invoke(obj);
                    descricao = (esp != null) ? esp.toString() : "-";
                } catch (Exception e) {
                    descricao = "-";
                }

            } else if ("paciente".equals(tipo)) {

                try {
                    Object cpf = obj.getClass().getMethod("getCpf").invoke(obj);
                    descricao = (cpf != null) ? cpf.toString() : "-";
                } catch (Exception e) {
                    descricao = "-";
                }

            } else if ("consulta".equals(tipo)) {

                try {
                    Object status = obj.getClass().getMethod("getStatus").invoke(obj);
                    descricao = (status != null) ? status.toString() : "-";
                } catch (Exception e) {
                    try {
                        Object data = obj.getClass().getMethod("getData").invoke(obj);
                        descricao = (data != null) ? data.toString() : "-";
                    } catch (Exception e2) {
                        descricao = "-";
                    }
                }

            } else if ("prontuario".equals(tipo)) {

                try {
                    Object diag = obj.getClass().getMethod("getDiagnostico").invoke(obj);
                    descricao = (diag != null) ? diag.toString() : "-";
                } catch (Exception e) {
                    descricao = "-";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🔥 SEGURANÇA: não renderiza se ID for inválido
        if (id == null || id.trim().isEmpty() || id.equals("null")) {
            continue;
        }
%>

<tr>
    <td><%= id %></td>
    <td><%= nome %></td>
    <td><%= descricao %></td>
    <td>
        <a href="FrontController?acao=editar&tipo=<%= tipo %>&id=<%= id %>">✏ Editar</a>

        <a href="FrontController?acao=excluir&tipo=<%= tipo %>&id=<%= id %>"
           onclick="return confirm('Tem certeza que deseja excluir?')">🗑 Excluir</a>
    </td>
</tr>

<%
    }
} else {
%>

<tr>
    <td colspan="4">Nenhum registro encontrado.</td>
</tr>

<%
}
%>

</tbody>
</table>

<br>
<a href="home.jsp">Voltar</a>

</div>

</body>
</html>