/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.helper;

import Model.Estabelecimento;
import View.Login;

/**
 *
 * @author Brenda Cristaldo
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Estabelecimento obterModelo(){
        String nome = view.getEmailField().getText();
        String senha = view.getSenhaField().getPassword().toString();
        
        Estabelecimento modelo = new Estabelecimento("0","0","0","brenda@gmail.com","brenda123");
        return modelo;
    }
    
    public void setarModelo(Estabelecimento modelo){
        String email = modelo.getEmail();
        String senha = modelo.getSenha();
        
        view.getEmailField().setText(email);
        view.getSenhaField().setText(senha);
    }
    
    public void limparTela(){
        view.getEmailField().setText("");
        view.getSenhaField().setText("");
    }
}
