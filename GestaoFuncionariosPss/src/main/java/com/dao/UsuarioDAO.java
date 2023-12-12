package com.dao;

import com.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author talle
 */
public class UsuarioDAO implements IDAO<Usuario> {
    
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    
    public UsuarioDAO() {
        SQLite sqlite = SQLite.getInstance();
        this.conn = sqlite.getConnection();
        try {
            this.statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM USUARIOS";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Date dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(resultSet.getString("DATA_CADASTRO"));
                Boolean isAdmin = resultSet.getBoolean("IS_ADMINISTRADOR");
                usuarios.add(
                        new Usuario(resultSet.getLong("ID"),
                                resultSet.getString("NOME"),
                                resultSet.getString("SENHA"),
                                isAdmin,
                            dataCadastro));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = null;

        try {
            String sql = "SELECT * FROM USUARIO WHERE USUARIO.ID = " + id;
            
            resultSet = statement.executeQuery(sql);
            Date dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(resultSet.getString("DATA_CADASTRO"));
            usuario = new Usuario
                    (resultSet.getLong("ID"),
                    resultSet.getString("NOME"),
                    resultSet.getString("SENHA"),
                    resultSet.getInt("NUM_NOTIFICACOES_LIDAS"),
                    resultSet.getInt("NUM_NOTIFICACOES_ENVIADAS"),
                    resultSet.getBoolean("IS_ADMINISTRADOR"),
                    dataCadastro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = String.format("UPDATE USUARIO SET NOME = '%s', SENHA = '%s',  NUM_NOTIFICACOES_LIDAS = %d, NUM_NOTIFICACOES_ENVIADAS = %d WHERE USUARIO.ID = '%d'",
            usuario.getNomeUsuario(), usuario.getSenha(), (usuario.getNumNotificacoesLidas()), (usuario.getNumNotificacoesEnviadas()), usuario.getId());
        execute(sql);
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM USUARIOS WHERE USUARIOS.ID = " + id;
        execute(sql);
    }

    @Override
    public void insert(Usuario usuario) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataCadastro = formatter.format(usuario.getDataCadastro());
        String sql;
        sql = String.format("INSERT INTO USUARIO ( NOME, SENHA, NUM_NOTIFICACOES_LIDAS, NUM_NOTIFICACOES_ENVIADAS, DATA_CADASTRO) VALUES  ('%s', '%s', %d, %d, '%s')",
                usuario.getNomeUsuario(),
                usuario.getSenha(),
                (usuario.getNumNotificacoesLidas()),
                (usuario.getNumNotificacoesEnviadas()),
                dataCadastro);
        execute(sql);
    }
    
    public void criarTabelaUsuario() {
        String sql = "CREATE TABLE  IF NOT EXISTS USUARIOS"
                + "( ID INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", NOME_USUARIO VARCHAR(20)"
                + ", SENHA VARCHAR(20)"
                + ", DATA_CADASTRO VARCHAR(20)"
                + ", NUM_NOTIFICACOES_ENVIADAS INTEGER"
                + ", NUM_NOTIFICACOES_LIDAS INTEGER"
                + ", IS_ADMINISTRADOR INTEGER)";
        execute(sql);
    }

    public void deletarTabelaUsuario() {
        String sql = "DROP TABLE USUARIOS";
        execute(sql);
    }

    /*
    public static String turnUserToAdmin(Integer id) throws Exception {
        String query = "UPDATE USUARIOS SET IS_ADMINISTRADOR = 1"
                + "WHERE ID =" + id;
        return query;
//        statement.execute(query);
    }
*/
    
    private void execute(String sql){
        try{
            statement.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
