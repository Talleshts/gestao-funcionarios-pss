/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.ArrayList;

/**
 *
 * @author Arthu
 */
public class NotificacaoCollection {
    
    private static NotificacaoCollection notificacaoCollection;
    
    private ArrayList<Notificacao> notificacoes;
    
    public static long proximoId = 1;
    
    private NotificacaoCollection(){
        notificacoes = new ArrayList<>();
    }
    
    public static NotificacaoCollection getInstancia(){
        
        if(notificacaoCollection == null){
            notificacaoCollection = new NotificacaoCollection();
        }
        
        return notificacaoCollection;
    }
    
    public void adicionarNotificacao(Notificacao notificacao){
        notificacoes.add(notificacao);
    }
    
    public void removerNotificacao(Long id){
        for(Notificacao notificacao : notificacoes){
            if(notificacao.getId() == id){
                notificacoes.remove(notificacao);
                return;
            }
        }
    }
    
    public Notificacao getNotificacao(long id){
        for(Notificacao notificacao : notificacoes){
            if(notificacao.getId() == id){
                return notificacao;
            }
        }
        
        return null;
    }
    
    public ArrayList<Notificacao> getNotificacoes() {
        return notificacoes;
    }
    
    public static long getProximoId() {
        return proximoId;
    }
}
