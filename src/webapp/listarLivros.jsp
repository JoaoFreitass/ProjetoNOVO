<%@ page import="model.Livro" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Livros</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script>
        function confirmarDelecao(isbn) {
            if (confirm("Você tem certeza que deseja deletar este livro?")) {
                window.location.href = "${pageContext.request.contextPath}/MainController?action=deletarLivro&isbn=" + isbn;
            }
        }
    </script>
</head>
<body>
<header>
    <h1>Listar Livros</h1>
</header>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>ISBN</th>
            <th>Título</th>
            <th>Categoria</th>
            <th>Quantidade</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Livro> livros = (List<Livro>) request.getAttribute("livros");
            if (livros != null) {
                for (Livro livro : livros) {
        %>
        <tr>
            <td><%= livro.getIsbn() %></td>
            <td><%= livro.getTitle() %></td>
            <td><%= livro.getCategory() %></td>
            <td><%= livro.getQuantity() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/MainController?action=alterarLivro&isbn=<%= livro.getIsbn() %>" class="btn">Alterar</a>
                <button onclick="confirmarDelecao('<%= livro.getIsbn() %>')" class="btn">Deletar</button>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">Nenhum livro encontrado.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
