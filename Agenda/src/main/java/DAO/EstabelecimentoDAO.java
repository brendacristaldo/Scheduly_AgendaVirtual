/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Estabelecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Brenda Cristaldo
 */
public class EstabelecimentoDAO {
    private final Connection connection;

    public EstabelecimentoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void inserir(Estabelecimento estabelecimento) throws SQLException{
       
           String sql = "INSERT INTO estabelecimento(nome, telefone, endereco, email, senha) VALUES(?,?,?,?,?)";
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, estabelecimento.getNome());
           ps.setString(2, estabelecimento.getTelefone());
           ps.setString(3, estabelecimento.getEndereco());
           ps.setString(4, estabelecimento.getEmail());
           ps.setString(5, estabelecimento.getSenha());
           ps.execute();
            
    }
    
    public void editar(Estabelecimento estabelecimento) throws SQLException {
            String sql = "UPDATE estabelecimento SET nome=?, telefone=?, endereco=?, senha=? WHERE email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, estabelecimento.getNome());
            ps.setString(2, estabelecimento.getTelefone());
            ps.setString(3, estabelecimento.getEndereco());
            ps.setString(4, estabelecimento.getSenha());
            ps.setString(5, estabelecimento.getEmail());
            ps.execute();
    }

    
    public void editarOuInserir(Estabelecimento estabelecimento) throws SQLException{
        if(estabelecimento.getEmail() != null){
            editar(estabelecimento);
        }else{
            JOptionPane.showMessageDialog(null, "Usuário inexistente!");
        }
    }
    
    public void deletar(Estabelecimento estabelecimento) throws SQLException{
        String sql = "DELETE FROM  estabelecimento WHERE email = ?";
           PreparedStatement ps = connection.prepareStatement(sql);
       
           ps.setString(1, estabelecimento.getEmail());

           ps.execute();
    }
    
    public ArrayList<Estabelecimento> buscar() throws SQLException{
        String sql = "SELECT * FROM  estabelecimento";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        return pesquisa(ps);
    }

    private ArrayList<Estabelecimento> pesquisa(PreparedStatement ps) throws SQLException {
        ArrayList<Estabelecimento> estabelecimento = new ArrayList<Estabelecimento>();
        
        ps.execute();
        
        ResultSet resultSet = ps.getResultSet();
        
        while(resultSet.next()){
            String nome = resultSet.getString("Nome");
            String telefone = resultSet.getString("Telefone");
            String endereco = resultSet.getString("Endereco");
            String email = resultSet.getString("Email");
            String senha = resultSet.getString("Senha");
            
            Estabelecimento comDados = new Estabelecimento(nome, telefone, endereco, email, senha);
            estabelecimento.add(comDados);
        }
        
        return estabelecimento;
    }
    
    public Estabelecimento buscaPorEmail(Estabelecimento estabelecimento) throws SQLException {
        String sql = "SELECT * FROM estabelecimento WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, estabelecimento.getEmail());
        ResultSet resultSet = ps.executeQuery();
        
        if(resultSet.next()){
            String nome = resultSet.getString("Nome");
            String telefone = resultSet.getString("Telefone");
            String endereco = resultSet.getString("Endereco");
            String email = resultSet.getString("Email");
            String senha = resultSet.getString("Senha");
            
            return new Estabelecimento(nome, telefone, endereco, email, senha);
        } else {
            return null; // Não encontrado
        }
    }

    public boolean existeEmailSenha(Estabelecimento eAutenticacao) throws SQLException {
        String sql = "SELECT * FROM estabelecimento WHERE email = ? AND senha = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, eAutenticacao.getEmail());
        ps.setString(2, eAutenticacao.getSenha());
        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();
    }
    
    public boolean existeEmail(Estabelecimento eAutenticacao) throws SQLException {
        String sql = "SELECT * FROM estabelecimento WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, eAutenticacao.getEmail());
        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();
    }

    

}
