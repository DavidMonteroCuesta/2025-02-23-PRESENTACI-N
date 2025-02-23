package es.etg.dmc.acc.rest.producto;

// Importa clases para listas y iteradores
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
// Importa anotaciones para controladores REST
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Define un controlador REST
@RestController
// Mapea la ruta base "/productos"
@RequestMapping("/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    @GetMapping
    public List<Producto> getProductos() {
        return productos;
    }

    @PostMapping
    public String agregarProducto(@RequestBody Producto producto) {
        productos.add(producto); // Agrega a la lista
        return "Producto agregado con éxito!";
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        Iterator<Producto> iterator = productos.iterator();

        while (iterator.hasNext()) { // RECORRE LA LISTA
            Producto p = iterator.next();
            if (p.getId().equals(id)) iterator.remove(); // ELIMINA
        }
        return "Producto eliminado!";
    }
}
