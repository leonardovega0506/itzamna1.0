package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDetalleVentasRepository extends JpaRepository<DetalleVentaModel, Long> {
    List<DetalleVentaModel> findByVentas_IdVenta(Long idVenta);
}
