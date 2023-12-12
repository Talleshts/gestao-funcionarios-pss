/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.UsuarioNotificacaoCollection;
import com.observer.Observador;
import com.observer.Observavel;
import com.view.PrincipalUsuarioView;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Arthu
 */
public class PrincipalUsuarioPresenter implements Observador {
    
    private UsuarioNotificacaoCollection colecaoUsuarioNotificacao;
    private PrincipalUsuarioView view;
    
    private Long idUsuario;
    
    public PrincipalUsuarioPresenter(Long idUsuario){
        
        colecaoUsuarioNotificacao = UsuarioNotificacaoCollection.getInstancia();
        colecaoUsuarioNotificacao.adicionarObservador(this);
        view = new PrincipalUsuarioView();
        
        // Botão "Alterar Senha" [Navegação]
        view.getBtnAlterarSenha().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, abrimos a tela de Alterar Senha
            public void actionPerformed(ActionEvent e){
                AlterarSenhaPresenter presenterAlterarSenha = new AlterarSenhaPresenter(idUsuario);
                
                // view.dispose();
            }
        });
        
        // Botão "Visualizar Notificações" [Navegação]
        view.getBtnVisualizarNotificacoes().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, abrimos a tela de Visualizar Notificações
            public void actionPerformed(ActionEvent e){
                VisualizarNotificacoesPresenter presenterVisualizarNotificacoes = new VisualizarNotificacoesPresenter(idUsuario);
                
                // view.dispose();
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
                fecharTudo();
                LoginCadastroPresenter presenterLoginCadastro = new LoginCadastroPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    private void fecharTudo() {
        
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            
            if (window instanceof JFrame) {
                window.dispose();
            }
        }
    }
    
    public void atualizar(Observavel observavel){
        
        /*
            Contexto útil: ArrayList<Solicitacao> (colecaoSolicitacoes.getNotificacoes())
        */
        
    }
}
