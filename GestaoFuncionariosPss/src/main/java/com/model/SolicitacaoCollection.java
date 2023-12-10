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
public class SolicitacaoCollection {
    
    private static SolicitacaoCollection solicitacaoCollection;
    
    private ArrayList<Solicitacao> solicitacoes;
    
    public static long proximoId = 1;
    
    private SolicitacaoCollection(){
        solicitacoes = new ArrayList<>();
    }
    
    public static SolicitacaoCollection getInstancia(){
        
        if(solicitacaoCollection == null){
            solicitacaoCollection = new SolicitacaoCollection();
        }
        
        return solicitacaoCollection;
    }
    
    public void adicionarSolicitacao(Solicitacao solicitacao){
        solicitacoes.add(solicitacao);
    }
    
    public void removerSolicitacao(Long id){
        for(Solicitacao solicitacao : solicitacoes){
            if(solicitacao.getId() == id){
                solicitacoes.remove(solicitacao);
                return;
            }
        }
    }
    
    public Solicitacao getSolicitacao(long id){
        for(Solicitacao solicitacao : solicitacoes){
            if(solicitacao.getId() == id){
                return solicitacao;
            }
        }
        
        return null;
    }
    
    public ArrayList<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }
    
    public static long getProximoId() {
        return proximoId;
    }
}
