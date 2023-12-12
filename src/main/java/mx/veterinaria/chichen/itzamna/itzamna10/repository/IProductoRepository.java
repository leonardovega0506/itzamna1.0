package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<ProductosModel,Long> {
    Page<ProductosModel> findByProveedor_IdProveedor(Long idProveedor, Pageable pageable);
    Optional<ProductosModel> findByClaveProductoAllIgnoreCase(String claveProducto);
    Page<ProductosModel> findByProveedor_NombreProveedor(String nombreProveedor, Pageable pageable);
    Optional<ProductosModel> findByClaveProducto(String claveProducto);
}
