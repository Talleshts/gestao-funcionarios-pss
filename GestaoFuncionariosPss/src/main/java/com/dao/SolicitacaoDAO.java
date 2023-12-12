package com.dao;

import com.model.Solicitacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author talle
 */
public class SolicitacaoDAO implements IDAO<Solicitacao> {

    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;

    public SolicitacaoDAO() {
        SQLite sqlite = SQLite.getInstance();
        this.conn = sqlite.getConnection();
        try {
            this.statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Solicitacao> findAll() {
        List<Solicitacao> solicitacoes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SOLICITACOES";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                solicitacoes.add(new Solicitacao(
                        resultSet.getLong("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getString("SENHA")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return solicitacoes;
    }

    @Override
    public Solicitacao findById(Long id) {
        Solicitacao solicitacao = null;

        try {
            String sql = "SELECT * FROM SOLICITACOES WHERE SOLICITACOES.ID = " + id;

            resultSet = statement.executeQuery(sql);
            solicitacao = new Solicitacao(
                    resultSet.getLong("ID"),
                    resultSet.getString("NOME"),
                    resultSet.getString("SENHA"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return solicitacao;
    }

    @Override
    public void update(Solicitacao solicitacao) {
        String sql = String.format("UPDATE SOLICITACOES SET NOME = '%s', SENHA = '%s' WHERE SOLICITACOES.ID = %d",
                solicitacao.getNome(), solicitacao.getSenha(), solicitacao.getId());
        execute(sql);
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM SOLICITACOES WHERE SOLICITACOES.ID = " + id;
        execute(sql);
    }

    @Override
    public void insert(Solicitacao solicitacao) {
        String sql = String.format("INSERT INTO SOLICITACOES (NOME, SENHA) VALUES ('%s', '%s')",
                solicitacao.getNome(), solicitacao.getSenha());
        execute(sql);
    }

    public void criarTabelaSolicitacao() {
        String sql = "CREATE TABLE IF NOT EXISTS SOLICITACOES"
                + "(ID INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", NOME VARCHAR(20)"
                + ", SENHA VARCHAR(20))";
        execute(sql);
    }

    public void deletarTabelaSolicitacao() {
        String sql = "DROP TABLE SOLICITACOES";
        execute(sql);
    }

    private void execute(String sql) {
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
