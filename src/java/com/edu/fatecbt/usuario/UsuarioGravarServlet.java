package com.edu.fatecbt.usuario;

import com.edu.fatecbt.sistema.controle.AppUrls;
import com.edu.fatecbt.sistema.controle.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioGravar", urlPatterns = {AppUrls.USUARIO_GRAVAR})
public class UsuarioGravarServlet extends ServletBase {

    private UsuarioService service;

    @Override
    public void init() throws ServletException {
        service = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = null;
        String cod = request.getParameter("cod");
        String nome = request.getParameter("nome");
        String login = request.getParameter("ilogin");
        String senha = request.getParameter("isenha");

        if (ehCodigoNovo(cod)) {
            usuario = new Usuario();
            usuario.setCodUsuario(strToInt(cod));
            usuario.setLogin(login);
        } else {
            usuario = service.getUsuario(strToInt(cod));
        }

        usuario.setNome(nome);
        usuario.setSenha(senha);

        if (usuario.isValid()) {

            service.gravarUsuario(usuario, request.getSession());
            adicionaMensagemDeSucessoCadastro(request);
            redirect("/usuarios", resp);
        } else {
            adicionaMensagemDeErroCadastro(request);
            request.setAttribute("usuario", usuario);
            String destino = ehCodigoNovo(cod) ? AppUrls.USUARIO_NOVO : AppUrls.USUARIO_EDITAR;
            redirect(destino, resp);
        }
    }

}
