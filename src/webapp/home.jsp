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
    <p>JSP é a sigla para Java Server Pages, uma tecnologia do lado do servidor que permite a criação de conteúdo web dinâmico. Com JSP, é possível embutir código Java em páginas HTML, tornando-as mais interativas e funcionais. O JSP é uma parte integral da plataforma Java EE e é usado para desenvolver aplicações web robustas e escaláveis.</p>

    <h1>Apache Tomcat</h1>
    <p>O Apache Tomcat é um contêiner de servlets que implementa as especificações de Java Servlet e JavaServer Pages (JSP). Desenvolvido pela Apache Software Foundation, o Tomcat é um servidor web de código aberto que fornece um ambiente para executar o código Java. É uma das soluções mais populares para hospedar aplicações JSP devido à sua facilidade de uso, estabilidade e integração com as tecnologias Java.</p>

    <h1>Integração de JSP com Tomcat e Java</h1>
    <p>Para executar uma aplicação JSP, é necessário um servidor como o Tomcat, que processa o código JSP e gera o conteúdo HTML dinâmico. O código Java embutido nas páginas JSP é compilado e executado pelo servidor, que então envia a resposta processada de volta ao cliente. Essa integração entre JSP, Tomcat e Java permite o desenvolvimento de aplicações web complexas e dinâmicas.
    </p>

    <h1>Minha conclusão:</h1>
    <p> Isso é muito complicativo, muitos cabelos brancos adquiridos, mas, o legal é ver funcionando 😅</p>
</div>
</body>
</html>
