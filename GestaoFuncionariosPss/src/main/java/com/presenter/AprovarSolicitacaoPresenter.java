/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.AprovarSolicitacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class AprovarSolicitacaoPresenter {
    
    private AprovarSolicitacaoView view;
    
    public AprovarSolicitacaoPresenter(){
        view = new AprovarSolicitacaoView();
        
        // Botão "Aprovar" [Navegação]
        view.getBtnAprovar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                MsgAprovarOuNegarPresenter presenterMsgAprovarOuNegar = new MsgAprovarOuNegarPresenter();
            }
        });
        
        // Botão "Negar" [Navegação]
        view.getBtnNegar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                MsgAprovarOuNegarPresenter presenterMsgAprovarOuNegar = new MsgAprovarOuNegarPresenter();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarSolicitacoesPresenter presenterVisualizarSolicitacoes = new VisualizarSolicitacoesPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
}
