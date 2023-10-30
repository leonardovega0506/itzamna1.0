package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IComprasRepository extends JpaRepository<ComprasModel,Long> {
    Optional<ComprasModel> findByNotaCompra(String notaCompra);
    List<ComprasModel> findByProveedor_IdProveedor(Long idProveedor);
}
