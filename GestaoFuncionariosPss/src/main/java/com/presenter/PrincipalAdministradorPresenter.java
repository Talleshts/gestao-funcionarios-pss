/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.PrincipalAdministradorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class PrincipalAdministradorPresenter {
    
    private PrincipalAdministradorView view;
    
    public PrincipalAdministradorPresenter(){
        view = new PrincipalAdministradorView();
        
        // Botão "Ver Solicitações" [Navegação]
        view.getBtnVerSolicitacoes().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarSolicitacoesPresenter presenterVisualizarSolicitacoes = new VisualizarSolicitacoesPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Manter Usuários" [Navegação]
        view.getBtnManterUsuarios().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                ManterUsuariosPresenter presenterBuscarUsuarios = new ManterUsuariosPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Enviar Notificação" [Navegação]
        view.getBtnEnviarNotificacao().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                EnviarNotificacaoPresenter presenterEnviarNotificacao = new EnviarNotificacaoPresenter();
                
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
