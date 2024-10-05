package ABC;

import java.sql.*;

public class Producto {
	private String url = "jdbc:mysql://localhost:3307/ejemplo_1"; // Cambia el nombre de la base de datos
    private String usuario = "root"; // Cambia el usuario si es necesario
    private String contraseña = "1234"; // Cambia la contraseña

    // Crear (Insertar un nuevo registro)
    public void crearProducto(String nombre, double precio, int cantidad) {
        String sql = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, cantidad);
            
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Producto creado. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer (Seleccionar registros)
    public void leerProductos() {
        String sql = "SELECT * FROM productos";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar (Modificar un registro)
    public void actualizarProducto(int id, String nombre, double precio, int cantidad) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, cantidad);
            pstmt.setInt(4, id);
            
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Producto actualizado. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar (Eliminar un registro)
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Producto eliminado. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
