package dao;

import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // Crear nuevo cliente
    public int create(Cliente c) throws SQLException {
        String sql = "INSERT INTO Clientes (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());

            int affected = ps.executeUpdate();
            if (affected == 0) return -1;

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    c.setClienteId(id);
                    return id;
                }
            }
            return -1;
        }
    }

    // Listar todos los clientes
    public List<Cliente> findAll() throws SQLException {
        String sql = "SELECT cliente_id, nombre, telefono, correo FROM Clientes";
        List<Cliente> list = new ArrayList<>();

        try (Connection conn = DBHelper.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
                list.add(c);
            }
        }
        return list;
    }

    // Buscar cliente por ID
    public Cliente findById(int id) throws SQLException {
        String sql = "SELECT cliente_id, nombre, telefono, correo FROM Clientes WHERE cliente_id = ?";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("cliente_id"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("correo")
                    );
                }
            }
        }
        return null;
    }


    public boolean update(Cliente c) throws SQLException {
        String sql = "UPDATE Clientes SET nombre = ?, telefono = ?, correo = ? WHERE cliente_id = ?";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());
            ps.setInt(4, c.getClienteId());

            return ps.executeUpdate() > 0;
        }
    }


    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE cliente_id = ?";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
