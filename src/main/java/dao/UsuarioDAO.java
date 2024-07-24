package dao;

import model.Usuario;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection; // Conexão com o banco de dados

    // Construtor que inicializa a conexão com o banco de dados
    public UsuarioDAO() {
        this.connection = DBConnection.getConnection();
    }

    // Obtém todos os usuários do banco de dados
    public List<Usuario> getAllUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>(); // Lista para armazenar os usuários
        String sql = "SELECT * FROM usuario";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Itera sobre o resultado da consulta
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setName(resultSet.getString("name"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario); // Adiciona o usuário à lista
            }
        }
        return usuarios; // Retorna a lista de usuários
    }

    // Adiciona um novo usuário ao banco de dados
    public void addUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (name, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define os valores dos parâmetros do SQL
            statement.setString(1, usuario.getName());
            statement.setString(2, usuario.getEmail());
            statement.executeUpdate(); // Executa a inserção
        }
    }

    // Deleta um usuário do banco de dados pelo ID
    public void deleteUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define o valor do parâmetro do SQL
            statement.setInt(1, id);
            statement.executeUpdate(); // Executa a exclusão
        }
    }

    // Obtém um usuário pelo ID
    public Usuario getUsuarioById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define o valor do parâmetro do SQL
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Verifica se o resultado existe
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setName(resultSet.getString("name"));
                    usuario.setEmail(resultSet.getString("email"));
                    return usuario; // Retorna o usuário encontrado
                }
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    // Atualiza as informações de um usuário
    public void updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define os valores dos parâmetros do SQL
            statement.setString(1, usuario.getName());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, usuario.getId());
            statement.executeUpdate(); // Executa a atualização
        }
    }

    // Obtém um usuário pelo email
    public Usuario getUsuarioByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define o valor do parâmetro do SQL
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Verifica se o resultado existe
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setName(resultSet.getString("name"));
                    usuario.setEmail(resultSet.getString("email"));
                    return usuario; // Retorna o usuário encontrado
                }
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }
}
