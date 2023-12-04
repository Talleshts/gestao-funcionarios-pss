/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.sistemalog.adapter;

import com.ufes.sistemalog.utils.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author tallesh
 */
public class JSONLoggerAdapter implements ILoggerAdapter {

    private static final Logger LOGGER = LogManager.getLogger(JSONLoggerAdapter.class);

    @Override
    public void logInclusao(String nome, String usuario) {
        logOperation("Inclusao", nome, usuario);
    }
    
    @Override
    public void logAlteracao(String nome, String usuario) {
        logOperation("Alteracao", nome, usuario);
    }

    @Override
    public void logExclusao(String nome, String usuario) {
        logOperation("Exclusao", nome, usuario);
    }

    @Override
    public void logEnvioNotificacao(String nome, String usuario) {
        logOperation("Envio de Notificacao", nome, usuario);
    }

    @Override
    public void logLeituraNotificacao(String nome, String usuario) {
        logOperation("Leitura de Notificacao", nome, usuario);
    }

    @Override
    public void logAlteracaoSenha(String nome, String usuario) {
        logOperation("Alteracao de Senha", nome, usuario);
    }

    @Override
    public void logAutorizacaoUsuario(String nome, String usuario) {
        logOperation("Autorizacao de Usuario", nome, usuario);
    }

    @Override
    public void logFalhaOperacao(String operacao, String nome, String usuario, String mensagem) {
        String message = String.format("Ocorreu a falha %s ao realizar a %s do contato %s, (%s, %s, e %s).",
                mensagem, operacao, nome, DateUtil.getCurrentDate(), DateUtil.getCurrentTime(), usuario);
        LOGGER.error(formatJSON(message));
    }

    private String formatJSON(String message) {
        // Lógica de formatação para JSON
        return message;
    }    

    private void logOperation(String alteracao, String nome, String usuario) {
        throw new UnsupportedOperationException("Não suportado."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
