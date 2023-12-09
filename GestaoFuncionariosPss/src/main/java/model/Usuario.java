/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Arthu
 */
public class Usuario {
    private final Long id;
    private String nomeUsuario;
    private String senha;
    private final Date dataCadastro;
    private int numNotificacoesEnviadas;
    private int numNotificacoesLidas;
    private boolean isAdministrador;
    
    public Usuario(Long id, String nomeUsuario, String senha, Date dataCadastro, boolean isAdministrador){
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.numNotificacoesEnviadas = 0;
        this.numNotificacoesLidas = 0;
        this.isAdministrador = isAdministrador;
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public int getNumNotificacoesEnviadas() {
        return numNotificacoesEnviadas;
    }

    public void setNumNotificacoesEnviadas(int numNotificacoesEnviadas) {
        this.numNotificacoesEnviadas = numNotificacoesEnviadas;
    }

    public int getNumNotificacoesLidas() {
        return numNotificacoesLidas;
    }

    public void setNumNotificacoesLidas(int numNotificacoesLidas) {
        this.numNotificacoesLidas = numNotificacoesLidas;
    }

    public boolean isAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }

    public Long getId() {
        return id;
    }
    
}
