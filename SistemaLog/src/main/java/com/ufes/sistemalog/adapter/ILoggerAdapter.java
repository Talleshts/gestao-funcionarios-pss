/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.sistemalog.adapter;

/**
 *
 * @author tallesh
 */
public interface ILoggerAdapter {
    void logInclusao(String nome, String usuario);
    void logAlteracao(String nome, String usuario);
    void logExclusao(String nome, String usuario);
    void logEnvioNotificacao(String nome, String usuario);
    void logLeituraNotificacao(String nome, String usuario);
    void logAlteracaoSenha(String nome, String usuario);
    void logAutorizacaoUsuario(String nome, String usuario);
    void logFalhaOperacao(String operacao, String nome, String usuario, String mensagem);
}
