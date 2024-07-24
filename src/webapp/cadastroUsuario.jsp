<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/MainController" method="post">
    <input type="hidden" name="action" value="salvarUsuario">
    <label for="name">Nome:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>
