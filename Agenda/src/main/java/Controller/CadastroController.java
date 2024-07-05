/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.EstabelecimentoDAO;
import Model.Estabelecimento;
import View.Cadastro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brenda Cristaldo
 */
public class CadastroController {
    private Cadastro view;

    public CadastroController(Cadastro view) {
        this.view = view;
    }
    
    public void salvarEstabelecimento(){
        
        String nome = view.getNomeField().getText();
        String tel = view.getTelField().getText();
        String end = view.getEndField().getText();
        String email = view.getEmailField().getText();
        String senha = view.getSenhaField().getText();
        
        Estabelecimento est = new Estabelecimento(nome, tel, end, email, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
        EstabelecimentoDAO estdao = new EstabelecimentoDAO(conexao);
            estdao.inserir(est);
            view.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
