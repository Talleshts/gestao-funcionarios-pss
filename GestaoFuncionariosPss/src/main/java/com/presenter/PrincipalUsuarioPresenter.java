/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.PrincipalUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class PrincipalUsuarioPresenter {
    
    private PrincipalUsuarioView view;
    
    public PrincipalUsuarioPresenter(){
        view = new PrincipalUsuarioView();
        
        // Botão "Alterar Senha" [Navegação]
        view.getBtnAlterarSenha().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, abrimos a tela de Alterar Senha
            public void actionPerformed(ActionEvent e){
                AlterarSenhaPresenter presenterAlterarSenha = new AlterarSenhaPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Visualizar Notificações" [Navegação]
        view.getBtnVisualizarNotificacoes().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, abrimos a tela de Visualizar Notificações
            public void actionPerformed(ActionEvent e){
                VisualizarNotificacoesPresenter presenterVisualizarNotificacoes = new VisualizarNotificacoesPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Configurações" [Navegação]
        view.getBtnConfiguracoes().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, abrimos a tela de Configuracoes
            public void actionPerformed(ActionEvent e){
                ConfiguracoesPresenter presenterConfiguracoes = new ConfiguracoesPresenter();
            }
        });
        
        // Botão "Deslogar" [Navegação]
        view.getBtnDeslogar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, abrimos a tela de LoginCadastro
            public void actionPerformed(ActionEvent e){
                LoginCadastroPresenter presenterLoginCadastro = new LoginCadastroPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
