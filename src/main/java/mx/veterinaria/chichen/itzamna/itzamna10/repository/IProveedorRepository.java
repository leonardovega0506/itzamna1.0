package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepository extends JpaRepository<ProveedorModel,Long> {
}
