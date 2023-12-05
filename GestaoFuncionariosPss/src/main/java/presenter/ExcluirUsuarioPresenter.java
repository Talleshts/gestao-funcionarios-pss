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
public class ExcluirUsuarioPresenter {
    
    private ExcluirUsuarioView view;
    
    public ExcluirUsuarioPresenter(){
        view = new ExcluirUsuarioView();
        
        // Botão "Sim" [Navegação]
        view.getBtnSim().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarUsuarioPresenter presenterVisualizarUsuario = new VisualizarUsuarioPresenter();
                MsgExclusaoPresenter presenterMsgExclusaoPresenter = new MsgExclusaoPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Não" [Navegação]
        view.getBtnNao().addActionListener(new ActionListener(){
            
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
