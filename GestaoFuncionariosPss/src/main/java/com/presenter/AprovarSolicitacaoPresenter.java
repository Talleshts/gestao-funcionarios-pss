/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Solicitacao;
import com.model.SolicitacaoCollection;
import com.model.Usuario;
import com.model.UsuarioCollection;
import com.view.AprovarSolicitacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author Arthu
 */
public class AprovarSolicitacaoPresenter {
    
    private UsuarioCollection colecaoUsuarios;
    private SolicitacaoCollection colecaoSolicitacoes;
    private AprovarSolicitacaoView view;
    
    public AprovarSolicitacaoPresenter(Solicitacao solicitacao){
        
        colecaoUsuarios = UsuarioCollection.getInstancia();
        colecaoSolicitacoes = SolicitacaoCollection.getInstancia();
        view = new AprovarSolicitacaoView();
        
        view.getTxtNome().setText(solicitacao.getNome());
        view.getTxtSenha().setText(solicitacao.getSenha());
        
        // Botão "Aprovar" [Navegação]
        view.getBtnAprovar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                aprovarSolicitacao(solicitacao);
                MsgAprovarOuNegarPresenter presenterMsgAprovarOuNegar = new MsgAprovarOuNegarPresenter(true);
                
                view.dispose();
            }
        });
        
        // Botão "Negar" [Navegação]
        view.getBtnNegar().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                negarSolicitacao(solicitacao);
                MsgAprovarOuNegarPresenter presenterMsgAprovarOuNegar = new MsgAprovarOuNegarPresenter(false);
                
                view.dispose();
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
    
    public void aprovarSolicitacao(Solicitacao solicitacao){
        
        String nomeUsuario = view.getTxtNome().getText();
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
        colecaoSolicitacoes.removerSolicitacao(solicitacao.getId());
    }
    
    public void negarSolicitacao(Solicitacao solicitacao){
        
        colecaoSolicitacoes.removerSolicitacao(solicitacao.getId());
    }
    
}
