package controller;

import dao.UsuarioDAO;
import dao.LivroDAO;
import model.Usuario;
import model.Livro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/MainController")
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO; // DAO para operações de usuário
    private LivroDAO livroDAO; // DAO para operações de livro

    public MainController() {
        super();
        usuarioDAO = new UsuarioDAO(); // Inicializa o DAO de usuário
        livroDAO = new LivroDAO(); // Inicializa o DAO de livro
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action"); // Obtém a ação do parâmetro da solicitação

        try {
            switch (action) {
                case "cadastroLivro":
                    showCadastroLivro(request, response); // Exibe o formulário de cadastro de livro
                    break;
                case "cadastroUsuario":
                    showCadastroUsuario(request, response); // Exibe o formulário de cadastro de usuário
                    break;
                case "listarUsuarios":
                    listUsuarios(request, response); // Lista todos os usuários
                    break;
                case "listarLivros":
                    listLivros(request, response); // Lista todos os livros
                    break;
                case "alterarUsuario":
                    showEditFormUsuario(request, response); // Exibe o formulário de edição de usuário
                    break;
                case "alterarLivro":
                    showEditFormLivro(request, response); // Exibe o formulário de edição de livro
                    break;
                case "deletarUsuario":
                    deleteUsuario(request, response); // Deleta um usuário
                    break;
                case "deletarLivro":
                    deleteLivro(request, response); // Deleta um livro
                    break;
                case "logout":
                    logout(request, response); // Realiza logout
                    break;
                default:
                    response.sendRedirect("home.jsp"); // Redireciona para a página inicial se ação não reconhecida
                    break;
            }
        } catch (SQLException e) {
            handleError(request, response, e); // Lida com erros SQL
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action"); // Obtém a ação do parâmetro da solicitação

        try {
            switch (action) {
                case "salvarLivro":
                    saveLivro(request, response); // Salva um novo livro
                    break;
                case "salvarUsuario":
                    saveUsuario(request, response); // Salva um novo usuário
                    break;
                case "atualizarLivro":
                    updateLivro(request, response); // Atualiza informações de um livro
                    break;
                case "atualizarUsuario":
                    updateUsuario(request, response); // Atualiza informações de um usuário
                    break;
                case "login":
                    login(request, response); // Realiza login
                    break;
                default:
                    response.sendRedirect("home.jsp"); // Redireciona para a página inicial se ação não reconhecida
                    break;
            }
        } catch (SQLException e) {
            handleError(request, response, e); // Lida com erros SQL
        }
    }

    private void showCadastroLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroLivro.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de cadastro de livro
    }

    private void showCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de cadastro de usuário
    }

    private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuario> listUsuarios = usuarioDAO.getAllUsuarios(); // Obtém todos os usuários
        request.setAttribute("usuarios", listUsuarios); // Define a lista de usuários como atributo da requisição
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarUsuarios.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de listagem de usuários
    }

    private void listLivros(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Livro> listLivros = livroDAO.getAllLivros(); // Obtém todos os livros
        request.setAttribute("livros", listLivros); // Define a lista de livros como atributo da requisição
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarLivros.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de listagem de livros
    }

    private void showEditFormUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Obtém o ID do usuário
        Usuario existingUsuario = usuarioDAO.getUsuarioById(id); // Obtém o usuário pelo ID
        request.setAttribute("usuario", existingUsuario); // Define o usuário como atributo da requisição
        RequestDispatcher dispatcher = request.getRequestDispatcher("/alterarUsuario.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de edição de usuário
    }

    private void showEditFormLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String isbn = request.getParameter("isbn"); // Obtém o ISBN do livro
        Livro existingLivro = livroDAO.getLivroByIsbn(isbn); // Obtém o livro pelo ISBN
        request.setAttribute("livro", existingLivro); // Define o livro como atributo da requisição
        RequestDispatcher dispatcher = request.getRequestDispatcher("/alterarLivro.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de edição de livro
    }

    private void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Obtém o ID do usuário
        usuarioDAO.deleteUsuario(id); // Deleta o usuário
        response.sendRedirect("MainController?action=listarUsuarios"); // Redireciona para a listagem de usuários
    }

    private void deleteLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String isbn = request.getParameter("isbn"); // Obtém o ISBN do livro
        livroDAO.deleteLivro(isbn); // Deleta o livro
        response.sendRedirect("MainController?action=listarLivros"); // Redireciona para a listagem de livros
    }

    private void saveLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            Livro livro = new Livro(isbn, title, category, quantity); // Cria um novo livro
            livroDAO.addLivro(livro); // Adiciona o livro ao banco de dados
            response.sendRedirect("popup.jsp?message=Cadastro de livro realizado com sucesso!&type=success&redirect=home.jsp");
        } catch (SQLException e) {
            response.sendRedirect("popup.jsp?message=Erro ao cadastrar livro. Por favor, tente novamente.&type=error");
        }
    }

    private void saveUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        try {
            Usuario usuario = new Usuario(name, email); // Cria um novo usuário
            usuarioDAO.addUsuario(usuario); // Adiciona o usuário ao banco de dados
            response.sendRedirect("popup.jsp?message=Cadastro de usuário realizado com sucesso!&type=success&redirect=home.jsp");
        } catch (SQLException e) {
            response.sendRedirect("popup.jsp?message=Erro ao cadastrar usuário. Por favor, tente novamente.&type=error");
        }
    }

    private void updateLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Livro livro = new Livro(isbn, title, category, quantity); // Cria um livro atualizado
        livroDAO.updateLivro(livro); // Atualiza o livro no banco de dados

        response.sendRedirect("MainController?action=listarLivros"); // Redireciona para a listagem de livros
    }

    private void updateUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario(id, name, email); // Cria um usuário atualizado
        usuarioDAO.updateUsuario(usuario); // Atualiza o usuário no banco de dados

        response.sendRedirect("MainController?action=listarUsuarios"); // Redireciona para a listagem de usuários
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");

        // Verifica se o usuário com o email fornecido existe
        Usuario usuario = usuarioDAO.getUsuarioByEmail(email);

        if (usuario != null) {
            // Armazena o nome do usuário na sessão
            HttpSession session = request.getSession();
            session.setAttribute("usuarioNome", usuario.getName());

            // Redireciona para a página inicial
            response.sendRedirect("home.jsp");
        } else {
            // Redireciona para a página de login com uma mensagem de erro
            response.sendRedirect("login.jsp?error=true");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalida a sessão do usuário
        }
        response.sendRedirect("login.jsp"); // Redireciona para a página de login
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, SQLException e)
            throws ServletException, IOException {
        e.printStackTrace(); // Imprime o stack trace para depuração
        request.setAttribute("errorMessage", "Ocorreu um erro ao processar sua solicitação. Por favor, tente novamente.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
        dispatcher.forward(request, response); // Encaminha para a página de erro
    }
}
