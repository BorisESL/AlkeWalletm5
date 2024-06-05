package controllers;

import example.model.Usuario;
import example.model.repository.UsuarioRepositorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email + " " + password);


        String url = "jdbc:mysql://localhost:3306/usuarios";
        String user = "root";
        String pass = "conycata2019";

        UsuarioRepositorio repo = new UsuarioRepositorio();
        try{
            List<Usuario> usuarios = repo.listar();
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email)) {
                    if(usuario.getPassword().equals(password)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("usuario", usuario);
                        response.sendRedirect("pages/menuprincipal.jsp");
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
