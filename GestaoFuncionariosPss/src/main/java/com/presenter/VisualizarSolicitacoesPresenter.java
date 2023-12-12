/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Solicitacao;
import com.model.SolicitacaoCollection;
import com.model.Usuario;
import com.observer.*;
import com.view.VisualizarSolicitacoesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arthu
 */
public class VisualizarSolicitacoesPresenter implements Observador {
    
    private SolicitacaoCollection colecaoSolicitacoes;
    private VisualizarSolicitacoesView view;
    JTable tableSolicitacoes;
    
    public VisualizarSolicitacoesPresenter(){
        
        colecaoSolicitacoes = SolicitacaoCollection.getInstancia();
        colecaoSolicitacoes.adicionarObservador(this);
        view = new VisualizarSolicitacoesView();
        
        tableSolicitacoes = view.getTableSolicitacoes();
        atualizarTabela();
        
        // Botão "Abrir" [Navegação]
        view.getBtnAbrirSolicitacao().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                Solicitacao solicitacao = getSelecionado(tableSolicitacoes);
                AprovarSolicitacaoPresenter presenterAprovarSolicitacao = new AprovarSolicitacaoPresenter(solicitacao);
                
                // view.dispose();
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
    
    public void atualizarTabela(){
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                DefaultTableModel model;
                String[] columns = {"Nome", "Id Solicitação"};
                Object[][] data = new Object[colecaoSolicitacoes.getSolicitacoes().size()][2];

                int i = 0;
                for (Solicitacao solicitacao : colecaoSolicitacoes.getSolicitacoes()) {


                    data[i][0] = solicitacao.getNome();
                    data[i][1] = solicitacao.getId();

                    i++;
                }

                model = new DefaultTableModel(data, columns);
                tableSolicitacoes.setModel(model);

                model.fireTableDataChanged();
            }
        });
    }
    
    public Solicitacao getSelecionado(JTable tableSolicitacoes){
        
        DefaultTableModel model = (DefaultTableModel) tableSolicitacoes.getModel();
        
        // Obtendo o index da linha selecionada
        int linhaSelecionado = tableSolicitacoes.getSelectedRow();
        String stringIdSelecionado = String.valueOf( model.getValueAt(linhaSelecionado, 1 ));
        Long idSelecionado = Long.valueOf( stringIdSelecionado );
        
        // Buscando na coleção
        Solicitacao solicitacao = colecaoSolicitacoes.getSolicitacao( idSelecionado );
        
        return solicitacao;
    }
    
    public void atualizar(Observavel observavel){
        
        atualizarTabela();
    }
}
