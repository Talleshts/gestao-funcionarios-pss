/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.view.ManterUsuariosView;
import com.model.UsuarioCollection;
import com.model.Usuario;
import com.observer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arthu
 */
public class ManterUsuariosPresenter implements Observador{
    
    private UsuarioCollection colecaoUsuarios;
    private ManterUsuariosView view;
    JTable tableManter;
    
    public ManterUsuariosPresenter(){
        colecaoUsuarios = UsuarioCollection.getInstancia();
        colecaoUsuarios.adicionarObservador(this);
        view = new ManterUsuariosView();
        
        tableManter = view.getTableManter();
        atualizarTabela();
        
        // Botão "Buscar"
        view.getBtnBuscar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, a busca deve ser feita (oh)
            public void actionPerformed(ActionEvent e){
                buscarUsuario();
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
        
        // Botão "Ver"
        view.getBtnVer().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, a busca deve ser feita (oh)
            public void actionPerformed(ActionEvent e){
                verUsuario(tableManter);
            }
        });
        
        // Botão "Novo"
        view.getBtnNovo().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, a busca deve ser feita (oh)
            public void actionPerformed(ActionEvent e){
                incluirUsuario();
                atualizarTabela();
                MsgInclusaoPresenter presenterMsgInclusao = new MsgInclusaoPresenter();
            }
        });
        
        // Botão "Editar" [Navegação]
        view.getBtnEditar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                ConfirmarEdicaoPresenter presenterConfirmarEdicao = new ConfirmarEdicaoPresenter(ManterUsuariosPresenter.this);
            }
        });
        
        // Botão "Excluir" [Navegação]
        view.getBtnExcluir().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                ConfirmarExclusaoPresenter presenterConfirmarExclusao = new ConfirmarExclusaoPresenter(ManterUsuariosPresenter.this);
            }
        });
        
        // Botão "Limpar"
        view.getBtnLimpar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                limparCampos();
            }
        });
        
        
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    // Atualizar a tabela com os dados dos usuários
    public void atualizarTabela() {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTable tableManter = view.getTableManter();
                DefaultTableModel model = (DefaultTableModel) tableManter.getModel();
                String[] columns = {"Nome", "Data", "Id"};

                model.setRowCount(0);

                for (Usuario usuario : colecaoUsuarios.getUsuarios()) {
                    
                    model.addRow(new Object[]{
                        usuario.getNomeUsuario(),
                        usuario.getDataCadastro(),
                        usuario.getId()
                    });
                }

                model.fireTableDataChanged();
            }
        });
    }
    
    public Usuario getSelecionado(JTable tableManter){
        
        DefaultTableModel model = (DefaultTableModel) tableManter.getModel();
        
        // Obtendo o index da linha selecionada
        int linhaSelecionado = tableManter.getSelectedRow();
        String stringIdSelecionado = String.valueOf( model.getValueAt(linhaSelecionado, 2 ));
        Long idSelecionado = Long.valueOf( stringIdSelecionado );
        
        // Buscando na coleção
        Usuario usuario = colecaoUsuarios.getUsuario( idSelecionado );
        
        return usuario;
    }
    
    public void buscarUsuario(){
        
        DefaultTableModel model = (DefaultTableModel) tableManter.getModel();
        model.setRowCount(0); // Limpa todas as linhas da tabela
        
        String campo = view.getComboBoxCampo().getSelectedItem().toString();
        String filtro = view.getTxtFiltro().getText();
        
        // Se o filtro estiver vazio, atualiza a tabela com todas as entradas e retorna
        if (filtro.equals("")) {
            atualizarTabela();
            return;
        }
        
        // Descobre o index da coluna que representa o campo que queremos
        int coluna = model.findColumn(campo);

        // Procura, em coluna == campo, o filtro
        for (Usuario usuario : colecaoUsuarios.getUsuarios()) {
            
            
            Object[] rowData = {
                usuario.getNomeUsuario(),
                usuario.getDataCadastro(),
                usuario.getId()
            };
            
            if(rowData[coluna].toString().equals(filtro)){
                model.addRow(rowData);
            }
        }
        
    }
    
    // Pega o usuário selecionado e mostra nos JTxtFields
    private void verUsuario(JTable tableManter){
        
        Usuario usuario = getSelecionado(tableManter);
        
        // Exibindo nos JTxtFields
        view.getTxtNomeUsuario().setText( usuario.getNomeUsuario() );
        view.getTxtSenha().setText( usuario.getSenha() );
        view.getTxtNotificacoesRecebidas().setText( String.valueOf( usuario.getNumNotificacoesEnviadas()) );
        view.getTxtNotificacoesLidas().setText( String.valueOf( usuario.getNumNotificacoesLidas()) );
        view.getTxtId().setText( String.valueOf( usuario.getId()) );
        view.getTxtDataCadastro().setText( String.valueOf( usuario.getDataCadastro()) );
    }
    
    // Incluir usuário
    private void incluirUsuario(){
        
        // Recupere os valores dos campos de entrada
        String nomeUsuario = view.getTxtNomeUsuario().getText();
        String senha = view.getTxtSenha().getText();
        
        // Inicializando valores independentes (id, data e booleano de adm)
        Long novoId = UsuarioCollection.getProximoId();
        Date dataCadastro = new java.sql.Date( System.currentTimeMillis() );
        boolean isAdministrador = false;

        // Crie um novo usuario
        Usuario novoUsuario;
        novoUsuario = new Usuario(novoId, nomeUsuario, senha, 0, 0, isAdministrador, dataCadastro);
        UsuarioCollection.proximoId++;

        // Adicione o novo usuario à coleção de usuarios
        colecaoUsuarios.adicionarUsuario(novoUsuario);

        limparCampos();
    }
    
    public void editarUsuario(){
        
        Long id = Long.valueOf(view.getTxtId().getText());
        String nome = view.getTxtNomeUsuario().getText();
        String senha = view.getTxtSenha().getText();
        int numNotEnviadas = Integer.parseInt( view.getTxtNotificacoesRecebidas().getText() );
        int numNotLidas = Integer.parseInt( view.getTxtNotificacoesLidas().getText() );
        
        colecaoUsuarios.editarUsuario(id, nome, senha, numNotEnviadas, numNotLidas);
    }
    
    public void excluirUsuario(){
        
        Long id = Long.valueOf(view.getTxtId().getText());
        Usuario usuario = colecaoUsuarios.getUsuario( id );

        // Excluindo
        colecaoUsuarios.removerUsuario(id);
    }
    
    private void limparCampos(){
        // Limpe os campos de entrada após a inclusão
        view.getTxtNomeUsuario().setText("");
        view.getTxtSenha().setText("");
        view.getTxtNotificacoesRecebidas().setText("");
        view.getTxtNotificacoesLidas().setText("");
        view.getTxtId().setText("");
        view.getTxtDataCadastro().setText("");
    }
    
    public void atualizar(Observavel observavel){
        
        atualizarTabela();
    }
}