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
    private String nomeUsuario;
    private String senha;
    private Date dataCadastro;
    private int numNotificacoesEnviadas;
    private int numNotificacoesLidas;
    private boolean administrador;
    
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

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
}
