/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.*;
import com.observer.Observador;
import com.observer.Observavel;
import com.view.VisualizarNotificacoesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arthu
 */
public class VisualizarNotificacoesPresenter implements Observador {
    
    private VisualizarNotificacoesView view;
    private NotificacaoCollection colecaoNotificacoes;
    private UsuarioCollection colecaoUsuarios;
    private UsuarioNotificacaoCollection colecaoUsuarioNotificacao;
    JTable tableNotificacoesNaoLidas;
    JTable tableNotificacoesLidas;
    
    private Long idUsuario;
    
    public VisualizarNotificacoesPresenter(Long idUsuario){
        
        colecaoNotificacoes = NotificacaoCollection.getInstancia();
        colecaoUsuarios = UsuarioCollection.getInstancia();
        colecaoUsuarioNotificacao = UsuarioNotificacaoCollection.getInstancia();
        colecaoUsuarioNotificacao.adicionarObservador(this);
        
        view = new VisualizarNotificacoesView();
        
        tableNotificacoesNaoLidas = view.getTableNotificacoesLidas();
        tableNotificacoesLidas = view.getTableNotificacoesLidas();
        atualizarTabelas();
        
        // Botão "Abrir" [Navegação]
        view.getBtnAbrir().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                try{
                    JTable tabelaSelecionada = getTabelaSelecionada(tableNotificacoesNaoLidas, tableNotificacoesLidas);
                    Notificacao notificacaoSelecionada = getNotificacaoSelecionada(tabelaSelecionada);

                    LeituraNotificacaoPresenter presenterLeituraNotificacao = new LeituraNotificacaoPresenter(notificacaoSelecionada);
                    
                    view.dispose();
                } catch (RuntimeException ex) {
                    System.out.println("Selecione uma notificação de alguma tabela");
                }
                
            }
        });
        
        // Botão "Voltar" [Navegação]
        view.getBtnVoltar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                view.dispose();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    // Atualizar a tabela com os títulos das notificações
    public void atualizarTabelas() {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                DefaultTableModel modelNaoLidas = (DefaultTableModel) tableNotificacoesNaoLidas.getModel();
                modelNaoLidas.setRowCount(0); // Limpa todas as linhas da tabela

                DefaultTableModel modelLidas = (DefaultTableModel) tableNotificacoesLidas.getModel();
                modelLidas.setRowCount(0); // Limpa todas as linhas da tabela

                // Percorre a lista de link usuario-notificação
                for (UsuarioNotificacao usuarioNotificacao : colecaoUsuarioNotificacao.getUsuarioNotificacoes()){

                    // Se há uma instância com o mesmo idUsuario que o login da presenter, e a notificação não foi lda...
                    if(Objects.equals(usuarioNotificacao.getIdUsuario(), idUsuario) && !usuarioNotificacao.isLido()){
                        Notificacao notificacao = colecaoNotificacoes.getNotificacao(usuarioNotificacao.getIdNotificacao());

                        Object[] rowData = {
                            notificacao.getTitulo()
                        };

                        modelNaoLidas.addRow(rowData);
                    }
                    // Se há uma instância com o mesmo idUsuario que o login da presenter, e a notificação foi lda...
                    else if(Objects.equals(usuarioNotificacao.getIdUsuario(), idUsuario) && usuarioNotificacao.isLido()){
                        Notificacao notificacao = colecaoNotificacoes.getNotificacao(usuarioNotificacao.getIdNotificacao());

                        Object[] rowData = {
                            notificacao.getTitulo()
                        };

                        modelLidas.addRow(rowData);
                    }
                }

                modelNaoLidas.fireTableDataChanged();
            }
        });
    }
    
    public Notificacao getNotificacaoSelecionada(JTable tableSelecionada){
        
        DefaultTableModel model = (DefaultTableModel) tableSelecionada.getModel();
        
        // Obtendo o index da linha selecionada
        int linhaSelecionado = tableSelecionada.getSelectedRow();
        String stringIdSelecionado = String.valueOf( model.getValueAt(linhaSelecionado, 0 ));
        Long idSelecionado = Long.valueOf( stringIdSelecionado );
        
        // Buscando na coleção
        Notificacao notificacao = colecaoNotificacoes.getNotificacao( idSelecionado );
        
        return notificacao;
    }
    
    public JTable getTabelaSelecionada(JTable tableNotificacoesNaoLidas, JTable tableNotificacoesLidas){
        
        if(tableNotificacoesNaoLidas.getSelectedRow() != -1){
            return tableNotificacoesNaoLidas;
        }
        else if(tableNotificacoesLidas.getSelectedRow() != -1){
            return tableNotificacoesLidas;
        }
        else{
            throw new RuntimeException();
        }
    }
    
    public void atualizar(Observavel observavel){
        
        atualizarTabelas();
    }
}
