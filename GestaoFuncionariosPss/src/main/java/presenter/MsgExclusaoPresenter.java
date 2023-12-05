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
public class MsgExclusaoPresenter {
    
    private MsgExclusaoView view;
    
    public MsgExclusaoPresenter(){
        view = new MsgExclusaoView();
        
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
