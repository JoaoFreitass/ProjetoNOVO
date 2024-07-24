<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Livro" %>
<!DOCTYPE html>
<html>
<head>
    <title>Alterar Livro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<header>
    <h1>Alterar Livro</h1>
</header>
<div class="container">
    <%
        Livro livro = (Livro) request.getAttribute("livro");
    %>
    <form action="${pageContext.request.contextPath}/MainController" method="post">
        <input type="hidden" name="action" value="atualizarLivro">
        <input type="hidden" name="isbn" value="<%= livro.getIsbn() %>">
        <label for="title">Título:</label>
        <input type="text" id="title" name="title" value="<%= livro.getTitle() %>" required>
        <label for="category">Categoria:</label>
        <input type="text" id="category" name="category" value="<%= livro.getCategory() %>" required>
        <label for="quantity">Quantidade:</label>
        <input type="number" id="quantity" name="quantity" value="<%= livro.getQuantity() %>" required>
        <button type="submit">Atualizar</button>
    </form>
</div>
</body>
</html>
