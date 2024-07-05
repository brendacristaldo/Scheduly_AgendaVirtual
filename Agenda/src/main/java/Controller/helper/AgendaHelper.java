/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.helper;

import View.Agenda;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brenda Cristaldo
 */
public class AgendaHelper {
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    

    /*public void preencherTabela() {
        DefaultTableModel tableModel = (DefaultTableModel)view.getjTableAgenda().getModel();
        tableModel.addRow(rowData);
        
        for(Agenda agenda : agendamento){
            tableModel.addRow(new Object[]{
                agendamento.getNome();
                agendamento.getProf();
                agendamento.getProc();
                agendamento.getData();
                
            });
        }
    }*/

    /*public Agenda obterModelo(){
        String nome =view.getNomeField().getText();
        String prof = view.getProfField().getText();
        String proc = view.getProcField().getText();
        String data = view.getTextFormatedData().getText();
        String dataHora = data + " " + hora;
        Agenda agenda = new Agenda (nome, prof, proc, dataHora);
        return agenda;
    }  */ 

    private static class DefaultTabelModel {

        public DefaultTabelModel() {
        }
    }
}
