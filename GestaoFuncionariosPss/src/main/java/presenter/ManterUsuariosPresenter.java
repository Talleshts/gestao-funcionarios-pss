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
public class ManterUsuariosPresenter {
    
    private ManterUsuariosView view;
    
    public ManterUsuariosPresenter(){
        view = new ManterUsuariosView();
        
        // Botão "Buscar"
        view.getBtnBuscar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, a busca deve ser feita (oh)
            public void actionPerformed(ActionEvent e){
                // Adicionar tudo
            }
        });
        
        // Botão "Visualizar" [Navegação]
        view.getBtnVisualizar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarUsuarioPresenter presenterVisualizarUsuario = new VisualizarUsuarioPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                PrincipalAdministradorPresenter presenterPrincipalAdministrador = new PrincipalAdministradorPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
