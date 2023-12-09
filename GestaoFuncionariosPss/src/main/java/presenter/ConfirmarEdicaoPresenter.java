/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.Usuario;
import view.*;

/**
 *
 * @author Arthu
 */
public class ConfirmarEdicaoPresenter {
    
    private ConfirmarEdicaoView view;
    
    public ConfirmarEdicaoPresenter(ManterUsuariosPresenter presenterManterUsuarios){
        
        view = new ConfirmarEdicaoView();
        
        // Botão "Sim" [Navegação]
        view.getBtnSim().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                presenterManterUsuarios.editarUsuario();
                
                MsgEdicaoPresenter presenterMsgEdicaoPresenter = new MsgEdicaoPresenter();
                
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
