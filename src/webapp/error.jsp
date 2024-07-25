<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Erro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>Ocorreu um erro</h1>
<p><strong>Mensagem:</strong> ${requestScope.errorMessage}</p>
<a href="${pageContext.request.contextPath}/home.jsp">Voltar para a home</a>
</body>
</html>
