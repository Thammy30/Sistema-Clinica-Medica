<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.lang.reflect.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Registro</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<div class="content">

    <h2>🔎 Resultado da Busca - <%= request.getAttribute("tipo") %></h2>

    <%
        Object obj = request.getAttribute("objeto");

        if (obj != null) {
    %>

        <table border="1" style="width:100%; border-collapse:collapse; margin-top:20px;">

            <tr>
                <th>ID</th>
                <td>
                    <%
                        try {
                            out.print(obj.getClass().getMethod("getId").invoke(obj));
                        } catch (Exception e) {
                            out.print("-");
                        }
                    %>
                </td>
            </tr>

            <tr>
                <th>Nome / Descrição</th>
                <td>
                    <%
                        try {
                            Method m;
                            try {
                                m = obj.getClass().getMethod("getNome");
                            } catch (NoSuchMethodException e) {
                                m = obj.getClass().getMethod("getDescricao");
                            }
                            out.print(m.invoke(obj));
                        } catch (Exception e) {
                            out.print("-");
                        }
                    %>
                </td>
            </tr>

        </table>

    <%
        } else {
    %>

        <p>Nenhum registro encontrado.</p>

    <%
        }
    %>

    <br>
    <a href="home.jsp">Voltar</a>

</div>

</body>
</html>