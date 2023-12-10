/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.ConfirmarExclusaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class ConfirmarExclusaoPresenter {
    
    private ConfirmarExclusaoView view;
    
    public ConfirmarExclusaoPresenter(ManterUsuariosPresenter presenterManterUsuarios){
        view = new ConfirmarExclusaoView();
        
        // Botão "Sim" [Navegação]
        view.getBtnSim().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                try {
                    presenterManterUsuarios.excluirUsuario();
                    MsgExclusaoPresenter presenterMsgExclusaoPresenter = new MsgExclusaoPresenter();

                    // Update em ManterUsuario (Observer?)
                    presenterManterUsuarios.update();

                    view.dispose();
                    
                } catch (NumberFormatException ex) {
                    System.out.println("Um usuario deve ser visualizado nos campos de texto, antes de poder ser excluído. Use o botão [Ver]");
                    view.dispose();
                }
            }
        });
        
        // Botão "Não" [Navegação]
        view.getBtnNao().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
