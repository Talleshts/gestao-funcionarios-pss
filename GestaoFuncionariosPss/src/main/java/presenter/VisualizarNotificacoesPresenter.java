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
public class VisualizarNotificacoesPresenter {
    
    private VisualizarNotificacoesView view;
    
    public VisualizarNotificacoesPresenter(){
        view = new VisualizarNotificacoesView();
        
        // Botão "Ler" [Navegação]
        view.getBtnLerNotificacao().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                LeituraNotificacaoPresenter presenterLeituraNotificacao = new LeituraNotificacaoPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                PrincipalUsuarioPresenter presenterPrincipalUsuario = new PrincipalUsuarioPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
