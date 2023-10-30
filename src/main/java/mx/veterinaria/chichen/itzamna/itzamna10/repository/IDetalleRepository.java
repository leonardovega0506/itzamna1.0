package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DetalleCompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleRepository extends JpaRepository<DetalleCompraModel, Long> {
    List<DetalleCompraModel> findByProveedorDetalle_Compras_IdCompra(Long idCompra);
}
