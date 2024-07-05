/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import View.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Brenda Cristaldo
 */
public class AgendaDAO {
    private final Connection connection;

    public AgendaDAO(Connection connection) {
        this.connection = connection;
    }


    public void inserir(Agenda agenda) throws SQLException{
       
           String sql = "INSERT INTO estabelecimento(nome, telefone, endereco, email, senha) VALUES(?,?,?,?,?)";
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, agenda.getNomeField().toString());
           ps.setString(2, agenda.getProfField().toString());
           ps.setString(3, agenda.getProcField().toString());
           ps.setString(4, agenda.getDataField().toString());
           ps.setString(5, agenda.getEmailField().toString());
           ps.execute();
            
    }
}
