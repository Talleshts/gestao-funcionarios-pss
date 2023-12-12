/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Notificacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author talle
 */
public class NotificacaoDAO implements IDAO<Notificacao>{
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;    

    public NotificacaoDAO(){
        SQLite sqlite = SQLite.getInstance();
        this.conn = sqlite.getConnection();
        try{
            statement = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void criarTabelaNotificao() {
        String sql = "CREATE TABLE  IF NOT EXISTS NOTIFICACAO"
                + "( ID INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", TITULO VARCHAR(20)"
                + ", CORPO VARCHAR(20)"
                + ", ENVIADA_PARA INTEGER"
                + ", EH_LIDA BOOLEAN )";
        execute(sql);
    }
    
        public void deletarTabelaNotificacao() {
        String sql = "DROP TABLE NOTIFICACAO";
        execute(sql);
    }
    
    @Override
    public List<Notificacao> findAll() {
        List<Notificacao> notificacoes = new ArrayList<>();
        String sql = "SELECT * FROM NOTIFICACAO";
        try{
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                notificacoes.add(
                        new Notificacao(
                            resultSet.getLong("ID")
                            , resultSet.getString("TITULO")
                            , resultSet.getString("MENSAGEM"))
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return notificacoes;
    }

    @Override
    public Notificacao findById(Long id) {
        Notificacao not = null;
        String sql = String.format("SELECT * FROM %s WHERE %s = %d","NOTIFICACAO", id);
        try{
            resultSet = statement.executeQuery(sql);
            String titulo = resultSet.getString("TITULO");
            String corpo = resultSet.getString("CORPO");
            not = new Notificacao(id, titulo, corpo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return not;
    }

    @Override
    public void update(Notificacao notificacao) {
        String sql = "UPDATE NOTIFICACAO SET NOTIFICACAO.TITULO =" + notificacao.getTitulo()
                + ", NOTIFICACAO.CORPO =" + notificacao.getCorpo()
                + ", NOTIFICACAO.ENVIADA_PARA =" + notificacao.getEnviadaPara()
                + ", NOTIFICACAO.EH_LIDA =" + notificacao.getEhLida()
                + "WHERE NOTIFICACAO.ID = "+ notificacao.getId();
        execute(sql);
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM NOTIFICACAO WHERE NOTIFICACAO.ID = " + id;
        execute(sql);
    }

    @Override
    public void insert(Notificacao notificacao) {
        String sql = "INSERT INTO NOTIFICACAO ( TITULO, CORPO, ENVIADA_PARA, EH_LIDA) VALUES  ('" + notificacao.getTitulo() + "','" + notificacao.getCorpo()+ "','" + notificacao.getEnviadaPara() + "','" + notificacao.getEhLida() + "')";
        execute(sql);
    }
    
    private void execute(String sql){
        try{
            statement.execute(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public static String getNotificacoes() throws Exception {
        String query = ("SELECT * FROM NOTIFICACAO");
        return query;
    }
}
