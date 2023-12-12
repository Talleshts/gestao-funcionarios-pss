/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.*;
import com.service.ValidadorSenhaService;
import com.view.LoginCadastroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthu
 */
public class LoginCadastroPresenter {
    
    private UsuarioNotificacaoCollection colecaoUsuarioNotificacao;
    private NotificacaoCollection colecaoNotificacoes;
    private SolicitacaoCollection colecaoSolicitacoes;
    private UsuarioCollection colecaoUsuarios;
    private LoginCadastroView view;
    
    public LoginCadastroPresenter(){
        
        colecaoUsuarioNotificacao = UsuarioNotificacaoCollection.getInstancia();
        colecaoNotificacoes = NotificacaoCollection.getInstancia();
        colecaoSolicitacoes = SolicitacaoCollection.getInstancia();
        colecaoUsuarios = UsuarioCollection.getInstancia();
        
        view = new LoginCadastroView();
        
        // Botão "Login" [Navegação]
        view.getBtnLogin().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                try{
                    String nome = view.getTxtNomeUsuario().getText();
                    String senha = view.getTxtNomeUsuario().getText();
                    // ValidadorSenhaService.validar(senha);
                    
                    login(nome, senha);
                    
                } catch (Exception ex) {
                    System.out.println("Senha recusada");
                }
            }
        });
        
        // Botão "Cadastro" [Navegação]
        view.getBtnCadastro().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão ALGO ACONTECE
            public void actionPerformed(ActionEvent e){
                
                try{
                    if(UsuarioCollection.getProximoId() == 0){
                        String nome = view.getTxtNomeUsuario().getText();
                        String senha = view.getTxtNomeUsuario().getText();
                        // ValidadorSenhaService.validar(senha);

                        cadastraADM(nome, senha);
                    }
                    else{
                        adicionaSolicitacao();
                        MsgSolicitacaoPresenter presenterMsgSolicitacao = new MsgSolicitacaoPresenter();
                    }
                } catch (Exception ex) {
                    System.out.println("Senha recusada");
                }
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void adicionaSolicitacao(){
                
        // Recupere os valores dos campos de entrada
        String nomeUsuario = view.getTxtNomeUsuario().getText();
        String senha = view.getPassFieldSenha().getText();
        
        // Inicializando id
        Long novoId = SolicitacaoCollection.getProximoId();

        // Crie uma nova Solicitação
        Solicitacao novaSolicitacao;
        novaSolicitacao = new Solicitacao(novoId, nomeUsuario, senha);
        SolicitacaoCollection.proximoId++;

        // Adicione a nova solicitação à coleção de solicitações
        colecaoSolicitacoes.adicionarSolicitacao(novaSolicitacao);

        limparCampos();
    }
    
    private void limparCampos(){
        // Limpe os campos de entrada após a inclusão
        view.getTxtNomeUsuario().setText("");
        view.getPassFieldSenha().setText("");
    }
    
    private Long retornaId(String nome, String senha){
        
        for(Usuario usuario : colecaoUsuarios.getUsuarios()){
            
            if(usuario.getNomeUsuario().equals(nome) && usuario.getSenha().equals(senha)){
                return usuario.getId();
            }
        }
        
        return -1L;
    }
    
    private void login(String nome, String senha){
        
        Long idUsuario = retornaId(nome, senha);
        
        // Está credenciado, não é administrador
        if(retornaId(nome, senha) > 0){
            PrincipalUsuarioPresenter presenterPrincipalUsuario = new PrincipalUsuarioPresenter(idUsuario);
            // view.dispose();

        }
        // Está credenciado, é administrador
        else if(retornaId(nome, senha) == 0){
            PrincipalAdministradorPresenter presenterAdministradorUsuario = new PrincipalAdministradorPresenter();
            // view.dispose();
        }
        else{
            System.out.println("Usuário não credenciado");
        }
    }
    
    private void cadastraADM(String nome, String senha){
        
        // Inicializando valores independentes (id, data e booleano de adm)
        Long novoId = UsuarioCollection.getProximoId();
        Date dataCadastro = new java.sql.Date( System.currentTimeMillis() );
        boolean isAdministrador = true;

        // Crie um novo usuario
        Usuario novoUsuario;
        novoUsuario = new Usuario(novoId, nome, senha, 0, 0, isAdministrador, dataCadastro);
        UsuarioCollection.proximoId++;

        // Adicione o novo usuario à coleção de usuarios
        colecaoUsuarios.adicionarUsuario(novoUsuario);

        limparCampos();
        
        PrincipalAdministradorPresenter presenterAdministradorUsuario = new PrincipalAdministradorPresenter();
    }
}
