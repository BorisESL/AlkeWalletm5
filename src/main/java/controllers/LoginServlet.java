package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/usuarios";
        String user = "tu_usuario";
        String pass = "tu_contraseña";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE email=? AND contraseña=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Si las credenciales son válidas, crea una sesión y redirige al usuario al menú principal
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                response.sendRedirect("pages/menuprincipal.jsp");
            } else {
                // Si las credenciales son inválidas, redirige de vuelta a index.jsp con un mensaje de error
                response.sendRedirect("index.jsp?error=1");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
