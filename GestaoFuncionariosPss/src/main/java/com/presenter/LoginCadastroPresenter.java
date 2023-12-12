/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.*;
import com.view.LoginCadastroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class LoginCadastroPresenter {
    
    private LoginCadastroView view;
    
    public LoginCadastroPresenter(){
        
        UsuarioNotificacaoCollection colecaoUsuarioNotificacao = UsuarioNotificacaoCollection.getInstancia();
        NotificacaoCollection colecaoNotificacoes = NotificacaoCollection.getInstancia();
        UsuarioCollection colecaoUsuarios = UsuarioCollection.getInstancia();
        
        view = new LoginCadastroView();
        
        // Botão "Login" [Navegação]
        // NA REAL ELE PODE IR PRA UMA DENTRE DUAS TELAS. Por enquanto vamos
        // nos restringir a decidir só uma dessas telas de forma estática.
        // Só pra testar.
        view.getBtnLogin().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                // PrincipalUsuarioPresenter presenterPrincipalUsuario = new PrincipalUsuarioPresenter();
                PrincipalAdministradorPresenter presenterAdministradorUsuario = new PrincipalAdministradorPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Cadastro" [Navegação]
        view.getBtnCadastro().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                MsgSolicitacaoPresenter presenterMsgSolicitacao = new MsgSolicitacaoPresenter();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
