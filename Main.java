package ABC;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto Producto = new Producto();

        // Crear un nuevo producto
		Producto.crearProducto("Producto 1", 19.99, 100);
        
        // Leer productos
        System.out.println("Lista de productos:");
        Producto.leerProductos();
        
        // Actualizar un producto (por ejemplo, el producto con id 1)
        Producto.actualizarProducto(1, "Producto 1 Modificado", 25.00, 150);
        
        // Leer productos nuevamente para ver el cambio
        System.out.println("Lista de productos después de la actualización:");
        Producto.leerProductos();
        
        // Eliminar un producto (por ejemplo, el producto con id 1)
        Producto.eliminarProducto(1);
        
        // Leer productos nuevamente para ver el cambio
        System.out.println("Lista de productos después de la eliminación:");
        Producto.leerProductos();

	}

}
