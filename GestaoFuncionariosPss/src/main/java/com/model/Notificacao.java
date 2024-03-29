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
public class Notificacao {
    
    private Long id;
    private String titulo;
    private String corpo;

    public Notificacao(Long id, String titulo, String corpo) {
        this.id = id;
        this.titulo = titulo;
        this.corpo = corpo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}