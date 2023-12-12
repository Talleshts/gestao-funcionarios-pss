/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.observer.Observavel;
import java.util.ArrayList;

/**
 *
 * @author Arthu
 */
public class UsuarioNotificacaoCollection extends Observavel {
    
    private static UsuarioNotificacaoCollection notificacaoCollection;
    
    private ArrayList<UsuarioNotificacao> usuarioNotificacoes;
    
    public static long proximoId = 1;
    
    private UsuarioNotificacaoCollection(){
        super();
        usuarioNotificacoes = new ArrayList<>();
    }
    
    public static UsuarioNotificacaoCollection getInstancia(){
        
        if(notificacaoCollection == null){
            notificacaoCollection = new UsuarioNotificacaoCollection();
        }
        
        return notificacaoCollection;
    }
    
    public void adicionarUsuarioNotificacao(UsuarioNotificacao usuarioNotificacao){
        usuarioNotificacoes.add(usuarioNotificacao);
        this.notificarObservadores();
    }
    
    public void removerUsuarioNotificacao(Long idUsuario, Long idNotificacao){
        for(UsuarioNotificacao usuarioNotificacao : usuarioNotificacoes){
            if(usuarioNotificacao.getIdUsuario() == idUsuario && usuarioNotificacao.getIdNotificacao() == idNotificacao){
                usuarioNotificacoes.remove(usuarioNotificacao);
                this.notificarObservadores();
                return;
            }
        }
    }
    
    public UsuarioNotificacao getUsuarioNotificacao(Long idUsuario, Long idNotificacao){
        for(UsuarioNotificacao usuarioNotificacao : usuarioNotificacoes){
            if(usuarioNotificacao.getIdUsuario() == idUsuario && usuarioNotificacao.getIdNotificacao() == idNotificacao){
                return usuarioNotificacao;
            }
        }
        
        return null;
    }
    
    public ArrayList<UsuarioNotificacao> getUsuarioNotificacoes() {
        return usuarioNotificacoes;
    }
    
    public static long getProximoId() {
        return proximoId;
    }
    
    public boolean foiEnviadaPara(Long idUsuario, Long idNotificacao){
        
        for(UsuarioNotificacao par : usuarioNotificacoes){
            if(par.getIdNotificacao() == idNotificacao && par.getIdUsuario() == idUsuario){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean foiLidaPor(Long idUsuario, Long idNotificacao){
        
        for(UsuarioNotificacao par : usuarioNotificacoes){
            if(par.getIdNotificacao() == idNotificacao && par.getIdUsuario() == idUsuario && par.isLido()){
                return true;
            }
        }
        
        return false;
    }
    
    public void marcarComoLida(Long idUsuario, Long idNotificacao){
        
        for(UsuarioNotificacao par : usuarioNotificacoes){
            if(par.getIdNotificacao() == idNotificacao && par.getIdUsuario() == idUsuario){
                par.setLido(true);
                this.notificarObservadores();
            }
        }
    }
    
    public void marcarComoNaoLida(Long idUsuario, Long idNotificacao){
        
        for(UsuarioNotificacao par : usuarioNotificacoes){
            if(par.getIdNotificacao() == idNotificacao && par.getIdUsuario() == idUsuario){
                par.setLido(false);
                this.notificarObservadores();
            }
        }
    }
}
