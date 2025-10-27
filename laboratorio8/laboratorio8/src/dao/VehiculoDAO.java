package dao;

import modelo.Vehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {
    private Connection conn;

    public VehiculoDAO() {
    }

    private Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DBHelper.getConnection();
        }
        return conn;
    }

    public List<Vehiculo> findAll() throws SQLException {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT vehiculo_id, marca, modelo, ano, estado, id_tipo, num_puertas, num_asientos, id_sucursal FROM Vehiculos";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehiculo v = new Vehiculo(
                    rs.getInt("vehiculo_id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getInt("estado"),
                    rs.getInt("id_tipo"),
                    rs.getInt("num_puertas"),
                    rs.getInt("num_asientos"),
                    rs.getInt("id_sucursal")
                );
                lista.add(v);
            }
        }
        return lista;
    }

    public void create(Vehiculo v) throws SQLException {
        String sql = "INSERT INTO Vehiculos (marca, modelo, ano, estado, id_tipo, num_puertas, num_asientos, id_sucursal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getMarca());
            ps.setString(2, v.getModelo());
            ps.setInt(3, v.getAno());
            ps.setInt(4, v.getEstado());
            ps.setInt(5, v.getIdTipo());
            ps.setInt(6, v.getNumPuertas());
            ps.setInt(7, v.getNumAsientos());
            ps.setInt(8, v.getIdSucursal());
            ps.executeUpdate();
        }
    }

    public Vehiculo findById(int id) throws SQLException {
        String sql = "SELECT * FROM Vehiculos WHERE vehiculo_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Vehiculo(
                        rs.getInt("vehiculo_id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getInt("estado"),
                        rs.getInt("id_tipo"),
                        rs.getInt("num_puertas"),
                        rs.getInt("num_asientos"),
                        rs.getInt("id_sucursal")
                    );
                }
            }
        }
        return null;
    }

    public boolean update(Vehiculo v) throws SQLException {
        String sql = "UPDATE Vehiculos SET marca=?, modelo=?, ano=?, estado=?, id_tipo=?, num_puertas=?, num_asientos=?, id_sucursal=? WHERE vehiculo_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getMarca());
            ps.setString(2, v.getModelo());
            ps.setInt(3, v.getAno());
            ps.setInt(4, v.getEstado());
            ps.setInt(5, v.getIdTipo());
            ps.setInt(6, v.getNumPuertas());
            ps.setInt(7, v.getNumAsientos());
            ps.setInt(8, v.getIdSucursal());
            ps.setInt(9, v.getVehiculoId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Vehiculos WHERE vehiculo_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
