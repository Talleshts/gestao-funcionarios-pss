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
public class UsuarioCollection extends Observavel {
    
    private static UsuarioCollection usuarioCollection;
    
    private ArrayList<Usuario> usuarios;
    
    public static long proximoId = 0;
    
    private UsuarioCollection(){
        super();
        usuarios = new ArrayList<>();
    }
    
    public static UsuarioCollection getInstancia(){
        
        if(usuarioCollection == null){
            usuarioCollection = new UsuarioCollection();
        }
        
        return usuarioCollection;
    }
    
    public void adicionarUsuario(Usuario usuario){
        this.notificarObservadores();
        usuarios.add(usuario);
    }
    
    public void removerUsuario(Long id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuarios.remove(usuario);
                this.notificarObservadores();
                return;
            }
        }
    }
   
    public void editarUsuario(Long id, String nome, String senha, int numNotEnviadas, int numNotLidas){
        
        Usuario usuario = getUsuario(id);

        // Editando
        usuario.setNomeUsuario(nome);
        usuario.setSenha(senha);
        usuario.setNumNotificacoesEnviadas(numNotEnviadas);
        usuario.setNumNotificacoesLidas(numNotLidas);
        
        this.notificarObservadores();
    }
    
    public Usuario getUsuario(long id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        
        return null;
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public static long getProximoId() {
        return proximoId;
    }
}
