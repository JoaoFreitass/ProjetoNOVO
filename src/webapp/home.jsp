<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="sidebar">
    <div class="sidebar-header">
        <img src="https://static.vecteezy.com/system/resources/previews/009/267/048/non_2x/user-icon-design-free-png.png" alt="User Icon" class="user-icon">
        <h2>Olá, ${sessionScope.usuarioNome}!</h2>
    </div>
    <ul>
        <li><a href="MainController?action=listarLivros">Listar Livros</a></li>
        <li><a href="MainController?action=cadastroLivro">Cadastrar Livro</a></li>
        <li><a href="MainController?action=listarUsuarios">Listar Usuários</a></li>
        <li><a href="MainController?action=cadastroUsuario">Cadastrar Usuário</a></li>
    </ul>
</div>
<div class="content">
    <h1>Bem-vindo, ${sessionScope.usuarioNome}!</h1>
    <p>Aqui está o conteúdo da página principal.</p>
</div>
</body>
</html>
