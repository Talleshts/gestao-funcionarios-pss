/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.*;
import com.view.LoginCadastroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author Arthu
 */
public class LoginCadastroPresenter {
    
    private UsuarioNotificacaoCollection colecaoUsuarioNotificacao;
    private NotificacaoCollection colecaoNotificacoes;
    private SolicitacaoCollection colecaoSolicitacoes;
    private UsuarioCollection colecaoUsuarios;
    private LoginCadastroView view;
    
    public LoginCadastroPresenter(){
        
        colecaoUsuarioNotificacao = UsuarioNotificacaoCollection.getInstancia();
        colecaoNotificacoes = NotificacaoCollection.getInstancia();
        colecaoSolicitacoes = SolicitacaoCollection.getInstancia();
        colecaoUsuarios = UsuarioCollection.getInstancia();
        
        view = new LoginCadastroView();
        
        // Botão "Login" [Navegação]
        view.getBtnLogin().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                PrincipalUsuarioPresenter presenterPrincipalUsuario = new PrincipalUsuarioPresenter();
                PrincipalAdministradorPresenter presenterAdministradorUsuario = new PrincipalAdministradorPresenter();
                
                // view.dispose();
            }
        });
        
        // Botão "Cadastro" [Navegação]
        view.getBtnCadastro().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                adicionaSolicitacao();
                MsgSolicitacaoPresenter presenterMsgSolicitacao = new MsgSolicitacaoPresenter();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void adicionaSolicitacao(){
                
        // Recupere os valores dos campos de entrada
        String nomeUsuario = view.getTxtNomeUsuario().getText();
        String senha = view.getPassFieldSenha().getText();
        
        // Inicializando id
        Long novoId = SolicitacaoCollection.getProximoId();

        // Crie uma nova Solicitação
        Solicitacao novaSolicitacao;
        novaSolicitacao = new Solicitacao(novoId, nomeUsuario, senha);
        SolicitacaoCollection.proximoId++;

        // Adicione a nova solicitação à coleção de solicitações
        colecaoSolicitacoes.adicionarSolicitacao(novaSolicitacao);

        limparCampos();
    }
    
    
    private void limparCampos(){
        // Limpe os campos de entrada após a inclusão
        view.getTxtNomeUsuario().setText("");
        view.getPassFieldSenha().setText("");
    }
}
