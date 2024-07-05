/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.helper.LoginHelper;
import DAO.Conexao;
import DAO.EstabelecimentoDAO;
import Model.Estabelecimento;
import View.Agenda;
import View.Login;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Brenda Cristaldo
 */
public class LoginController {

    private final Login view;
    private final LoginHelper helper;
    public static String emailLogado;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void autenticar() throws SQLException {
        
        
        String email = view.getEmailField().getText();
        String senha = new String(view.getSenhaField().getPassword());
        
        Estabelecimento eAutenticacao = new Estabelecimento(email,senha);
        
        Connection conexao = new Conexao().getConnection();
        EstabelecimentoDAO estdao = new EstabelecimentoDAO(conexao);
        
        boolean existe = estdao.existeEmailSenha(eAutenticacao);
        
        if(existe){
            emailLogado = email;
            Agenda agenda = new Agenda();
            view.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Email ou senha invalidos!");
        }
        
    }
    
}
