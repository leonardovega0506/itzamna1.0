package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProductosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProductoRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceimpl implements IProductosService {


    @Override
    public ProductoResponse getAllProductos(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ProductoResponse getAllProductoByProveedor(int numPage, int sizePage, String orderBy, String sortDir, String nombreProveedor) {
        return null;
    }

    @Override
    public ProductoResponse getProductoByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombreProducto) {
        return null;
    }

    @Override
    public ProductosDTO getProductoById(Long idProducto) {
        return null;
    }

    @Override
    public ProductosDTO getProductoByClaveProducto(String claveProducto) {
        return null;
    }

    @Override
    public ProductosDTO saveProducto(ProductosDTO producto) {
        return null;
    }

    @Override
    public void updateProductos(ProductosDTO producto) {

    }

    @Override
    public void deleteProdycById(Long idProducto) {

    }
}
