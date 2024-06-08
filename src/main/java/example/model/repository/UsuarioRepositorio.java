package example.model.repository;

import example.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static conexion.ConexionDb.obtenerConexion;

public class UsuarioRepositorio {

    private Connection conn;
    public UsuarioRepositorio() {

        try {
            this.conn = obtenerConexion();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> Arraylist;
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
            ResultSet rs = ((Statement) stmt).executeQuery("SELECT * FROM usuarios")) {
            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setBalance(rs.getDouble("balance"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
    public void actualizarBalance(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET balance = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, usuario.getBalance());
            pstmt.setInt(2, usuario.getId());
            pstmt.executeUpdate();
        }
    }
}