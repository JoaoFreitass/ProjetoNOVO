package dao;

import model.Livro;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection connection; // Conexão com o banco de dados

    // Construtor que inicializa a conexão com o banco de dados
    public LivroDAO() {
        this.connection = DBConnection.getConnection();
    }

    // Adiciona um novo livro ao banco de dados
    public void addLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (isbn, title, category, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define os valores dos parâmetros do SQL
            statement.setString(1, livro.getIsbn());
            statement.setString(2, livro.getTitle());
            statement.setString(3, livro.getCategory());
            statement.setInt(4, livro.getQuantity());
            statement.executeUpdate(); // Executa a inserção
        }
    }

    // Deleta um livro do banco de dados pelo ISBN
    public void deleteLivro(String isbn) throws SQLException {
        String sql = "DELETE FROM livro WHERE isbn = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define o valor do parâmetro do SQL
            statement.setString(1, isbn);
            statement.executeUpdate(); // Executa a exclusão
        }
    }

    // Obtém todos os livros do banco de dados
    public List<Livro> getAllLivros() throws SQLException {
        List<Livro> livros = new ArrayList<>(); // Lista para armazenar os livros
        String sql = "SELECT * FROM livro";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Itera sobre o resultado da consulta
            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setIsbn(resultSet.getString("isbn"));
                livro.setTitle(resultSet.getString("title"));
                livro.setCategory(resultSet.getString("category"));
                livro.setQuantity(resultSet.getInt("quantity"));
                livros.add(livro); // Adiciona o livro à lista
            }
        }
        return livros; // Retorna a lista de livros
    }

    // Obtém um livro pelo ISBN
    public Livro getLivroByIsbn(String isbn) throws SQLException {
        String sql = "SELECT * FROM livro WHERE isbn = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define o valor do parâmetro do SQL
            statement.setString(1, isbn);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Verifica se o resultado existe
                if (resultSet.next()) {
                    Livro livro = new Livro();
                    livro.setIsbn(resultSet.getString("isbn"));
                    livro.setTitle(resultSet.getString("title"));
                    livro.setCategory(resultSet.getString("category"));
                    livro.setQuantity(resultSet.getInt("quantity"));
                    return livro; // Retorna o livro encontrado
                }
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    // Atualiza as informações de um livro
    public void updateLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET title = ?, category = ?, quantity = ? WHERE isbn = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define os valores dos parâmetros do SQL
            statement.setString(1, livro.getTitle());
            statement.setString(2, livro.getCategory());
            statement.setInt(3, livro.getQuantity());
            statement.setString(4, livro.getIsbn());
            statement.executeUpdate(); // Executa a atualização
        }
    }
}
