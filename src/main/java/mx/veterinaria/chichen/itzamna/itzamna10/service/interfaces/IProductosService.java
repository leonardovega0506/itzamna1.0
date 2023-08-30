package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ProductosModel;

import java.util.List;
import java.util.Optional;

public interface IProductosService {

    List<ProductosModel> findAllProductos();

    List<ProductosModel> findAllProductosByProveedorId(Long idProveedor);

    Optional<ProductosModel> findProductoById(Long idProducto);

    Optional<ProductosModel> findProductoByClaveProducto(String claveProducto);

    ProductosModel saveProducto(ProductosModel producto);

    void updateProductos(ProductosModel producto);

    void deleteProdycById(Long idProducto);
}
