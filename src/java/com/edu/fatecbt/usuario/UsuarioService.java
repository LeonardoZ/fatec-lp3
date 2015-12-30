package com.edu.fatecbt.usuario;

import com.edu.fatecbt.usuario.Usuario;
import com.edu.fatecbt.usuario.UsuarioDAO;
import java.util.Optional;
import javax.servlet.http.HttpSession;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = null;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean ehUsuarioLogado(String login, String senha, HttpSession sessao) {
        Optional<Usuario> logado = usuarioDAO.getLoginSenha(login, senha);
        boolean present = logado.isPresent();
        if (present) {
            sessao.setAttribute("usuario", logado.get());
        }
        return present;
    }

    public void gravarUsuario(Usuario usuario, HttpSession session) {
        if (usuario.getCodUsuario() == 0) {
            usuarioDAO.salvar(usuario);
        } else {
            usuarioDAO.salvar(usuario);
            session.removeAttribute("usuario");
            session.setAttribute("usuario", usuario);
        }
    }

    public Usuario getUsuario(int cod) {
        return usuarioDAO.get(cod).orElse(new Usuario());
    }

}
