/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.EnviarNotificacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class EnviarNotificacaoPresenter {
    
    private EnviarNotificacaoView view;
    
    public EnviarNotificacaoPresenter(){
        view = new EnviarNotificacaoView();
        
        // Botão "Enviar Para" [Navegação]
        view.getBtnEnviarPara().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                String titulo = view.getTxtTituloNotificacao().getText();
                String corpo = view.getTxtCorpoNotificacao().getText();
                
                EnviarNotificacaoParaPresenter presenterEnviarNotificacaoPara = new EnviarNotificacaoParaPresenter(titulo, corpo);
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
}
