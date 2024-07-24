package model;

public class Usuario {
    private int id;
    private String name;
    private String email;

    // Construtor padrão
    public Usuario() {
    }

    // Construtor com parâmetros para criar novo usuário
    public Usuario(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Construtor com parâmetros para atualizar usuário
    public Usuario(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
