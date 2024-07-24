<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Livro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/MainController" method="post">
    <input type="hidden" name="action" value="salvarLivro">
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" required><br>
    <label for="title">Título:</label>
    <input type="text" id="title" name="title" required><br>
    <label for="category">Categoria:</label>
    <input type="text" id="category" name="category" required><br>
    <label for="quantity">Quantidade:</label>
    <input type="number" id="quantity" name="quantity" required><br>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>
