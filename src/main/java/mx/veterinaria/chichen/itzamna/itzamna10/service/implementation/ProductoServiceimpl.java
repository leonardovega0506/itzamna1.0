package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProductoRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceimpl implements IProductosService {

    @Autowired
    private IProductoRepository iProducto;


    @Override
    public List<ProductosModel> findAllProductos() {
        return iProducto.findAll();
    }

    @Override
    public List<ProductosModel> findAllProductosByProveedorId(Long idProveedor) {
        return iProducto.findByProveedor_IdProveedor(idProveedor);
    }

    @Override
    public Optional<ProductosModel> findProductoById(Long idProducto) {
        return iProducto.findById(idProducto);
    }

    @Override
    public Optional<ProductosModel> findProductoByClaveProducto(String claveProducto) {
        return iProducto.findByClaveProducto(claveProducto);
    }

    @Override
    public ProductosModel saveProducto(ProductosModel producto) {
        return iProducto.save(producto);
    }

    @Override
    public void updateProductos(ProductosModel producto) {
        iProducto.save(producto);
    }

    @Override
    public void deleteProdycById(Long idProducto) {
        iProducto.deleteById(idProducto);
    }
}
