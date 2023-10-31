package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IServiciosRepository extends JpaRepository<ServiciosModel,Long> {
    Optional<ServiciosModel> findByClaveServicio(String claveServicio);
}
