package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProductosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface IProductosService {


    ProductoResponse getAllProductos(int numPage, int sizePage, String orderBy, String sortDir);

    ProductoResponse getAllProductoByProveedor(int numPage, int sizePage, String orderBy, String sortDir, Long idProveedor);

    ProductoResponse getProductoByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombreProducto);

    ProductosDTO getProductoById(Long idProducto);

    ProductosDTO getProductoByClaveProducto(String claveProducto);


    ProductosDTO saveProducto(ProductosDTO producto, Long idProveedor);

    void updateProductos(ProductosDTO producto);

    void deleteProdycById(Long idProducto);
}
