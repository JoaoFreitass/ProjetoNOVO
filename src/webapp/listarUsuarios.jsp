<%@ page import="model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Usuários</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script>
        function confirmarDelecao(id) {
            if (confirm("Você tem certeza que deseja deletar este usuário?")) {
                window.location.href = "${pageContext.request.contextPath}/MainController?action=deletarUsuario&id=" + id;
            }
        }
    </script>
</head>
<body>
<header>
    <h1>Listar Usuários</h1>
</header>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
        %>
        <tr>
            <td><%= usuario.getId() %></td>
            <td><%= usuario.getName() %></td>
            <td><%= usuario.getEmail() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/MainController?action=alterarUsuario&id=<%= usuario.getId() %>" class="btn">Alterar</a>
                <button onclick="confirmarDelecao('<%= usuario.getId() %>')" class="btn">Deletar</button>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">Nenhum usuário encontrado.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
