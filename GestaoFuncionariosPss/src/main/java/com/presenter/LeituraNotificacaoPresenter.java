/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.*;
import com.observer.*;
import com.view.LeituraNotificacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class LeituraNotificacaoPresenter {
    
    private LeituraNotificacaoView view;
    private UsuarioNotificacaoCollection colecaoUsuarioNotificacao;
    
    private Long idUsuario = 0L;
    
    public LeituraNotificacaoPresenter(Notificacao notificacaoSelecionada){
        colecaoUsuarioNotificacao = UsuarioNotificacaoCollection.getInstancia();
        view = new LeituraNotificacaoView();
        
        view.getLabelTituloNotificacao().setText(notificacaoSelecionada.getTitulo());
        
        toggleLidoNaoLido(notificacaoSelecionada.getId());
        
        // Botão "Marcar como lido/não lido"
        view.getBtnMarcarComoLido().addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                marcarLidoNaoLido(notificacaoSelecionada.getId());
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarNotificacoesPresenter presenterVisualizarNotificacoes = new VisualizarNotificacoesPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void toggleLidoNaoLido(Long idNotificacao){
        
        if(colecaoUsuarioNotificacao.foiLidaPor(idUsuario, idNotificacao)){
            view.getLabelLido().setText("Lido");
            view.getBtnMarcarComoLido().setText("Marcar como não lido");
        }
        else{
            view.getLabelLido().setText("Não Lido");
            view.getBtnMarcarComoLido().setText("Marcar como lido");
        }
    }
    
    public void marcarLidoNaoLido(Long idNotificacao){
        
        UsuarioNotificacao usuarioNotificacao = colecaoUsuarioNotificacao.getUsuarioNotificacao(idUsuario, idNotificacao);
        
        // Se estiver não lida, marca como lida
        if(!usuarioNotificacao.isLido()){
            colecaoUsuarioNotificacao.marcarComoLida(idUsuario, idNotificacao);
        }
        // Se estiver lida, marca como não lida
        else{
            colecaoUsuarioNotificacao.marcarComoNaoLida(idUsuario, idNotificacao);
        }
        
        toggleLidoNaoLido(idNotificacao);
    }
}
