<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <title>Alterar Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<header>
    <h1>Alterar Usuário</h1>
</header>
<div class="container">
    <%
        Usuario usuario = (Usuario) request.getAttribute("usuario");
    %>
    <form action="${pageContext.request.contextPath}/MainController" method="post">
        <input type="hidden" name="action" value="atualizarUsuario">
        <input type="hidden" name="id" value="<%= usuario.getId() %>">
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" value="<%= usuario.getName() %>" required>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= usuario.getEmail() %>" required>
        <button type="submit">Atualizar</button>
    </form>
</div>
</body>
</html>
