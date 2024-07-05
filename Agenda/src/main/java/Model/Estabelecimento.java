/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Brenda Cristaldo
 */
public class Estabelecimento {
      private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;

    public Estabelecimento(String nome, String telefone, String endereco, String email,  String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Estabelecimento(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Estabelecimento(String nome, String telefone, String endereco, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Estabelecimento(String email) {
        this.email = email;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
