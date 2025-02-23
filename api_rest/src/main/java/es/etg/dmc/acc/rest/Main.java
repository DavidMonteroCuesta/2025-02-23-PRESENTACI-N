package es.etg.dmc.acc.rest;

import es.etg.dmc.acc.rest.producto.Producto;
import es.etg.dmc.acc.rest.producto.ProductoController;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoController controlador = new ProductoController();

        agregarProductos(controlador);
        listarProductos(controlador);
        eliminarProducto(controlador, 2L);
        listarProductos(controlador);
    }

    /**
     * Agrega 3 productos
     * @param controlador
     */
    private static void agregarProductos(ProductoController controlador) {
        System.out.println(controlador.agregarProducto(new Producto(1L, "Laptop", 1200.0)));
        System.out.println(controlador.agregarProducto(new Producto(2L, "Teclado", 50.0)));
        System.out.println(controlador.agregarProducto(new Producto(3L, "Ratón", 30.0)) + "\n");
    }

    /**
     * Lista los productos
     * @param controlador
     */
    private static void listarProductos(ProductoController controlador) {
        List<Producto> productos = controlador.getProductos();
        System.out.println("Lista de productos:");
        for (Producto p : productos) System.out.println(p.getId() + " - " + p.getNombre() + " - $" + p.getPrecio());
        System.out.println();
    }

    /**
     * Elimina el producto cuyo id coincida con el pasado por parámetro
     * @param controlador
     * @param id
     */
    private static void eliminarProducto(ProductoController controlador, Long id) {
        System.out.println(controlador.eliminarProducto(id) + "\n");
    }
}
