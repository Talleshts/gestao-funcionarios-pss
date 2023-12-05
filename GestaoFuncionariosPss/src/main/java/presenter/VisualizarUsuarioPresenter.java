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
public class VisualizarUsuarioPresenter {
    
    private VisualizarUsuarioView view;
    
    public VisualizarUsuarioPresenter(){
        view = new VisualizarUsuarioView();
        
        // Botão "Excluir" [Navegação]
        view.getBtnExcluir().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                ExcluirUsuarioPresenter presenterExcluirUsuario = new ExcluirUsuarioPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Editar" [Navegação]
        view.getBtnEditar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                EditarUsuarioPresenter presenterEditarUsuario = new EditarUsuarioPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar2().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                ManterUsuariosPresenter presenterManterUsuarios = new ManterUsuariosPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
