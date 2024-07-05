/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.EstabelecimentoDAO;
import Model.Estabelecimento;
import View.Cadastro;
import View.Editar;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brenda Cristaldo
 */
public class EditarController {
    
    private Editar view;
    public static String emailLogado;

    public EditarController(Editar view) {
        this.view = view;
    }
    
    public void autenticar() throws SQLException {
        
        String email = view.getEmailField().getText();
        
        Estabelecimento eAutenticacao = new Estabelecimento(email);
        
        Connection conexao = new Conexao().getConnection();
        EstabelecimentoDAO estdao = new EstabelecimentoDAO(conexao);
        
        boolean existe = estdao.existeEmail(eAutenticacao);
        
        if(existe){
            emailLogado = email; // Armazena o email do estabelecimento logado
            
            Estabelecimento estabelecimento = estdao.buscaPorEmail(eAutenticacao);
            
            // Passar os dados do estabelecimento para a tela de edição
            Editar editar = new Editar();
            editar.getNomeField().setText(estabelecimento.getNome());
            editar.getTelField().setText(estabelecimento.getTelefone());
            editar.getEndField().setText(estabelecimento.getEndereco());
            editar.getSenhaField().setText(estabelecimento.getSenha());
            editar.setVisible(true);
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Email inválido!");
        }
    }
    
    public void editarEstabelecimento(){
        
            String nome = view.getNomeField().getText();
            String tel = view.getTelField().getText();
            String end = view.getEndField().getText();
            String email = view.getEmailField().getText();
            String senha = view.getSenhaField().getText();
            
        
        Estabelecimento est = new Estabelecimento(nome, tel, end, email, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
        EstabelecimentoDAO estdao = new EstabelecimentoDAO(conexao);
            estdao.editar(est);
            view.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
