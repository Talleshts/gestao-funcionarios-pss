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
public class ConfirmarExclusaoPresenter {
    
    private ConfirmarExclusaoView view;
    
    public ConfirmarExclusaoPresenter(ManterUsuariosPresenter presenterManterUsuarios){
        view = new ConfirmarExclusaoView();
        
        // Botão "Sim" [Navegação]
        view.getBtnSim().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                presenterManterUsuarios.excluirUsuario();
                
                MsgExclusaoPresenter presenterMsgExclusaoPresenter = new MsgExclusaoPresenter();
                
                // Update em ManterUsuario (Observer?)
                presenterManterUsuarios.update();
                
                view.dispose();
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
