/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Arthu
 */
public class UsuarioCollection {
    
    private static UsuarioCollection usuarioCollection;
    
    private ArrayList<Usuario> usuarios;
    
    public static long proximoId = 0;
    
    private UsuarioCollection(){
        usuarios = new ArrayList<>();
    }
    
    public static UsuarioCollection getInstancia(){
        
        if(usuarioCollection == null){
            usuarioCollection = new UsuarioCollection();
        }
        
        return usuarioCollection;
    }
    
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void removerUsuario(Long id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuarios.remove(usuario);
                return;
            }
        }
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
