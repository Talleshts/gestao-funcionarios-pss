/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author Arthu
 */
public class EditarUsuarioPresenter {
    
    private EditarUsuarioView view;
    
    public EditarUsuarioPresenter(){
        view = new EditarUsuarioView();
        
        // Botão "Salvar" [Navegação]
        view.getBtnSalvar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarUsuarioPresenter presenterVisualizarUsuario = new VisualizarUsuarioPresenter();
                MsgEdicaoPresenter presenterMsgEdicao = new MsgEdicaoPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarUsuarioPresenter presenterVisualizarUsuario = new VisualizarUsuarioPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
}
