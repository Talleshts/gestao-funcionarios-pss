/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.*;
import com.view.EnviarNotificacaoParaView;

/**
 *
 * @author Arthu
 */
public class EnviarNotificacaoParaPresenter {
    
    private EnviarNotificacaoParaView view;
    private NotificacaoCollection colecaoNotificacoes;
    private UsuarioCollection colecaoUsuarios;
    JTable tableConsulta;
    
    public EnviarNotificacaoParaPresenter(String titulo, String corpo){
        
        colecaoNotificacoes = NotificacaoCollection.getInstancia();
        view = new EnviarNotificacaoParaView();
        
        // Botão "Enviar" [Navegação]
        view.getBtnEnviar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                
                
                MsgNotificacaoPresenter presenterMsgNotificacao = new MsgNotificacaoPresenter();
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                EnviarNotificacaoPresenter presenterEnviarNotificacao = new EnviarNotificacaoPresenter();
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    // Método para obter múltiplos usuários selecionados
    public ArrayList<Usuario> getSelecionados(JTable tableConsulta) {

        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();

        // Obtendo o index das linhas selecionadas
        int[] linhasSelecionadas = tableConsulta.getSelectedRows();

        ArrayList<Usuario> usuariosSelecionados = new ArrayList<>();

        // Para cada linha selecionada...
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            String stringIdSelecionado = String.valueOf(model.getValueAt(linhasSelecionadas[i], 2));
            Long idSelecionado = Long.parseLong(stringIdSelecionado);

            // Busca na coleção e adicionando à lista
            Usuario usuario = colecaoUsuarios.getUsuario(idSelecionado);
            if (usuario != null) {
                usuariosSelecionados.add(usuario);
            }
        }

        return usuariosSelecionados;
    }
    
    public void enviarNotificacao(String titulo, String corpo){
        
        Long novoId = NotificacaoCollection.getProximoId();        
        Notificacao novaNotificacao = new Notificacao(novoId, titulo, corpo);
        NotificacaoCollection.proximoId++;
        
        // Recuperando usuários selecionados
        ArrayList<Usuario> selecionados = getSelecionados(tableConsulta);
        
        // Adicionando, na lista de ids da notificação, os ids dos usuários
        // para a qual a notificação foi enviada
        for (Usuario usuario : selecionados) {
            novaNotificacao.getEnviadaPara().add(usuario.getId());
        }
        
        colecaoNotificacoes.adicionarNotificacao(novaNotificacao);
        
    }
}
