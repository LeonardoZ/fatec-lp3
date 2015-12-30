
import com.edu.fatecbt.sistema.controle.ServletBase;
import com.edu.fatecbt.usuario.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/usuarios"})
public class UsuariosServlet extends ServletBase {


    private UsuarioDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("usuarios", dao.selecionaTodos());
        forward("usuarios.jsp", request, response);
    }

}
