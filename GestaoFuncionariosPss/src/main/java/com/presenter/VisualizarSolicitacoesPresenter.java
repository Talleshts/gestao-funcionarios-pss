/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.SolicitacaoCollection;
import com.observer.*;
import com.view.VisualizarSolicitacoesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class VisualizarSolicitacoesPresenter implements Observador {
    
    private SolicitacaoCollection colecaoSolicitacoes;
    private VisualizarSolicitacoesView view;
    
    public VisualizarSolicitacoesPresenter(){
        
        colecaoSolicitacoes = SolicitacaoCollection.getInstancia();
        colecaoSolicitacoes.adicionarObservador(this);
        view = new VisualizarSolicitacoesView();
        
        // Botão "Abrir" [Navegação]
        view.getBtnAbrirSolicitacao().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                AprovarSolicitacaoPresenter presenterAprovarSolicitacao = new AprovarSolicitacaoPresenter();
                
                // view.dispose();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                PrincipalAdministradorPresenter presenterPrincipalAdministrador = new PrincipalAdministradorPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void atualizarTabela(){
        
    }
    
    public void atualizar(Observavel observavel){
        
        atualizarTabela();
    }
}
