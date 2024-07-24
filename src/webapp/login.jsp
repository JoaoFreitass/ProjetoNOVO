<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script>
        // Função para verificar se o parâmetro 'error' está presente na URL
        function showError() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.has('error')) {
                document.getElementById('error-message').style.display = 'block';
            }
        }

        window.onload = showError;
    </script>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form action="MainController" method="post">
        <input type="hidden" name="action" value="login"/>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/>

        <button type="submit">Login</button>
    </form>

    <div id="error-message" class="error-message" style="display: none;">
        Não foi possível realizar o login. O email fornecido não foi encontrado.
    </div>
</div>
</body>
</html>
