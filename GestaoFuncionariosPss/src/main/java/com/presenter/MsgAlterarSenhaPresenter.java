/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.MsgAlterarSenhaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class MsgAlterarSenhaPresenter {
    
    private MsgAlterarSenhaView view;
    
    public MsgAlterarSenhaPresenter(){
        view = new MsgAlterarSenhaView();
        
        // Botão "OK" [Navegação]
        view.getBtnOK().addActionListener(new ActionListener(){
            
            @Override
            // Fecha a view quando o botão OK for pressionado
            public void actionPerformed(ActionEvent e){
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
