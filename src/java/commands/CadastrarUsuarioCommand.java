package commands;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarUsuarioCommand implements ICommand {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Usuario u = new Usuario();

            u.setNome(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("senha"));
            u.setPerfil(request.getParameter("perfil"));
            u.setAtivo(true);

            UsuarioDAO dao = new UsuarioDAO();
            boolean ok = dao.cadastrar(u);

            if (ok) {
                response.sendRedirect("FrontController?acao=listar&tipo=usuario");

            } else {

                request.setAttribute("msg", "Erro ao cadastrar usuário!");
                request.getRequestDispatcher("usuario_form.jsp").forward(request, response);
            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new ServletException("Erro ao cadastrar usuário", e);
        }
    }
}