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
import com.observer.*;
import com.view.EnviarNotificacaoParaView;

/**
 *
 * @author Arthu
 */
public class EnviarNotificacaoParaPresenter implements Observador {
    
    private EnviarNotificacaoParaView view;
    private NotificacaoCollection colecaoNotificacoes;
    private UsuarioCollection colecaoUsuarios;
    JTable tableConsulta;
    
    public EnviarNotificacaoParaPresenter(EnviarNotificacaoPresenter presenterEnviarNotificacao, String titulo, String corpo){
        
        colecaoNotificacoes = NotificacaoCollection.getInstancia();
        colecaoUsuarios = UsuarioCollection.getInstancia();
        colecaoUsuarios.adicionarObservador(this);
        view = new EnviarNotificacaoParaView();
        
        tableConsulta = view.getTableEnviarPara();
        atualizarTabela();
        
        // Botão "Enviar" [Navegação]
        view.getBtnEnviar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                enviarNotificacao(titulo, corpo);
                
                // Teste
//                System.out.println("-----------");
//                ArrayList<Notificacao> notificacoes = colecaoNotificacoes.getNotificacoes();
//                for(Notificacao notificacao : notificacoes){
//                    ArrayList<Long> enviadaPara = notificacao.getEnviadaPara();
//                    
//                    System.out.println("Notificacao: " + notificacao.getId());
//                    for(Long id : enviadaPara){
//                        System.out.println("Enviada para: " + id);
//                    }
//                }

                presenterEnviarNotificacao.limparCampos();
                // view.dispose();
                
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
    
    // Atualizar a tabela com os dados dos usuários
    public void atualizarTabela() {
        
        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
        model.setRowCount(0); // Limpa todas as linhas da tabela

        for (Usuario usuario : colecaoUsuarios.getUsuarios()) {
            
            // Adicione uma nova linha à tabela com os dados do usuário
            Object[] rowData = {
                usuario.getNomeUsuario(),
                usuario.getId()
            };
            model.addRow(rowData);
        }
    }
    
    // Método para obter múltiplos usuários selecionados
    public ArrayList<Usuario> getUsuariosSelecionados(JTable tableConsulta) {

        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();

        // Obtendo o index das linhas selecionadas
        int[] linhasSelecionadas = tableConsulta.getSelectedRows();

        ArrayList<Usuario> usuariosSelecionados = new ArrayList<>();

        // Para cada linha selecionada...
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            String stringIdSelecionado = String.valueOf(model.getValueAt(linhasSelecionadas[i], 1));
            Long idSelecionado = Long.valueOf(stringIdSelecionado);

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
        ArrayList<Usuario> selecionados = getUsuariosSelecionados(tableConsulta);
        
        // Adicionando, na lista de ids da notificação, os ids dos usuários
        // para a qual a notificação foi enviada
        for (Usuario usuario : selecionados) {
            UsuarioNotificacao usuarioNotificacao = new UsuarioNotificacao(usuario.getId(), novaNotificacao.getId());
            usuario.incrementarNumNotificacoesEnviadas();
        }
        
        colecaoNotificacoes.adicionarNotificacao(novaNotificacao);
        
        
    }
    
    public void atualizar(Observavel observavel){
        
        atualizarTabela();
    }
}
