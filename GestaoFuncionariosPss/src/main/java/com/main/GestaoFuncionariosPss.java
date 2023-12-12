/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.main;

import com.dao.NotificacaoDAO;
import com.dao.SolicitacaoDAO;
import com.dao.UsuarioDAO;
import com.presenter.LoginCadastroPresenter;

/**
 *
 * @author tallesh
 */
public class GestaoFuncionariosPss {

    public static void main(String[] args) {
        
        LoginCadastroPresenter presenterLoginCadastro = new LoginCadastroPresenter();
        new UsuarioDAO().criarTabelaUsuario();        
        new SolicitacaoDAO().criarTabelaSolicitacao();
        new NotificacaoDAO().criarTabelaNotificao();
        //LoggerAdapter loggerAdapter = LoggerConfig.getLoggerAdapter();
    }
}
