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
public class LeituraNotificacaoPresenter {
    
    private LeituraNotificacaoView view;
    
    public LeituraNotificacaoPresenter(){
        view = new LeituraNotificacaoView();
        
        // Botão "Marcar como lido"
        view.getBtnMarcarComoLido().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, o botão altera o texto pra "Marcar como não lido"
            // e o componente "labelLido" troca de "Não lido" pra "lido"
            // E vice-versa
            public void actionPerformed(ActionEvent e){
                // Adicionar tudo
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                VisualizarNotificacoesPresenter presenterVisualizarNotificacoes = new VisualizarNotificacoesPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
