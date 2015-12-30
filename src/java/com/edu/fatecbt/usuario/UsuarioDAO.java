/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.fatecbt.usuario;

import com.edu.fatecbt.usuario.Usuario;
import com.edu.fatecbt.sistema.dados.GenericDAO;
import java.util.Optional;

/**
 *
 * @author Leonardo
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public Optional<Usuario> getLoginSenha(String login, String senha) {
        Usuario usuario = (Usuario) getSession().getNamedQuery("usuario.fazLogin")
                .setParameter("login", login)
                .setParameter("senha", senha)
                .uniqueResult();
        return Optional.ofNullable(usuario);
    }

    @Override
    protected Class<?> getClasse() {
        return Usuario.class;
    }

}
