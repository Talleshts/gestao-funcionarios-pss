/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.AlterarSenhaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class AlterarSenhaPresenter {
    
    private AlterarSenhaView view;

    public AlterarSenhaPresenter() {
        view = new AlterarSenhaView();
        
        // Botão "Salvar" [Navegação]
        view.getBtnSalvar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                MsgAlterarSenhaPresenter presenterAlterarSenha = new MsgAlterarSenhaPresenter();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                PrincipalUsuarioPresenter presenterPrincipalUsuario = new PrincipalUsuarioPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
