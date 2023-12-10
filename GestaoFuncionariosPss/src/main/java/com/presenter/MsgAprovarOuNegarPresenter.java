/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.MsgAprovarOuNegarView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Arthu
 */
public class MsgAprovarOuNegarPresenter {
    
    private MsgAprovarOuNegarView view;
    
    public MsgAprovarOuNegarPresenter(){
        view = new MsgAprovarOuNegarView();
        
        // Botão "OK2" [Navegação]
        view.getBtnOK2().addActionListener(new ActionListener(){
            
            @Override
            // Fecha a view quando o botão OK2 for pressionado
            public void actionPerformed(ActionEvent e){
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
