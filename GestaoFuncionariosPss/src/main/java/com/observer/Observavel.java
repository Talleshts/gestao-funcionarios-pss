/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.observer;

import java.util.ArrayList;

/**
 *
 * @author Arthu
 */
public abstract class Observavel {
    
    private ArrayList<Observador> observadores;
    
    public Observavel(){
        observadores = new ArrayList<>();
    }
    
    public void adicionarObservador(Observador observador){
        observadores.add(observador);
    }
    
    public void removerObservador(Observador observador){
        observadores.remove(observador);
    }
    
    public void notificarObservadores(){
        
        for(Observador observador : observadores){
            observador.atualizar(this);
        }
    }
}
