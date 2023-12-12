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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arthu
 */
public class ManterUsuariosPresenter implements Observador{
    
    private UsuarioCollection colecaoUsuarios;
    private ManterUsuariosView view;
    JTable tableConsulta;
    
    public ManterUsuariosPresenter(){
        colecaoUsuarios = UsuarioCollection.getInstancia();
        colecaoUsuarios.adicionarObservador(this);
        view = new ManterUsuariosView();
        
        tableConsulta = view.getTableManter();
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
                PrincipalAdministradorPresenter presenterPrincipalAdministrador = new PrincipalAdministradorPresenter();
                
                view.dispose();
            }
        });
        
        // Botão "Ver"
        view.getBtnVer().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão, a busca deve ser feita (oh)
            public void actionPerformed(ActionEvent e){
                verUsuario(tableConsulta);
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
        
        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
        model.setRowCount(0); // Limpa todas as linhas da tabela

        for (Usuario usuario : colecaoUsuarios.getUsuarios()) {
            
            // Adicione uma nova linha à tabela com os dados do usuário
            Object[] rowData = {
                usuario.getNomeUsuario(),
                usuario.getDataCadastro(),
                usuario.getId()
            };
            model.addRow(rowData);
        }
    }
    
    public Usuario getSelecionado(JTable tableConsulta){
        
        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
        
        // Obtendo o index da linha selecionada
        int linhaSelecionado = tableConsulta.getSelectedRow();
        String stringIdSelecionado = String.valueOf( model.getValueAt(linhaSelecionado, 2 ));
        Long idSelecionado = Long.parseLong( stringIdSelecionado );
        
        // Buscando na coleção
        Usuario usuario = colecaoUsuarios.getUsuario( idSelecionado );
        
        return usuario;
    }
    
    public void buscarUsuario(){
        
        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
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
    private void verUsuario(JTable tableConsulta){
        
        Usuario usuario = getSelecionado(tableConsulta);
        
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
        Usuario usuario = colecaoUsuarios.getUsuario(id);

        // Editando
        usuario.setNomeUsuario( view.getTxtNomeUsuario().getText() );
        usuario.setSenha( view.getTxtSenha().getText() );
        usuario.setNumNotificacoesEnviadas(Integer.parseInt( view.getTxtNotificacoesRecebidas().getText() ));
        usuario.setNumNotificacoesLidas(Integer.parseInt( view.getTxtNotificacoesLidas().getText() ));
    }
    
    public void excluirUsuario(){
        
        Long id = Long.parseLong(view.getTxtId().getText());
        Usuario usuario = colecaoUsuarios.getUsuario( id );

        // Excluindo
        colecaoUsuarios.removerUsuario(id);
    }
    
    // Limpar campos
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