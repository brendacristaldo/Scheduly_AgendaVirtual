/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.helper.AgendaHelper;
import DAO.AgendaDAO;
import DAO.Conexao;
import DAO.EstabelecimentoDAO;
import Model.Estabelecimento;
import View.Agenda;
import View.Cadastro;
import View.Editar;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

/**
 *
 * @author Brenda Cristaldo
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void navegarParaEditar(){
        Editar editar = new Editar();
        editar.setVisible(true);
    }
    
    /*public void atualizaTabela(){
        AgendaDAO adao = new AgendaDAO();
        
        //buscar lista com agendamentos no banco de dados
        adao.selecionarAgenda();
        
        //exibir lista na view
        helper.preencherTabela();
    }
    
    public void agendar(){
        Agenda agenda = helper.obterModelo();
        new AgendaDAO.inserir(agenda);
        atualizaTabela();
    }*/
    
    public void salvarAgenda(){
        
        String nome = view.getNomeField().getText();
        String profissional = view.getProfField().getText();
        String procedimento = view.getProcField().getText();
        String data = view.getDataField().getText();
        String email = view.getEmailField().getText();
        
        Agenda a = new Agenda();
        
        try {
            Connection conexao = new Conexao().getConnection();
        AgendaDAO adao = new AgendaDAO(conexao);
            adao.inserir(a);
            view.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
