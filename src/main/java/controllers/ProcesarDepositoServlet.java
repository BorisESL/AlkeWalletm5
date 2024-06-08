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

@WebServlet("/procesarDeposito")
public class ProcesarDepositoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("../index.jsp");
            return;
        }

        double monto = Double.parseDouble(request.getParameter("monto"));
        UsuarioRepositorio repo = new UsuarioRepositorio();

        try {
            double nuevoSaldo = usuario.getBalance() + monto;
            usuario.setBalance(nuevoSaldo);
            repo.actualizarBalance(usuario);
            session.setAttribute("usuario", usuario);
            response.sendRedirect("pages/menuprincipal.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
