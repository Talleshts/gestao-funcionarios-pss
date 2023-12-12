/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.UsuarioCollection;
import com.view.AlterarSenhaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class AlterarSenhaPresenter {
    
    private UsuarioCollection colecaoUsuarios;
    private AlterarSenhaView view;
    
    private Long idUsuario;

    public AlterarSenhaPresenter(Long idUsuario) {
        colecaoUsuarios = UsuarioCollection.getInstancia();
        view = new AlterarSenhaView();
        
        // Botão "Salvar" [Navegação]
        view.getBtnSalvar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                alterarSenha();
                MsgAlterarSenhaPresenter presenterAlterarSenha = new MsgAlterarSenhaPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void alterarSenha(){
        
        String novaSenha = view.getTxtNovaSenha().getText();
        
        colecaoUsuarios.alterarSenha(idUsuario, novaSenha);
    }
}
