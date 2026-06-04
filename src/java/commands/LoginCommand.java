package commands;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginCommand implements ICommand {
    
    @Override
    public void executar(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            System.out.println("EMAIL = [" + email + "]");
            System.out.println("SENHA = [" + senha + "]");

            email = email.trim();
            senha = senha.trim();

            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.autenticar(email, senha);

            System.out.println("USUARIO ENCONTRADO = " + (usuario != null));

            if (usuario != null) {

                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario.getNome());

                response.sendRedirect("home.jsp");

            } else {

               response.sendRedirect("index.html?erro=Usuário ou senha inválidos!");
            }

        } catch (Exception e) {
            throw new ServletException("Erro no login", e);
        }
    }
}

